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
	public void GL_Settings_GM_69_verifyAddGroupMembership() throws Exception{
		addGroupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);
		settingPage = new SettingsPage(driver);
		
		leftPanel = new CommonPageLeftPane(driver);
		addGroup = new ManageGroupPage(driver);
		groupMembership = new GroupMembershipPage(driver);
		
		//Navigate to setting
				
				leftPanel.clickSettings();
		//Navigate to Manage group page
				Thread.sleep(3000);
				settingPage.clickManageGroupsBtn();
				addGroup.inputGroupName(groupAdd);
				addGroup.clickAddGroup();
				Thread.sleep(5000);
				groupMembership.clickDone();
				
		//go to group membership page
				
				Thread.sleep(5000);

				leftPanel.clickSettings();
				settingPage.clickGroupMembershipBtn();
		

		addGroupMembership.selectUser(userNameEdit);
		addGroupMembership.selectGroup(groupAdd);
		addGroupMembership.submit();
		Thread.sleep(3000);

		addGroupMembership.clickDone();
		
		//addGroupMembership.verifyAdded(group,addUser);
		editGroup.selectGroup(groupAdd);
		Thread.sleep(3000);
		Assert.assertTrue(addGroupMembership.verifyAdded(groupAdd,userNameEdit));
		
	}
	
	@Test(priority=2)
	public void GL_Settings_GM_71_verifyAddDuplicateEntries() throws Exception{
		addGroupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);

		addGroupMembership.selectUser(userNameEdit);
		addGroupMembership.selectGroup(groupAdd);
		addGroupMembership.submit();
		Thread.sleep(3000);
		Assert.assertTrue(addGroupMembership.getMsgDuplicateEntried());

		addGroupMembership.clickOk();
		
		//addGroupMembership.verifyAdded(group,addUser);
		//editGroup.selectGroup(group);
		
		
	}
	
	@Test(priority=3)
	public void GL_Settings_GM_70_verifyAddGroupMembershipWithEmptyFields() throws Exception{
		
		addGroupMembership = new GroupMembershipPage(driver);
		
		//addGroupMembership.selectUser(addUser);
		addGroupMembership.submit();
		Thread.sleep(5000);
		Assert.assertTrue(addGroupMembership.getMsg());
		
		addGroupMembership.clickOk();
		
		 
		
	}
	
	@Test(priority=4)
	public void verifyCancelAddGroupMembership() throws Exception{
		addGroupMembership = new GroupMembershipPage(driver);
		loginPage = new LoginPage(driver);
		
		addGroupMembership.cancel();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));
		
	}
	
	@Test(priority=5)
	public void GL_Settings_GM_72_viewMembers() throws InterruptedException {

//Select group
		editGroup = new EditGroupMembership(driver);
		settingPage = new SettingsPage(driver);
		
		settingPage.clickGroupMembershipBtn();
		editGroup.selectGroup(groupAdd);
		Assert.assertTrue(editGroup.verifyTableIsDisplayed());

	}
	
	@Test(priority=6)
	public void GL_Settings_GM_74_verifyCancelDelete() throws InterruptedException {
		groupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);
//Delete user
		
		editGroup.removeUser(userNameEdit);
		Thread.sleep(5000);
		editGroup.selectGroup(groupAdd);
		
		editGroup.removeUser(userNameEdit);
//Cancel delete user
		editGroup.closeRemove();
		Assert.assertTrue(groupMembership.verifyNavigationToGroupMembershipPage("Add group membership"));
	}
	
	@Test(priority=7)
	public void GL_Settings_GM_73_verifyDeleteGroupMembership() throws InterruptedException {

//Select group
		editGroup = new EditGroupMembership(driver);
		editGroup.selectGroup(groupAdd);
//Delete user
		editGroup.removeUser(userNameEdit);
		Thread.sleep(5000);
	
		editGroup.ClickOkToRemoveUser();
//verify deleted
		Thread.sleep(5000);
		editGroup.selectGroup(groupAdd);
		
		Assert.assertTrue(editGroup.verifyRemove(userNameEdit));

	}
}
	
	