package com.glance.datamanagement.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddAccountPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;
import com.glance.pageobjects.datamanagement.DataUploadPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

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

		// login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

	}

	@Test(priority = 0)
	public void GL_Settings_DU_41() throws Exception {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));

	}

	@Test(priority = 1)
	public void GL_Settings_DU_42_1() throws IOException, InterruptedException {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();
		Assert.assertTrue(dataDUPage.verifyReordExist("8"));

		// click data upload
		leftPane.clickSettings();
		settingsPage.clickDataUploadBtn();
		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.selectDataTable(tableName);
		dataUploadPage.selectFileUploadArea();
		Runtime.getRuntime().exec("C:\\Poornima\\Glance\\Glance Automation\\GlanceAutomationTests\\FileUpload.exe");
		Thread.sleep(4000);
		dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifyRecordsAdded("1 records added to the table cdi"));
		dataUploadPage.clickDone();

		// check for the uploaded record
		Thread.sleep(3000);
		leftPane.clickSettings();
		settingsPage.clickDataDeleteModifyBtn();
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();
		Assert.assertTrue(dataDUPage.verifyReordExist("8"));

	}

	@Test(priority = 2)
	public void GL_Settings_DU_42_2() {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.selectDataTable(tableName);

		dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifyEmptyFileErrorMessage("Please select a file you wish to upload"));
		dataUploadPage.clickOkay();

	}

	@Test(priority = 3)
	public void GL_Settings_DU_42_3() throws IOException, InterruptedException {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.selectFileUploadArea();
		Runtime.getRuntime().exec("C:\\Poornima\\Glance\\Glance Automation\\GlanceAutomationTests\\FileUpload.exe");
		Thread.sleep(4000);
		dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifyTableSelection("Please select the table you wish to upload data into"));
		dataUploadPage.clickOkay();

	}

	@Test(priority = 4)
	public void GL_Settings_DU_42_4() throws InterruptedException {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();

		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifyEmptyFields("Please select a file you wish to upload"));
		Thread.sleep(5000);
		dataUploadPage.clickOkay();

	}

	@Test(priority = 5)
	public void GL_Settings_DU_44() {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();
		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.clickCollapseExpand();

	}

	@Test(priority = 6)
	public void GL_Settings_DU_43() {

		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();
		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.clickClose();

	}
}