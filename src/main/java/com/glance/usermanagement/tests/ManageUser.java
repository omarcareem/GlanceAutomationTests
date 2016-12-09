package com.glance.usermanagement.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.GlanceDataProvider;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.UserManagementPage;

public class ManageUser extends BaseTest {

	LoginPage loginPage;
	CommonPageObject common;
	CommonPageLeftPane leftPane;
	UserManagementPage manageUser;
	SettingsPage icons;
	GlanceDataProvider rowCout;

	@BeforeMethod
	public void systemLogin() {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		icons = new SettingsPage(driver);
		icons.ClickManageUsersBtn();
		common = new CommonPageObject(driver);
		manageUser = new UserManagementPage(driver);

	}

	@Test(dataProvider = "GL_UM_02", dataProviderClass = GlanceDataProvider.class, priority = 1)
	public void GL_UM_02(String colomName) {
		common.tableSort(colomName);
		System.out.println(colomName);
		Assert.assertTrue(common.verifyTableSort(colomName));
	}

	@Test(dataProvider = "GL_UM_08", dataProviderClass = GlanceDataProvider.class, priority = 2)
	public void GL_UM_08(String keyWord, String expectedsearch) {

		common.tableSearch(keyWord);
		System.out.println(keyWord);
		Assert.assertEquals(manageUser.actualSearchResult(keyWord),
				expectedsearch);
	}

	@Test(dataProvider = "GL_UM_09_1", dataProviderClass = GlanceDataProvider.class, priority = 3)
	public void GL_UM_09_1(String pagination) {

		int rowCount = common.actualRowCount();
		int pageCount = common.actualPageCount();

		String dropDownValue = Integer.toString(10);
		common.selectDropDuwn(dropDownValue);

		common.pageNavigationString(pagination);
		Assert.assertTrue(common.verifyPageNavigationString(pagination,
				rowCount, pageCount));

	}

	@Test(dataProvider = "GL_UM_09_2", dataProviderClass = GlanceDataProvider.class, priority = 4)
	public void GL_UM_09(int middlePagination) {

		int rowCount = common.actualRowCount();
		int pageCount = common.actualPageCount();

		String dropDownValue = Integer.toString(10);
		common.selectDropDuwn(dropDownValue);

		common.pageNavigationMiddle(middlePagination);
		Assert.assertTrue(common.verifyPageNavigationMiddle(middlePagination,
				rowCount, pageCount));

	}

	@Test(priority = 5)
	public void GL_UM_10() {
		manageUser.buttondelete();
		Assert.assertTrue(manageUser.verifyButtonDelete());
	}

	@Test(priority = 6)
	public void GL_UM_11() {

		manageUser.buttonMin();
		Assert.assertEquals(manageUser.verifyButtonMin(), "fa fa-chevron-down",
				"Minimize  success");

		manageUser.buttonMax();
		Assert.assertEquals(manageUser.verifyButtonMax(), "fa fa-chevron-up",
				"Maximize  success");

	}

	@Test(dataProvider = "GL_UM_12", dataProviderClass = GlanceDataProvider.class, priority = 7)
	public void GL_UM_12(String dropDownValue) {
		int actualRawCount = 0;
		actualRawCount = common.actualRowCount();
		common.selectDropDuwn(dropDownValue);
		System.out.println(dropDownValue);
		Assert.assertEquals(common.actualRowCountDropDown(dropDownValue),
				common.expectedRowCountDropDown(actualRawCount));
	}

	@AfterMethod
	public void systemLogOut() {
		leftPane.clickLogout();
	}

}
