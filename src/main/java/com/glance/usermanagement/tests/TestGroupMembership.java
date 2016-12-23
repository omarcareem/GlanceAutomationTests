package com.glance.usermanagement.tests;

import com.glance.common.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.EditGroupMembership;
import com.glance.pageobjects.usermanagement.GroupMembershipPage;
import com.glance.pageobjects.usermanagement.ManageGroupPage;
import com.relevantcodes.extentreports.LogStatus;


public class TestGroupMembership extends BaseTest{
	LoginPage loginPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	GroupMembershipPage addGroupMembership;
	EditGroupMembership editGroup;
	CreateAccountPage createAccount;
	GroupMembershipPage groupMembership;
	ManageGroupPage addGroup;



	@BeforeMethod
	public void verifyGoToEditGroupMembership() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		createAccount =  new CreateAccountPage(driver);
		groupMembership = new GroupMembershipPage(driver);
		addGroup = new ManageGroupPage(driver);
		//go to create account page and create new user
				loginPage.navigateCreateAccountPage();
				createAccount.createUsername(userNameEdit);
				createAccount.addemailAdd(emailAddEdit);
				createAccount.createpassword(passwordEdit);
				createAccount.confirmPassword(passwordEdit);
				createAccount.clickSubmitBtn();
				Thread.sleep(3000);
				groupMembership.clickDone();
				createAccount.clickLoginLink();
				
