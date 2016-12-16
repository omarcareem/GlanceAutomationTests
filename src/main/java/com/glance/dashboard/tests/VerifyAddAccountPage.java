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
import com.glance.pageobjects.usermanagement.DeleteUser;
import com.glance.pageobjects.usermanagement.UserManagementPage;

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

		// login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

	}

	@Test(priority = 0)
	public void GL_Settings_AA_01() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();
		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

	}

	@Test(priority = 1)
	public void GL_Settings_AA_02() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

	}

	@Test(priority = 2)
	public void GL_Settings_AA_03_1() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// get previous count of number of accounts
		settingsPage = new SettingsPage(driver);
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);

		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));

		addAccount.enterAccountName("Abc");
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

		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.addNewEntry();

		Assert.assertTrue(leftPane.verifyAdded(accountName));

	}

	@Test(priority = 4)
	public void GL_Settings_AA_03_3() throws Exception {

		// logout admin
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickLogout();

		// create a user
		loginPage.navigateCreateAccountPage();
		createAccount = new CreateAccountPage(driver);
		createAccount.createUsername("Kavinda");
		createAccount.addemailAdd("psvishwamali@gmail.com");
		createAccount.createpassword("1234qwer");
		createAccount.confirmPassword("1234qwer");
		createAccount.clickSubmitBtn();

		createAccount.clickpopupOK();

		createAccount.clickpopupDone();

		createAccount.clickLoginLink();

		// login with new user
		loginPage = new LoginPage(driver);
		loginPage.enterUsername("Kavinda");
		loginPage.enterPassword("1234qwer");
		loginPage.clickLoginBtn();

		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyAccessDeniedMessage("Access Denied!"));

		leftPane.clickLogout();

		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

		leftPane.clickSettings();
		settingsPage = new SettingsPage(driver);
		settingsPage.ClickManageUsersBtn();

		deleteUser = new DeleteUser(driver);
		deleteUser.selectUserToDelete("Kavinda");
		deleteUser.deleteUsers();
		deleteUser.verifyDelete("Kavinda");

	}

	@Test(priority = 5)
	public void GL_Settings_AA_04() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		int previousCount = settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickCancel();

		Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));

		int newestCount = settingsPage.getCountAddAccount();
		System.out.println(newestCount);

		if (newestCount > previousCount)
			System.out.println("New account is added");

		else
			System.out.println("Account is not added");

	}

	@Test(priority = 6)
	public void GL_Settings_AA_05() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();

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

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddAccountBtn();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName = RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.goToDashboard();

		dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));

	}

	@Test(priority = 8)
	public void GL_Settings_AA_08() {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickCollapseExpand();

	}

	@Test(priority = 9)
	public void GL_Settings_AA_07() {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		leftPane.clickOnAddNewAccountLink();

		addAccount = new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickClose();

	}

}
