package com.glance.userlogin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LockScreenPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyLockScreen extends BaseTest {

	CommonPageObject commonPage;
	LoginPage login;
	CommonPageLeftPane leftPanel;
	LockScreenPage lockscreen;
	DashboardPage dashboard;

	@Test(priority = 18)
	public void GL_Main_08_verifyClickProfile() throws Exception {

		// Login to Glance By entering user name and password
		test=report.startTest("verifyClickProfile");
		login = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		login.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		login.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		login.clickLoginBtn();

		// click on LockScreen button in left panal
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on screen lock button");
		leftPanel.clickScreenLock();

	
		lockscreen = new LockScreenPage(driver);

		// checking whether in lockscreen page
		test.log(LogStatus.INFO, "verify Navigation To LockScreen");
		Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
		// click on profile picture
		test.log(LogStatus.INFO, "Clicking on profile picture of the user");
		System.out.println("Clicking on Profile Picture");
		lockscreen.clickProfilePicture();
		System.out.println("Clicked on profile picture");

	}

	@Test(priority = 19)
	public void GL_Main_09_verifyPassword() throws Exception {

		// Login to Glance By entering user name and password
		test=report.startTest("verifyPassword");
		login = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		login.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		login.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		login.clickLoginBtn();

		// click on LockScreen button in left panal and checking whether in lockscreen page
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on screen lock button");
		leftPanel.clickScreenLock();
		lockscreen = new LockScreenPage(driver);
		test.log(LogStatus.INFO, "verify Navigation To LockScreen");
		Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));

		// click on profile picture
		test.log(LogStatus.INFO, "Clicking on profile picture of the user");
		lockscreen.clickProfilePicture();

		// giving empty password and login
		System.out.println("Giving empty password");
		test.log(LogStatus.INFO, "Giving empty password");
		lockscreen.enterPassword(emptypassword);
		test.log(LogStatus.INFO, "Clicking on login button");
		lockscreen.clickLogInBtn();

		// checking remains in the lockscreen page
		System.out.println("Gave empty password and checking whether stay in Lockscreen page ");
		test.log(LogStatus.INFO, "verify staying in LockScreen page");
		Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));

		// giving wrong password and login
		System.out.println("Giving wrong password");
		test.log(LogStatus.INFO, "Giving wrong password");
		lockscreen.enterPassword(wrongpassword);
		test.log(LogStatus.INFO, "Clicking on login button");
		lockscreen.clickLogInBtn();
		test.log(LogStatus.INFO, "Clicking on loginOK button");
		lockscreen.clickLogInOKBtn();

		// checking whether in lockscreen page and login with correct password
		System.out.println("Gave wrong password and checking whether stay in Lockscreen page ");
		test.log(LogStatus.INFO, "verify staying in LockScreen page");
		Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
		
		test.log(LogStatus.INFO, "Clicking on profile picture of the user");
		lockscreen.clickProfilePicture();
		test.log(LogStatus.INFO, "Giving correct password");
		System.out.println("Giving correct password");
		lockscreen.enterPassword(password);
		
		test.log(LogStatus.INFO, "Clicking on login button");
		lockscreen.clickLogInBtn();

		// checking whether in dashboard page
		System.out.println("Gave correct password and checking whether go to dashboard page ");
		dashboard = new DashboardPage(driver);
		test.log(LogStatus.INFO, "verify Navigation To DashboardPage");
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));

		// Logout
		test.log(LogStatus.INFO, "Clicking on logout button");
		leftPanel.clickLogout();

	}

}
