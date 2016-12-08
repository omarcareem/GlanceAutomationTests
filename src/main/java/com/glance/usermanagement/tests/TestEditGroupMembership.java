package com.glance.usermanagement.tests;

import com.glance.common.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.EditGroupMembership;
import com.glance.pageobjects.usermanagement.GroupMembershipPage;

public class TestEditGroupMembership extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	EditGroupMembership editGroup;
	GroupMembershipPage groupMembership;

	@BeforeMethod
	public void verifyGoToEditGroupMembership() {
//to login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
//Navigate to setting
		leftPanel = new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
//go to group membership page
		settingPage = new SettingsPage(driver);
		settingPage.clickGroupMembershipBtn();
		

	}

	@Test(priority=0)
	public void GL_Settings_GM_72_viewMembers() throws InterruptedException {

//Select group
		editGroup = new EditGroupMembership(driver);
		editGroup.selectGroup(groupAdd);
		Assert.assertTrue(editGroup.verifyTableIsDisplayed());

	}
	
	@Test(priority=1)
	public void GL_Settings_GM_74_verifyCancelDelete() throws InterruptedException {
		groupMembership = new GroupMembershipPage(driver);
		editGroup = new EditGroupMembership(driver);
//Delete user
		
		editGroup.removeUser(userNameEdit);
		Thread.sleep(5000);
		editGroup.selectGroup(groupAdd);
		
		editGroup.removeUser(userNameEdit);
		editGroup.closeRemove();
		Assert.assertTrue(groupMembership.verifyNavigationToGroupMembershipPage("Add group membership"));
	}
	
	@Test(priority=2)
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
