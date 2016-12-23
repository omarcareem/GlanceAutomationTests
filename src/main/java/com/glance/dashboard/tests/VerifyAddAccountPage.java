package com.glance.dashboard.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddAccountPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.DeleteUser;
import com.glance.pageobjects.usermanagement.UserManagementPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyAddAccountPage extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	CreateAccountPage createAccount;
	SettingsPage settingsPage;
	AddAccountPage addAccount;
	DashboardPage dashboard;
	CommonPageObject commonPage;
	BaseTest baseTest;
	DeleteUser deleteUser;
	UserManagementPage userManagement;

	@BeforeMethod
	public void login() {
		
		test=report.startTest("Login");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();

	}

	@Test(priority = 0)
	public void GL_Settings_DBM_01() throws Exception {
		
		test=report.startTest("verifyNavigationToAddAccountPage from settings page");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking account button");
		settingsPage.clickAddAccountBtn();
		
		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
		
	}

	@Test(priority = 1)
	public void GL_Settings_DBM_02() throws Exception {
		
		test=report.startTest("verifyNaavigationToAddAccountPage from left pane");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		test.log(LogStatus.INFO, "Clicking on Add New under Account in left panel");
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(priority = 2)
	public void GL_Settings_DBM_03_1() throws Exception {

		test=report.startTest("verifyAddingAccount");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		// get previous count of number of accounts
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Getting number of accounts");
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

		test.log(LogStatus.INFO, "Entering account name");
		addAccount.enterAccountName("Abc");
		test.log(LogStatus.INFO, "Selecting a segment");
		addAccount.selectSegment(segment);
		test.log(LogStatus.INFO, "Clicking submit button");
		addAccount.clickSubmit();
		addAccount.addNewEntry();

		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		test.log(LogStatus.INFO, "Getting number of accounts");
		int newestCount = settingsPage.getCountAddAccount();
		System.out.println(newestCount);

		test.log(LogStatus.INFO, "Compairing the number of accounts");
		if (newestCount > previousCount)
			System.out.println("New account is added");

		else
			System.out.println("Account is not added");
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 3)
	public void GL_Settings_DBM_03_2() throws Exception {

		test=report.startTest("verifyAddingAccount from left pane");
		test.log(LogStatus.INFO, "Clicking on Add New under Account in left panel");
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering account name");
		addAccount.enterAccountName(accountName);
		test.log(LogStatus.INFO, "Selecting a segment");
		addAccount.selectSegment(segment);
		test.log(LogStatus.INFO, "Clicking submit button");
		addAccount.clickSubmit();
		test.log(LogStatus.INFO, "Clicking add new entry button");
		addAccount.addNewEntry();
		
		test.log(LogStatus.INFO, "Verifying account is added");
		Assert.assertTrue(leftPane.verifyAdded(accountName));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 4)
	public void GL_Settings_DBM_03_3() throws Exception {

		test=report.startTest("verifyNoAccessUser");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

		loginPage = new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		createAccount = new CreateAccountPage(driver);
		
		test.log(LogStatus.INFO, "Entering a user name");
		createAccount.createUsername("Kavinda");
		test.log(LogStatus.INFO, "Entering email");
		createAccount.addemailAdd("psvishwamali@gmail.com");
		test.log(LogStatus.INFO, "Entering password");
		createAccount.createpassword("1234qwer");
		test.log(LogStatus.INFO, "Entering the password again");
		createAccount.confirmPassword("1234qwer");
		test.log(LogStatus.INFO, "Clicking submit button");
		createAccount.clickSubmitBtn();
		test.log(LogStatus.INFO, "Clicking ok button");
		createAccount.clickpopupOK();
		test.log(LogStatus.INFO, "Clicking done button");
		createAccount.clickpopupDone();
		test.log(LogStatus.INFO, "Clicking login link");
		createAccount.clickLoginLink();

		test.log(LogStatus.INFO, "Entering created user name");
		loginPage.enterUsername("Kavinda");
		test.log(LogStatus.INFO, "Entering created password");
		loginPage.enterPassword("1234qwer");
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();

		test.log(LogStatus.INFO, "Clicking on Add New under Account in left panel");
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying the access denied meeage is displayed");
		Assert.assertTrue(addAccount.verifyAccessDeniedMessage("Access Denied!"));
		test.log(LogStatus.INFO, "Clicking logout button");
		leftPane.clickLogout();

		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();
		
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		settingsPage = new SettingsPage(driver);
		
		test.log(LogStatus.INFO, "Clicking on manage user button");
		settingsPage.ClickManageUsersBtn();

		deleteUser = new DeleteUser(driver);
		test.log(LogStatus.INFO, "Selecting the user to delete");
		deleteUser.selectUserToDelete("Kavinda");
		deleteUser.deleteUsers();
		test.log(LogStatus.INFO, "Verifying user is deleted");
		deleteUser.verifyDelete("Kavinda");
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 5)
	public void GL_Settings_DBM_04() throws Exception {

		test=report.startTest("verifyCancel");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Getting number of accounts");
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		test.log(LogStatus.INFO, "Clicking account button");
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		test.log(LogStatus.INFO, "Generating an account name");
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		test.log(LogStatus.INFO, "Selecting a segment");
		addAccount.selectSegment(segment);
		test.log(LogStatus.INFO, "Clicking cancel button");
		addAccount.clickCancel();
		
		test.log(LogStatus.INFO, "Verifying navigation to settings page");
		Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));

		test.log(LogStatus.INFO, "Getting number of accounts");
		int newestCount = settingsPage.getCountAddAccount();
		System.out.println(newestCount);

		test.log(LogStatus.INFO, "Compairing the number of accounts");
		if (newestCount > previousCount)
			System.out.println("New account is added");

		else
			System.out.println("Account is not added");
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 6)
	public void GL_Settings_DBM_05() throws Exception {

		test=report.startTest("verifyAddNewEntry");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking account button");
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		test.log(LogStatus.INFO, "Generating account name");
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		test.log(LogStatus.INFO, "Selecting a segment");
		addAccount.selectSegment(segment);
		test.log(LogStatus.INFO, "Clicking submit button");
		addAccount.clickSubmit();
		test.log(LogStatus.INFO, "Clicking add new entry button");
		addAccount.addNewEntry();
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 7)
	public void GL_Settings_DBM_06() throws Exception {

		test=report.startTest("verifyGoToDashboard");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking account button");
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		test.log(LogStatus.INFO, "Generating account name");
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		test.log(LogStatus.INFO, "Selecting a segment");
		addAccount.selectSegment(segment);
		test.log(LogStatus.INFO, "Clicking submit button");
		addAccount.clickSubmit();
		test.log(LogStatus.INFO, "Clicking go to dashboard button");
		addAccount.goToDashboard();

		dashboard = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to dashboard");
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 8)
	public void GL_Settings_DBM_08() {

		test=report.startTest("verifyCollapseExpand");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Add New under Account in left panel");
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		test.log(LogStatus.INFO, "Clicking collapse and expand");
		addAccount.clickCollapseExpand();

		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(priority = 9)
	public void GL_Settings_DBM_07() {

		test=report.startTest("verifyClose");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		test.log(LogStatus.INFO, "Clicking on Add New under Account in left panel");
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Add Account page");
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		test.log(LogStatus.INFO, "Clicking close icon");
		addAccount.clickClose();

		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

}
