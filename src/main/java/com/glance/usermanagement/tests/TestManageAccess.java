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
import com.relevantcodes.extentreports.LogStatus;

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
	public void GL_Settings_UM_22_cancelManageAccess(){
		test=report.startTest("verifycancelManageAccess");
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		
		test.log(LogStatus.INFO, "Clicking cancel");
		manageAccess.cancel();
		
		test.log(LogStatus.INFO, "Verifying the page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));	 

	
	}
	
	@Test(priority=1)
	public void GL_Settings_UM_21_testGiveAccessWithEmptyFields() throws InterruptedException{
		test=report.startTest("verifyGiveAccessWithEmptyFields");
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		//Assert.assertTrue(manageAccess.getTitle());
		//manageAccess.selectGroup(group);
		test.log(LogStatus.INFO, "Clicking manage access");
		settingPage.clickManageAccessBtn();
		
		test.log(LogStatus.INFO, "Selecting Access type");
		manageAccess.selectAccessType();
	
		test.log(LogStatus.INFO, "Clicking update");
		manageAccess.update();
		
		test.log(LogStatus.INFO, "Verifying alert message");
		Assert.assertTrue(manageAccess.verifyMessageEmptyFields());
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Clicking ok on warning message");
		manageAccess.clickOkInWarning();
		
		//verify whether we are in manage access page after clicking ok
		test.log(LogStatus.INFO, "Verifying page");
		Assert.assertTrue(manageAccess.getTitle());
		Thread.sleep(500);
	
	}
	
	@Test(priority=2)
	public void GL_Settings_UM_20_testGiveAccess() throws InterruptedException{
		test=report.startTest("verifyGiveAccess");
		manageAccess = new ManageAccessPage(driver);
		settingPage = new SettingsPage(driver);
		editUser = new EditUser(driver);
		leftPanel = new CommonPageLeftPane(driver);
		addGroupMembership = new GroupMembershipPage(driver);
		topPane = new CommonPageTopPane(driver);
		loginPage = new LoginPage(driver);

		
		Assert.assertTrue(manageAccess.getTitle());
		test.log(LogStatus.INFO, "Selecting group");
		manageAccess.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Selecting eType");
		manageAccess.selectEntityType(eType);
		
		test.log(LogStatus.INFO, "Selecting EntityID");
		manageAccess.selectEntityID(eId);
		
		test.log(LogStatus.INFO, "Selecting Access type");
		manageAccess.selectAccessType();
	
		test.log(LogStatus.INFO, "Clicking Give access");
		manageAccess.update();
		//Assert.assertTrue(manageAccess.verifyMessage());
		Thread.sleep(5000);

		//manageAccess.clickDone();
		
		
		//verify whether we are in manage access page after clicking ok
		test.log(LogStatus.INFO, "Verifying page");
		Assert.assertTrue(manageAccess.getTitle());
		
		//After giving access we have to check whether the user could login. 
		//so have to assign admin role to him as only admin could login in the current system
		
		//Go to edit user to assign job role
				test.log(LogStatus.INFO, "Clicking setting");
				leftPanel.clickSettings();
				
				test.log(LogStatus.INFO, "Clicking manage user");
				settingPage.ClickManageUsersBtn();
				
				test.log(LogStatus.INFO, "Selecting User");
				editUser.selectUserToEdit(userNameEdit);
				
				test.log(LogStatus.INFO, "Assigning job role as admin");
				editUser.changeJobRole(role);
				
				test.log(LogStatus.INFO, "Updating");
				editUser.update();
				Thread.sleep(5000);
				
				test.log(LogStatus.INFO, "Clicking ok ");
				editUser.clickOk();
		
		//Assign him to the group to which we provide access
		
				test.log(LogStatus.INFO, "clicking setting");
				leftPanel.clickSettings();
				
				test.log(LogStatus.INFO, "Clicking group membership");
				settingPage.clickGroupMembershipBtn();
				addGroupMembership = new GroupMembershipPage(driver);
				
				test.log(LogStatus.INFO, "Selecting user");
				addGroupMembership.selectUser(userNameEdit);
				
				test.log(LogStatus.INFO, "Selecting group");
				addGroupMembership.selectGroup(groupAdd);
				
				test.log(LogStatus.INFO, "Adding membership");
				addGroupMembership.submit();
				addGroupMembership.clickDone();
				
		//Log out from current account
				test.log(LogStatus.INFO, "Logout");
				topPane.clickDropDownIcon();
				topPane.clickLogout();

		//Log in as the user to whome we gave access

				test.log(LogStatus.INFO, "Enter the username of the person to whome access is given");
				loginPage.enterUsername(userNameEdit);
				
				test.log(LogStatus.INFO, "Enter the password of the person to whome access is given");
				loginPage.enterPassword(passwordEdit);
				
				test.log(LogStatus.INFO, "Login");
				loginPage.clickLoginBtn();
	
	}
	
	
}

