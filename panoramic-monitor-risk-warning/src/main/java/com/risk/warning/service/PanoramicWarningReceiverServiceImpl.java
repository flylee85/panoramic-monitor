
/**
 * @author fgh
 *
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.risk.warning.api.PanoramicWarningReceiverService;
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.mapper.PanoramicEmailSendInfoMapper;
import com.risk.warning.model.PanoramicWarningReceiver;
import com.risk.warning.model.PanoramicEmailSendInfo;
import com.risk.warning.model.PanoramicWarningData;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("panoramicWarningReceiverService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicWarningReceiverServiceImpl extends AbstractService<PanoramicWarningReceiver>  implements PanoramicWarningReceiverService {
    
    @Autowired
    @Qualifier("warningDataMapper")
    private PanoramicWarningDataMapper warningDataMapper;
    
    @Autowired
    @Qualifier("warningReceiverMapper")
    private PanoramicWarningReceiverMapper warningReceiverMapper; 
    

    @Autowired
    @Qualifier("emailSendInfoMapper")
    private PanoramicEmailSendInfoMapper emailSendInfoMapper;
    
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void regularlDealWarningData() {
    	 try {
    		 warningDataMapper.UpdatewarningSourceLevel();
    		 List<PanoramicWarningData> ListWarningData = warningDataMapper.GetDealWarningData();
    			if(ListWarningData != null) {
	   					for (PanoramicWarningData  SourceData : ListWarningData) {
	   						//获取发送邮件对象
	   						List<PanoramicWarningReceiver> listReceiver = warningReceiverMapper.GetDataByWarningConfigurationID(SourceData.getWarnConfigurationID(),SourceData.getLevel());
	   						if(listReceiver != null) {
	   							sendEmail(listReceiver,SourceData);
	   						}
	   						warningDataMapper.UpdatewarningSourceStatus(2,SourceData.getId());
	   					 
	   					}
	   				}
         } catch (Exception e) {
        	 System.out.println(e);

         }
    }
    
    
    private void sendEmail(List<PanoramicWarningReceiver> listReceiver,PanoramicWarningData  SourceData )  {
    	   // 1. 创建一封邮件
        System.out.println("进入邮件");
        
        // 指定发送邮件的主机为本机
        String host = "smtp.163.com";  

        
        // 获取系统属性
        Properties properties = System.getProperties();
   
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        
        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
             return new PasswordAuthentication("slayersfox@163.com", "slayerskurama"); //发件人邮件用户名、密码
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
	            message.setFrom(new InternetAddress("slayersfox@163.com", "预警系统", "UTF-8"));
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
	            System.out.println("Sent message successfully....");
	        	sendInfo.setReason("发送成功");
	        	sendInfo.setSendStatus(1);
	        }catch (Exception e) {

	        	sendInfo.setSendStatus(2);
	        	sendInfo.setReason(String.valueOf(e));
	        	
	        }finally {
	        	emailSendInfoMapper.AddSendInfo(sendInfo.getReceiverName(),sendInfo.getReceiverEmail(),sendInfo.getWarningSourceID(),sendInfo.getSendStatus(),sendInfo.getReason());
	        }
        }
    }
    	
    

}