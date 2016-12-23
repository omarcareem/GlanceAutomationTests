package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

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
import com.relevantcodes.extentreports.LogStatus;

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

		test=report.startTest("verifyLogin");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
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

	@Test(priority = 0)
	public void GL_Settings_DBM_26_Verify1() throws Exception {

		test=report.startTest("verifyNavigationOfDeleteSearchResultPage");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 1)
	public void GL_Settings_DBM_26() throws Exception {

		//search key word - name
		test=report.startTest("verifyFunctionalityOfDeleteSearchResultPage");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		test.log(LogStatus.INFO, "Enter Search value");
		deleteSearchRecordPage.tableSearch(enterSearch);
		System.out.println("enterSearch " + enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		//search key word - id
		test=report.startTest("verifyFunctionalityOfDeleteSearchResultPage");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		test.log(LogStatus.INFO, "Enter Search value");
		deleteSearchRecordPage.tableSearch(enterSearch2);
		System.out.println("enterSearch2 " + enterSearch2);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}

    @Test(dataProvider = "GL_UM_12", dataProviderClass = GlanceDataProvider.class)
	public void GL_Settings_DBM_27(String showEntry) throws Exception {

		test=report.startTest("verifyFunctionalityOfShowEntry");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		test.log(LogStatus.INFO, "Clicking on ShowEntry");
		deleteSearchRecordPage.clicktShowEntry();
		test.log(LogStatus.INFO, "Selecting Value from show entry dropdown");
		deleteSearchRecordPage.selectDropDown2(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying expected row count");
		deleteSearchRecordPage.expectedRowCount(25);
		test.log(LogStatus.INFO, "Verifying actual row count");
		deleteSearchRecordPage.actualRowCount();
		test.log(LogStatus.INFO, "Verifying dropdown page count");
		deleteSearchRecordPage.verifyDropDownPageCount(25);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 3)
	public void GL_Settings_DBM_28() throws Exception {

		test=report.startTest("verifyFunctionalityOfPagination");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		test.log(LogStatus.INFO, "Clicking on First page navigation");
		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Previous page navigation");
		deleteSearchRecordPage.previousPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Next page navigation");
		deleteSearchRecordPage.nextPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Last page navigation");
		deleteSearchRecordPage.lastPageNavigation();
		test.log(LogStatus.INFO, "Clicking on Middle page navigation");
		deleteSearchRecordPage.middlePageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		test.log(LogStatus.INFO, "Verifying actual page");
		deleteSearchRecordPage.actualPage();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}

	@Test(priority = 4)
	public void GL_Settings_DBM_29() throws Exception {

		test=report.startTest("verifyFunctionalityOfDeleteIcon");
    	commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "clicking on Add Engagement Button");
		settingsPage.clickAddEngagementBtn();

		// add an engagement
		AddEngagementPage addEngagementPage = new AddEngagementPage(driver);
		test.log(LogStatus.INFO, "Verifying Engagement Add operations page");
		Assert.assertTrue(addEngagementPage.getPageName("Engagement Add operations"));

		String engagementName2;
		engagementName2 = RandomNameGenerator.getName();
		addEngagementPage.enterEngagementName(engagementName2);
		System.out.println("before " + engagementName2);
		test.log(LogStatus.INFO, "Selecting account name");
		addEngagementPage.selectAccount(accountName1);
		test.log(LogStatus.INFO, "Selecting delivery method");
		addEngagementPage.selectDeliveryMethod(DeliveryMethod);
		test.log(LogStatus.INFO, "Selecting contract type");
		addEngagementPage.selectContractType(conractType);
		test.log(LogStatus.INFO, "Entering year");
		addEngagementPage.enterYears(years);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selecting Radio button");
		addEngagementPage.selectRadioButton4();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Submit");
		addEngagementPage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selecting Add New Entry button");
		addEngagementPage.selectAddNewEntry();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// get the newly created engagement to a variable
		String newName = engagementName2;
		System.out.println("after " + engagementName2);

		// go to delete record page and delete that created engagement
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();

		test.log(LogStatus.INFO, "Click Search Tab");
		deleteSearchPage.clickSearchTab();
		test.log(LogStatus.INFO, "Selecting select type");
		deleteSearchPage.selectType(deleteType);
		test.log(LogStatus.INFO, "Clicking on Search");
		deleteSearchPage.clickSearch();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		// find the created engagement
		test.log(LogStatus.INFO, "Enter value for Table search");
		deleteSearchRecordPage.tableSearch(newName);
		test.log(LogStatus.INFO, "Selecting Delete");
		deleteSearchRecordPage.selectDelete();
		test.log(LogStatus.INFO, "Verifying Confirm Delete");
		Assert.assertTrue(deleteSearchRecordPage.verifyDelete("Confirm Delete ?"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Okay");
		deleteSearchRecordPage.clickOkay();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		System.out.println("deleted " + newName);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));

		// verify deleted engagement
		test.log(LogStatus.INFO, "Clicking on Search Tab");
		deleteSearchPage.clickSearchTab();
		test.log(LogStatus.INFO, "Selecting select type");
		deleteSearchPage.selectType(deleteType);
		test.log(LogStatus.INFO, "Clicking on Search");
		deleteSearchPage.clickSearch();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		// verify deleted engagement
		test.log(LogStatus.INFO, "Verifying Delete Record Has Deleted");
		deleteSearchRecordPage.verifyDeleteRecordHasDeleted(newName);
		 
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 5)
	public void GL_Settings_DBM_30() throws Exception {

		test=report.startTest("verifyFunctionalityOfTableSort");
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Entering Column Name for Table Sort");
		deleteSearchRecordPage.tableSort(columnName);
		test.log(LogStatus.INFO, "Verifying Table Sort");
		deleteSearchRecordPage.verifyTableSort(columnName);
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Entering Column Name for Table Sort");
		deleteSearchRecordPage.tableSort(columnName2);
		test.log(LogStatus.INFO, "Verifying Table Sort");
		deleteSearchRecordPage.verifyTableSort(columnName2);
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Entering Column Name for Table Sort");
		deleteSearchRecordPage.tableSort(columnName3);
		test.log(LogStatus.INFO, "Verifying Table Sort");
		deleteSearchRecordPage.verifyTableSort(columnName3);
		Thread.sleep(5000);
		// deleteSearchRecordPage.pageCount();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();

	}

	@Test(priority = 5)
	public void GL_Settings_DBM_31() throws Exception {

		test=report.startTest("verifyFunctionalityOfDashboardIcons");
		DashboardPage dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Selecting MaxMin icon");
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		test.log(LogStatus.INFO, "Clickin on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		CommonPageObject commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Selecting Close icon");
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}

}
