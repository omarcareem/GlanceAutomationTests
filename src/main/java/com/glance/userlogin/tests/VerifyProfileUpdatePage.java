package com.glance.userlogin.tests;

import java.io.IOException;
import junit.framework.Assert;
import org.testng.annotations.Test;
import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyProfileUpdatePage extends BaseTest {
	
	
	@Test (priority = 12)
	public void GL_Settings_PS_05 () throws InterruptedException {
		
		test=report.startTest("verifyprofileupadatepage");
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering the user name admin 2");
		loginPage.enterUsername(adminUser);
		test.log(LogStatus.INFO, "Entering the Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking login Button");
		loginPage.clickLoginBtn();
	
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking Settings button");
		commonLeftPane.clickSettings();
		
		SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking profile update Button");
		settingspage.clickProfileUpdateBtn();
		
		
		//valid user name
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(updateValidUN);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Successfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		test.log(LogStatus.INFO, "Clicking Message Box Done Button");
		profileUpdate.clickPopupDoneBtn();
		
	//	SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking Profile Update Button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Successfull update of user name");
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		//Invalid Username1
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(updateInvalidUN1);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box Okay Button");
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of user name ");
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
	
	
		//Invalid username2	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(upadteInvalidUN2);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box Okay Button");
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of user name ");
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		
		//Invalid user name3
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(updateExistingUN);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent5("User Name is duplicate entry!"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box Okay Button");
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of user name ");
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		//empty Username
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(updateEmptyUN);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent2("Please enter user name in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box Okay Button");
		profileUpdate.clickPopupOKBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of user name ");
		Assert.assertTrue(profileUpdate.getUserNameValue("admin1"));
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the user name");
		profileUpdate.changeUsername(adminUser);	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box done Button");
		profileUpdate.clickPopupDoneBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking profile update Button");
		settingspage.clickProfileUpdateBtn();
	
	}
	

	
	@Test (priority = 13)
	public void GL_Settings_PS_06 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the email address");
		profileUpdate.changeEmail(updateValidEID);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Successfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		test.log(LogStatus.INFO, "Clicking Message Box done Button");
		profileUpdate.clickPopupDoneBtn();
		
		SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking profile update Button");
		settingspage.clickProfileUpdateBtn();
		
		test.log(LogStatus.INFO, "Verifying that the Successful update of email Address ");
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		
		
		//ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the email address");
		profileUpdate.changeEmail(updateInvalidEID);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent3("You have entered an invalid email address!"));
		test.log(LogStatus.INFO, "Clicking Message Box Ok Button");
		profileUpdate.clickPopupOKBtn();
		
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of email Address ");
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		//ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the email address");
		profileUpdate.changeEmail(updateEmptyEID);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the unsuccessfull update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		test.log(LogStatus.INFO, "Clicking Message Box done Button");
		profileUpdate.clickPopupDoneBtn();
		
		test.log(LogStatus.INFO, "Clicking profile update Button");
		settingspage.clickProfileUpdateBtn();
		
		test.log(LogStatus.INFO, "Verifying that the unsuccessful update of email Address ");
		Assert.assertTrue(profileUpdate.getEmailIDValue("admin1@gmail.com"));
		
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the email address");
		profileUpdate.changeEmail(emailAddErr);
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Clicking update Button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Message Box done Button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Clicking profile update Button");
		settingspage.clickProfileUpdateBtn();		
	}
	
	

	

	
	@Test (priority = 14)
	public void GL_Settings_PS_07 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(updateValidPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(updateValidConPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		SettingsPage settingspage= new SettingsPage(driver);
		
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(updateInvalidPSW1);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(updateInvalidConPSW1);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the unsuccessful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Okay button");
		profileUpdate.clickPopupOKBtn();
	
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(updateInvalidPSW2);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(updateInvalidConPSW2);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the unsuccessful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Okay button");
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		
		
		
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(updateValidPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(updateInvalidConPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the unsuccessful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent4("The passsword and confirmation password do not match!"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Okay button");
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(updateEmptyPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(updateEmptyConPSW);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the unsuccessful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent6("Please enter password in valid length !"));
		Thread.sleep(5000);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Okay button");
		profileUpdate.clickPopupOKBtn();
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Clicking the change password button");
		profileUpdate.clickChangePssword();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the password");
		profileUpdate.changeNewPswd(password);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing confirm password");
		profileUpdate.changeConPassword(password);
		
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the messge box Done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);

		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
				
	}
	


	
	@Test (priority = 15)
	public void GL_Settings_PS_08 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the First name");
		profileUpdate.changeFirstName(updateFirstName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the Last name");
		profileUpdate.changeLastname(UpdatelastName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "clicking the message box Done Button");
		profileUpdate.clickPopupDoneBtn();
		
		SettingsPage settingspage= new SettingsPage(driver);
		
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update of first name");
		Assert.assertTrue(profileUpdate.getFirstNameValue("Neelamani"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update of Last name");
		Assert.assertTrue(profileUpdate.getlastNameValue("Hewawasam"));
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the first name");
		profileUpdate.changeFirstName(updateEmptyFirstName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the Last name");
		profileUpdate.changeLastname(UpdateEmptyLastName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "clicking the message box Done Button");
		profileUpdate.clickPopupDoneBtn();
		
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update of first name");
		Assert.assertTrue(profileUpdate.getFirstNameValue("Neelamani"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "verifying the successful update of Last name");
		Assert.assertTrue(profileUpdate.getlastNameValue("Hewawasam"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the first name");
		profileUpdate.changeFirstName(validfirstName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the Last name");
		profileUpdate.changeLastname(validlastName);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "clicking the message box Done Button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
	}
	
	

	
	@Test (priority = 16)
	public void GL_Settings_PS_09 () throws InterruptedException, IOException {
		
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		test.log(LogStatus.INFO, "Clicking the Change Image button");
		profileUpdate.clickchangeImg();
		test.log(LogStatus.INFO, "Clicking the Choose Image button");
		profileUpdate.clickChooseImg();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Coosing an Image");
		Runtime.getRuntime().exec("C:\\Users\\nhewawasam\\Desktop\\FileUpload.exe");
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		
		
		SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		//Assert.assertTrue(profileUpdate.getImagePreview("user_images/admin.png"));
		
		test.log(LogStatus.INFO, "Clicking the Change Image button");
		profileUpdate.clickchangeImg();
		test.log(LogStatus.INFO, "Clicking the Choose Image button");
		profileUpdate.clickChooseImg();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Coosing an Image");
		Runtime.getRuntime().exec("C:\\Users\\nhewawasam\\Desktop\\FileUpload1.exe");
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
	}

	
	@Test (priority = 17)
	public void GL_Settings_PS_10 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(manager_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Manager - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(sConsultant_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Senior Consultant - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(consultant_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Consultant - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(aConsultant_QA);
		Thread.sleep(5000);;
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Associate Consultant - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(sEngineer_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Senior Engineer - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(engineer_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Engineer - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(aEngineer_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Associate Engineer - QA"));
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(jEngineer_QA);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update");
		Assert.assertTrue(profileUpdate.getpopupMsgContent1("Profile details updated successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the profile update button");
		settingspage.clickProfileUpdateBtn();
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful profile update of job role");
		Assert.assertTrue(profileUpdate.getJobRoleValue("Junior Engineer - QA"));
		Thread.sleep(5000);
		
	
	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Changing the job role");
		profileUpdate.selectJobRole(admin);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the update button");
		profileUpdate.clickUpdateBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box done button");
		profileUpdate.clickPopupDoneBtn();
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking the Logout button");
		commanleft.clickLogout();	
		
				
	}

	
}

