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
	public static String userin1;
	public static String colomName;
	
	public static String clientProjectId;
	public static String engagementName;
	public static String applicationName;
	public static String fundStartDate;
	public static String fundEndDate;
	public static String fundReleaseDate;
	public static String status;
	
	/*public static String emptyProjectName;
	public static String wrongProjectName;
	public static String emptyClientProjectId;
	public static String wrongClientProjectId;*/
	
	
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
	public static String email;
	public static String accountName4;
	
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
	public static String updateEmptyUN;
	public static String updateValidUN;
	public static String updateInvalidEID;
	public static String updateEmptyEID;
	public static String updateValidEID;
	public static String updateInvalidPSW1;
	public static String updateInvalidConPSW1;
	public static String updateInvalidPSW2;
	public static String updateInvalidConPSW2;
	public static String updateValidPSW;
	public static String updateValidConPSW;
	public static String updateInvalidConPSW;
	public static String updateEmptyPSW;
	public static String updateEmptyConPSW;
	public static String updateFirstName;
	public static String UpdatelastName;
	public static String validfirstName;
	public static String validlastName;
	

	//User management

	public static String group;
	public static String user;
	
	
	public static String labl;
	public static String addUser;
	public static String addSelectGroup;
	
	public static String verifyUser;
	

	public static String user1;
	
	public static String newUserName;
	public static String firstName;
	public static String lastName;
	//public static String email;
	public static String newPassword;
	public static String confirmPassword;
	public static String role;
	public static String path;
	public static String userDelete;
	public static String userDeleteCancel;
	public static String userCancel;
	public static String userClose;

	public static String eType;
	public static String eId;
	
	public static String userNameEdit;
	public static String emailAddEdit;
	public static String passwordEdit;
	public static String groupAdd;
	public static String wrongUserName;
	public static String wrongEmail;

	


	public static String admin;
	public static String manager_QA;
	public static String sConsultant_QA;
	public static String consultant_QA;
	public static String aConsultant_QA;
	public static String sEngineer_QA;
	public static String engineer_QA;
	public static String aEngineer_QA;
	public static String jEngineer_QA;


	public static int rowCount;
	public static String columnName;

	public static String grpName;
    public static String grpNameNew;
    public static String grpNameDeleted;
    public static String accountName3;
    public static String projectName;
    public static String expectedMessageEdit;
    public static String searchTwo;
    public static String searchFullText;
    public static String searchUnexisting;
    public static String searchEmpty;
    public static String searchAD;
    public static String expectedMessage;
    public static String profileUpdateTitle;
    public static String lblLoginTitle;
    public static String expectedMessageTitleSet;


	
	
	public static String selectTopPaneProfile;
	public static String selectTopPaneLogout;
	
	
	
	 
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
		userin=getDataRepository().getProperty("userin");
		System.out.println(userin);
		userin1=getDataRepository().getProperty("userin1");
		System.out.println(userin1);
		colomName=getDataRepository().getProperty("colomName");
		System.out.println(colomName);
		
		
		
		
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
		
		/*clientProjectId=getDataRepository().getProperty("emptyProjectName");
		System.out.println(emptyProjectName);
		clientProjectId=getDataRepository().getProperty("wrongProjectName");
		System.out.println(wrongProjectName);
		clientProjectId=getDataRepository().getProperty("emptyClientProjectId");
		System.out.println(emptyClientProjectId);
		clientProjectId=getDataRepository().getProperty("wrongClientProjectId");
		System.out.println(wrongClientProjectId);*/
		
		
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
		email=getDataRepository().getProperty("email");
		System.out.println(email);
		accountName4=getDataRepository().getProperty("accountName4");
		System.out.println(accountName4);
		
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
		System.out.println(updateExistingUN);		
		updateEmptyUN=getDataRepository().getProperty("updateEmptyUN");
		System.out.println(updateEmptyUN);
		updateValidUN=getDataRepository().getProperty("updateValidUN");
		System.out.println(updateValidUN);
		updateInvalidEID=getDataRepository().getProperty("updateInvalidEID");
		System.out.println(updateInvalidEID);
		updateEmptyEID=getDataRepository().getProperty("updateEmptyEID");
		System.out.println(updateEmptyEID);
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
		updateEmptyPSW=getDataRepository().getProperty("updateEmptyPSW");
		System.out.println(updateEmptyPSW);
		updateEmptyConPSW=getDataRepository().getProperty("updateEmptyConPSW");
		System.out.println(updateEmptyConPSW);
		updateFirstName=getDataRepository().getProperty("updateFirstName");
		System.out.println(updateFirstName);
		UpdatelastName=getDataRepository().getProperty("UpdatelastName");
		System.out.println(UpdatelastName);

		

		
		//User management
		group=getDataRepository().getProperty("group");
		user=getDataRepository().getProperty("user");
		
		labl=getDataRepository().getProperty("labl");
		addUser=getDataRepository().getProperty("addUser");
		addSelectGroup=getDataRepository().getProperty("addSelectGroup");

		verifyUser=getDataRepository().getProperty("verifyUser");
		
		user1=getDataRepository().getProperty("user1");

		newUserName=getDataRepository().getProperty("newUserName");
		firstName=getDataRepository().getProperty("firstName");
		lastName=getDataRepository().getProperty("lastName");
		email=getDataRepository().getProperty("email");
		newPassword=getDataRepository().getProperty("newPassword");
		confirmPassword=getDataRepository().getProperty("confirmPassword");
		role=getDataRepository().getProperty("role");
		path=getDataRepository().getProperty("role");
		userDelete=getDataRepository().getProperty("userDelete");
		userDeleteCancel=getDataRepository().getProperty("userDeleteCancel");
		userCancel=getDataRepository().getProperty("userCancel");
		
		userClose=getDataRepository().getProperty("userClose");
		
		eType=getDataRepository().getProperty("eType");
		eId=getDataRepository().getProperty("eId");	
		
		userNameEdit=getDataRepository().getProperty("userNameEdit");
		emailAddEdit=getDataRepository().getProperty("emailAddEdit");	
		passwordEdit=getDataRepository().getProperty("passwordEdit");
		
		groupAdd=getDataRepository().getProperty("groupAdd");
		wrongUserName=getDataRepository().getProperty("wrongUserName");
		wrongEmail=getDataRepository().getProperty("wrongEmail");
				
			


		validfirstName=getDataRepository().getProperty("validfirstName");
		System.out.println(validfirstName);		
		validlastName=getDataRepository().getProperty("validlastName");
		System.out.println(validlastName);		
		
		
		admin=getDataRepository().getProperty("admin");
		System.out.println(admin);		
		manager_QA=getDataRepository().getProperty("manager_QA");
		System.out.println(manager_QA);		
		sConsultant_QA=getDataRepository().getProperty("sConsultant_QA");
		System.out.println(sConsultant_QA);		
		consultant_QA=getDataRepository().getProperty("consultant_QA");
		System.out.println(consultant_QA);		
		aConsultant_QA=getDataRepository().getProperty("aConsultant_QA");
		System.out.println(aConsultant_QA);		
		sEngineer_QA=getDataRepository().getProperty("sEngineer_QA");
		System.out.println(sEngineer_QA);		
		engineer_QA=getDataRepository().getProperty("engineer_QA");
		System.out.println(engineer_QA);		
		aEngineer_QA=getDataRepository().getProperty("aEngineer_QA");
		System.out.println(aEngineer_QA);		
		jEngineer_QA=getDataRepository().getProperty("jEngineer_QA");
		System.out.println(jEngineer_QA);		
		
		
		selectTopPaneProfile=getDataRepository().getProperty("selectTopPaneProfile");
		System.out.println(selectTopPaneProfile);
		selectTopPaneLogout=getDataRepository().getProperty("selectTopPaneLogout");
		System.out.println(selectTopPaneLogout);
		

		/*rowCount=getDataRepository().getProperty(rowCount);
		System.out.println(rowCount);*/
		columnName=getDataRepository().getProperty("columnName");
		System.out.println(columnName);



		accountName=getDataRepository().getProperty("accountName");
		projectName=getDataRepository().getProperty("projectName");
		expectedMessageEdit=getDataRepository().getProperty("expectedMessageEdit");
		searchTwo=getDataRepository().getProperty("searchTwo");
		searchFullText=getDataRepository().getProperty("searchFullText");
		searchUnexisting=getDataRepository().getProperty("searchUnexisting");
		searchEmpty=getDataRepository().getProperty("searchEmpty");
		searchAD=getDataRepository().getProperty("searchAD");	
		expectedMessage=getDataRepository().getProperty("expectedMessage");
		profileUpdateTitle=getDataRepository().getProperty("profileUpdateTitle");
		lblLoginTitle=getDataRepository().getProperty("lblLoginTitle");
		

	}

	
	
}
