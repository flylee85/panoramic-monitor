
/**
 * @author fgh
 *
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicWarningReceiverService;
import com.risk.warning.dto.PanoramicEmailSendInfoDto;
import com.risk.warning.dto.PanoramicWarningDataDto;
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.mapper.PanoramicEmailSendInfoMapper;
import com.risk.warning.model.PanoramicWarningReceiver;
import com.sun.mail.util.MailSSLSocketFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("panoramicWarningReceiverService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicWarningReceiverServiceImpl extends AbstractService<PanoramicWarningReceiver>  implements PanoramicWarningReceiverService {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicSystemSqlqueryServiceImpl.class);
    
    @Autowired
    @Qualifier("warningDataMapper")
    private PanoramicWarningDataMapper warningDataMapper;
    
    @Autowired
    @Qualifier("warningReceiverMapper")
    private PanoramicWarningReceiverMapper warningReceiverMapper; 
    

    @Autowired
    @Qualifier("emailSendInfoMapper")
    private PanoramicEmailSendInfoMapper emailSendInfoMapper;
    
      
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void regularlDealWarningData() {
    	 try {
    		//获取未处理的预警数据
    		 List<PanoramicWarningDataDto> ListWarningData = warningDataMapper.getDealWarningData();
    			if(ListWarningData != null) {
	   					for (PanoramicWarningDataDto  SourceData : ListWarningData) {
	   						//获取发送邮件对象
	   						List<PanoramicWarningReceiver> listReceiver = warningReceiverMapper.getDataByWarningConfigurationID(SourceData.getWarnConfigurationID(),SourceData.getLevel());
	   						if(listReceiver != null) {
	   							//发送邮件
	   							sendEmail(listReceiver,SourceData);
	   						}
	   					}
	   				}
         } catch (Exception e) {
          	DB_LOGGER.warn("操作异常!");
         }
    }

    @Value("${Email.Config.protocol}")
    private String protocol;
    
    @Value("${Email.Config.host}")
    private String host;
    
    @Value("${Email.Config.port}")
    private String port;

    @Value("${Email.Config.address}")
    private String fromEmailAddress;

    @Value("${Email.Config.password}")
    private String fromEmailPassword;
    
    @Value("${Email.Config.needSSL}")
    private Boolean needSSL;
    
    @Value("${Email.Config.mailContent}")
    private String mailContent;
    
    private void sendEmail(List<PanoramicWarningReceiver> listReceiver,PanoramicWarningDataDto  SourceData )  {
  	  // 1. 创建一封邮件
        // 指定发送邮件的主机为本机
        //String host = "smtp.163.com";  

        
        // 获取系统属性
        Properties properties = System.getProperties();
        //协议
        properties.setProperty("mail.transport.protocol", protocol);
   
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        // 设置邮件服务器端口号
        properties.setProperty("mail.smtp.port", port);
        
        properties.put("mail.smtp.auth", "true");
        
        if(needSSL) {
	        MailSSLSocketFactory sf = null;
	        try {
	            sf = new MailSSLSocketFactory();
	        } catch (GeneralSecurityException e) {
	        	DB_LOGGER.warn(String.valueOf(e));
	        }
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
        }

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication()
            {
             return new PasswordAuthentication(fromEmailAddress, fromEmailPassword); //发件人邮件用户名、密码
            }
        });  // 根据参数配置，创建会话对象（为了发送邮件准备的）
   
        MimeMessage message = new MimeMessage(session);     // 创建邮件对象


        
        for (PanoramicWarningReceiver Receiver : listReceiver) {
        	PanoramicEmailSendInfoDto sendInfo = new PanoramicEmailSendInfoDto();
        	sendInfo.setReceiverName(Receiver.getUserName());
        	sendInfo.setReceiverEmail(Receiver.getEmail());
        	sendInfo.setWarningSourceID(SourceData.getId());
	        try {
	        	
	            // 2. From: 发件人
	            //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
	            //    真正要发送时, 邮箱必须是真实有效的邮箱。
	            message.setFrom(new InternetAddress(fromEmailAddress, "预警系统", "UTF-8"));
	            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(Receiver.getEmail(), Receiver.getUserName(), "UTF-8"));
	
	            // 4. Subject: 邮件主题
	            message.setSubject(SourceData.getWarningname());
	
	            // 5. Content: 邮件正文（可以使用html标签）

	            DecimalFormat decimalFormat = new DecimalFormat("###################.###########");  
	            mailContent=  String.format(mailContent,SourceData.getFactoryName(),SourceData.getSectionName(),SourceData.getDeviceName(),SourceData.getEventName(),SourceData.getEventValue() ,decimalFormat.format(SourceData.getMinValue()), decimalFormat.format(SourceData.getMaxValue()) , SourceData.getLevel());
	            
	            message.setContent(mailContent, "text/html;charset=UTF-8");
	
	            // 6. 设置显示的发件时间
	            message.setSentDate(new Date());
	
	            // 7. 保存前面的设置
	            message.saveChanges();
	            // 发送消息
	            Transport.send(message);
	        	sendInfo.setReason("发送成功");
	        	sendInfo.setSendStatus(1);
	        } catch (MessagingException e) {
	        	sendInfo.setSendStatus(2);
	        	sendInfo.setReason(ChangeErrorCode(String.valueOf(e)));
	        } catch (UnsupportedEncodingException e) {
	        	sendInfo.setSendStatus(2);
	        	sendInfo.setReason(ChangeErrorCode(String.valueOf(e)));
	        } catch (IOException e) {
	        	sendInfo.setSendStatus(2);
	        	sendInfo.setReason(ChangeErrorCode(String.valueOf(e)));
	        }finally {
	        	emailSendInfoMapper.addSendInfo(sendInfo.getReceiverName(),sendInfo.getReceiverEmail(),sendInfo.getWarningSourceID(),sendInfo.getSendStatus(),sendInfo.getReason());
	        	if(sendInfo.getSendStatus() == 1) {
	        		warningDataMapper.updatewarningSourceStatus(SourceData.getId());
	        	}
	        }
        }
    }
    
    
    private String ChangeErrorCode(String errorMessage) {
    	String result = "";
    	if(errorMessage.indexOf("440") > -1) {
    		result = "440 收件地址错误";
    	}else if(errorMessage.indexOf("445") > -1) {
    		result = "445  服务被封锁";
    	}else if(errorMessage.indexOf("451") > -1) {
    		result = "451  无法解析";
    	}else if(errorMessage.indexOf("452") > -1) {
    		result = "452  系统空间不足";
    	}else if(errorMessage.indexOf("501") > -1) {
    		result = "501  收件人不存在";
    	}else if(errorMessage.indexOf("505") > -1) {
    		result = "505 Smtp服务器需要认证";
    	}else if(errorMessage.indexOf("535") > -1) {
    		result = "535  发件箱验证错误";
    	}else if(errorMessage.indexOf("550") > -1) {
    		result = "550 Smtp服务器信息错误";
    	}else if(errorMessage.indexOf("551") > -1) {
    		result = "551 Smtp服务器发送被限制";
    	}else if(errorMessage.indexOf("553") > -1) {
    		result = "553 Smtp服务器邮件地址不正确";
    	}else if(errorMessage.indexOf("554") > -1) {
    		result = "554  因政策原因拒绝";
    	}	
    	return result; 
    }
    	
    

}