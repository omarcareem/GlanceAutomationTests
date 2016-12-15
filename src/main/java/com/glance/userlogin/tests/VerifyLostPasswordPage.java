package com.glance.userlogin.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.LostPasswordPage;

public class VerifyLostPasswordPage extends BaseTest {

	LoginPage loginPage;
	LostPasswordPage lostPassword;

	@Test(priority = 0)
	public void GL_Login_11() {

		loginPage = new LoginPage(driver);

		loginPage.navigateLostPasswordPage();

		lostPassword = new LostPasswordPage(driver);
		Assert.assertTrue(lostPassword.getLostPasswordTitle("Lost Password"));
		lostPassword.clickBackBtn();

	}

	// Valid Request

	@Test(priority = 1)
	public void GL_Login_12() {

		// Valid Request

		/*
		 * LoginPage loginPage=new LoginPage(driver);
		 * loginPage.navigateLostPasswordPage();
		 * 
		 * LostPasswordPage lostPassword = new LostPasswordPage(driver);
		 * lostPassword.enterUserName(userName);
		 * lostPassword.enterEmailAdd(emailAdd); lostPassword.clickSubmitBtn();
		 * //message Verification lostPassword.switchtoMsgBoxLostPasswordPage();
		 * lostPassword.clickBackBtn();
		 */

		// Invalid request1
		loginPage = new LoginPage(driver);
		loginPage.navigateLostPasswordPage();

		lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userNameErr);
		lostPassword.enterEmailAdd(emailAdd);
		lostPassword.clickSubmitBtn();

		// message Verification
		lostPassword.switchtoMsgBoxLostPasswordPage();
		lostPassword.clickBackBtn();

		// Invalid request1
		loginPage = new LoginPage(driver);
		loginPage.navigateLostPasswordPage();

		lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userNameErr);
		lostPassword.enterEmailAdd(emailAdd);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();

		// Invalid Request3

		loginPage.navigateLostPasswordPage();

		lostPassword.enterUserName(userName);
		lostPassword.enterEmailAdd(emailAddErr);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();

		// Invalid Request4

		loginPage.navigateLostPasswordPage();

		lostPassword.enterUserName(userNameErr);
		lostPassword.enterEmailAdd(emailAddErr);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();

		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();

		// Invalid Request2

	}

	@Test(priority = 2)
	public void GL_Login_13() {

		loginPage = new LoginPage(driver);

		loginPage.navigateLostPasswordPage();

		lostPassword.enterUserName(userName);
		lostPassword.enterEmailAdd(emailAddErr);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();

	}

	@Test(priority = 3)
	public void GL_Login_14() {

		loginPage = new LoginPage(driver);
		loginPage.navigateLostPasswordPage();

		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		lostPassword.clickBackBtn();

		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

	}

	/*
	 * <<<<<<< HEAD
	 * 
	 * @Test (priority =5) public void GL_Login_13 { }
	 * 
	 * }
	 */

	/*
	 * @Test (priority =5) public void GL_Login_14 {
	 * 
	 * 
	 * }
	 */

	@Test(priority = 4)
	public void GL_Login_15() {

		loginPage = new LoginPage(driver);
		loginPage.navigateLostPasswordPage();

		lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userName);
		lostPassword.enterEmailAdd(emailAddErr);
		lostPassword.clickSubmitBtn();
		lostPassword.clickPopupOkay();
		Assert.assertTrue(lostPassword.getLostPasswordTitle("Lost Password"));
	}
}
