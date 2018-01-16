package com.risk.warning.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cloud.model.BaseObject;

public class PanoramicRiskForWebInfo extends BaseObject {
    /**
    *
    */
   private static final long serialVersionUID = 1L;
   /**
    * id
    */
   private String id;
   /**
    * StatusName
    */
   private String status_name;
   /**
    * WarningName
    */
   private String warning_name;
   /**
    * WarningContent
    */
   private String warning_content;
   /**
    * Ctime
    */
   private Timestamp  ctime;
   
   /**
    * ReceiverName
    */
   private String receiver_name;
   
   /**
    * ReturnContent
    */
   private String return_content;
   /**
    * Utime
    */
   private Timestamp  utime;
   /**
    * Level
    */
   private Integer level;
   

   /**
    * 获取Id
    *
    * @return id - Id
    */
   public String getId() {
   		return id;    	
   }
   

   /**
    * 设置Id
    *
    * @param id Id
    */
   public void setId(String id) {
       this.id = id;
   } 

   /**
    * 获取StatusName
    *
    * @return status_name - StatusName
    */
   public String getStatusName() {
   		return status_name;    	
   }
   

   /**
    * 设置StatusName
    *
    * @param statusname StatusName
    */
   public void setStatusName(String statusname) {
       this.status_name = statusname;
   } 
   

   /**
    * 获取Warningname
    *
    * @return warning_name - Warningname
    */
   public String getWarningname() {
	   return warning_name;
   }

   /**
    * 设置Warningname
    *
    * @param warningname Warningname
    */
   public void setWarningname(String warningname) {
	   this.warning_name = warningname;
   }
   /**
    * 获取WarningContent
    *
    * @return warning_content - WarningContent
    */
   public String getWarningContent() {
   		return warning_content;    	
   }
   

   /**
    * 设置WarningContent
    *
    * @param warningcontent WarningContent
    */
   public void setWarningContent(String warningcontent) {
       this.warning_content = warningcontent;
   } 
   
   /**
    * 获取Ctime
    * 
    * @return ctime -Ctime
    */
   public Timestamp getCtime() {
	   return ctime;
   }
   
   /**
    * 设置Ctime
    *
    * @param ctime Ctime
    */
   public void setCtime(Timestamp ctime) {
	   this.ctime = ctime;
   }

   
   /**
    * 获取Utime
    * 
    * @return utime -Utime
    */
   public Timestamp getUtime() {
	   return utime;
   }
   
   /**
    * 设置Utime
    *
    * @param utime Utime
    */
   public void setUtime(Timestamp utime) {
	   this.utime = utime;
   }
   /**
    * 获取ReceiverName
    *
    * @return receiver_name - ReceiverName
    */
   public String getReceiverName() {
   		return receiver_name;    	
   }
   

   /**
    * 设置ReceiverName
    *
    * @param receivername ReceiverName
    */
   public void setReceiverName(String receivername) {
       this.receiver_name = receivername;
   } 
   

   /**
    * 获取ReturnContent
    *
    * @return return_content - ReturnContent
    */
   public String getReturnContent() {
   		return return_content;    	
   }
   

   /**
    * 设置ReturnContent
    *
    * @param returncontent ReturnContent
    */
   public void setReturnContent(String returncontent) {
       this.return_content = returncontent;
   } 

   
   /**
    * 获取Level
    *
    * @return level - Level
    */
   public Integer getLevel() {
	   return level;
   }
   
   /**
    * 设置Level
    *
    * @param level Level
    */
   public void SetLevel(Integer level) {
	   this.level = level;
   }

   

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}
}