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


public class VerifyCreateAccountPage extends BaseTest {

<<<<<<< HEAD

	@Test (priority = 0)
	public void GL_Login_04() throws InterruptedException {
	
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
=======
	@BeforeMethod
	public void createAccnvigation() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void LoginNavigation() {
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		createAccount.clickLoginLink();
	}

	@Test(priority = 0)
	public void GL_Login_05() throws InterruptedException {

>>>>>>> omartest
		Thread.sleep(5000);
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getCreateAccTitle("Create Account"));
		Thread.sleep(5000);
		createAccount.clickLoginLink();
	}

<<<<<<< HEAD
	
	
	@Test (priority =1)
	public void GL_Login_05() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
		CreateAccountPage createAccount=new CreateAccountPage(driver);
	
			//Valid account Creation
=======
	@Test(priority = 1)
	public void GL_Login_06() throws InterruptedException {

		CreateAccountPage createAccount = new CreateAccountPage(driver);

		// Valid account Creation
>>>>>>> omartest
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg1("New User inserted successfully"));
		Thread.sleep(5000);
		createAccount.clickpopupDone();
		Thread.sleep(1000);

		// Invalid account creation 1
		createAccount.createUsername(newInvalidUN1);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW1);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 2
		createAccount.createUsername(newInvalidUN1);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW1);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 3
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW1);
		createAccount.confirmPassword(newInvalidConPSW1);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 4
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW1);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// invalid account creation 5
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newInvalidConPSW1);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 6
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 7
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW2);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 8
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW2);
		createAccount.confirmPassword(newInvalidConPSW2);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 9

		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW2);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg2("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);

		// Invalid account creation 10
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newInvalidPSW1);
		createAccount.confirmPassword(newInvalidConPSW1);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg3("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);
<<<<<<< HEAD
		
		//Invalid account creation 11
=======

		// Invalid account creation 11
		/*
		 * Thread.sleep(5000); createAccount.createUsername(newValidUN);
		 * createAccount.addemailAdd(newValidEID);
		 * createAccount.createpassword(newValidPSW);
		 * createAccount.confirmPassword(newInvalidConPSW1);
		 * createAccount.clickSubmitBtn(); Thread.sleep(5000);
		 * Assert.assertTrue(createAccount.getPopupMsg2(
		 * "The passsword and confirmation password do not match !"));
		 * Thread.sleep(5000); createAccount.clickpopupOK(); Thread.sleep(1000);
		 */
	}

	@Test(priority = 12)
	public void GL_Login_07() throws InterruptedException {

		/*
		 * LoginPage loginPage=new LoginPage(driver);
		 * loginPage.navigateCreateAccountPage(); Thread.sleep(5000);
		 */
		CreateAccountPage createAccount = new CreateAccountPage(driver);
>>>>>>> omartest
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newInvalidConPSW1);
		createAccount.clickSubmitBtn();

		// createAccount.clickpopupOK();
		createAccount.clickpopupDone();
		Thread.sleep(5000);
<<<<<<< HEAD
		Assert.assertTrue(createAccount.getPopupMsg4("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOK();
		Thread.sleep(1000);
		
		createAccount.clickLoginLink();
	
	}
	

		
		@Test (priority = 13)
		public void GL_Login_06() throws InterruptedException {
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.navigateCreateAccountPage();
			Thread.sleep(5000);
			CreateAccountPage createAccount=new CreateAccountPage(driver);
			Thread.sleep(5000);
			createAccount.createUsername(newValidUN);
			createAccount.addemailAdd(newValidEID);
			createAccount.createpassword(newValidPSW);
			createAccount.confirmPassword(newValidConPSW);
			createAccount.clickSubmitBtn();
			Thread.sleep(5000);
			Assert.assertTrue(createAccount.getPopupMsg1("This is duplicate entry!"));
			Thread.sleep(5000);
			createAccount.clickpopupOK();
			createAccount.clickLoginLink();
			
			
			
		}

	
		@Test (priority = 14)
		public void GL_Login_07() throws InterruptedException {
			
			LoginPage loginPage=new LoginPage(driver);
			
			Thread.sleep(1000);
			loginPage.enterUsername(newValidUN);
			loginPage.enterPassword(newValidPSW);
			loginPage.clickLoginBtn();
		
			DashboardPage dashBoard =new DashboardPage(driver);
			Thread.sleep(1000);
			Assert.assertTrue(dashBoard.verifyNavigationToAccessDeniedPage("Access Denied"));
			Thread.sleep(5000);
			CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
			commanleft.clickLogout();	
		
		
	}
	
	@Test (priority = 15)
	public void GL_Login_08() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
	
		CreateAccountPage createAccount=new CreateAccountPage(driver);
=======
		Assert.assertTrue(createAccount.getCreateAccTitle("Create Account"));
		Thread.sleep(5000);
		// createAccount.clickLoginLink();
	}

	@Test(priority = 13)
	public void GL_Login_08() throws InterruptedException {

		/*
		 * LoginPage loginPage=new LoginPage(driver);
		 * loginPage.navigateCreateAccountPage();
		 */Thread.sleep(5000);
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newValidConPSW);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg1("This is duplicate entry!"));
		Thread.sleep(5000);
		createAccount.clickpopupDone();
		// createAccount.clickLoginLink();

	}

	/*
	 * @Test (priority = 14) public void GL_Login_09() throws
	 * InterruptedException {
	 * 
	 * LoginPage loginPage=new LoginPage(driver); Thread.sleep(1000);
	 * loginPage.enterUsername(newValidUN);
	 * loginPage.enterPassword(newValidPSW); loginPage.clickLoginBtn();
	 * 
	 * DashboardPage dashBoard =new DashboardPage(driver);
	 * Assert.assertTrue(dashBoard.getPageName("Access Denied"));
	 * 
	 * CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
	 * commanleft.clickLogout();
	 * 
	 * 
	 * }
	 */
	@Test(priority = 15)
	public void GL_Login_10() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		Thread.sleep(10000);
		// loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
		CreateAccountPage createAccount = new CreateAccountPage(driver);
>>>>>>> omartest
		createAccount.clickLoginLink();
		Thread.sleep(5000);
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

<<<<<<< HEAD
		
		Thread.sleep(5000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		Thread.sleep(5000);
		CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		commonLeftPane.clickSettings();
		Thread.sleep(5000);
		SettingsPage settingspage= new SettingsPage(driver);
		settingspage.clickManageUsersBtn();
		
		
		Thread.sleep(5000);
		DeleteUser deleteuser=new DeleteUser(driver);
		deleteuser.selectUserToDelete(newValidUN);
		deleteuser.deleteUsers();
		Thread.sleep(5000);
		CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
		commanleft.clickLogout();	
		
		
	}
	
	
=======
		/*
		 * loginPage.enterUsername(userName); loginPage.enterPassword(password);
		 * 
		 * CommonPageLeftPane commonLeftPane =new CommonPageLeftPane(driver);
		 * commonLeftPane.clickSettings();
		 * 
		 * SettingsPage settingspage= new SettingsPage(driver);
		 * settingspage.clickManageUsersBtn();
		 */

>>>>>>> omartest
	}

}
