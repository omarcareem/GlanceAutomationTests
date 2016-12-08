package com.glance.usermanagement.tests;

import com.glance.common.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.DeleteUser;
public class TestDeleteUser extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	DeleteUser deleteUser;
	
	@BeforeMethod
	public void verifyGoToDeleteUserPage() {
//to login
		loginPage = new LoginPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
//Navigate to setting
		leftPanel.clickSettings();

//to get the initial count of users
		//settingPage.getCountManageUsers();
		
//click on manage user
		settingPage.clickManageUsersBtn();
		
//Select the user to be deleted
		deleteUser.selectUserToDelete(user1);

	}
	@Test (priority=1)
	public void GL_Settings_MU_62_verifyGoBack() throws InterruptedException{
		
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		//deleteUser.selectUserToDelete(userDelete);
		deleteUser.goBack();
		
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	@Test (priority=2)
	public void GL_Settings_MU_61_verifyCancelDeleteUser() throws InterruptedException{
		
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		deleteUser.selectUserToDelete(user1);
		deleteUser.deleteUsers();
		deleteUser.CancelDeleteUser();
		
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	
	
@Test(priority=3)
public void GL_Settings_MU_60_verifyDeleteUser() throws InterruptedException{
	
	deleteUser = new DeleteUser(driver);
	settingPage = new SettingsPage(driver);
	leftPanel = new CommonPageLeftPane(driver);
	
	
	deleteUser.selectUserToDelete(newUserName);
	deleteUser.deleteUsers();
	
	
	//leftPanel.clickSettings();
	
	//settingPage.clickManageUsersBtn();
	Thread.sleep(5000);
	
	Assert.assertTrue(deleteUser.getTitle());
	Assert.assertTrue(deleteUser.verifyDelete(newUserName));
	
	//deleteUser.verifyDelete(userDelete);
	
}


}