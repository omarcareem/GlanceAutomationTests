package com.glance.dashboard.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
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
	public void deleteSearchAccount() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSearchTab();
		deleteSearchPage.selectType(deleteType);
		deleteSearchPage.clickSearch();
		
	}
	
	@Test (priority=1)
	public void deleteSearchAllElement() throws Exception{
		
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
	
	@Test (priority=2)
	public void deleteSearchSQL() throws Exception{
		
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
}
