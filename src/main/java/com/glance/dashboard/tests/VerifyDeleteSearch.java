package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;



public class VerifyDeleteSearch extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	DeleteSearchPage deleteSearchPage;
	
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
	
	@Test (priority=0)
	public void NavigatetoDeleteSearchpage() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		
	}
	
	@Test (priority=1)
	public void NavigatetoSearchtab() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSearchTab();
	}
	
	@Test (priority=2)
	public void NavigatetoSQLtab() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSqlTab();
	}
	
	@Test (priority=3)
	public void searchforparticulardatausingSearch() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSearchTab();
		deleteSearchPage.selectType(deleteType);
		deleteSearchPage.enterId(typeID);
		deleteSearchPage.enterId(typeName);
		deleteSearchPage.clickSearch();
		
	}
	
	@Test (priority=4)
	public void searchforparticulardatausingSQL() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSqlTab();
		deleteSearchPage.enterSqlQuery(sqlQuery);
		deleteSearchPage.clickSubmit();
		
	}
	
	@Test (priority=5)
	public void screenIconsoftehDeleteSearchpage() throws Exception{
		
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
