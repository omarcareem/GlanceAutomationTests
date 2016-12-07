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
	
	public static String emptyProjectName;
	
	public static String wrongpassword;
	public static String emptypassword;
	public static String userNameErr;
	public static String passwordErr;
	
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
	public static String recordInsert;
	
	public static String emailAdd;
	public static String emailAddErr;
	
	public static String newValidUN;
	public static String newValidEID;
	public static String newValidPSW;
	public static String newValidConPSW;
	public static String newInvalidUN1;
	public static String newInvalidUN2;
	public static String newInvalidEID;
	public static String newInvalidPSW1;
	public static String newInvalidPSW2;
	public static String newInvalidConPSW1;
	public static String newInvalidConPSW2;
	
	
	public static String updateInvalidUN1;
	public static String upadteInvalidUN2;
	public static String updateExistingUN;
	public static String updateValidUN;
	public static String updateInvalidEID;
	public static String updateValidEID;
	public static String updateInvalidPSW1;
	public static String updateInvalidConPSW1;
	public static String updateInvalidPSW2;
	public static String updateInvalidConPSW2;
	public static String updateValidPSW;
	public static String updateValidConPSW;
	public static String updateInvalidConPSW;
	public static String updateFirstName;
	public static String UpdatelastName;
	
	

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
		
		clientProjectId=getDataRepository().getProperty("emptyProjectName");
		System.out.println(emptyProjectName);
		
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
		recordInsert=getDataRepository().getProperty("recordInsert");
		System.out.println(recordInsert);
		
		
		//LoginValidation
		userNameErr=getDataRepository().getProperty("userNameErr");
		System.out.println(userNameErr);
		passwordErr=getDataRepository().getProperty("passwordErr");
		System.out.println(passwordErr);
				
		//LostPasswordValidatin
		emailAdd=getDataRepository().getProperty("emailAdd");
		System.out.println(emailAdd);
		emailAddErr=getDataRepository().getProperty("emailAddErr");
		System.out.println(emailAddErr);
				
		//CreateAccountValidation
		newValidUN=getDataRepository().getProperty("newValidUN");
		System.out.println(newValidUN);
		newValidEID=getDataRepository().getProperty("newValidEID");
		System.out.println(newValidEID);
		newValidPSW=getDataRepository().getProperty("newValidPSW");
		System.out.println(newValidPSW);
		newValidConPSW=getDataRepository().getProperty("newValidConPSW");
		System.out.println(newValidConPSW);
		newInvalidUN1=getDataRepository().getProperty("newInvalidUN1");
		System.out.println(newInvalidUN1);
		newInvalidUN2=getDataRepository().getProperty("newInvalidUN2");
		System.out.println(newInvalidUN2);
		newInvalidEID=getDataRepository().getProperty("newInvalidEID");
		System.out.println(newInvalidEID);
		newInvalidPSW1=getDataRepository().getProperty("newInvalidPSW1");
		System.out.println(newInvalidPSW1);
		newInvalidPSW2=getDataRepository().getProperty("newInvalidPSW2");
		System.out.println(newInvalidPSW2);
		newInvalidConPSW1=getDataRepository().getProperty("newInvalidConPSW1");
		System.out.println(newInvalidConPSW1);
		newInvalidConPSW2=getDataRepository().getProperty("newInvalidConPSW2");
		System.out.println(newInvalidConPSW2);
				
		//profile Update Page Validations
		updateInvalidUN1=getDataRepository().getProperty("updateInvalidUN1");
		System.out.println(updateInvalidUN1);
		upadteInvalidUN2=getDataRepository().getProperty("upadteInvalidUN2");
		System.out.println(upadteInvalidUN2);
		updateExistingUN=getDataRepository().getProperty("updateExistingUN");
		System.out.println(newInvalidConPSW2);
				
		updateValidUN=getDataRepository().getProperty("updateValidUN");
		System.out.println(updateValidUN);
		updateInvalidEID=getDataRepository().getProperty("updateInvalidEID");
		System.out.println(updateInvalidEID);
		updateValidEID=getDataRepository().getProperty("updateValidEID");
		System.out.println(updateValidEID);
				
		updateInvalidPSW1=getDataRepository().getProperty("updateInvalidPSW1");
		System.out.println(updateInvalidPSW1);
		updateInvalidConPSW1=getDataRepository().getProperty("updateInvalidConPSW1");
		System.out.println(updateInvalidConPSW1);
		updateInvalidPSW2=getDataRepository().getProperty("updateInvalidPSW2");
		System.out.println(updateInvalidPSW2);
				
				
		updateInvalidConPSW2=getDataRepository().getProperty("updateInvalidConPSW2");
		System.out.println(updateInvalidConPSW2);
		updateValidPSW=getDataRepository().getProperty("updateValidPSW");
		System.out.println(updateValidPSW);
		updateValidConPSW=getDataRepository().getProperty("updateValidConPSW");
		System.out.println(updateValidConPSW);
				
		updateInvalidConPSW=getDataRepository().getProperty("updateInvalidConPSW");
		System.out.println(updateInvalidConPSW);
		updateFirstName=getDataRepository().getProperty("updateFirstName");
		System.out.println(updateFirstName);
		UpdatelastName=getDataRepository().getProperty("UpdatelastName");
		System.out.println(UpdatelastName);
				
				
			
	}

	
	
}
