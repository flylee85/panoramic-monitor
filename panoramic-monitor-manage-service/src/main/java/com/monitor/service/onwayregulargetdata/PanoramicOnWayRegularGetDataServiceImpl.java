/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.service.onwayregulargetdata;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitor.api.onwayregulargetdata.PanoramicOnWayRegularGetDataService;
import com.monitor.dto.onwayquery.PanoramicOnWayQueryDto;
import com.monitor.dto.onwayqueryorder.PanoramicOnWayQueryOrderDto;
import com.monitor.mapper.onwayorder.PanoramicOnWayOrderMapper;

import tk.mybatis.mapper.entity.Condition;

import com.alibaba.fastjson.JSON;

@Service("onWayRegularGetDataService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicOnWayRegularGetDataServiceImpl extends AbstractService<PanoramicOnWayQueryOrderDto>
       implements PanoramicOnWayRegularGetDataService {

   private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicOnWayRegularGetDataServiceImpl.class);

   private String orgcode ="201IEC";
   
   
   private String url = "http://g7s.api.huoyunren.com/interface/index.php";
   private String app_key = "xzdsj_api";
   private String app_secret = "c7618ffb01363153d8d1657697d58f8a";
   

   @Autowired
   @Qualifier("onWayOrderMapper")
   private PanoramicOnWayOrderMapper onWayOrderMapper;
   
	@Override
	public void getNewOrderData() {
			String startTime = onWayOrderMapper.getStartTime();
	        if(startTime == null || !startTime.equals("")) {
	        	startTime = "2017-01-01 00:00:00";
	        }
	
	    	String method = "order.order.getOrderList";
	    	
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    	java.util.Date date=new java.util.Date();  
	    	String createtimeLt =  sdf.format(date);
	    	
	    	
	    	PanoramicOnWayQueryDto m = new PanoramicOnWayQueryDto();
	    	m.setCreateTimeGe(startTime);
	    	m.setCreateTimeLt(createtimeLt);
	    	m.setFields("orderno,sebindstatus");
	    	m.setOrgCode(orgcode);
	    	
	    	String data = JSON.toJSONString(m);
	        //String data = "{\"createtimeGe\":\"" + startTime + "\",\"createtimeLt\":\""+createtimeLt+"\",\"orgcode\":\""+orgcode+"\",\"fields\":\"orderno,sebindstatus\"}";
	    
	        DB_LOGGER.warn(data);
	        
	
	       // String param = getParam(method,data);
	        //param.replaceAll("\\\\","");

	        String timestamp = createtimeLt;  
	        String mae =  app_secret + "app_key" + app_key + "data" + data + "method" + method + "timestamp" + timestamp + app_secret;

	        DB_LOGGER.warn(mae);
	        String sign = MD5Encode(mae);
	        String param =  "method=" + method + "&timestamp=" + timestamp + "&app_key=" + app_key + "&sign=" + sign + "&data=" + data;

	        DB_LOGGER.warn(param);
	        String s=convert(sendPost(url,param));
	        DB_LOGGER.warn(s);
	}
	
	
	private String getParam(String method, String data) {
        Date dt = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String timestamp = sdf.format(dt);  
        String mae =  app_secret + "app_key" + app_key + "data" + data + "method" + method + "timestamp" + timestamp + app_secret;

        DB_LOGGER.warn(mae);
        String sign = MD5Encode(mae);
        String param =  "method=" + method + "&timestamp=" + timestamp + "&app_key=" + app_key + "&sign=" + sign + "&data=" + data;
        
		return param;
	}
	

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

 

    /**
     * MD5缂栫爜
     * @param origin 鍘熷瀛楃涓�
     * @return 缁忚繃MD5鍔犲瘑涔嬪悗鐨勭粨鏋�
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(resultString.getBytes("UTF-8"));
            resultString = byteArrayToHexString(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
    
    
    /**
     * 杞崲瀛楄妭鏁扮粍涓�16杩涘埗瀛椾覆
     * @param b 瀛楄妭鏁扮粍
     * @return 16杩涘埗瀛椾覆
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 杞崲byte鍒�16杩涘埗
     * @param b 瑕佽浆鎹㈢殑byte
     * @return 16杩涘埗鏍煎紡
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    
    public String convert(String utfString){
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;
         
        while((i=utfString.indexOf("\\u", pos)) != -1){
            sb.append(utfString.substring(pos, i));
            if(i+5 < utfString.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));
            }
        }
         
        return sb.toString();
    }
  
}
