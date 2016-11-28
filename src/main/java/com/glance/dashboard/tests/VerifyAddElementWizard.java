package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;

import com.glance.common.tests.GlanceDataProvider;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddElementWizardPage;
import com.glance.pageobjects.dashboard.AddProjectPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class VerifyAddElementWizard extends BaseTest {

	LoginPage loginPage;
	CommonPageObject commonPage;
	DashboardPage dashBoardPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	AddProjectPage addProjectPage;

	@Test(dataProvider = "chartTestData", dataProviderClass = GlanceDataProvider.class)
	public void TC01_verifyAddNewDashboardElement(String accountName, String metric, String title, String footer, String description,
			String dataTable, String labelColumn, String dataField, String dataSeriesField, String chartSeriesField) throws Exception {

		
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		 leftPanel= new CommonPageLeftPane(driver);
		 leftPanel.clickOnAccount();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		leftPanel.clickOnAccountName(accountName);
		//commonPage.waitForPageLoad(10);
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		dashBoardPage.selectAddNewElement();
			
		//commonPage.waitForPageLoad(10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AddElementWizardPage wizardPage = new AddElementWizardPage(driver);
		wizardPage.selectMetric(metric);
		wizardPage.enterMetricTitle(title);
		wizardPage.enterFooter(footer);
		wizardPage.enterDescription(description);
		wizardPage.clickNextButton();
		//commonPage.waitForPageLoad(5);
		///wizardPage.selectMutiChartsCheck();
		//wizardPage.selectMutiSeriesCheck();
		wizardPage.selectDataTable(dataTable);
		wizardPage.selectLabelColumn(labelColumn);
		wizardPage.selectDataField(dataField);
		wizardPage.selectDataSeriesField(dataSeriesField);
		wizardPage.selectChartSeriesField(chartSeriesField);
		wizardPage.clickNextButton();
		Thread.sleep(5000);
		wizardPage.saveNewElement();
		Assert.assertEquals(dashBoardPage.verifyChartTitle(),title);
		
		dashBoardPage.selectDelete();
		dashBoardPage.confirmDeleteGraph();
		Thread.sleep(5000);
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		Thread.sleep(5000);
			
		
	}
	
	@AfterTest
	public void runAfterTest(){
		leftPanel.clickLogout();	
	}

}
