package userlogin;

import junit.framework.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;

import com.glance.pageobjects.dashboard.CommonPageTopPane;

import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;



public class VerifyProfileUpdatePage extends BaseTest{
	
	
	  
public class GL_Settings_01{
	

	@Test (priority = 0)
	public void verifynavigationProfileUpdatePage() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickProfile();
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		Assert.assertTrue(profileUpdate.getProfileUpdateTitle("Update Profile Details"));
		
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickLogout();
		
	}}

public class GL_Settings_02{
	
	@BeforeMethod
	 public void LoginAndNavigation() { 
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickProfile();	 }
	
	@AfterMethod
	public void Logout(){
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeUsername(userName);
		profileUpdate.clickUpdateBtn();
		profileUpdate.clickPopupOkayBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickLogout();
	}
	
	
	@Test (priority = 1)
	public void verifyValidaUsername () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeUsername(updateValidUN);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Profile details updated successfully"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 2)
	public void verifyInvalidaUsername1 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeUsername(updateInvalidUN1);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
			
		
	}
	
	@Test (priority = 3)
	public void verifyInvalidaUsername2 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeUsername(upadteInvalidUN2);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
			
		
	}
	
	
	@Test (priority = 4)
	public void verifyInvalidaUsername3 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeUsername(updateExistingUN);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("There is a user from same user name use another"));
		profileUpdate.clickPopupCloseBtn();
			
		
	}
}

public class GL_Settings_03{
	@BeforeMethod
	 public void LoginAndNavigation() { 
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickProfile();	 }
	
	@AfterMethod
	public void Logout(){
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeEmail(emailAdd);
		profileUpdate.clickUpdateBtn();
		profileUpdate.clickPopupOkayBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickLogout();
	}
	
	@Test (priority = 5)
	public void verifyValidEmailAdd () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.changeEmail(updateValidEID);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Profile details updated successfully"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
}


public class GL_Settings_04{
	@BeforeMethod
	 public void LoginAndNavigation() { 
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickProfile();	 }
	
	@AfterMethod
	public void Logout(){
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(password);
		profileUpdate.changeConPassword(password);
		profileUpdate.clickUpdateBtn();
		profileUpdate.clickPopupOkayBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickLogout();
	}
	
	@Test (priority = 6)
	public void verifyValidPasswordChange () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateValidPSW);
		profileUpdate.changeConPassword(updateValidConPSW);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Profile details updated successfully"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 7)
	public void verifyInvalidPasswordChange1 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateInvalidPSW1);
		profileUpdate.changeConPassword(updateInvalidConPSW1);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 8)
	public void verifyInvalidPasswordChange2 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateInvalidPSW2);
		profileUpdate.changeConPassword(updateInvalidConPSW2);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 9)
	public void verifyInvalidPasswordChange3 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateValidPSW);
		profileUpdate.changeConPassword(updateInvalidConPSW);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("The passsword and confirmation password do not match !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
}
	

public class GL_Settings_05{
	@BeforeMethod
	 public void LoginAndNavigation() { 
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickProfile();	 }
	
	@AfterMethod
	public void Logout(){
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		//profileUpdate.changeFirstName(firstName);
		profileUpdate.changeConPassword(password);
		profileUpdate.clickUpdateBtn();
		profileUpdate.clickPopupOkayBtn();
		
		CommonPageTopPane commonTopPane=new CommonPageTopPane(driver);
		commonTopPane.clickDropDownIcon();
		commonTopPane.clickLogout();
	}
	
	@Test (priority = 6)
	public void verifyValidPasswordChange () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateValidPSW);
		profileUpdate.changeConPassword(updateValidConPSW);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Profile details updated successfully"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 7)
	public void verifyInvalidPasswordChange1 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateInvalidPSW1);
		profileUpdate.changeConPassword(updateInvalidConPSW1);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 8)
	public void verifyInvalidPasswordChange2 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateInvalidPSW2);
		profileUpdate.changeConPassword(updateInvalidConPSW2);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("Please enter user name and password in valid length !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
	
	@Test (priority = 9)
	public void verifyInvalidPasswordChange3 () throws InterruptedException {
		
		ProfileUpdatePage profileUpdate=new ProfileUpdatePage(driver);
		profileUpdate.clickChangePssword();
		profileUpdate.changeNewPswd(updateValidPSW);
		profileUpdate.changeConPassword(updateInvalidConPSW);
		profileUpdate.clickUpdateBtn();
		Assert.assertTrue(profileUpdate.getpopupMsgContent("The passsword and confirmation password do not match !"));
		profileUpdate.clickPopupCloseBtn();
		
				
	}
}

}
