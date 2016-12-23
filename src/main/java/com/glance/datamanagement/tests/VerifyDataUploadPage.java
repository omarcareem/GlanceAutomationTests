package com.glance.datamanagement.tests;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;
import com.glance.pageobjects.datamanagement.DataUploadPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class VerifyDataUploadPage extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	DataUploadPage dataUploadPage;
	CommonPageObject commonPage;
	DataDeleteUpdatePage dataDUPage;

	@BeforeMethod
	public void login() {

		test=report.startTest("Login");
		test=report.startTest("Login");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();

	}

	@Test(priority = 0)
	public void GL_Settings_DM_01() throws Exception {

		test=report.startTest("verifyNavigationToDataUploadPage from settings page");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 1)
	public void GL_Settings_DM_02_1() throws IOException, InterruptedException {

		test=report.startTest("verifyUploadingData");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();
		test.log(LogStatus.INFO, "Verifying the existence of record");
		Assert.assertTrue(dataDUPage.verifyReordExist("8"));

		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();
		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataUploadPage.selectDataTable(tableName);
		test.log(LogStatus.INFO, "Selecting file upload area");
		dataUploadPage.selectFileUploadArea();
		test.log(LogStatus.INFO, "AutoIT script");
		Runtime.getRuntime().exec("C:\\GlanceProject\\GlanceAutomationTests\\FileUpload.exe");
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Clicking upload button");
		dataUploadPage.clickUpload();
		test.log(LogStatus.INFO, "Verifying record is added message");
		Assert.assertTrue(dataUploadPage.verifyRecordsAdded("1 records added to the table cdi"));
		test.log(LogStatus.INFO, "Clicking done button");
		dataUploadPage.clickDone();

		// check for the uploaded record
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();
		test.log(LogStatus.INFO, "Verifying the existence of record");
		Assert.assertTrue(dataDUPage.verifyReordExist("8"));
		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 2)
	public void GL_Settings_DM_02_2() throws InterruptedException {

		test=report.startTest("verifyUploadingData without a file");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataUploadPage.selectDataTable(tableName);

		test.log(LogStatus.INFO, "Clicking upload button");
		dataUploadPage.clickUpload();
		test.log(LogStatus.INFO, "Verifying error message");
		Assert.assertTrue(dataUploadPage.verifyEmptyFileErrorMessage("Please select a file you wish to upload"));
		test.log(LogStatus.INFO, "Clicking okay button");
		dataUploadPage.clickOkay();
		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 3)
	public void GL_Settings_DM_02_3() throws IOException, InterruptedException {

		test=report.startTest("verifyUploadingData without a table");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Selecting file upload area");
		dataUploadPage.selectFileUploadArea();
		test.log(LogStatus.INFO, "AutoIT script");
		Runtime.getRuntime().exec("C:\\GlanceProject\\GlanceAutomationTests\\FileUpload.exe");
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Clicking upload button");
		dataUploadPage.clickUpload();
		test.log(LogStatus.INFO, "Verifying error message");
		Assert.assertTrue(dataUploadPage.verifyTableSelection("Please select the table you wish to upload data into"));
		test.log(LogStatus.INFO, "Clicking okay button");
		dataUploadPage.clickOkay();
		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 4)
	public void GL_Settings_DM_02_4() throws InterruptedException {

		test=report.startTest("verifyUploadingData without a file and a table");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Clicking upload button");
		dataUploadPage.clickUpload();
		test.log(LogStatus.INFO, "Verifying error message");
		Assert.assertTrue(dataUploadPage.verifyEmptyFields("Please select a file you wish to upload"));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking okay button");
		dataUploadPage.clickOkay();
		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 5)
	public void GL_Settings_DM_03() {

		test=report.startTest("verifyCollapseExpand");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();
		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Clicking collapse and expand");
		dataUploadPage.clickCollapseExpand();
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 6)
	public void GL_Settings_DM_04() {

		test=report.startTest("verifyClose");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data upload");
		settingsPage.clickDataUploadBtn();
		
		dataUploadPage = new DataUploadPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data Upload page");
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		test.log(LogStatus.INFO, "Clicking close icon");
		dataUploadPage.clickClose();
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}
}