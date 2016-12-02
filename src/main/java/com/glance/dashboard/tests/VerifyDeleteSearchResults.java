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
	public void testLogout(){
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickLogout();
	}
	
	@Test (priority=0)
	public void NavigatetoDeleteSearchResultpage() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
	}
	
	@Test (priority=1)
	public void DeleteSearchrecordInparticularsearchentryandinparticularpage() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectValue(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		/*deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);*/
		deleteSearchRecordPage.enterSearch(enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.selectDelete();
		Assert.assertTrue(deleteSearchRecordPage.verifyDelete("Confirm Delete ?"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.clickOkay();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.verifyDeleteRecordHasDeleted(recordInsert);
		//deleteSearchRecordPage.verifyDeleted(recordInsert);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
	
	}
	
	@Test (priority=2)
	public void deleteSearchResultPageDeleteCancel() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectValue(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.enterSearch(enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.selectDelete();
		Assert.assertTrue(deleteSearchRecordPage.verifyDelete("Confirm Delete ?"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.clickClose();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.verifyDeleteRecordHasDeleted(recordInsert);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}
	
	@Test (priority=3)
	public void deleteSearchResultPageDeleteFailed() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectValue(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.enterSearch(enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.selectDelete();
		Assert.assertTrue(deleteSearchRecordPage.verifyDelete("Confirm Delete ?"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.clickOkay();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.verifyDeleteRecordHasDeleted(recordInsert);
		//deleteSearchRecordPage.verifyDeleted(recordInsert);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
	}
	
	@Test (priority=4)
	public void deleteSearchResultPageShowEntryAndPAgeNavigation() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.clicktShowEntry();
		deleteSearchRecordPage.selectValue(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.previousPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.nextPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.lastPageNavigation();
	}
	
	@Test (priority=5)
	public void deleteSearchResultPageEnterSearch() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.enterSearch(enterSearch);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}
	
	@Test (priority=6)
	public void deleteSearchResultPageAllPageNavigation() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.previousPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.nextPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		deleteSearchRecordPage.lastPageNavigation();
		
	}
	
	@Test (priority=7)
	public void deleteSearchResultPageMiddlePageNavigation() throws Exception{
		
		deleteSearchRecordPage = new DeleteSearchRecordPage(driver);
		Assert.assertTrue(deleteSearchRecordPage.getPageName("Search"));
		
		deleteSearchRecordPage.middlePageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
	}
	
}
