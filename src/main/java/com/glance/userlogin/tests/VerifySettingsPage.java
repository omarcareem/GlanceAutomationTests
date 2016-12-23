package com.glance.userlogin.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddAccountPage;
import com.glance.pageobjects.dashboard.AddEngagementPage;
import com.glance.pageobjects.dashboard.AddProjectPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.datamanagement.AddSocketDetailsPage;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;
import com.glance.pageobjects.datamanagement.DataUploadPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.GroupMembershipPage;
import com.glance.pageobjects.usermanagement.ManageAccessPage;
import com.glance.pageobjects.usermanagement.ManageGroupPage;
import com.glance.pageobjects.usermanagement.UserManagementPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifySettingsPage extends BaseTest {

	CommonPageObject commonPage;
	LoginPage login;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	AddAccountPage addAccount;
	AddEngagementPage addEngagement;
	AddProjectPage addProject;
	DeleteSearchPage deleteSearch;
	DataUploadPage dataUpload;
	DataDeleteUpdatePage dataDeleteUpdate;
	AddSocketDetailsPage addSocket;
	UserManagementPage userManagement;
	ManageGroupPage manageGroup;
	GroupMembershipPage groupMembership;
	ManageAccessPage manageAccess;

	ProfileUpdatePage profileUpdate;

	@BeforeMethod
	public void login() {
		// Login to Glance By entering user name and password
		test=report.startTest("verifyLogin");
		login=new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		login.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		login.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		login.clickLoginBtn();
	}

	@Test(priority = 0)
	public void GL_Settings_DBM_01_verifyAddAccount() throws Exception {

		settingPage = new SettingsPage(driver);
		test=report.startTest("verifyAddAccount");
		// click on settings button in left panal
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));

		// click on add account and check
		test.log(LogStatus.INFO, "Clicking on add account button in settings");
		settingPage.clickAddAccountBtn();
		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account "));

	}

	@Test(priority = 1)
	public void GL_Settings_DBM_09_verifyAddEngagement() throws Exception {
		test=report.startTest("verifyAddEngagement");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on add Engagement and check
		test.log(LogStatus.INFO, "Clicking on add Engagement in settings");
		settingPage.clickAddEngagementBtn();
		addEngagement = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Engagement page");
		Assert.assertTrue(addEngagement.getPageName("Engagement "));

	}

	@Test(priority = 2)
	public void GL_Settings_DBM_14_verifyAddProject() throws Exception {
		
		test=report.startTest("verifyAddProject");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on add Project and check
		test.log(LogStatus.INFO, "Clicking on add Project in settings");
		settingPage.clickAddProjectBtn();
		addProject = new AddProjectPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));

	}

	@Test(priority = 3)
	public void GL_Settings_DBM_21_verifyDeleteSearch() throws Exception {
		
		test=report.startTest("verifyDeleteSearch");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on delete search and check
		test.log(LogStatus.INFO, "Clicking on delete search  in settings");
		settingPage.clickDeleteRecordsBtn();
		deleteSearch = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to search page");
		Assert.assertTrue(deleteSearch.verifyNavigationToDeleteSearchPage("Search"));

	}

	@Test(priority = 4)
	public void GL_Settings_DM_01_verifyDataUploadPage() throws Exception {
		
		test=report.startTest("verifyDataUploadPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on data upload and check
		test.log(LogStatus.INFO, "Clicking on data upload in settings");
		settingPage.clickDataUploadBtn();
		dataUpload = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to data upload page");
		Assert.assertTrue(dataUpload.verifyNavigationToDataUploadPage("Upload Your Files Here"));

	}

	@Test(priority = 5)
	public void GL_Settings_DM_05_verifyDataDeleteModifyPage() throws Exception {
		
		test=report.startTest("verifyDataDeleteModifyPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on Data Delete/Modify and check
		test.log(LogStatus.INFO, "Clicking on add Data Delete/Modify in settings");
		settingPage.clickDataDeleteModifyBtn();
		dataDeleteUpdate = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Data Delete/Modify page");
		Assert.assertTrue(dataDeleteUpdate.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));

	}

	@Test(priority = 6)
	public void verifySocketsPage() throws Exception {
		
		test=report.startTest("verifySocketsPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on Sockets and check
		test.log(LogStatus.INFO, "Clicking on Sockets in settings");
		settingPage.clickSocketsBtn();
		addSocket = new AddSocketDetailsPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Sockets page");
		Assert.assertTrue(addSocket.verifyNavigationToAddSocketPage("Add Socket Details"));

	}

	@Test(priority = 7)
	public void GL_Settings_UM_01_verifyManageUsersPage() throws Exception {
		
		test=report.startTest("verifyManageUsersPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on Manage users and check
		test.log(LogStatus.INFO, "Clicking on Manage users in settings");
		settingPage.ClickManageUsersBtn();
		userManagement = new UserManagementPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Manage users page");
		Assert.assertTrue(userManagement.FindUserDetailsElement("User Details"));

	}

	@Test(priority = 8)
	public void GL_Settings_UM_23_verifyManageGroupPage() throws Exception {
		
		test=report.startTest("verifyManageUsersPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on Manage groups and check
		test.log(LogStatus.INFO, "Clicking on Manage groups in settings");
		settingPage.clickManageGroupsBtn();
		manageGroup = new ManageGroupPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Manage groups page");
		Assert.assertTrue(manageGroup.verifyNavigationToManageGroupPage("Add Group Details"));

	}

	@Test(priority = 9)
	public void GL_Settings_UM_13_verifyManageGroupmembershipPage() throws Exception {
		
		test=report.startTest("verifyManageGroupmembershipPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on Group Membership and check
		test.log(LogStatus.INFO, "Clicking on Group Membership in settings");
		settingPage.clickGroupMembershipBtn();
		groupMembership = new GroupMembershipPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Group Membership page");
		Assert.assertTrue(groupMembership.verifyNavigationToGroupMembershipPage("Add group membership"));

	}

	@Test(priority = 10)
	public void GL_Settings_UM_19_verifyManageAccessPage() throws Exception {
		
		test=report.startTest("verifyManageAccessPage");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on manage access and check
		test.log(LogStatus.INFO, "Clicking on manage access in settings");
		settingPage.clickManageAccessBtn();
		manageAccess = new ManageAccessPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to manage access page");
		Assert.assertTrue(manageAccess.verifyNavigationToManageAccessPage("Manage Access"));

	}

	@Test(priority = 11)
	public void GL_Settings_PS_01_verifyRadioBtnCurrentMonth() throws Exception {
		
		test=report.startTest("verifyRadioBtnCurrentMonth");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on default date and check
		test.log(LogStatus.INFO, "Clicking on CurrentMonthRadioBtn in settings");
		settingPage.clickCurrentMonthRadioBtn();
		test.log(LogStatus.INFO, "Clicking on save button");
		settingPage.clickSaveBtn();
		test.log(LogStatus.INFO, "Clicking on Ok button");
		settingPage.clickSaveOKBtn();

		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));

	}

	@Test(priority = 12)
	public void GL_Settings_PS_02_verifyRadioBtnLastSelected() throws Exception {
		
		test=report.startTest("verifyRadioBtnLastSelected");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on default date and check
		test.log(LogStatus.INFO, "Clicking on LastSelectedRadioBtn in settings");
		settingPage.clickLastSelectedRadioBtn();
		test.log(LogStatus.INFO, "Clicking on save button");
		settingPage.clickSaveBtn();
		test.log(LogStatus.INFO, "Clicking on Ok button");
		settingPage.clickSaveOKBtn();
		
		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));
	}

	@Test(priority = 13)
	public void GL_Settings_PS_03_verifyProfileUpdate() throws Exception {
		
		test=report.startTest("verifyProfileUpdate");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on profile update and check
		test.log(LogStatus.INFO, "Clicking on profile update in settings");
		settingPage.clickProfileUpdateBtn();
		profileUpdate = new ProfileUpdatePage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to profile update page");
		Assert.assertTrue(profileUpdate.getProfileUpdateTitle("Update Login Profile Details"));

	}

	@Test(priority = 14)
	public void GL_Settings_SD_01_verifySessionDump() throws Exception {
		
		test=report.startTest("verifySessionDump");
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		// click on maintenance and check
		test.log(LogStatus.INFO, "Clicking on session dump in settings");
		settingPage.clickSessionDumpBtn();
		test.log(LogStatus.INFO, "Checking on userID on session dump");
		Assert.assertTrue(settingPage.checkSessionDumpUserId(expectedMessageUserId));
		test.log(LogStatus.INFO, "Checking on UserName on session dump");
		Assert.assertTrue(settingPage.checkSessionDumpUserName(expectedMessageUserName));
		/*test.log(LogStatus.INFO, "Checking on FirstName on session dump");
		Assert.assertTrue(settingPage.checkSessionDumpFirstName(expectedMessageFirstName));*/
		

	}

}
