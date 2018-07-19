package com.inno72.log.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

	private String properiesName = "";

	public PropertiesUtil() {

	}

	public PropertiesUtil(String fileName) {
		this.properiesName = fileName;
	}

	public String readProperty(String key) {
		String value = "";
		InputStream is = null;
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName);
			Properties p = new Properties();
			p.load(is);
			value = p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public Properties getProperties() {
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName);
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

}