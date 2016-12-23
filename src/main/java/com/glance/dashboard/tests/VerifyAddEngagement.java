package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddEngagementPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyAddEngagement extends BaseTest {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	AddEngagementPage addEngagementPage;
	String engagementName;
	int previousCount;
	int newCount;
	
	@BeforeMethod
	public void testLogin(){
		
		test=report.startTest("verifyLogin");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();
	}
	
	@Test(priority = 0)
	public void GL_Settings_DBM_09() throws Exception {
		
		test=report.startTest("verifyNavigationToAddEngagementFromSettingsPage");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings icon");
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Add Engagement button");
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}
	
	@Test(priority = 1)
	public void GL_Settings_DBM_10() throws Exception {
		
		test=report.startTest("verifyNavigationToAddEngagementFromLeftPane");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Engagement drpdown");
		commonPageLeftPane.clickEngagement();
		test.log(LogStatus.INFO, "Clicking on Add Engagement link");
		commonPageLeftPane.clickOnAddNewEngagementLink();
		Thread.sleep(5000);
		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 2)
	public void GL_Settings_DBM_11() throws Exception {
		
		test=report.startTest("verifyAddingNewEngagementWithInputData");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Add Engagement button");
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		engagementName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.enterEngagementName(engagementName);
		test.log(LogStatus.INFO, "Selecting Account Name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting Delivery Method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting Contract Type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering Year");
		addEngagementPage.enterYears(years);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		test.log(LogStatus.INFO, "Clicking on Submit button");
		addEngagementPage.clickSubmit();
		test.log(LogStatus.INFO, "Verifying Done Adding New Entry page");
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		test.log(LogStatus.INFO, "Selecting Add New Entry button");
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		engagementName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.enterEngagementName(engagementName);
		test.log(LogStatus.INFO, "Selecting Account Name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting Delivery Method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting Contract Type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering Year");
		addEngagementPage.enterYears(years);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Submit button");
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Done Adding New Entry page");
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		test.log(LogStatus.INFO, "Selecting Go to Dashboard button");
		addEngagementPage.selectGoToDashboard();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dashboardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashboardPage.getPageName("Account Level Dashboard"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}

	@Test(priority = 3)
	public void GL_Settings_DBM_12() throws Exception {

		test=report.startTest("verifyCancelingAddNewEngagement");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Add Engagement button");
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		engagementName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.enterEngagementName(engagementName);
		test.log(LogStatus.INFO, "Selecting Account Name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting Delivery Method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting Contract Type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering Year");
		addEngagementPage.enterYears(years);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Cancel button");
		addEngagementPage.clickCancel();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}


	@Test(priority = 4)
	public void GL_Settings_DBM_11_verify1() throws Exception {

		test=report.startTest("verifyTheCountOfAddedNewEngagement");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage = new SettingsPage(driver);
		// get previous count to a variable
		test.log(LogStatus.INFO, "Confirming previous count");
		previousCount = settingsPage.getCountAddEngagement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Add Engagement button");
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		engagementName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.enterEngagementName(engagementName);
		test.log(LogStatus.INFO, "Selecting Account Name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting Delivery Method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting Contract Type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering Year");
		addEngagementPage.enterYears(years);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		test.log(LogStatus.INFO, "Clicking on Submit button");
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Done Adding New Entry page");
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		test.log(LogStatus.INFO, "Selecting Add New Entry button");
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// verify the previous count is greater than new count
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();

		// get new count to a variable
		test.log(LogStatus.INFO, "Confirming new count");
		newCount = settingsPage.getCountAddEngagement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		test.log(LogStatus.INFO, "Verifying previous and new count");
		settingsPage.verifyEngagementCount(previousCount, newCount);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}
	
	@Test(priority = 5)
	public void GL_Settings_DBM_11_verify2() throws Exception {

		test=report.startTest("verifyTheNameOfAddedNewEngagement");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Add Engagement button");
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operation page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		engagementName = RandomNameGenerator.getName();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.enterEngagementName(engagementName);
		test.log(LogStatus.INFO, "Selecting Account Name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting Delivery Method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting Contract Type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering Year");
		addEngagementPage.enterYears(years);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		test.log(LogStatus.INFO, "Clicking on Submit button");
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Done Adding New Entry page");
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		test.log(LogStatus.INFO, "Selecting Add New Entry button");
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking on Account");
		commonPageLeftPane.clickAccount();
		test.log(LogStatus.INFO, "Verifying the value added");
		addEngagementPage.verifyValueAccount3();
		
		test.log(LogStatus.INFO, "Clicking on Engagement");
		commonPageLeftPane.clickEngagement();
		test.log(LogStatus.INFO, "Entering Engagement Name");
		addEngagementPage.verifyValueEngagement(engagementName);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}
	
	@Test (priority=6)
	public void GL_Settings_DBM_13() throws Exception{
		
		test=report.startTest("verifyFunctionalityOfDashboardIcons");
		DashboardPage dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Clicking on MaxMin icon");
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		CommonPageObject commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Clicking on Close icon");
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
}
