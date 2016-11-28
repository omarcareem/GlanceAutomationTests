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
	
	public static String accountName;
	public static String DeliveryMethod;
	public static String conractType;
	public static String years;
	public static String radioButton;
	public static String addNewEngagement;
	
	public static String dateRange; 
	public static String customDateStart;
	public static String customDateEnd;
	
	public static String deleteType;
	public static String typeID;
	public static String typeName;
	public static String sqlQuery;
	
	public static String showEntry;
	public static String enterSearch;
	
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
		System.out.println(userName);
		password=getDataRepository().getProperty("password");
		System.out.println(password);
		
		accountName=getDataRepository().getProperty("accountName");
		System.out.println(accountName);
		DeliveryMethod=getDataRepository().getProperty("DeliveryMethod");
		System.out.println(DeliveryMethod);
		conractType=getDataRepository().getProperty("conractType");
		System.out.println(conractType);
		years=getDataRepository().getProperty("years");
		System.out.println(years);
		radioButton=getDataRepository().getProperty("radioButton");
		System.out.println(radioButton);
		addNewEngagement=getDataRepository().getProperty("addNewEngagement");
		System.out.println(addNewEngagement);
		
		dateRange=getDataRepository().getProperty("dateRange");
		System.out.println(dateRange);
		customDateStart=getDataRepository().getProperty("customDateStart");
		System.out.println(customDateStart);
		customDateEnd=getDataRepository().getProperty("customDateEnd");
		System.out.println(customDateEnd);
		
		deleteType=getDataRepository().getProperty("deleteType");
		System.out.println(deleteType);
		typeID=getDataRepository().getProperty("typeID");
		System.out.println(typeID);
		typeName=getDataRepository().getProperty("typeName");
		System.out.println(typeName);
		sqlQuery=getDataRepository().getProperty("sqlQuery");
		System.out.println(sqlQuery);
		
		showEntry=getDataRepository().getProperty("showEntry");
		System.out.println(showEntry);
		enterSearch=getDataRepository().getProperty("enterSearch");
		System.out.println(enterSearch);
	}

}
