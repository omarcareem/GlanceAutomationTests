package com.glance.dashboard.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
import com.glance.pageobjects.usermanagement.UserManagementPage;

public class VerifyAddAccountPage extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	CreateAccountPage createAccount;
	SettingsPage settingsPage;
	AddAccountPage addAccount;
	String accountName;
	DashboardPage dashboard;
	CommonPageObject commonPage;
	BaseTest baseTest;
	UserManagementPage userManagement;
	

	@BeforeMethod
	public void login() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

	}

	@BeforeMethod
	public void waitingForPageLoad() {

		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(5);
	}

	@Test(priority = 0)
	public void GL_Settings_AA_01() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

	}
	
	@Test(priority = 1)
	public void GL_Settings_AA_02() throws Exception {

		// click on add new under account tab
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickOnAddNewAccountLink();

		
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

	}

	@Test(priority = 2)
	public void GL_Settings_AA_03_1() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// get previous count of number of accounts
		settingsPage = new SettingsPage(driver);
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();

		// create an account
		addAccount = new AddAccountPage(driver);

		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

		addAccount.enterAccountName("Abc");
		System.out.println(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.addNewEntry();

		// get current count of number of accounts
		leftPane.clickSettings();
		int newestCount = settingsPage.getCountAddAccount();
		System.out.println(newestCount);

		// compare the counts
		if (newestCount > previousCount)
			System.out.println("New account is added");

		else
			System.out.println("Account is not added");	

	}
	
	@Test(priority = 3)
	public void GL_Settings_AA_03_2() throws Exception {

		// click on add new on left pane
		leftPane.clickOnAddNewAccountLink();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.addNewEntry();

		// check account is added
		Assert.assertTrue(leftPane.verifyAdded(accountName));

	}
	
	@Test(priority = 4)
	public void GL_Settings_AA_03_3() throws Exception {
		
		//logout admin
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickLogout();
		
		//create a user
		loginPage.navigateCreateAccountPage();
		createAccount = new CreateAccountPage(driver);
		createAccount.createUsername("Kavinda");
		createAccount.addemailAdd("psvishwamali@gmail.com");
		createAccount.createpassword("1234qwer");
		createAccount.confirmPassword("1234qwer");
		createAccount.clickSubmitBtn();
		createAccount.clickpopupOK();
		createAccount.clickLoginLink();
		
		//login with new user
		loginPage = new LoginPage(driver);
		loginPage.enterUsername("Kavinda");
		loginPage.enterPassword("1234qwer");
		loginPage.clickLoginBtn();
		
		// click on add new on left pane
		leftPane.clickOnAddNewAccountLink();
		
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyAccessDeniedMessage("Access Denied!"));

	}

		@Test(priority = 5)
	public void GL_Settings_AA_04() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// get previous count of number of accounts
		settingsPage = new SettingsPage(driver);
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickCancel();

		// checking navigation back to settings page
		Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));

		// get current count of number of accounts
		int newestCount = settingsPage.getCountAddAccount();
		System.out.println(newestCount);

		// compare the counts
		if (newestCount > previousCount)
			System.out.println("New account is added");

		else
			System.out.println("Account is not added");

	}

	@Test(priority = 6)
	public void GL_Settings_AA_05() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// click on add account
		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.addNewEntry();

		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

	}

	@Test(priority = 7)
	public void GL_Settings_AA_06() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// click on add account
		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.goToDashboard();
		
		// checking navigation back to dashboard page
		dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));

	}

	@Test(priority = 8)
	public void GL_Settings_AA_08() {

		// click on add new on left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickOnAddNewAccountLink();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickCollapseExpand();

	}

/*	@Test(priority = 9)
	public void GL_Settings_AA_07() {

		// click on add new on left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickOnAddNewAccountLink();

		// create an account
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickClose();

	}*/
	
	@AfterMethod
	public void deleteUser(){
		
		// login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		// click manage users
		settingsPage = new SettingsPage(driver);
		settingsPage.ClickManageUsersBtn();
		
		userManagement = new UserManagementPage(driver);
		userManagement.tableDeleteLink("35");
	}
}
