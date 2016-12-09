package com.glance.datamanagement.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;
import com.glance.pageobjects.datamanagement.DataUploadPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class VerifyDataDeleteUpdatePage extends BaseTest {

	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	DataDeleteUpdatePage dataDUPage;
	CommonPageObject commonPage;

	@BeforeMethod
	public void login() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();

	}

	@BeforeMethod
	public void waitingForPageLoad() {

		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(5);
	}

	@Test(priority = 0)
	public void GL_Settings_DM_45() throws Exception {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// check for the record in the table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));

	}

	@Test(priority = 0)
	public void GL_Settings_DM_46() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

	}

	@Test(priority = 1)
	public void GL_Settings_DM_47() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();
		dataDUPage.tableSort(colomName);
		dataDUPage.verifyTableSort(colomName);
	}

	@Test(priority = 2)
	public void GL_Settings_DM_48() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

		// delete record
		dataDUPage.clickDelete(userin);
		Assert.assertTrue(dataDUPage.verifydeleteConfirmationMessage("Confirm Delete ?"));
		dataDUPage.clickDeleteOkay();
		Assert.assertTrue(dataDUPage.verifyDeleted(userin));

	}

	@Test(priority = 3)
	public void GL_Settings_DM_49() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

		// delete record
		dataDUPage.clickDelete(userin1);
		Assert.assertTrue(dataDUPage.verifydeleteConfirmationMessage("Confirm Delete ?"));
		dataDUPage.clickDeleteClose();
		Assert.assertTrue(dataDUPage.verifyDeleted(userin1));

	}

	@Test(priority = 4)
	public void GL_Settings_DM_51() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

		dataDUPage.tableSearch("817");

	}

	@Test(priority = 5)
	public void GL_Settings_DM_52() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

		dataDUPage.firstPageNavigation();
		dataDUPage.actualPage();
		dataDUPage.nextPageNavigation();
		dataDUPage.actualPage();
		dataDUPage.previousPageNavigation();
		dataDUPage.actualPage();
		dataDUPage.lastPageNavigation();
		dataDUPage.actualPage();
		// dataDUPage.middlePageNavigation();
		// dataDUPage.actualPage();
		dataDUPage.pageCount();
	}

	@Test(priority = 6)
	public void GL_Settings_DM_55() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();

		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();

		dataDUPage.selectDropDuwn("100");
		dataDUPage.expectedRowCount(100);
		dataDUPage.actualRowCount();
		dataDUPage.actualPage();
		dataDUPage.verifyDroDownPageCount(100);
		dataDUPage.pageCount();
	}

	@Test(priority = 7)
	public void GL_Settings_DM_54() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// click delete upload button
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();
		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.clickCollapseExpand();

	}

	@Test(priority = 8)
	public void GL_Settings_DM_53() {

		// click on settings icon in left pane
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();

		// click delete upload button
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();
		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.clickClose();

	}

}