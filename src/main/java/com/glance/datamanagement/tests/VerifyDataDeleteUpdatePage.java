package com.glance.datamanagement.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.GlanceDataProvider;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;

import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyDataDeleteUpdatePage extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	DataDeleteUpdatePage dataDUPage;
	CommonPageObject commonPage;

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
	public void GL_Settings_DM_05() throws Exception {

		test=report.startTest("verifyNavigationToDeleteModifyPage");
		test=report.startTest("verifyNavigationToDataUploadPage from settings page");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 1)
	public void GL_Settings_DM_06() {

		test=report.startTest("verifySelectingATable");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 2)
	public void GL_Settings_DM_07() {

		test=report.startTest("verifySorting");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();
		test.log(LogStatus.INFO, "Selecting a coloumn name");
		dataDUPage.tableSort(colomName);
		test.log(LogStatus.INFO, "Verifying the sorting");
		dataDUPage.verifyTableSort(colomName);
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(priority = 3)
	public void GL_Settings_DM_08() {

		test=report.startTest("verifyDelete");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();

		// delete record
		dataDUPage.clickDelete(userin);
		Assert.assertTrue(dataDUPage.verifydeleteConfirmationMessage("Confirm Delete ?"));
		dataDUPage.clickDeleteOkay();
		Assert.assertTrue(dataDUPage.verifyDeleted(userin));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 4)
	public void GL_Settings_DM_09() {

		test=report.startTest("verifyDeleteCancelation");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();

		// delete record
		dataDUPage.clickDelete(userin1);
		Assert.assertTrue(dataDUPage.verifydeleteConfirmationMessage("Confirm Delete ?"));
		dataDUPage.clickDeleteClose();
		Assert.assertTrue(dataDUPage.verifyDeleted(userin1));
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 5)
	public void GL_Settings_DM_10() {
		
		test=report.startTest("verifySearchOption");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();

		dataDUPage.tableSearch("817");
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();

	}

	@Test(priority = 6)
	public void GL_Settings_DM_11() {

		test=report.startTest("verifyPageNavigation");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();

		dataDUPage.firstPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dataDUPage.nextPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dataDUPage.previousPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dataDUPage.lastPageNavigation();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(dataProvider = "GL_UM_12", dataProviderClass = GlanceDataProvider.class)
	public void GL_Settings_DM_55(String showEntry) throws Exception {

		test=report.startTest("verifyVisibleEntries");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Selecting a table");
		dataDUPage.selectTable(tableName);
		test.log(LogStatus.INFO, "Clicking submit button");
		dataDUPage.clickSubmit();

		
		dataDUPage.selectDropDuwn(showEntry);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		dataDUPage.expectedRowCount(25);
		dataDUPage.actualRowCount();
		dataDUPage.verifyDroDownPageCount(25);
		
		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(priority = 8)
	public void GL_Settings_DM_13() {

		test=report.startTest("verifyCollapseExpand");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();
		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.clickCollapseExpand();

		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

	@Test(priority = 9)
	public void GL_Settings_DM_14() {

		test=report.startTest("verifyClose");
		leftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Navigating to settings page");
		leftPane.clickSettings();

		settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking data delete/modify");
		settingsPage.clickDataDeleteModifyBtn();
		dataDUPage = new DataDeleteUpdatePage(driver);
		test.log(LogStatus.INFO, "Verifying navigation to Data delete/modify page");
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		test.log(LogStatus.INFO, "Clicking close icon");
		dataDUPage.clickClose();

		test.log(LogStatus.INFO, "Clicking logout");
		leftPane.clickLogout();
	}

}