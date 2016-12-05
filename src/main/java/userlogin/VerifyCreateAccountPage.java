package userlogin;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;


public class VerifyCreateAccountPage {
	
	public class GL_Login_05 extends BaseTest{
	
	@Test (priority = 0)
	public void verifynavigationCreateAccountPage() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(10000);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(10000);
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Assert.assertTrue(createAccount.getCreateAccTitle("Create Account"));
		createAccount.clickLoginLink();
	}
	
	}
	
	public class GL_Login_06 extends BaseTest{
	@Test (priority =1)
	public void verifyValidAccountCreation() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newValidPSW);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("New User inserted successfully"));
		Thread.sleep(10000);
		createAccount.clickpopupOkay();
		Thread.sleep(10000);
		createAccount.clickLoginLink();
		
		
	}
	
	
	@Test (priority =2)
	public void verifyInvalidAccountCreation2() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW1);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);

		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		Thread.sleep(5000);
		createAccount.clickLoginLink();
	}
	
	
	@Test (priority =3)
	public void verifyInvalidAccountCreation3() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW1);
		Thread.sleep(5000);
		createAccount.confirmPassword(newInvalidConPSW1);
		Thread.sleep(5000);
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	
	}

	
	@Test (priority = 4)
	public void verifyInvalidAccountCreation4() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW1);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	
	
	@Test (priority = 5)
	public void verifyInvalidAccountCreation5() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newValidPSW);
		Thread.sleep(5000);
		createAccount.confirmPassword(newInvalidConPSW1);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	@Test (priority = 6)
	public void verifyInvalidAccountCreation6() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newValidPSW);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	@Test (priority = 7)
	public void verifyInvalidAccountCreation7() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW2);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	@Test (priority = 8)
	public void verifyInvalidAccountCreation8() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW2);
		Thread.sleep(5000);
		createAccount.confirmPassword(newInvalidConPSW2);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	@Test (priority = 9)
	public void verifyInvalidAccountCreation9() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN2);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW2);
		Thread.sleep(5000);
		createAccount.confirmPassword(newValidConPSW);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	

	@Test (priority = 10)
	public void verifyInvalidAccountCreation10() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newInvalidUN1);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newInvalidPSW1);
		Thread.sleep(5000);
		createAccount.confirmPassword(newInvalidConPSW1);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("Please enter user name and password in valid length !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	
	@Test (priority = 11)
	public void verifyInvalidAccountCreation11() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		Thread.sleep(5000);
		createAccount.addemailAdd(newValidEID);
		Thread.sleep(5000);
		createAccount.createpassword(newValidPSW);
		Thread.sleep(5000);
		createAccount.confirmPassword(newInvalidConPSW1);
		Thread.sleep(5000);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(createAccount.getPopupMsg("The passsword and confirmation password do not match !"));
		Thread.sleep(5000);
		createAccount.clickpopupOkay();
		createAccount.clickLoginLink();
	}
	}
	
	
	public class GL_Login_07 extends BaseTest{
		
	@Test (priority = 12)
	public void verifyPopupMsgOkay() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(newValidUN);
		createAccount.addemailAdd(newValidEID);
		createAccount.createpassword(newValidPSW);
		createAccount.confirmPassword(newInvalidConPSW1);
		createAccount.clickSubmitBtn();
		
		createAccount.clickpopupOkay();
		Assert.assertTrue(createAccount.getCreateAccTitle("Create Account"));
		createAccount.clickLoginLink();
	}}
	
	/*public class GL_Login_08 extends BaseTest{
		
		@Test (priority = 13)
		public void verifyUserNameUniqueness() throws InterruptedException {
			
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
			Assert.assertTrue(createAccount.getPopupMsg("There is a user from same user name use another"));
			Thread.sleep(5000);
			createAccount.clickpopupOkay();
			createAccount.clickLoginLink();
		}}
		
	*/
	/*public class GL_Login_09 extends BaseTest{
		@Test (priority = 14)
		public void verifyInvalidUserAccess() throws InterruptedException {
			
			LoginPage loginPage=new LoginPage(driver);
			Thread.sleep(1000);
			loginPage.enterUsername(newValidUN);
			loginPage.enterPassword(newValidPSW);
			loginPage.clickLoginBtn();
		
			DashboardPage dashBoard =new DashboardPage(driver);
			Assert.assertTrue(dashBoard.getPageName("Access Denied"));
			
			CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
			commanleft.clickLogout();	
		
		
	}}
	*/
	public class GL_Login_10 extends BaseTest{
	@Test (priority = 15)
	public void verifyLoginNavigationLink() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		Thread.sleep(5000);
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		createAccount.clickLoginLink();
		Thread.sleep(5000);
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

		
	}}


	

}
