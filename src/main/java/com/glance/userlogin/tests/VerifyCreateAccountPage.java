package com.glance.userlogin.tests;

import junit.framework.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import com.glance.pageobjects.usermanagement.DeleteUser;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyCreateAccountPage extends BaseTest {


	@Test (priority = 6)
	public void GL_Login_04() throws InterruptedException {
		test=report.startTest("verifyCreateAccountPage");
		LoginPage loginPage=new LoginPage(driver);
		test.log(LogStatus.INFO, "Clicking the create Account link");
		Thread.sleep(5000);
		loginPage.navigateCreateAccountPage();
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying navigation to Create Account Page");
		Assert.assertTrue(createAccount.getCreateAccTitle("Create Account"));
		
	}

	
	
	@Test (priority =7)
	public void GL_Login_05() throws InterruptedException {
		

		CreateAccountPage createAccount=new CreateAccountPage(driver);
	
			//Valid account Creation
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering Valid User name");
		createAccount.createUsername(newValidUN);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering Valid password");
		createAccount.createpassword(newValidPSW);
		test.log(LogStatus.INFO, "Entering Valid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the successful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg1("New User inserted successfully"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Done button");
		createAccount.clickpopupDone();
		Thread.sleep(1000);

		//Invalid account creation 1
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN1);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW1);
		test.log(LogStatus.INFO, "Entering Valid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 2
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN2);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW1);
		test.log(LogStatus.INFO, "Entering Invalid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		
		
		
		
		//Invalid account creation 3
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering valid User name");
		createAccount.createUsername(newValidUN);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW1);
		test.log(LogStatus.INFO, "Entering valid Confirm Password");
		createAccount.confirmPassword(newInvalidConPSW1);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 4
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN2);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW1);
		test.log(LogStatus.INFO, "Entering invalid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//invalid account creation 5
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN1);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering valid password");
		createAccount.createpassword(newValidPSW);
		test.log(LogStatus.INFO, "Entering invalid Confirm Password");
		createAccount.confirmPassword(newInvalidConPSW1);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 6
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN2);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering valid password");
		createAccount.createpassword(newValidPSW);
		test.log(LogStatus.INFO, "Entering valid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 7
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN1);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW2);
		test.log(LogStatus.INFO, "Entering invalid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		
		//Invalid account creation 8
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering valid User name");
		createAccount.createUsername(newValidUN);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW2);
		test.log(LogStatus.INFO, "Entering valid Confirm Password");
		createAccount.confirmPassword(newInvalidConPSW2);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 9
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN2);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW2);
		test.log(LogStatus.INFO, "Entering invalid Confirm Password");
		createAccount.confirmPassword(newValidConPSW);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		
		//Invalid account creation 10
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering invalid User name");
		createAccount.createUsername(newInvalidUN1);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering invalid password");
		createAccount.createpassword(newInvalidPSW1);
		test.log(LogStatus.INFO, "Entering valid Confirm Password");
		createAccount.confirmPassword(newInvalidConPSW1);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		//Invalid account creation 11
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering valid User name");
		createAccount.createUsername(newValidUN);
		test.log(LogStatus.INFO, "Entering Valid Email Address");
		createAccount.addemailAdd(newValidEID);
		test.log(LogStatus.INFO, "Entering valid password");
		createAccount.createpassword(newValidPSW);
		test.log(LogStatus.INFO, "Entering invalid Confirm Password");
		createAccount.confirmPassword(newInvalidConPSW1);
		test.log(LogStatus.INFO, "Clicking the Submit Button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
		Assert.assertTrue(createAccount.getPopupMsg4("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking the message box Okay button");
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
	
	}
	

		
		@Test (priority = 8)
		public void GL_Login_06() throws InterruptedException {
			
		
			CreateAccountPage createAccount=new CreateAccountPage(driver);
			test.log(LogStatus.INFO, "Entering valid User name");
			createAccount.createUsername(newValidUN);
			test.log(LogStatus.INFO, "Entering Valid Email Address");
			createAccount.addemailAdd(newValidEID);
			test.log(LogStatus.INFO, "Entering valid password");
			createAccount.createpassword(newValidPSW);
			test.log(LogStatus.INFO, "Entering invalid Confirm Password");
			createAccount.confirmPassword(newValidConPSW);
			test.log(LogStatus.INFO, "Clicking the Submit Button");
			createAccount.clickSubmitBtn();
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Verifying the Unsuccessful user account creation");
			Assert.assertTrue(createAccount.getPopupMsg1("This is duplicate entry!"));
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Clicking the message box Okay button");
			createAccount.clickpopupOK();
			test.log(LogStatus.INFO, "Clicking the Login Page Link");
			createAccount.clickLoginLink();
			
			
			
		}

	
		@Test (priority = 9)
		public void GL_Login_07() throws InterruptedException {
			
			LoginPage loginPage=new LoginPage(driver);
			
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Entering User name");
			loginPage.enterUsername(newValidUN);
			test.log(LogStatus.INFO, "entering Password");
			loginPage.enterPassword(newValidPSW);
			test.log(LogStatus.INFO, "Entering Login Button");
			loginPage.clickLoginBtn();
		
			DashboardPage dashBoard =new DashboardPage(driver);
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Verifying that user cannot to access the dashboard till user getting the access from admin");
			Assert.assertTrue(dashBoard.verifyNavigationToAccessDeniedPage("Access Denied"));
			Thread.sleep(5000);
			
			CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
			test.log(LogStatus.INFO, "Clicking the Logout button");
			commanleft.clickLogout();	
		
		
	}
	
	@Test (priority = 10)
	public void GL_Login_08() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		test.log(LogStatus.INFO, "navigates to Create Account page");
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
	
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		test.log(LogStatus.INFO, "Clicking the Login Link");
		createAccount.clickLoginLink();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying the navigation to Login Page");
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "entering the Username");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "entering the password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking the login button");
		loginPage.clickLoginBtn();
		Thread.sleep(5000);
		
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking the settings button");
		commonLeftPane.clickSettings();
		Thread.sleep(5000);
		SettingsPage settingspage= new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking the Manage user Tab");
		settingspage.ClickManageUsersBtn();
		
		
		Thread.sleep(5000);
		DeleteUser deleteuser=new DeleteUser(driver);
		test.log(LogStatus.INFO, "Selecting the created user to delete");
		deleteuser.selectUserToDelete(newValidUN);
		test.log(LogStatus.INFO, "Deleting the selected user");
		deleteuser.deleteUsers();
		Thread.sleep(5000);
		CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking the Logout button");
		commanleft.clickLogout();	
		
		
	}
	
	
	}


