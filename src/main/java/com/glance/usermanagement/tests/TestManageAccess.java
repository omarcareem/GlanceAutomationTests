package com.glance.usermanagement.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import com.glance.pageobjects.usermanagement.EditUser;
import com.glance.pageobjects.usermanagement.GroupMembershipPage;
import com.glance.pageobjects.usermanagement.ManageAccessPage;

public class TestManageAccess extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	ManageAccessPage manageAccess;
	EditUser editUser;
	GroupMembershipPage addGroupMembership;
	CommonPageTopPane topPane;

	@BeforeMethod
	public void verifyGoToEditGroupMembership() throws InterruptedException {
//to login
		loginPage = new LoginPage(driver);
		editUser = new EditUser(driver);
		settingPage = new SettingsPage(driver);
		
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
//Navigate to setting
		leftPanel = new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		settingPage.clickManageAccessBtn();

		
}
	
	
	@Test(priority=0)
	public void GL_Settings_MA_78_cancelManageAccess(){
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		
		manageAccess.cancel();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));	 

	
	}
	
	@Test(priority=1)
	public void GL_Settings_MA_77_testGiveAccessWithEmptyFields() throws InterruptedException{
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		//Assert.assertTrue(manageAccess.getTitle());
		//manageAccess.selectGroup(group);
		settingPage.clickManageAccessBtn();
		manageAccess.selectAccessType();
	
		manageAccess.update();
		Assert.assertTrue(manageAccess.verifyMessageEmptyFields());
		Thread.sleep(5000);
		manageAccess.clickOkInWarning();
		
		//verify whether we are in manage access page after clicking ok
		Assert.assertTrue(manageAccess.getTitle());
		Thread.sleep(500);
	
	}
	
	@Test(priority=2)
	public void GL_Settings_MA_76_testGiveAccess() throws InterruptedException{
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		editUser = new EditUser(driver);
		leftPanel = new CommonPageLeftPane(driver);
		addGroupMembership = new GroupMembershipPage(driver);
		topPane = new CommonPageTopPane(driver);
		loginPage = new LoginPage(driver);

		
		Assert.assertTrue(manageAccess.getTitle());
		manageAccess.selectGroup(groupAdd);
		manageAccess.selectEntityType(eType);
		manageAccess.selectEntityID(eId);
		manageAccess.selectAccessType();
	
		manageAccess.update();
		//Assert.assertTrue(manageAccess.verifyMessage());
		Thread.sleep(5000);

		//manageAccess.clickDone();
		
		
		//verify whether we are in manage access page after clicking ok
		Assert.assertTrue(manageAccess.getTitle());
		
		//After giving access we have to check whether the user could login. 
		//so have to assign admin role to him as only admin could login in the current system
		
		//Go to edit user to assign job role
		
				leftPanel.clickSettings();
				settingPage.ClickManageUsersBtn();
				editUser.selectUserToEdit(userNameEdit);
				editUser.changeJobRole(role);
				editUser.update();
				Thread.sleep(5000);
				editUser.clickOk();
		
		//Assign him to the group to which we provide access
		
				leftPanel.clickSettings();
				settingPage.clickGroupMembershipBtn();
				addGroupMembership = new GroupMembershipPage(driver);
				addGroupMembership.selectUser(userNameEdit);
				addGroupMembership.selectGroup(groupAdd);
				addGroupMembership.submit();
				addGroupMembership.clickDone();
				
		//Log out from current account
				topPane.clickDropDownIcon();
				topPane.clickLogout();

		//Log in as the user to whome we gave access

				loginPage.enterUsername(userNameEdit);
				loginPage.enterPassword(passwordEdit);
				loginPage.clickLoginBtn();
	
	}
	
	
}

