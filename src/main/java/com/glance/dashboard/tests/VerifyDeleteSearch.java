package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyDeleteSearch extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	DeleteSearchPage deleteSearchPage;
	
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
	
	@Test (priority=0)
	public void GL_Settings_DBM_21() throws Exception{
		
		test=report.startTest("verifyNavigationOfDeleteRecordPage");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
	
	@Test (priority=1)
	public void GL_Settings_DBM_21_Verify1() throws Exception{
		
		test=report.startTest("verifyNavigationOfSearchTab");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		test.log(LogStatus.INFO, "Clicking on Search Tab");
		deleteSearchPage.clickSearchTab();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}
	
	@Test (priority=2)
	public void GL_Settings_DBM_22() throws Exception{
		
		test=report.startTest("verifyNavigationOfSqlTab");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		test.log(LogStatus.INFO, "Clicking on Sql Tab");
		deleteSearchPage.clickSqlTab();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}
	
	@Test (priority=3)
	public void GL_Settings_DBM_23() throws Exception{
		
		test=report.startTest("verifyDeleteRecordSearch");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		test.log(LogStatus.INFO, "Clicking on Search Tab");
		deleteSearchPage.clickSearchTab();
		test.log(LogStatus.INFO, "Selecting Type from dropdown");
		deleteSearchPage.selectType(deleteType);
		test.log(LogStatus.INFO, "Entering ID");
		deleteSearchPage.enterId(typeID);
		test.log(LogStatus.INFO, "Entering Name");
		deleteSearchPage.enterId(typeName);
		deleteSearchPage.clickSearch();
		
		//invalid data
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		test=report.startTest("verifyDeleteRecordSearch");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		test.log(LogStatus.INFO, "Clicking on Search Tab");
		deleteSearchPage.clickSearchTab();
		test.log(LogStatus.INFO, "Selecting Type from dropdown");
		deleteSearchPage.selectType(deleteType);
		test.log(LogStatus.INFO, "Entering ID");
		deleteSearchPage.enterId(typeID2);
		test.log(LogStatus.INFO, "Entering Name");
		deleteSearchPage.enterId(typeName2);
		deleteSearchPage.clickSearch();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
	
	@Test (priority=4)
	public void GL_Settings_DBM_24() throws Exception{
		
		test=report.startTest("verifySubmitSqlQuery");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSqlTab();
		test.log(LogStatus.INFO, "Entering Sql query");
		deleteSearchPage.enterSqlQuery(sqlQuery);
		test.log(LogStatus.INFO, "Clicking on Submit button");
		deleteSearchPage.clickSubmit();
		
		//invalid data
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		test=report.startTest("verifySubmitSqlQuery");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Settings button");
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Delete Record button");
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		test.log(LogStatus.INFO, "Verifying Search page");
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSqlTab();
		test.log(LogStatus.INFO, "Entering Sql query");
		deleteSearchPage.enterSqlQuery(sqlQuery2);
		test.log(LogStatus.INFO, "Clicking on Submit button");
		deleteSearchPage.clickSubmit();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
	
	@Test (priority=5)
	public void GL_Settings_DBM_25() throws Exception{
		
		test=report.startTest("verifyFunctionalityOfDashboardIcons");
		DashboardPage dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Selecting MaxMin icon");
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking on Glance icon");
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
