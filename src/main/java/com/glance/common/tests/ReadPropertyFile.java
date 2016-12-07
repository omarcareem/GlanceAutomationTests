package com.glance.common.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.thoughtworks.selenium.webdriven.commands.GetValue;

public class ReadPropertyFile {


	public static String driverCommonPath=System.getProperty("user.dir")+ "/";	
	public static WebDriver driver;
	public static String chromeDriverPath;
	public static String ieDriverPath;
	public static String geckoDriverPath;
	public static String baseUrl;
	public static String browser;
	public static String userName;
	public static String password;
	
	public static String accountName;
	public static String segment;
	public static String tableName;
	public static String userin;
	
	public static String clientProjectId;
	public static String engagementName;
	public static String applicationName;
	public static String fundStartDate;
	public static String fundEndDate;
	public static String fundReleaseDate;
	public static String status;
	
	
	public static String wrongpassword;
	public static String emptypassword;
	
	public static String expectedMessageUserId;
	public static String expectedMessageUserName;
	public static String expectedMessageFirstName;
	public static String expectedMessageLastName;
	
	public static String accountName2;
	public static String DeliveryMethod;
	public static String conractType;
	public static String years;
	public static String radioButton;
	public static String addNewEngagement;
	
	public static String accountName1;
	public static String engagementName1;
	public static String projectName1;
	public static String individualName1;
	public static String dateRange; 
	public static String customDateStart;
	public static String customDateEnd;
	public static String userName1;
	public static String password1;
	
	public static String deleteType;
	public static String typeID;
	public static String typeName;
	public static String sqlQuery;
	
	public static String showEntry;
	public static String enterSearch;
	public static int rowCount;
	public static String columnName;

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
		geckoDriverPath = driverCommonPath+ getDataRepository().getProperty("geckoDriverPath");
		userName=getDataRepository().getProperty("userName");
		System.out.println(userName);
		password=getDataRepository().getProperty("password");
		System.out.println(password);
		
		accountName=getDataRepository().getProperty("accountName");
		System.out.println(accountName);
		segment=getDataRepository().getProperty("segment");
		System.out.println(segment);
		tableName=getDataRepository().getProperty("tableName");
		System.out.println(tableName);
		
		clientProjectId=getDataRepository().getProperty("clientProjectId");
		System.out.println(clientProjectId);
		engagementName=getDataRepository().getProperty("engagementName");
		System.out.println(engagementName);
		applicationName=getDataRepository().getProperty("applicationName");
		System.out.println(applicationName);
		fundStartDate=getDataRepository().getProperty("fundStartDate");
		System.out.println(fundStartDate);	
		fundEndDate=getDataRepository().getProperty("fundEndDate");
		System.out.println(fundEndDate);
		fundReleaseDate=getDataRepository().getProperty("fundReleaseDate");
		System.out.println(fundReleaseDate);
		status=getDataRepository().getProperty("status");
		System.out.println(status);
		
		wrongpassword=getDataRepository().getProperty("wrongpassword");
		System.out.println(wrongpassword);
		emptypassword=getDataRepository().getProperty("emptypassword");
		System.out.println(emptypassword);
		expectedMessageUserId=getDataRepository().getProperty("expectedMessageUserId");
		System.out.println(expectedMessageUserId);
		expectedMessageUserName=getDataRepository().getProperty("expectedMessageUserName");
		System.out.println(expectedMessageUserName);
		expectedMessageFirstName=getDataRepository().getProperty("expectedMessageFirstName");
		System.out.println(expectedMessageFirstName);
		expectedMessageLastName=getDataRepository().getProperty("expectedMessageLastName");
		System.out.println(expectedMessageLastName);
		
		accountName1=getDataRepository().getProperty("accountName2");
		System.out.println(accountName2);
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
		
		accountName1=getDataRepository().getProperty("accountName1");
		System.out.println(accountName1);
		engagementName1=getDataRepository().getProperty("engagementName1");
		System.out.println(engagementName1);
		projectName1=getDataRepository().getProperty("projectName1");
		System.out.println(projectName1);
		individualName1=getDataRepository().getProperty("individualName1");
		System.out.println(individualName1);
		dateRange=getDataRepository().getProperty("dateRange");
		System.out.println(dateRange);
		customDateStart=getDataRepository().getProperty("customDateStart");
		System.out.println(customDateStart);
		customDateEnd=getDataRepository().getProperty("customDateEnd");
		System.out.println(customDateEnd);
		userName1=getDataRepository().getProperty("userName1");
		System.out.println(userName1);
		password1=getDataRepository().getProperty("password1");
		System.out.println(password1);
		
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
		/*rowCount=getDataRepository().getProperty(rowCount);
		System.out.println(rowCount);*/
		columnName=getDataRepository().getProperty("columnName");
		System.out.println(columnName);
	}

}
