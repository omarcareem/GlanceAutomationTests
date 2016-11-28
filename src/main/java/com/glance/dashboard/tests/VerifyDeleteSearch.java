package com.glance.dashboard.tests;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DeleteSearchPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import junit.framework.Assert;

public class VerifyDeleteSearch extends BaseTest{
	
	CommonPageLeftPane commonPageLeftPane;
	SettingsPage settingsPage;
	DeleteSearchPage deleteSearchPage;
	
	@Test (priority=0)
	public void deleteSearchAccount() throws Exception{
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickSettings();
		
		settingsPage = new SettingsPage(driver);
		settingsPage.ClickDeleteRecordsBtn();
		
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
		settingsPage.ClickDeleteRecordsBtn();
		
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
		settingsPage.ClickDeleteRecordsBtn();
		
		deleteSearchPage = new DeleteSearchPage(driver);
		Assert.assertTrue(deleteSearchPage.getPageName("Search"));
		deleteSearchPage.clickSqlTab();
		deleteSearchPage.enterSqlQuery(sqlQuery);
		deleteSearchPage.clickSubmit();
		
	}
}
