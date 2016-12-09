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
	login=new LoginPage(driver);
	login.enterUsername(userName);
	login.enterPassword(password);
	login.clickLoginBtn();
	
	}
	
	@Test (priority=0)
	public void GL_Settings_AA_01_verifyAddAccount() throws Exception{
		
	
		settingPage=new SettingsPage(driver);
		
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"));
		
		
		//click on add account and check
		settingPage.clickAddAccountBtn();
		addAccount=new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account "));
		
	}
	
	@Test (priority=1)
	public void GL_Settings_AE_09_verifyAddEngagement() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on add Engagement and check
				settingPage.clickAddEngagementBtn();
				addEngagement=new AddEngagementPage(driver);
				Assert.assertTrue(addEngagement.getPageName("Engagement "));
		
	}
	
	@Test (priority=2)
	public void GL_Settings_AP_14_verifyAddProject() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on add Project and check
		settingPage.clickAddProjectBtn();
		addProject=new AddProjectPage(driver);
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		
	}
	
	@Test (priority=3)
	public void GL_Settings_DS_22_verifyDeleteSearch() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on delete search and check
		settingPage.clickDeleteRecordsBtn();
		deleteSearch=new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearch.verifyNavigationToDeleteSearchPage("Search"));
		
	}
	
	@Test (priority=4)
	public void GL_Settings_DU_41_verifyDataUploadPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on data upload and check
		settingPage.clickDataUploadBtn();
		dataUpload=new DataUploadPage(driver);
		Assert.assertTrue(dataUpload.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		
	}
	
	
	@Test (priority=5)
	public void GL_Settings_DM_45_verifyDataDeleteModifyPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on Data Delete/Modify and check
		settingPage.clickDataDeleteModifyBtn();
		dataDeleteUpdate=new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDeleteUpdate.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		
	}
	
	@Test (priority=6)
	public void verifySocketsPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on Sockets and check
		settingPage.clickSocketsBtn();
		addSocket=new AddSocketDetailsPage(driver);
		Assert.assertTrue(addSocket.verifyNavigationToAddSocketPage("Add Socket Details"));
		
	}
	
	@Test (priority=7)
	public void GL_Settings_MU_56_verifyManageUsersPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on Manage users and check
		settingPage.clickManageUsersBtn();
		userManagement=new UserManagementPage(driver);
		Assert.assertTrue(userManagement.FindUserDetailsElement("All active users"));
		
	}
	
	@Test (priority=8)
	public void GL_Settings_MG_79_verifyManageGroupPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on Manage groups and check
		settingPage.clickManageGroupsBtn();
		manageGroup=new ManageGroupPage(driver);
		Assert.assertTrue(manageGroup.verifyNavigationToManageGroupPage("Add Group Details"));

	}
	
	@Test (priority=9)
	public void GL_Settings_GM_68_verifyManageGroupmembershipPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on Group Membership and check
		settingPage.clickGroupMembershipBtn();
		groupMembership=new GroupMembershipPage(driver);
		Assert.assertTrue(groupMembership.verifyNavigationToGroupMembershipPage("Add group membership"));		
						
	
	}
	
	@Test (priority=10)
	public void GL_Settings_MA_75_verifyManageAccessPage() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on manage access and check
		settingPage.clickManageAccessBtn();
		manageAccess=new ManageAccessPage(driver);
		Assert.assertTrue(manageAccess.verifyNavigationToManageAccessPage("Manage Access"));
		
	}
	
	
	@Test (priority=11)
	public void GL_Settings_DD_88_verifyRadioBtnCurrentMonth() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on default date and check
		settingPage.clickCurrentMonthRadioBtn();
		settingPage.clickSaveBtn();
		settingPage.clickSaveOKBtn();
		
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
				));		
		
	}
	
	@Test (priority=12)
	public void GL_Settings_DD_89_verifyRadioBtnLastSelected() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on default date and check
		settingPage.clickLastSelectedRadioBtn();
		settingPage.clickSaveBtn();
		settingPage.clickSaveOKBtn();	
		
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
				));		
	}
	
	@Test (priority=13)
	public void GL_Settings_PU_90_verifyProfileUpdate() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
	//click on profile update and check
	settingPage.clickProfileUpdateBtn();
	profileUpdate=new ProfileUpdatePage(driver);
	Assert.assertTrue(profileUpdate.getProfileUpdateTitle("Update Login Profile Details"));	
	
	}
	
	
	@Test (priority=14)
	public void GL_Settings_SD_100_verifySessionDump() throws Exception{
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		//click on maintenance and check
		settingPage.clickSessionDumpBtn();
		Assert.assertTrue(settingPage.checkSessionDumpUserId(expectedMessageUserId));
		Assert.assertTrue(settingPage.checkSessionDumpUserName(expectedMessageUserName));
		Assert.assertTrue(settingPage.checkSessionDumpFirstName(expectedMessageFirstName));
		Assert.assertTrue(settingPage.checkSessionDumpLastName(expectedMessageLastName));
	
	}
	
}
	

