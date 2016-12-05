package userlogin;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyLoginPage {
	
	public class GL_Login_01 extends BaseTest{
		
		@Test (priority =0)
		
		public void verifyNavigationLoginPage() {
			LoginPage loginPage=new LoginPage(driver);
			Assert.assertTrue(loginPage.getLoginTitle("Login Form"));
	}
		
	}
	
	
	public class GL_login_02 extends BaseTest{
	
	@Test (priority =1)
	public void verifyValidLogin() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	
		DashboardPage dashBoard =new DashboardPage(driver);
		Assert.assertTrue(dashBoard.getPageName("Account Level Dashboard"));
		
		CommonPageLeftPane commanleft= new CommonPageLeftPane(driver);
		commanleft.clickLogout();
		
	}

	@Test (priority =2)
	public void verifyInvalidUNLogin() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userNameErr);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		loginPage.clickErrorOK();
	
		
	}
	
	@Test(priority =3)
	public void verifyInvalidPSWLogin() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(passwordErr);
		
		loginPage.clickLoginBtn();
		Thread.sleep(1000);
 		Assert .assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
		loginPage.clickErrorOK();
		
	}
	}
	
/*	public class GL_login_03{
		
		@Test (priority =4)
		
		public void verifyInvalid5attempts() throws InterruptedException {
			
			
			for(int i=0; i<5 ;i++){
			LoginPage loginPage=new LoginPage(driver);
			Thread.sleep(1000);
			loginPage.enterUsername(userName);
			loginPage.enterPassword(passwordErr);
			
			loginPage.clickLoginBtn();
			Assert .assertTrue(loginPage.verifyLoginError("Login unsuccessfull. Incorrect Login Credentials"));
			loginPage.clickErrorOK();
			}
			
			LoginPage loginPage=new LoginPage(driver);
			Thread.sleep(1000);
			loginPage.enterUsername(userName);
			loginPage.enterPassword(passwordErr);
			
			loginPage.clickLoginBtn();
			Assert .assertTrue(loginPage.verifyLoginError("User ID is Locked"));
			loginPage.clickErrorOK();
			
			
		}
	}*/
	
	public class GL_login_04 extends BaseTest{
		
	@Test (priority =5)
	public void verifyLoginErrorMsgOkay() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(passwordErr);
		loginPage.clickLoginBtn();
		loginPage.clickErrorOK();
		
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));

	}
	}
	
	
	

}
