package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.dashboard.DeleteSearchRecordPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import junit.framework.Assert;

public class VerifyDeleteSearchResults extends BaseTest{

	LoginPage loginPage;
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	DeleteSearchPage deleteSearchPage;
	DeleteSearchRecordPage deleteSearchRecordPage;
	CommonPageObject commonPageObject;
	
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
	public void deleteSearchResultPage() throws Exception{
		
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
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectValue(showEntry);
		deleteSearchRecordPage.enterSearch(enterSearch);
		
		commonPageObject = new CommonPageObject(driver);
		commonPageObject.firstPageNavigation();
		commonPageObject.previousPageNavigation();
		commonPageObject.nextPageNavigation();
		
	}
	
}
