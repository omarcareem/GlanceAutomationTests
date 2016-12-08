package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddElementWizardPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.DeleteUser;



public class VerifyDashboard extends BaseTest{
	
	LoginPage loginPage;
	CommonPageObject commonPage;
	DashboardPage dashBoardPage;
	CommonPageLeftPane commonPageLeftPane;
	CommonPageTopPane commonPageTopPane;
	AddElementWizardPage addElementWizardPage;
	
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
	public void GL_Settings_DB_35() throws Exception{
		
		
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		commonPageLeftPane.clickOnAccount();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnAccountName(accountName1);
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		commonPageLeftPane.clickEngagement();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnEngagementName(engagementName1);
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Engagement Level Dashboard"));
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		commonPageLeftPane.clickProject();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnProjectName(projectName1);
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Project Level Dashboard"));
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		commonPageLeftPane.clickIndividual();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@Test (priority=1)
	public void GL_Settings_DB_36() throws Exception{
		
		
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		dashBoardPage.selectDateRange(dateRange);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//verify the selected date range is matched with what was clicked
		dashBoardPage.clickDateRange();
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		commonPageLeftPane.clickGlanceIcon();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.selectCustomDate();
		dashBoardPage.selectStartYear();
		dashBoardPage.selectStartMonth();
		dashBoardPage.selectStartDate();
		dashBoardPage.selectEndYear();
		dashBoardPage.selectEndMonth();
		dashBoardPage.selectEndDate();
		dashBoardPage.selectSubmit();
		//verify the selected date range is matched with what was clicked
		dashBoardPage.clickDateRange();
		
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.selectCustomDate();
		dashBoardPage.selectStartYear();
		dashBoardPage.selectStartMonth();
		dashBoardPage.selectStartDate();
		dashBoardPage.selectEndYear();
		dashBoardPage.selectEndMonth();
		dashBoardPage.selectEndDate();
		dashBoardPage.selectClear();
		//verify clear the selected date range (default date range has selected)
		dashBoardPage.clickDateRange();
	}
	
	@Test (priority=2)
	public void GL_Settings_DB_37() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		commonPageLeftPane.clickGlanceIcon();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		dashBoardPage.selectCloseInPopup();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		dashBoardPage.selectDeleteInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDeleteDone("Done!"));
		dashBoardPage.selectOkayInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}


	@Test (priority=3)
	public void GL_Settings_DB_38() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectAddNewElement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addElementWizardPage = new AddElementWizardPage(driver);
		Assert.assertTrue(addElementWizardPage.getElementWizardPageTitle("Elements Wizard Account level"));
		
	}
	
	@Test (priority=4)
	public void GL_Settings_DB_39() throws Exception{
		
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		commonPageLeftPane.clickLogout();
		
		//create a user
		LoginPage loginPage=new LoginPage(driver);
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		createAccount.createUsername(userName1);
		Thread.sleep(5000);
		createAccount.addemailAdd(email);
		Thread.sleep(5000);
		createAccount.createpassword(password1);
		Thread.sleep(5000);
		createAccount.confirmPassword(password1);
		
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		createAccount.clickpopupDone();
		Thread.sleep(10000);
		createAccount.clickLoginLink();
		
		
		//loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName1);
		loginPage.enterPassword(password1);
		loginPage.clickLoginBtn();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		commonPageLeftPane.clickLogout();
		
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		commonPageLeftPane.clickSettings();
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickManageUsersBtn();
		
		DeleteUser deleteUser = new DeleteUser(driver);
		deleteUser.selectUserToDelete(userName1);
		deleteUser.deleteUsers();
		deleteUser.verifyDelete(userName1);
		
	}
	
	@Test (priority=5)
	public void GL_Settings_DB_40() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		commonPageLeftPane.clickOnAccount();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnAccountName(accountName4);
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		
	}
}