		//To login
				loginPage.enterUsername(userName);
				loginPage.enterPassword(password);
				loginPage.clickLoginBtn();
		
/*//Navigate to setting
		leftPanel = new CommonPageLeftPane(driver);
	
		leftPanel.clickSettings();
//Navigate to Manage group page
		Thread.sleep(3000);
		settingPage.clickManageGroupsBtn();
		addGroup.inputGroupName(groupAdd);
		addGroup.clickAddGroup();
		groupMembership.clickDone();
		
//go to group membership page
		settingPage = new SettingsPage(driver);
		leftPanel.clickSettings();
		settingPage.clickGroupMembershipBtn();*/

	}
	
	
	@Test(priority=1)
	public void GL_Settings_UM_14_1_verifyAddGroupMembership() throws Exception{
		test=report.startTest("verifyAddingGroupMembership");
		addGroupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);
		settingPage = new SettingsPage(driver);
		
		leftPanel = new CommonPageLeftPane(driver);
		addGroup = new ManageGroupPage(driver);
		groupMembership = new GroupMembershipPage(driver);
		
		//Navigate to setting
		test.log(LogStatus.INFO, "Clicking setting");		
				leftPanel.clickSettings();
		//Navigate to Manage group page
				Thread.sleep(3000);
				
				test.log(LogStatus.INFO, "Clicking manage group");
				settingPage.clickManageGroupsBtn();
				
				test.log(LogStatus.INFO, "Entering group name");
				addGroup.inputGroupName(groupAdd);
				
				test.log(LogStatus.INFO, "Adding the group");
				addGroup.clickAddGroup();
				Thread.sleep(5000);
				groupMembership.clickDone();
				
		//go to group membership page
				
				Thread.sleep(5000);

				test.log(LogStatus.INFO, "Clicking setting");
				leftPanel.clickSettings();
				
				test.log(LogStatus.INFO, "Clicking group membership");
				settingPage.clickGroupMembershipBtn();
		

		test.log(LogStatus.INFO, "Selecting user");
		addGroupMembership.selectUser(userNameEdit);
		
		test.log(LogStatus.INFO, "Selecting Group");
		addGroupMembership.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Adding membership");
		addGroupMembership.submit();
		Thread.sleep(3000);

		addGroupMembership.clickDone();
		
		test.log(LogStatus.INFO, "Verifying added");
		//addGroupMembership.verifyAdded(group,addUser);
		editGroup.selectGroup(groupAdd);
		Thread.sleep(3000);
		Assert.assertTrue(addGroupMembership.verifyAdded(groupAdd,userNameEdit));
		
	}
	
	@Test(priority=2)
	public void GL_Settings_UM_15_verifyAddDuplicateEntries() throws Exception{
		test=report.startTest("verifyAddingDuplicateEntries");
		addGroupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);

		test.log(LogStatus.INFO, "Selecting user");
		addGroupMembership.selectUser(userNameEdit);
		
		test.log(LogStatus.INFO, "Selecting group");
		addGroupMembership.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Adding duplicate entry");
		addGroupMembership.submit();
		Thread.sleep(3000);
		
		test.log(LogStatus.INFO, "Verifying error message");
		Assert.assertTrue(addGroupMembership.getMsgDuplicateEntried());
		
		test.log(LogStatus.INFO, "Clicking ok in error message");
		addGroupMembership.clickOk();
		
		//addGroupMembership.verifyAdded(group,addUser);
		//editGroup.selectGroup(group);
		
		
	}
	
	@Test(priority=3)
	public void GL_Settings_UM_14_2_verifyAddGroupMembershipWithEmptyFields() throws Exception{
		test=report.startTest("verifyAddingGroupMembershipWithEmptyFields");
		addGroupMembership = new GroupMembershipPage(driver);
		
		test.log(LogStatus.INFO, "Clicking submit without selecting group and/or user");
		//addGroupMembership.selectUser(addUser);
		addGroupMembership.submit();
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Verifying error message");
		Assert.assertTrue(addGroupMembership.getMsg());
		
		test.log(LogStatus.INFO, "Clicking ok in error message");
		addGroupMembership.clickOk();
		
		 
		
	}
	
	@Test(priority=4)
	public void verifyCancelAddGroupMembership() throws Exception{
		test=report.startTest("verifyCancellingAddGroupMembership");
		addGroupMembership = new GroupMembershipPage(driver);
		loginPage = new LoginPage(driver);
		
		test.log(LogStatus.INFO, "Clicking Cancel in group membership page");
		addGroupMembership.cancel();
		
		test.log(LogStatus.INFO, "Verifying the navigation to setting page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));
		
	}
	
	@Test(priority=5)
	public void GL_Settings_UM_16_viewMembers() throws InterruptedException {

//Select group
		test=report.startTest("verifyViewMembership");
		editGroup = new EditGroupMembership(driver);
		settingPage = new SettingsPage(driver);
		
		test.log(LogStatus.INFO, "Click on group membership");
		settingPage.clickGroupMembershipBtn();
		
		test.log(LogStatus.INFO, "Selecting group");
		editGroup.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Verifying the members is displayed or not");
		Assert.assertTrue(editGroup.verifyTableIsDisplayed());

	}
	
	@Test(priority=6)
	public void GL_Settings_UM_18_verifyCancelDelete() throws InterruptedException {
		test=report.startTest("verifyCancelDelete");
		groupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);
//Delete user
		
		test.log(LogStatus.INFO, "Selecting the user whome to remove");
		editGroup.removeUser(userNameEdit);
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Verifying the members is displayed or not");
		editGroup.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Clicking remove membership");
		editGroup.removeUser(userNameEdit);
//Cancel delete user
		
		test.log(LogStatus.INFO, "close the message to cancel removing");
		editGroup.closeRemove();
		
		test.log(LogStatus.INFO, "Verifying navigation");
		Assert.assertTrue(groupMembership.verifyNavigationToGroupMembershipPage("Add group membership"));
	}
	
	@Test(priority=7)
	public void GL_Settings_UM_17_verifyDeleteGroupMembership() throws InterruptedException {
		test=report.startTest("verifyDeleteGroupMembership");
//Select group
		editGroup = new EditGroupMembership(driver);
		
		test.log(LogStatus.INFO, "Selecting the group");
		editGroup.selectGroup(groupAdd);
//Delete user
		test.log(LogStatus.INFO, "Clicking remove membership");
		editGroup.removeUser(userNameEdit);
		Thread.sleep(5000);
	
		test.log(LogStatus.INFO, "Clicking ok to remove");
		editGroup.ClickOkToRemoveUser();
//verify deleted
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Selecting group");
		editGroup.selectGroup(groupAdd);
		
		test.log(LogStatus.INFO, "Verifying the removed member exists or not");
		Assert.assertTrue(editGroup.verifyRemove(userNameEdit));

	}
}
	
	