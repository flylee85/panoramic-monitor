
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
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.mapper.PanoramicEmailSendInfoMapper;
import com.risk.warning.model.PanoramicWarningReceiver;
import com.sun.mail.util.MailSSLSocketFactory;
import com.risk.warning.model.PanoramicEmailSendInfo;
import com.risk.warning.model.PanoramicWarningData;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
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
    		 //提升未处理的数据等级
    		 warningDataMapper.updatewarningSourceLevel();
    		//获取未处理的预警数据
    		 List<PanoramicWarningData> ListWarningData = warningDataMapper.getDealWarningData();
    			if(ListWarningData != null) {
	   					for (PanoramicWarningData  SourceData : ListWarningData) {
	   						//获取发送邮件对象
	   						List<PanoramicWarningReceiver> listReceiver = warningReceiverMapper.getDataByWarningConfigurationID(SourceData.getWarnConfigurationID(),SourceData.getLevel());
	   						if(listReceiver != null) {
	   							//发送邮件
	   							sendEmail(listReceiver,SourceData);
	   						}
	   						warningDataMapper.updatewarningSourceStatus(SourceData.getId());
	   					}
	   				}
         } catch (Exception e) {
          	DB_LOGGER.warn("操作异常!");
         }
    }
    
    
    @Value("${Email.Config.host}")
    private String host;

    @Value("${Email.Config.address}")
    private String fromEmailAddress;

    @Value("${Email.Config.password}")
    private String fromEmailPassword;
    
    @Value("${Email.Config.needSSL}")
    private Boolean needSSL;
    
    private void sendEmail(List<PanoramicWarningReceiver> listReceiver,PanoramicWarningData  SourceData )  {
  	  // 1. 创建一封邮件
        // 指定发送邮件的主机为本机
        //String host = "smtp.163.com";  

        
        // 获取系统属性
        Properties properties = System.getProperties();
   
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        
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
        	PanoramicEmailSendInfo sendInfo = new PanoramicEmailSendInfo();
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
	            String mailContent = "您好，"+ SourceData.getFactoryName() + SourceData.getSectionName() + SourceData.getDeviceName() + "    " +  SourceData.getEventName() + "=" + SourceData.getEventValue() + "超出阈值(" + SourceData.getMinValue() + "," + SourceData.getMaxValue() +"),触发" + SourceData.getLevel() + "级预警  请及时查看" ;
	            message.setContent(mailContent, "text/html;charset=UTF-8");
	
	            // 6. 设置显示的发件时间
	            message.setSentDate(new Date());
	
	            // 7. 保存前面的设置
	            message.saveChanges();
	            // 发送消息
	            Transport.send(message);
	        	sendInfo.setReason("发送成功");
	        	sendInfo.setSendStatus(1);
	        }catch (Exception e) {
	        	sendInfo.setSendStatus(2);
	        	sendInfo.setReason(String.valueOf(e));
	        	
	        }finally {
	        	emailSendInfoMapper.addSendInfo(sendInfo.getReceiverName(),sendInfo.getReceiverEmail(),sendInfo.getWarningSourceID(),sendInfo.getSendStatus(),sendInfo.getReason());
	        }
        }
    }
    	
    

}