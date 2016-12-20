package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
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
import com.relevantcodes.extentreports.LogStatus;

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
		//report.startTest(test);
		test=report.startTest("verifyAddNewDashboardElement");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		 leftPanel= new CommonPageLeftPane(driver);
		 Thread.sleep(3000);
		 test.log(LogStatus.INFO, "Clicking on Account in left panel");
		 leftPanel.clickOnAccount();
		 Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on a account name");
		leftPanel.clickOnAccountName(accountName);
		//commonPage.waitForPageLoad(10);
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying no dashboard message");
		Assert.assertTrue(dashBoardPage.verifyElementMessage());		
		test.log(LogStatus.INFO, "Clicking on Add New Element");
		dashBoardPage.selectAddNewElement();
			
		//commonPage.waitForPageLoad(10);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		AddElementWizardPage wizardPage = new AddElementWizardPage(driver);
		test.log(LogStatus.INFO, "Selecting a value from metric dropdown");
		wizardPage.selectMetric(metric);
		test.log(LogStatus.INFO, "Entering a title");
		wizardPage.enterMetricTitle(title);
		test.log(LogStatus.INFO, "Entering footer");
		wizardPage.enterFooter(footer);
		test.log(LogStatus.INFO, "Entering description");
		wizardPage.enterDescription(description);
		test.log(LogStatus.INFO, "Clicking on Next button");
		wizardPage.clickNextButton();
		//commonPage.waitForPageLoad(5);
		///wizardPage.selectMutiChartsCheck();
		//wizardPage.selectMutiSeriesCheck();
		test.log(LogStatus.INFO, "Selecting a value from data table dropdown");
		wizardPage.selectDataTable(dataTable);
		test.log(LogStatus.INFO, "Selecting a value from label column dropdown");
		wizardPage.selectLabelColumn(labelColumn);
		test.log(LogStatus.INFO, "Selecting a value from data field dropdown");
		wizardPage.selectDataField(dataField);
		test.log(LogStatus.INFO, "Selecting a value from data series field dropdown");
		wizardPage.selectDataSeriesField(dataSeriesField);
		test.log(LogStatus.INFO, "Selecting a value from chart series dropdown");
		wizardPage.selectChartSeriesField(chartSeriesField);
		test.log(LogStatus.INFO, "Clicking on next button");
		wizardPage.clickNextButton();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Saving the dashboard");
		wizardPage.saveNewElement();
		test.log(LogStatus.INFO, "Verifying dahsboard created");
		Assert.assertEquals(dashBoardPage.verifyChartTitle(),title);
		test.log(LogStatus.INFO, "Deleting the created dashboard");
		dashBoardPage.selectDelete();
		test.log(LogStatus.INFO, "Confirming dashboard delete");
		dashBoardPage.confirmDeleteGraph();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Verifying dashboard deletion");
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		//test.log(LogStatus.PASS, "Test Passed");
		Thread.sleep(5000);
		report.endTest(test);
		
	}
	
	@AfterTest
	public void runAfterTest(){
		leftPanel.clickLogout();
			
	}

}
