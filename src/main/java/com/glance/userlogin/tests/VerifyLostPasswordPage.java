package com.glance.userlogin.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.LostPasswordPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyLostPasswordPage extends BaseTest {
	

	
	@Test (priority =3)
	public void GL_Login_09() throws InterruptedException {
		test=report.startTest("verifyLostPassword");
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking Lost Password Link");
		loginPage.navigateLostPasswordPage();
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		test.log(LogStatus.INFO, "Verifying the navigation of lost password page");
		Assert.assertTrue(lostPassword.getLostPasswordTitle("Lost Password"));
		
		
	}
	
	
	
		
	@Test (priority =4)
	public void GL_Login_10(){
		
		//Valid Request
	/*	LostPasswordPage lostPassword = new LostPasswordPage(driver);
		test.log(LogStatus.INFO, "Entering valid username");
		lostPassword.enterUserName(userName);
		test.log(LogStatus.INFO, "Entering valid email address");
		lostPassword.enterEmailAdd(emailAdd);
		test.log(LogStatus.INFO, "Clicking submit button");
		lostPassword.clickSubmitBtn();
		test.log(LogStatus.INFO, "Verifying the valid lost password request submission");
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent1("Successfully updated!"));
		test.log(LogStatus.INFO, "Clicking message box done button");
		lostPassword.clickPopupDone();*/
			
	
	
	//Invalid request1
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		test.log(LogStatus.INFO, "Entering invalid username");
		lostPassword.enterUserName(userNameErr);
		test.log(LogStatus.INFO, "Entering valid email address");
		lostPassword.enterEmailAdd(emailAdd);
		test.log(LogStatus.INFO, "Clicking submit button");
		lostPassword.clickSubmitBtn();
		test.log(LogStatus.INFO, "Verifying the invalid lost password request submission");
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		test.log(LogStatus.INFO, "Clicking message box done button");
		lostPassword.clickPopupOkay();
		

	//Invalid Request3
		test.log(LogStatus.INFO, "Entering valid username");
		lostPassword.enterUserName(userName);
		test.log(LogStatus.INFO, "Entering invalid email address");
		lostPassword.enterEmailAdd(emailAddErr);
		test.log(LogStatus.INFO, "Clicking submit button");
		lostPassword.clickSubmitBtn();
		test.log(LogStatus.INFO, "Verifying the invalid lost password request submission");
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		test.log(LogStatus.INFO, "Clicking message box done button");
		lostPassword.clickPopupOkay();
		
	
	//Invalid Request4
		test.log(LogStatus.INFO, "Entering invalid username");
		lostPassword.enterUserName(userNameErr);
		test.log(LogStatus.INFO, "Entering invalid email address");
		lostPassword.enterEmailAdd(emailAddErr);
		test.log(LogStatus.INFO, "Clicking submit button");
		lostPassword.clickSubmitBtn();
		test.log(LogStatus.INFO, "Verifying the invalid lost password request submission");
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		test.log(LogStatus.INFO, "Clicking message box done button");
		lostPassword.clickPopupOkay();
		
}

	
	@Test (priority =5)
	public void GL_Login_11(){
		
	
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		test.log(LogStatus.INFO, "Clicking Back button");
		lostPassword.clickBackBtn();
		
		LoginPage loginPage=new LoginPage(driver);
		test.log(LogStatus.INFO, "Verifying the navigation to login page");
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));
		

	}
	
	
	
	
	
		
		
}
