package org.ssm.zhb.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author lwm
 *
 */
public class PropertiesUtil {
	
	private static Properties properties = new Properties();
	
	private static String propName = "config/jjp.properties";

	public static String getPropertiesValue(String propFileName, String propertiesKey) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			if(propFileName == null){
				propFileName = propName;
			}
			InputStream config = cl.getResourceAsStream(propFileName);
			properties.load(config);
			config.close();
			return properties.getProperty(propertiesKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getStatusCode(String bankStatus, String errorFile) {
		try{
			String strSysError = getPropertiesValue(errorFile,bankStatus);
			if(StringUtils.isEmpty(strSysError)) {
				return "000100";
			} else {
				return strSysError;
			}
		} catch (Exception ex) {
			return "";
		}
	}
	
	public static String getConstant(String bankStatus, String errorFile) {
		try{
			String strConstant = getPropertiesValue(errorFile,bankStatus);
			if(StringUtils.isEmpty(strConstant)) {
				return "";
			} else {
				return strConstant;
			}
		} catch (Exception ex) {
			return "";
		}
	}
	
	
	public static String getStatusMessage(String systemStatus){
		try{
			String strSysErrorM = getPropertiesValue("systemError.properties",systemStatus);
			if(StringUtils.isEmpty(strSysErrorM)) {
				return "原因未知";
			} else {
				return strSysErrorM;
			}
		} catch (Exception ex) {
			return "";
		}
	}
	public static String getPropertiesValue(String propertiesKey) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			InputStream config = cl.getResourceAsStream(propName);
			properties.load(config);
			config.close();
			return properties.getProperty(propertiesKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String test=PropertiesUtil.getPropertiesValue("jdbc.url");
		System.out.println(test);
	}
}
