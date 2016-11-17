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
		
	}

}
