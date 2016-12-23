package com.glance.userlogin.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;

import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyLoginPage extends BaseTest {

	@Test(priority = 0)
	public void GL_Login_01() {
		test=report.startTest("verifyLoginPage");
		LoginPage loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Login Page");
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));
	}

	@Test(priority = 1)
	public void GL_login_02() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering Valid User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Valid Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();

		DashboardPage dashBoard = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying valid login and navigation to dashboard");
		Assert.assertTrue(dashBoard.getPageName("Account Level Dashboard"));

		CommonPageLeftPane commanleft = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Logout from the system");
		commanleft.clickLogout();

		// invalid Login 1

		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering Invalid User name");
		loginPage.enterUsername(userNameErr);
		test.log(LogStatus.INFO, "Entering Valid Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");	
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Verifying invalid login message");
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		test.log(LogStatus.INFO, "Clicking message Box Okay button");
		loginPage.clickErrorOK();

		// Invalid Login2

		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering valid User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Invalid Password");
		loginPage.enterPassword(passwordErr);

		test.log(LogStatus.INFO, "Clicking on login button");	
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Verifying invalid login message");
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		test.log(LogStatus.INFO, "Clicking message Box Okay button");
		loginPage.clickErrorOK();

		// Invalid Login3
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering Invalid User name");
		loginPage.enterUsername(userNameErr);
		test.log(LogStatus.INFO, "Entering Invalid Password");
		loginPage.enterPassword(passwordErr);

		test.log(LogStatus.INFO, "Clicking on login button");	
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Verifying invalid login message");
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		test.log(LogStatus.INFO, "Clicking message Box Okay button");
		loginPage.clickErrorOK();

	}

	
}
