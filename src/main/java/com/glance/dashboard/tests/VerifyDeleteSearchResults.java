package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.GlanceDataProvider;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddEngagementPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.dashboard.DeleteSearchRecordPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import junit.framework.Assert;

public class VerifyDeleteSearchResults extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	DeleteSearchPage deleteSearchPage;
	DeleteSearchRecordPage deleteSearchRecordPage;
	CommonPageObject commonPageObject;

	@BeforeMethod
	public void testLogin() {

		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();

		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSearchTab();
		deleteSearchPage.selectType(deleteType);
		deleteSearchPage.clickSearch();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void testLogout() {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 0)
	public void GL_Settings_DSR_28() throws Exception {

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

	}

	@Test(priority = 1)
	public void GL_Settings_DSR_29() throws Exception {

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		deleteSearchRecordPage.tableSearch(enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//Assert.assertTrue(deleteSearchRecordPage.verifyEmptySearch("No matching records found"));

	}

	@Test(dataProvider = "ShowEntryData", dataProviderClass = GlanceDataProvider.class)
	public void GL_Settings_DSR_30(String showEntry) throws Exception {

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectDropDown2(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.expectedRowCount(25);
		deleteSearchRecordPage.actualRowCount();
		deleteSearchRecordPage.verifyDropDownPageCount(25);

	}

	@Test(priority = 3)
	public void GL_Settings_DSR_31() throws Exception {

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.previousPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.nextPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.lastPageNavigation();
		deleteSearchRecordPage.middlePageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		deleteSearchRecordPage.actualPage();
	}

	@Test(priority = 4)
	public void GL_Settings_DSR_32() throws Exception {

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickLogout();

		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickAddEngagementBtn();

		// add an engagement
		AddEngagementPage addEngagementPage = new AddEngagementPage(driver);
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		String engagementName2;
		engagementName2 = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName2);
		System.out.println("before " + engagementName2);
		addEngagementPage.selectAccount(accountName1);
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		addEngagementPage.selectContractType(conractType);
		addEngagementPage.enterYears(years);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// get the newly created engagement to a variable
		String newName = engagementName2;
		System.out.println("after " + engagementName2);

		// go to delete record page and delete that created engagement
		commonPageLeftPane.clickSettings();
		settingsPage.clickDeleteRecordsBtn();

		deleteSearchPage.clickSearchTab();
		deleteSearchPage.selectType(deleteType);
		deleteSearchPage.clickSearch();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		// find the created engagement
		deleteSearchRecordPage.tableSearch(newName);
		deleteSearchRecordPage.selectDelete();
		Assert.assertTrue(deleteSearchRecordPage.verifyDelete("Confirm Delete ?"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.clickOkay();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		System.out.println("deleted " + newName);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));

		// verify deleted engagement
		deleteSearchPage.clickSearchTab();
		deleteSearchPage.selectType(deleteType);
		deleteSearchPage.clickSearch();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// verify deleted engagement
		 deleteSearchRecordPage.verifyDeleteRecordHasDeleted(newName);

	}

	@Test(priority = 5)
	public void GL_Settings_DSR_33() throws Exception {

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		deleteSearchRecordPage.tableSort(columnName);
		deleteSearchRecordPage.verifyTableSort(columnName);
		Thread.sleep(5000);
		// deleteSearchRecordPage.pageCount();

	}

	@Test(priority = 5)
	public void GL_Settings_DSR_34() throws Exception {

		DashboardPage dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		commonPageLeftPane.clickGlanceIcon();
		CommonPageObject commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

}
