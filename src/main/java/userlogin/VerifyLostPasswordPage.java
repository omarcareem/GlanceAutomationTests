package userlogin;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.LostPasswordPage;

public class VerifyLostPasswordPage {
	
	
	
	public class GL_Login_11 extends BaseTest{
	@Test (priority =0)
	public void verifynavigationLostPasswordPage() {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateLostPasswordPage();
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		Assert.assertTrue(lostPassword.getLostPasswordTitle("Lost Password"));
		lostPassword.clickBackBtn();
		
	}
	}
	
	public class GL_Login_12 extends BaseTest{
	/*	
	@Test (priority =1)
	public void verifyValidLostPasswordRequest(){
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateLostPasswordPage();
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userName);
		lostPassword.enterEmailAdd(emailAdd);
		lostPassword.clickSubmitBtn();
		//message Verification
		lostPassword.switchtoMsgBoxLostPasswordPage();
		lostPassword.clickBackBtn();
	}
	*/		
	
	@Test (priority =2)
	public void verifyInvalidLostPasswordRequest1(){
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateLostPasswordPage();
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userNameErr);
		lostPassword.enterEmailAdd(emailAdd);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();
	
	}
	
		
	@Test (priority =3)
	public void verifyInvalidLostPasswordRequest2(){
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateLostPasswordPage();
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		lostPassword.enterUserName(userName);
		lostPassword.enterEmailAdd(emailAddErr);
		lostPassword.clickSubmitBtn();
		Assert.assertTrue(lostPassword.getLostPasswordMsgContent("Entered user name or email address do not match !"));
		lostPassword.clickPopupOkay();
		lostPassword.clickBackBtn();
	
	}
	}
	

	public class GL_Login_13 extends BaseTest{
	@Test (priority =4)
	public void verifyLostPasswordBack(){
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateLostPasswordPage();
		
		LostPasswordPage lostPassword = new LostPasswordPage(driver);
		lostPassword.clickBackBtn();
		
		Assert.assertTrue(loginPage.getLoginTitle("Login Form"));
		

	}
	}
	
	/*public class GL_Login_14 extends BaseTest{
		@Test (priority =5)
		
		
	}*/
	
	
	public class GL_Login_15 extends BaseTest{
		@Test (priority =6)
		public void verifyLostPasswordMsgOkay(){
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.navigateLostPasswordPage();
			
			LostPasswordPage lostPassword = new LostPasswordPage(driver);
			lostPassword.enterUserName(userName);
			lostPassword.enterEmailAdd(emailAddErr);
			lostPassword.clickSubmitBtn();
			lostPassword.clickPopupOkay();
			Assert.assertTrue(lostPassword.getLostPasswordTitle("Lost Password"));
		}
		}
}
