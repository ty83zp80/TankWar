package com.bimo.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
	private static PropertyMgr INSTANCE = new PropertyMgr();
	static Properties props = new Properties();
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private PropertyMgr() {	}
	
	public static PropertyMgr getInstance() {
		return INSTANCE;
	}
	
	public Object get(String key) {
		if(props == null) return null;
		return props.get(key);
	}
}
