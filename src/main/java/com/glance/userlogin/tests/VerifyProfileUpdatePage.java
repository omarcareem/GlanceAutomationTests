package com.glance.userlogin.tests;

import java.io.IOException;


import junit.framework.Assert;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;

import com.glance.pageobjects.dashboard.CommonPageLeftPane;


import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;
import com.glance.pageobjects.userlogin.SettingsPage;



public class VerifyProfileUpdatePage extends BaseTest {
	

	
	@BeforeMethod
	 public void LoginAndNavigation() throws InterruptedException { 
		LoginPage loginPage=new LoginPage(driver);
		
		
		Thread.sleep(5000);
		loginPage.enterUsername(adminUser);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		commonLeftPane.clickSettings();
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		 
				
		
	}
	
	@AfterMethod
	public void Logout() throws InterruptedException{
		
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		Thread.sleep(5000);
		commonLeftPane.clickLogout();
		Thread.sleep(5000);
		
		
	}
	
	@Test (priority = 0)
	public void GL_Settings_PU_92 () throws InterruptedException {
		
		//valid user name
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.changeUsername(updateValidUN);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		//Invalid Username1
		Thread.sleep(5000);
		profileUpdate.changeUsername(updateInvalidUN1);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
	
	
		//Invalid username2	
		Thread.sleep(5000);
		profileUpdate.changeUsername(upadteInvalidUN2);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		
		//Invalid user name3
		Thread.sleep(5000);
		profileUpdate.changeUsername(updateExistingUN);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent5("User Name is duplicate entry!"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		//empty Username
		Thread.sleep(5000);
		profileUpdate.changeUsername(updateEmptyUN);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		profileUpdate.changeUsername(adminUser);	
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		
		Thread.sleep(5000);
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		Thread.sleep(5000);
		commonLeftPane.clickLogout();
		Thread.sleep(5000);
		
	
	}
	

	
	@Test (priority = 1)
	public void GL_Settings_PU_93 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.changeEmail(updateValidEID);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		
		
		//ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.changeEmail(updateInvalidEID);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent3("You have entered an invalid email address!"));
		profileUpdate.clickPopupOKBtn();
		
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		//ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.changeEmail(updateEmptyEID);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		
		settingspage.clickProfileUpdateBtn();
		
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		
		Thread.sleep(5000);
		profileUpdate.changeEmail(emailAddErr);
		Thread.sleep(5000);
		
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
				
	}
	
	

	

	
	@Test (priority = 2)
	public void GL_Settings_PU_94 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(updateValidPSW);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(updateValidConPSW);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(updateInvalidPSW1);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(updateInvalidConPSW1);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
	
		
		Thread.sleep(5000);
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(updateInvalidPSW2);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(updateInvalidConPSW2);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		
		
		
		
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(updateValidPSW);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(updateInvalidConPSW);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent4("The passsword and confirmation password do not match!"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(updateEmptyPSW);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(updateEmptyConPSW);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		profileUpdate.changeNewPswd(password);
		Thread.sleep(5000);
		profileUpdate.changeConPassword(password);
		
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
				
	}
	


	
	@Test (priority = 3)
	public void GL_Settings_PU_95 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.changeFirstName(updateFirstName);
		Thread.sleep(5000);
		profileUpdate.changeLastname(UpdatelastName);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getFirstNameValue("Neelamani"));
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getlastNameValue("Hewawasam"));
		
		Thread.sleep(5000);
		profileUpdate.changeFirstName(updateEmptyFirstName);
		Thread.sleep(5000);
		profileUpdate.changeLastname(UpdateEmptyLastName);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		
		
		settingspage.clickProfileUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getFirstNameValue("Neelamani"));
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getlastNameValue("Hewawasam"));
		Thread.sleep(5000);
		
		profileUpdate.changeFirstName(validfirstName);
		Thread.sleep(5000);
		profileUpdate.changeLastname(validlastName);
		Thread.sleep(5000);
		
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		
	}
	
	

	
	@Test (priority = 4)
	public void GL_Settings_PU_96 () throws InterruptedException, IOException {
		
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickchangeImg();
		profileUpdate.clickChooseImg();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\nhewawasam\\Desktop\\FileUpload.exe");
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		
		
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		//Assert.assertTrue(profileUpdate.getImagePreview("user_images/admin.png"));
		
		profileUpdate.clickchangeImg();
		profileUpdate.clickChooseImg();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\nhewawasam\\Desktop\\FileUpload1.exe");
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
	}

	
	@Test (priority = 5)
	public void  GL_Settings_PU_97 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		profileUpdate.selectJobRole(manager_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Manager - QA"));
		Thread.sleep(5000);
		
		
		profileUpdate.selectJobRole(sConsultant_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Senior Consultant - QA"));
		Thread.sleep(5000);
		
	
		profileUpdate.selectJobRole(consultant_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();	
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Consultant - QA"));
		Thread.sleep(5000);
		
	
		profileUpdate.selectJobRole(aConsultant_QA);
		Thread.sleep(5000);;
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Associate Consultant - QA"));
		Thread.sleep(5000);
		
	
		profileUpdate.selectJobRole(sEngineer_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Senior Engineer - QA"));
		Thread.sleep(5000);
		
		
		profileUpdate.selectJobRole(engineer_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Engineer - QA"));
		Thread.sleep(5000);
		
		
		profileUpdate.selectJobRole(aEngineer_QA);
		Thread.sleep(5000);
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		settingspage.clickProfileUpdateBtn();
		
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Associate Engineer - QA"));
		Thread.sleep(5000);
		
		
		profileUpdate.selectJobRole(jEngineer_QA);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Junior Engineer - QA"));
		Thread.sleep(5000);
		
		/*profileUpdate.selectJobRole(none);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		Assert.assertTrue(profileUpdate.getJobRoleValue("Please select your Job Role"));
		Thread.sleep(5000);*/
		
		Thread.sleep(5000);
		profileUpdate.selectJobRole(admin);
		Thread.sleep(5000);
		
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
				
	}

	
}

