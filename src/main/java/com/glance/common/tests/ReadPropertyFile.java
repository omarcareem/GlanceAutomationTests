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
	public static String geckoDriverPath;
	public static String baseUrl;
	public static String browser;
	public static String userName;
	public static String password;
	
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
		
		
	}

}
