package com.cloud.api;

import com.cloud.util.BeanUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author summer
 */
public class ApiResponse {
	private String errorCode;
	private String msg;
	private Map<String, AbstractApiNode> apiNodeMap = new LinkedHashMap<String, AbstractApiNode>();
	public void addDataNode(AbstractApiNode node){
		apiNodeMap.put(node.getNodeName(), node);
	}
	public void addBeanNode(String nodeName, Object bean, boolean ignoreEmpty, String... outputFields){
		apiNodeMap.put(nodeName, new AbstractBeanNode(bean, nodeName, ignoreEmpty, outputFields));
	}
	public void addSimpleNode(String key, Object simpleValue, boolean ignoreEmpty){
		apiNodeMap.put(key, new AbstractSimpleNode(key, simpleValue, ignoreEmpty));
	}
	public Map getJsonMap(){
		Map result = new LinkedHashMap();
		result.put("errorCode", errorCode);
		result.put("msg", msg);
		for(String nodeName: apiNodeMap.keySet()){
			AbstractApiNode node = apiNodeMap.get(nodeName);
			if(node instanceof AbstractSimpleNode){
				result.put(nodeName, ((AbstractSimpleNode)node).getSimpleValue());
			}else if(node instanceof AbstractBeanNode){
				result.put(nodeName, ((AbstractBeanNode)node).getDataMap());
			}else if(node instanceof AbstractListNode){
				result.put(nodeName, ((AbstractListNode)node).getDataMapList());
			}
		}
		return result;
	}
	public String getXmlOutput(String root){
		StringWriter out = new StringWriter();
		writeXmlOutput(out, root);
		return out.toString();
	}
	public void writeXmlOutput(Writer writer, String root){
		try{
			writer.write(xmlStart(root));
			writeSingleElement(writer, "errorCode", errorCode, true);
			writeSingleElement(writer, "msg", msg, true);
			for(String key: apiNodeMap.keySet()){
				wrapXmlNode(writer, apiNodeMap.get(key));
			}
			writer.write(xmlEnd(root));
		}catch(IOException e){
		}
	}
	private static String xmlStart(String name){
		return "<" + name + ">";
	}
	private static String xmlEnd(String name){
		return "</" + name + ">";
	}
	private static void writeSingleElement(Writer writer, String name, Object value, boolean ignoreEmpty){
		String strValue = BeanUtil.getStringValue(value);
		if(!ignoreEmpty || StringUtils.isNotBlank(strValue)){
			try{
				writer.write(xmlStart(name));
				writer.write(StringEscapeUtils.escapeXml(strValue));
				writer.write(xmlEnd(name));
			}catch(IOException e){
			}
		}
	}
	private static void writeXmlMap(Writer writer, String nodeName, Map<String, ?> dataMap, boolean ignoreEmpty){
		if(!ignoreEmpty || dataMap!=null && !dataMap.isEmpty()){
			try{
				writer.write(xmlStart(nodeName));	
				for(String key: dataMap.keySet()){
					writeSingleElement(writer, key, dataMap.get(key), ignoreEmpty);
				}
				writer.write(xmlEnd(nodeName));
			}catch(IOException e){
			}
		}
	}
	private static void wrapXmlNode(Writer writer, AbstractApiNode dataNode){
		if(dataNode instanceof AbstractSimpleNode){
			AbstractSimpleNode node = (AbstractSimpleNode)dataNode;
			writeSingleElement(writer, node.getNodeName(), node.getSimpleValue(), node.ignoreEmpty);
		}else if(dataNode instanceof AbstractBeanNode){
			AbstractBeanNode node = (AbstractBeanNode)dataNode;
			Map<String, ?> dataMap = node.getDataMap();
			writeXmlMap(writer, node.nodeName, dataMap, node.ignoreEmpty);
		}else if(dataNode instanceof AbstractListNode){
			AbstractListNode node = (AbstractListNode)dataNode;
			if(!node.ignoreEmpty || node.getBeanList()!=null && !node.getBeanList().isEmpty()){
				try{
					writer.write(xmlStart(node.nodeName));
					for(Map<String, ?> dataMap: node.getDataMapList()){
						writeXmlMap(writer, node.getSingleNodeName(), dataMap, node.ignoreEmpty);
					}
					writer.write(xmlEnd(node.nodeName));
				}catch(IOException e){
				}
			}
			
		}
	}
}
