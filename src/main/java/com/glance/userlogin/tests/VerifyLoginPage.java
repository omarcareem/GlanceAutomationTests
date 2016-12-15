package com.glance.userlogin.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
//import com.glance.common.tests.GlanceDataProvider;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyLoginPage extends BaseTest {

	@Test(priority = 0)
	public void GL_Login_01() {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));
	}

	@Test(priority = 1)
	public void GL_login_02() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

		DashboardPage dashBoard = new DashboardPage(driver);
		Assert.assertTrue(dashBoard.getPageName("Account Level Dashboard"));

		CommonPageLeftPane commanleft = new CommonPageLeftPane(driver);
		commanleft.clickLogout();

		// invalid Login 1

		Thread.sleep(1000);
		loginPage.enterUsername(userNameErr);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		loginPage.clickErrorOK();

		// Invalid Login2

		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(passwordErr);

		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		loginPage.clickErrorOK();

	}

	/*
	 * 
	 * @Test (priority =4)
	 * 
	 * public void GL_login_03() throws InterruptedException {
	 * 
	 * 
	 * for(int i=0; i<5 ;i++){ LoginPage loginPage=new LoginPage(driver);
	 * Thread.sleep(1000); loginPage.enterUsername(userName);
	 * loginPage.enterPassword(passwordErr);
	 * 
	 * loginPage.clickLoginBtn(); Assert .assertTrue(loginPage.verifyLoginError(
	 * "Login unsuccessfull. Incorrect Login Credentials"));
	 * loginPage.clickErrorOK(); }
	 * 
	 * LoginPage loginPage=new LoginPage(driver); Thread.sleep(1000);
	 * loginPage.enterUsername(userName); loginPage.enterPassword(passwordErr);
	 * 
	 * loginPage.clickLoginBtn(); Assert .assertTrue(loginPage.verifyLoginError(
	 * "User ID is Locked")); loginPage.clickErrorOK();
	 * 
	 * 
	 * }
	 */

	@Test(priority = 5)
	public void GL_login_04() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(passwordErr);
		loginPage.clickLoginBtn();
		loginPage.clickErrorOK();

		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

	}

}
