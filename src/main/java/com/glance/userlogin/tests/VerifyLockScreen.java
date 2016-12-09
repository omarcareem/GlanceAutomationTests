package com.glance.userlogin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.GlanceDataProvider;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LockScreenPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyLockScreen extends BaseTest{

	
	
	CommonPageObject commonPage;
	LoginPage login;
	CommonPageLeftPane leftPanel;
	LockScreenPage lockscreen;
	DashboardPage dashboard;
	
	
		@Test
		public void GL_Main_08_verifyClickProfile() throws Exception {
		
		
		// Login to Glance By entering user name and password
				login=new LoginPage(driver);
				login.enterUsername(userName);
				login.enterPassword(password);
				login.clickLoginBtn();
						
		// click on LockScreen button in left panal
				leftPanel=new CommonPageLeftPane(driver);
				leftPanel.clickScreenLock();
						
		//click on profile picture
				lockscreen=new LockScreenPage(driver);
				
		//checking whether in lockscreen page		
				Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
				System.out.println("Clicking on Profile Picture");
				lockscreen.clickProfilePicture();
				System.out.println("Clicked on profile picture");
	
		}
		
		@Test
		public void GL_Main_09_verifyPassword() throws Exception {
		
		
		// Login to Glance By entering user name and password
				login=new LoginPage(driver);
				login.enterUsername(userName);
				login.enterPassword(password);
				login.clickLoginBtn();
						
		// click on LockScreen button in left panal and checking whether in lockscreen page		
				leftPanel=new CommonPageLeftPane(driver);
				leftPanel.clickScreenLock();		
				lockscreen=new LockScreenPage(driver);
				Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
		
		//click on profile picture		
				lockscreen.clickProfilePicture();
				
		//giving empty password and login
				System.out.println("Giving empty password");
				lockscreen.enterPassword(emptypassword);
				lockscreen.clickLogInBtn();
		
		//checking remains in the lockscreen page
				System.out.println("Gave empty password and checking whether stay in Lockscreen page ");
				Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
		
		//giving wrong password and login
				System.out.println("Giving wrong password");
				lockscreen.enterPassword(wrongpassword);
				lockscreen.clickLogInBtn();
				lockscreen.clickLogInOKBtn();
				
		//checking whether in lockscreen page and login with correct password
				System.out.println("Gave wrong password and checking whether stay in Lockscreen page ");
				Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
				lockscreen.clickProfilePicture();
				System.out.println("Giving correct password");
				lockscreen.enterPassword(password);
				lockscreen.clickLogInBtn();
				
		//checking whether in dashboard page
				System.out.println("Gave correct password and checking whether go to dashboard page ");
				dashboard =new DashboardPage(driver);
				Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
				
		//Logout
		        leftPanel.clickLogout();
	
		}
		
	}

