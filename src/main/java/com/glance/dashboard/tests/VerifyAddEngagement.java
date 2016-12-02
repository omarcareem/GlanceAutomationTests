package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.GlanceDataProvider;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddElementWizardPage;
import com.glance.pageobjects.dashboard.AddEngagementPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;



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
		
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	}
	
	@AfterMethod
	public void testLogout(){
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickLogout();
	}
	
	@Test(priority = 0)
	public void NavigatetoAddNewEngagementusingSettingspage() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

	}
	
	@Test(priority = 1)
	public void verifyAddEngagementElementByLeftPane() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickEngagement();
		commonPageLeftPane.clickOnAddNewEngagementLink();
		Thread.sleep(5000);
		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

	}

	@Test(priority = 2)
	public void submitAddEngagementElementBySettingsPage() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		
		//CommonPageObject commonPage = new CommonPageObject(driver);
		//commonPage.waitForPageLoad(10);
		
		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		addEngagementPage.selectGoToDashboard();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getPageName("Account Level Dashboard"));
	}

	@Test(priority = 3)
	public void verifyAddEngagementElementCancel() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.clickCancel();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		/*
		  String[] expectedValues = {"Dashboard Management", "Data Management", "User Management", "Personalizations", "Maintenance"};
		  Assert.assertTrue(settingsPage.verifyPageName(expectedValues));
		 */

	}


	@Test(priority = 4)
	public void verifyAddEngagementElementAddedtoDb() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage = new SettingsPage(driver);
		// get previous count to a variable
		previousCount = settingsPage.getCountAddEngagement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		addEngagementPage.selectRadioButton4();
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// verify the previous count is greater than new count
		commonPageLeftPane.clickSettings();

		// get new count to a variable
		newCount = settingsPage.getCountAddEngagement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage.verifyEngagementCount(previousCount, newCount);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

	}
	
	@Test(priority = 5)
	public void verifyAddEngagementElementAddedtoLeftPane() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);		
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		addEngagementPage.selectRadioButton4();
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(addEngagementPage.verifySubmit("Done adding new entry"));
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		commonPageLeftPane.clickAccount();
		addEngagementPage.verifyValueAccount3();
		
		commonPageLeftPane.clickEngagement();
		addEngagementPage.verifyValueEngagement(engagementName);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

	}
	
	@Test (priority=6)
	public void screenIconsoftehaddengaggemetnpage() throws Exception{
		
		DashboardPage dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane.clickGlanceIcon();
		CommonPageObject commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}
	
	//********************************************************
	@Test(dataProvider = "chartTestData", dataProviderClass = GlanceDataProvider.class)
	public void verifyAddNewEngagement(String engagementName, String account, String deliveryMethod, String contractType, String years) throws Exception {

		
		CommonPageObject commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		engagementName = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName);
		addEngagementPage.selectAccount(account);
		addEngagementPage.selectDeliveryMethod(deliveryMethod);
		addEngagementPage.selectContractType(contractType);
		addEngagementPage.enterYears(years);
		addEngagementPage.selectRadioButton4();
		Thread.sleep(5000);
		addEngagementPage.clickSubmit();
		
		Assert.assertTrue(dashboardPage.verifyElementMessage());
		Thread.sleep(5000);
			
		
	}
	//*********************************************************
}
