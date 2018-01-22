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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.cloud.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitor.api.onwayregulargetdata.PanoramicOnWayRegularGetDataService;
import com.monitor.dto.onwayquery.PanoramicOnWayQueryDeviceDto;
import com.monitor.dto.onwayquery.PanoramicOnWayQueryOrderDto;
import com.monitor.dto.onwayquery.PanoramicOnWayQueryOrderNodesDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultDeparturesDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultDeviceDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultOrderDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultOrderNodesDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultMessageDto;
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultMilestonesiotesDto;
import com.monitor.mapper.onwaydeparture.PanoramicOnWayDepartureMapper;
import com.monitor.mapper.onwaydevice.PanoramicOnWayDeviceMapper;
import com.monitor.mapper.onwayorder.PanoramicOnWayOrderMapper;
import com.monitor.model.onwayorder.PanoramicOnWayOrder;

import tk.mybatis.mapper.entity.Condition;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service("onWayRegularGetDataService")
@Transactional(readOnly = true,rollbackFor = ServiceException.class)
public class PanoramicOnWayRegularGetDataServiceImpl extends AbstractService<PanoramicOnWayQueryResultOrderDto>
       implements PanoramicOnWayRegularGetDataService {

   private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicOnWayRegularGetDataServiceImpl.class);

   private String orgcode ="201IEC";
   private String url = "http://g7s.api.huoyunren.com/interface/index.php";
   private String app_key = "xzdsj_api";
   private String app_secret = "c7618ffb01363153d8d1657697d58f8a";
   private Integer pageSize =100;
   private String filed = "[\"orderno\",\"sebindstatus\",\"userorderno\",\"scompany\",\"sprovince\",\"scity\",\"sdistricts\",\"slocation\",\"sname\",\"rcompany\",\"rprovince\",\"rcity\",\"rdistricts\",\"rlocation\",\"rname\",\"rphone\",\"rdatetime\",\"updatetime\",\"createtime\",\"currentstatus\",\"currenttranstype\",\"orgcode\",\"deleted\",\"fromorgcode\",\"fromtime\",\"departures\"]";
   private String defaultstime = "2017-10-01 00:00:00";
   

   @Autowired
   @Qualifier("onWayOrderMapper")
   private PanoramicOnWayOrderMapper onWayOrderMapper;

   @Autowired
   @Qualifier("onWayDepartureMapper")
   private PanoramicOnWayDepartureMapper onWayDepartureMapper;

   @Autowired
   @Qualifier("onWayDeviceMapper")
   private PanoramicOnWayDeviceMapper onWayDeviceMapper;
   
	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void getNewOrderData()  {
		try {
			String startTime = onWayOrderMapper.getStartTime();
	        if(startTime == null || startTime.equals("")) {
	        	//数据库里没有数据的时候从默认时间开始获取
	        	startTime = defaultstime;
	        }
	
	    	String method = "order.order.getOrderList";
	    	
	    	List<String> listString = JSON.parseArray(filed, String.class);
	    	
	    	Date dtNow = new Date(); 
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dtStartTime =  sdf.parse(startTime);
    		Boolean isloop = true;
			//因为只能抽取3天的数据，从开始时间到当前时间进行循环
	    	while(dtStartTime.before(dtNow)) {
    			if(!isloop) {
    				break;
    			}
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dtStartTime);
				calendar.add(Calendar.DAY_OF_MONTH, 3);// 今天+3天
				Date date=calendar.getTime(); 
			    String createtimeLt =  sdf.format(date);
				
	    		int totalCount = 1;

	    		int pageNo = 0;

		    	PanoramicOnWayQueryOrderDto mQuery = new PanoramicOnWayQueryOrderDto();
		    	mQuery.setCreatetimeGe(startTime);
		    	mQuery.setCreatetimeLt(createtimeLt);
		    	mQuery.setFields(listString);
		    	mQuery.setOrgcode(orgcode);
		    	mQuery.setPageSize(pageSize);
	    		//获取当前条件下的所有数据
	    		while(pageNo * pageSize < totalCount) {
	    			if(!isloop) {
	    				break;
	    			}
	    			pageNo += 1;
			    	mQuery.setPageNo(pageNo);
			    	String data = JSON.toJSONString(mQuery);
			        String param = getParam(method,data);
			        //发送请求
			        String s=sendPost(url,param);
			        DB_LOGGER.warn(s);
		
			        PanoramicOnWayQueryResultMessageDto jsonMessage =JSON.parseObject(s,PanoramicOnWayQueryResultMessageDto.class);
			        //判断通讯是否成功
			    	if(jsonMessage.getCode() == 0) {
			        	
			    		//解析返回的JSON数据
				        PanoramicOnWayQueryResultDto jsonResult = JSON.parseObject(jsonMessage.getData(),PanoramicOnWayQueryResultDto.class);
				        List<PanoramicOnWayQueryResultOrderDto> listOrder =JSON.parseArray(jsonResult.getResult(),PanoramicOnWayQueryResultOrderDto.class);
				        
				        
				        if(listOrder != null && listOrder.size() > 0) {
				        	for (PanoramicOnWayQueryResultOrderDto  order : listOrder) {
				        		String sendaddress = (order.getSProvince()   + order.getSCity()  +order.getSDistricts() + order.getSLocation()  + order.getSCompany()).replace("null", "") ;
				        		String receiveaddress = (order.getRProvince()  + order.getRCity() + order.getRDistricts() +  order.getRLocation()  + order.getRCompany()).replace("null", "");
				        		//判断orderno是否在数据库里存在
				        		Integer count = onWayOrderMapper.isExistOrder(order.getOrderNo());
				        		Boolean res = false;
				        		if(count == 0) {
				        			//不存在的情况下添加Order
					        		res = onWayOrderMapper.addOrderData(order.getOrderNo(), order.getUserOrderNo(), sendaddress, order.getSName(), order.getSPhone(), receiveaddress, order.getRName(), order.getRPhone(), order.getRDateTime(), order.getCreateTime(), order.getUpdateTime(), order.getCurrentStatus(), order.getCurrentStatusType(), order.getOrderNo(), order.getFromOrgCode(), order.getFromTime(), order.getDeleted());
					        		
					        		if(!res) {
					        			//数据库操作失败 终止所有循环
					        			isloop = false;
					        			break;
					        		}
				        		}else {
				        			//存在进行修改
				        			res = onWayOrderMapper.updateOrderData( order.getUserOrderNo(), sendaddress, order.getSName(), order.getSPhone(), receiveaddress, order.getRName(), order.getRPhone(), order.getRDateTime(), order.getCreateTime(), order.getUpdateTime(), order.getCurrentStatus(), order.getCurrentStatusType(), order.getOrderNo(), order.getFromOrgCode(), order.getFromTime(), order.getDeleted(),order.getOrderNo());
				        			if(!res) {
				        				//数据库操作失败 终止所有循环
					        			isloop = false;
					        			break;
					        		}

				        		}
				        		
				        	}
				        }
				        //对总条数进行赋值
				        totalCount = jsonResult.getTotalCount();
			        }
		    	}
	    		//将上次结束时间赋值给下一次的开始时间
	    		startTime = createtimeLt;
	    		dtStartTime =  sdf.parse(startTime);
	    	}
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	   
	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateOrderData()  {
		try {
			//获取所有未完成的Order的Orderno
			List<String> listOrderNo = onWayOrderMapper.getUnfinishOrderNo();
			
			if(listOrderNo == null || listOrderNo.size() == 0) {
				return;
			}
	    	String method = "order.order.getOrderList";
	    	List<String> listString = JSON.parseArray(filed, String.class);

    		int pageNo = 0;
    		int totalCount = 1;

			PanoramicOnWayQueryOrderDto mQuery = new PanoramicOnWayQueryOrderDto();
	    	mQuery.setOrdernoIn(listOrderNo);
	    	mQuery.setFields(listString);
	    	mQuery.setOrgcode(orgcode);
	    	mQuery.setPageSize(pageSize);
	    	
    		while(pageNo * pageSize < totalCount) {
    			pageNo += 1;
    			
    	    	mQuery.setPageNo(pageNo);
		    	String data = JSON.toJSONString(mQuery);
		        String param = getParam(method,data);
		        String s=sendPost(url,param);
		        DB_LOGGER.warn(s);
		        
		        PanoramicOnWayQueryResultMessageDto jsonMessage =JSON.parseObject(s,PanoramicOnWayQueryResultMessageDto.class);

		        //判断通讯是否成功
		    	if(jsonMessage.getCode() == 0) {

		    		//解析返回的JSON数据
			        PanoramicOnWayQueryResultDto jsonResult = JSON.parseObject(jsonMessage.getData(),PanoramicOnWayQueryResultDto.class);
			        List<PanoramicOnWayQueryResultOrderDto> listOrder =JSON.parseArray(jsonResult.getResult(),PanoramicOnWayQueryResultOrderDto.class) ;
			        
			        
			        if(listOrder != null && listOrder.size() > 0) {
			        	for (PanoramicOnWayQueryResultOrderDto  order : listOrder) {
			        		String sendaddress = order.getSProvince() == null ? "" :  order.getSProvince()  + order.getSCity() == null ? "" :  order.getSCity() +order.getSDistricts() == null ? "" :  order.getSDistricts() +order.getSLocation() == null ? "" :  order.getSLocation() + order.getSCompany() == null ? "" :  order.getSCompany();
			        		String receiveaddress = order.getRProvince() == null ? "" :  order.getSProvince() + order.getSProvince()== null ? "" :  order.getRCity() + order.getRDistricts() == null ? "" :  order.getRDistricts() + order.getRLocation() == null ? "" :  order.getRLocation() + order.getRCompany() == null ? "" :  order.getRCompany();
			        		
			        		//判断orderno是否在数据库里存在
			        		Integer count = onWayOrderMapper.isExistOrder(order.getOrderNo());
			        	
			        		if(count == 1) {
			        			//对Order 进行修改
			        			Boolean	res = onWayOrderMapper.updateOrderData( order.getUserOrderNo(), sendaddress, order.getSName(), order.getSPhone(), receiveaddress, order.getRName(), order.getRPhone(), order.getRDateTime(), order.getCreateTime(), order.getUpdateTime(), order.getCurrentStatus(), order.getCurrentStatusType(), order.getOrderNo(), order.getFromOrgCode(), order.getFromTime(), order.getDeleted(),order.getOrderNo());
			        		}
			        		
			        	}
			        }
			        //对总条数进行赋值
			        totalCount = jsonResult.getTotalCount();
		        }
		        
    		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	 /**
    * 获取天眼节点信息
    */
	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void getOrderNodes() {
		try {
			List<String> listOrderNo = onWayOrderMapper.getNeedUpdateDeviceOrderNo();
			if(listOrderNo == null || listOrderNo.size() == 0) {
				return;
			}
			
			String method = "order.order.searchOrderNodes";
    		int pageNo = 0;
    		int totalCount = 1;

    		PanoramicOnWayQueryOrderNodesDto mQuery = new PanoramicOnWayQueryOrderNodesDto();
	    	mQuery.setOrderno(listOrderNo);
	    	mQuery.setPageSize(pageSize);
    			pageNo += 1;
    	    	mQuery.setPageNo(pageNo);
		    	String data = JSON.toJSONString(mQuery);
		        String param = getParam(method,data);
		        String s=sendPost(url,param);
		        DB_LOGGER.warn(s);
		        
		        PanoramicOnWayQueryResultMessageDto jsonMessage =JSON.parseObject(s,PanoramicOnWayQueryResultMessageDto.class);

		        //判断通讯是否成功
		    	if(jsonMessage.getCode() == 0) {

		    		//解析返回的JSON数据
			        PanoramicOnWayQueryResultDto jsonResult = JSON.parseObject(jsonMessage.getData(),PanoramicOnWayQueryResultDto.class);
			        List<PanoramicOnWayQueryResultOrderNodesDto> listOrderNodes =JSON.parseArray(jsonResult.getResult(),PanoramicOnWayQueryResultOrderNodesDto.class) ;
			        
			        if(listOrderNodes != null && listOrderNodes.size() > 0) {
			        	for (PanoramicOnWayQueryResultOrderNodesDto  orderNode : listOrderNodes) {
			        		if(orderNode.getOrderNo() != null && !orderNode.getOrderNo().equals("")) {
					        	String startTime = null;
					        	String lastTime = null ;
					        	String lastAddress = null;
					        	List<PanoramicOnWayQueryResultMilestonesiotesDto> milestonesiotes = JSON.parseArray(orderNode.getMilestonesiotes(),PanoramicOnWayQueryResultMilestonesiotesDto.class);
					            if(milestonesiotes != null && milestonesiotes.size() > 0) {
						        	 startTime =  milestonesiotes.get(0).getMtime();
						        	 lastTime = milestonesiotes.get(milestonesiotes.size()-1).getMtime();
						        	 lastAddress = milestonesiotes.get(milestonesiotes.size()-1).getMaddress();
					            
					            }
					        	onWayOrderMapper.updateOrderNodes(orderNode.getDeviceNo(), startTime, lastTime, lastAddress, orderNode.getOrderNo());
			        		}
			        	}
			        }
	    	}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addDeviceData() {
    		String method = "order.device.search";
    		int pageNo = 0;
    		int totalCount = 1;
    		PanoramicOnWayQueryDeviceDto mData = new PanoramicOnWayQueryDeviceDto();
    		mData.setAddr(true);
    		mData.setLocation(true);
    		mData.setPageSize(pageSize);
    		while(pageNo * pageSize < totalCount) {
    			pageNo += 1;
	    		mData.setPageNo(pageNo);
	    		String data = JSON.toJSONString(mData);
		        String param = getParam(method,data);
		        String s=sendPost(url,param);
		        PanoramicOnWayQueryResultMessageDto jsonMessage =   JSON.parseObject(s,PanoramicOnWayQueryResultMessageDto.class);
		        
		        //判断通讯是否成功
		        if(jsonMessage.getCode() == 0) {
		        	
		        	//解析返回的JSON数据
			        PanoramicOnWayQueryResultDto jsonResult = JSON.parseObject(jsonMessage.getData(),PanoramicOnWayQueryResultDto.class);
			        List<PanoramicOnWayQueryResultDeviceDto> listDevice =JSON.parseArray(jsonResult.getResult(),PanoramicOnWayQueryResultDeviceDto.class) ;
			        
			        if(listDevice != null && listDevice.size() > 0) {
			        	for (PanoramicOnWayQueryResultDeviceDto  Device : listDevice) {
			        		//判断DEvice在数据库里是否存在
			        		Integer count = onWayDeviceMapper.isExistDevice(Device.getDeviceNo());
				        	 
			        		if(String.valueOf(Device.getBattery()) == null) {
			        			Device.setBattery(0);
			        		}
			        		if(count == 0) {
			        			//不存在添加DEVICE
			        			Boolean res =onWayDeviceMapper.addDeviceData(Device.getDeviceNo(), Device.getDType(), Device.getBind(), Device.getOnlineStatus(),0 ,String.valueOf( Device.getLng()) == null ? 0 :Device.getLng(), String.valueOf(Device.getLat()) == null ? 0 :Device.getLat(), Device.getGpsTime(), Device.getAddress());
			        		}else {
			        			//存在 修改DEVICE
			        			Boolean res =onWayDeviceMapper.updateDeviceData(Device.getDType(), Device.getBind(), Device.getOnlineStatus(),String.valueOf(Device.getBattery()) == null ? 0 :Device.getBattery() ,String.valueOf( Device.getLng()) == null ? 0 :Device.getLng(), String.valueOf(Device.getLat()) == null ? 0 :Device.getLat(), Device.getGpsTime(), Device.getAddress(),Device.getDeviceNo());
			        		}
			        		
			        	}
			        }
			        totalCount = jsonResult.getTotalCount();
			        
		        }else {
		        	break;
		        }
    		}
	}
	

	
	
	private String getParam(String method, String data) {
        Date dt = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String timestamp = sdf.format(dt);  
        String mae =  app_secret + "app_key" + app_key + "data" + data + "method" + method + "timestamp" + timestamp + app_secret;

        DB_LOGGER.warn(mae);
        String sign = StringUtil.md5(mae,32).toUpperCase();
        String param =  "method=" + method + "&timestamp=" + timestamp + "&app_key=" + app_key + "&sign=" + sign + "&data=" + data;
       // param = getDecodeJSONStr(param);
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
        	 DB_LOGGER.warn("发送 POST 请求出现异常！"+e);
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
    
    
    
  
}
