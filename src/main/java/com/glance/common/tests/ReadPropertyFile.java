package com.glance.common.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class ReadPropertyFile {


	public static String driverCommonPath=System.getProperty("user.dir")+ "/";	
	public static WebDriver driver;
	public static String chromeDriverPath;
	public static String ieDriverPath;
	public static String baseUrl;
	public static String browser;
	public static String userName;
	public static String password;
	public static String segment;
	public static String accountName;
	public static String tableName;
	public static String socketName;
	public static String url;
	public static String userName1;
	public static String password1;
	public static String query;
	public static String tableName1;
	public static String userin;
	public static String deleRecord;
	
	public static Properties getDataRepository() throws IOException {
		// Read object repository file
		Properties prop = new Properties();
		InputStream stream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\PropertyFile\\config.properties"));
		// load all objects
		prop.load(stream);
		return prop;
	}
	
	@BeforeSuite
	public void testStartUp() throws IOException{
		baseUrl = getDataRepository().getProperty("Url");
		browser = getDataRepository().getProperty("browser");
		chromeDriverPath = driverCommonPath+ getDataRepository().getProperty("chromeDriverPath");
		ieDriverPath = driverCommonPath+ getDataRepository().getProperty("ieDriverPath");
		userName=getDataRepository().getProperty("userName");
		//System.out.println(userName);
		password=getDataRepository().getProperty("password");
		//System.out.println(password);
		segment=getDataRepository().getProperty("segment");
		//System.out.println(segment);
		accountName=getDataRepository().getProperty("accountName");
		//System.out.println(accountName);
		tableName=getDataRepository().getProperty("tableName");
		//System.out.println(tableName);
		socketName=getDataRepository().getProperty("socketName");
		//System.out.println(socketName);
		url=getDataRepository().getProperty("url");
		//System.out.println(url);
		userName1=getDataRepository().getProperty("userName1");
		//System.out.println(userName1);
		password1=getDataRepository().getProperty("password1");
		//System.out.println(password1);
		query=getDataRepository().getProperty("query");
		//System.out.println(query);
		userin=getDataRepository().getProperty("userin");
		//System.out.println(userin);
		deleRecord=getDataRepository().getProperty("deleRecord");
		//System.out.println(deleRecord);
	}

}
