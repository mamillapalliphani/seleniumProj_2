package com.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties proper;
	public ReadConfig() {
		File  src=new File("./Configuration\\config.properties");
		try {
		FileInputStream file=new FileInputStream(src);
		proper=new Properties();
		proper.load(file);
		} catch (Exception e) {
		System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=proper.getProperty("baseurl");
		return url;
	}
	public String getUserName() {
		String userName=proper.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String password=proper.getProperty("password");
		return password;
	}
	public String getChromeDriver() {
		String chromeDriver=proper.getProperty("chromepath");
		return chromeDriver;
	}
	public String getfirefoxpath() {
		String firefoxpath=proper.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getiepath() {
		String iepath=proper.getProperty("iepath");
		return iepath;
	}
}
