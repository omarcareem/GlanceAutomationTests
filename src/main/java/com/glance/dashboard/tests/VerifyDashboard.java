package com.glance.dashboard.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
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
import com.relevantcodes.extentreports.LogStatus;



public class VerifyDashboard extends BaseTest{
	
	LoginPage loginPage;
	CommonPageObject commonPage;
	DashboardPage dashBoardPage;
	CommonPageLeftPane commonPageLeftPane;
	CommonPageTopPane commonPageTopPane;
	AddElementWizardPage addElementWizardPage;
	
	@BeforeMethod
	public void testLogin(){
		
		test=report.startTest("verifyLogin");
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering User name");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on login button");
		loginPage.clickLoginBtn();
	}
	
	@Test (priority=0)
	public void GL_Main_27() throws Exception{
		
		test=report.startTest("verifyNavigationOfLeftPaneEntities");
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Account");
		commonPageLeftPane.clickOnAccount();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Account Name");
		commonPageLeftPane.clickOnAccountName(accountName1);
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Clicking on Engagement");
		commonPageLeftPane.clickEngagement();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnEngagementName(engagementName1);
		test.log(LogStatus.INFO, "Verifying Engagement Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Engagement Level Dashboard"));
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Clicking on Project");
		commonPageLeftPane.clickProject();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Project Name");
		commonPageLeftPane.clickOnProjectName(projectName1);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!");
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Clicking on Individual");
		commonPageLeftPane.clickIndividual();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Individual name");
		commonPageLeftPane.clickOnProjectName(individualName1);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
	
	@Test (priority=1)
	public void GL_Main_28() throws Exception{
		
		test=report.startTest("verifyFunctionalityOfDateRange");
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Selecting Date Range");
		dashBoardPage.selectDateRange(dateRange);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//verify the selected date range is matched with what was clicked
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "selecting Custom Date");
		dashBoardPage.selectCustomDate();
		test.log(LogStatus.INFO, "selecting Start Year");
		dashBoardPage.selectStartYear();
		test.log(LogStatus.INFO, "selecting Start Month");
		dashBoardPage.selectStartMonth();
		test.log(LogStatus.INFO, "selecting Start Date");
		dashBoardPage.selectStartDate();
		test.log(LogStatus.INFO, "selecting End Year");
		dashBoardPage.selectEndYear();
		test.log(LogStatus.INFO, "selecting End Month");
		dashBoardPage.selectEndMonth();
		test.log(LogStatus.INFO, "selecting End Date");
		dashBoardPage.selectEndDate();
		test.log(LogStatus.INFO, "selecting Submit butoon");
		dashBoardPage.selectSubmit();
		//verify the selected date range is matched with what was clicked
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "select Custom Date");
		dashBoardPage.selectCustomDate();
		test.log(LogStatus.INFO, "selecting Start Year");
		dashBoardPage.selectStartYear();
		test.log(LogStatus.INFO, "selecting Start Month");
		dashBoardPage.selectStartMonth();
		test.log(LogStatus.INFO, "selecting Start Date");
		dashBoardPage.selectStartDate();
		test.log(LogStatus.INFO, "selecting End Year");
		dashBoardPage.selectEndYear();
		test.log(LogStatus.INFO, "selecting End Month");
		dashBoardPage.selectEndMonth();
		test.log(LogStatus.INFO, "selecting End Date");
		dashBoardPage.selectEndDate();
		test.log(LogStatus.INFO, "selecting Clear butoon");
		dashBoardPage.selectClear();
		//verify clear the selected date range (default date range has selected)
		test.log(LogStatus.INFO, "Clicking on Date Range");
		dashBoardPage.clickDateRange();
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}
	
	@Test (priority=2)
	public void GL_Main_29() throws Exception{
		
		test=report.startTest("verifyFunctionalityOfDashboardIcons");
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Clicking on MaxMin icon");
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Selecting Delete icon");
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Confirm element deletion popup");
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		test.log(LogStatus.INFO, "Selecting Close");
		dashBoardPage.selectCloseInPopup();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Selecting Close icon");
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Selecting Delete icon");
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Confirm element deletion popup");
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		test.log(LogStatus.INFO, "Selecting Delete");
		dashBoardPage.selectDeleteInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Verifying Done popup");
		Assert.assertTrue(dashBoardPage.verifyDeleteDone("Done!"));
		test.log(LogStatus.INFO, "Selecting Okay");
		dashBoardPage.selectOkayInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}

	@Test (priority=3)
	public void GL_Main_30() throws Exception{
		
		test=report.startTest("verifyNavigationOfAddNewElementButton");
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Selecting Add New Element");
		dashBoardPage.selectAddNewElement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addElementWizardPage = new AddElementWizardPage(driver);
		test.log(LogStatus.INFO, "Verifying Elements Wizard Account level page");
		Assert.assertTrue(addElementWizardPage.getElementWizardPageTitle("Elements Wizard Account level"));
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
	
	@Test (priority=4)
	public void GL_Main_31() throws Exception{
		
		test=report.startTest("verifyFunctionalityOfAccessDeniedMessageWhenLoginFromDifferentUser");
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
		//create a user
		LoginPage loginPage=new LoginPage(driver);
		test.log(LogStatus.INFO, "Verifying navigation of Create Account page");
		loginPage.navigateCreateAccountPage();
		
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering UserName");
		createAccount.createUsername(userName1);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering Email");
		createAccount.addemailAdd(email);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Entering Password");
		createAccount.createpassword(password1);
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Re Entering password");
		createAccount.confirmPassword(password1);
		
		test.log(LogStatus.INFO, "Clicking on Submit button");
		createAccount.clickSubmitBtn();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking on Done");
		createAccount.clickpopupDone();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Clicking on Login link");
		createAccount.clickLoginLink();
		
		
		test.log(LogStatus.INFO, "Entering UserName");
		loginPage.enterUsername(userName1);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password1);
		test.log(LogStatus.INFO, "Clicking on Login button");
		loginPage.clickLoginBtn();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		test.log(LogStatus.INFO, "Clicking on Account");
		commonPageLeftPane.clickOnAccount();
		test.log(LogStatus.INFO, "Clicking on Add New Account link");
		commonPageLeftPane.clickOnAddNewAccountLink();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		test.log(LogStatus.INFO, "Clicking on Engagement");
		commonPageLeftPane.clickOnEngagement();
		test.log(LogStatus.INFO, "Clicking on Add New Engagement link");
		commonPageLeftPane.clickOnAddNewEngagementLink();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		test.log(LogStatus.INFO, "Clicking on Project");
		commonPageLeftPane.clickOnProject();
		test.log(LogStatus.INFO, "Clicking on Add New project link");
		commonPageLeftPane.clickOnAddNewProjectLink();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		test.log(LogStatus.INFO, "Clicking on Individual");
		commonPageLeftPane.clickOnIndividual();
		test.log(LogStatus.INFO, "Clicking on Add New Individual link");
		commonPageLeftPane.clickOnAddNewIndividualLink();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "Verifying Access Denied page");
		Assert.assertTrue(dashBoardPage.verifyNavigationToAccessDeniedPage("Access Denied!"));
		
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
		loginPage = new LoginPage(driver);
		test.log(LogStatus.INFO, "Entering UserName");
		loginPage.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering Password");
		loginPage.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking on Login button");
		loginPage.clickLoginBtn();
		
		test.log(LogStatus.INFO, "Clicking on Settings");
		commonPageLeftPane.clickSettings();
		SettingsPage settingsPage = new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on Manage User button");
		settingsPage.ClickManageUsersBtn();
		
		DeleteUser deleteUser = new DeleteUser(driver);
		test.log(LogStatus.INFO, "Entering UserName");
		deleteUser.selectUserToDelete(userName1);
		test.log(LogStatus.INFO, "Clicking on Delete");
		deleteUser.deleteUsers();
		
		test.log(LogStatus.INFO, "Entering UserName");
		deleteUser.verifyDelete(userName1);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
	}
	
	@Test (priority=5)
	public void GL_Main_32() throws Exception{
		
		test=report.startTest("verifyNoDashboardElemntDefinedPage");
		dashBoardPage = new DashboardPage(driver);
		test.log(LogStatus.INFO, "Verifying Account Level Dashboard page");
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		
		commonPageLeftPane= new CommonPageLeftPane(driver);
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Clicking on Account");
		commonPageLeftPane.clickOnAccount();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking on Account Name");
		commonPageLeftPane.clickOnAccountName(accountName4);
		test.log(LogStatus.INFO, "Verifying No dashboard elements defined page");
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
		
		test.log(LogStatus.INFO, "Clicking on Engagement");
		commonPageLeftPane.clickEngagement();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonPageLeftPane.clickOnEngagementName(engagementName1);
		test.log(LogStatus.INFO, "Verifying No dashboard elements defined page");
		Assert.assertTrue(dashBoardPage.verifyElementMessage());
		test.log(LogStatus.INFO, "Clicking on Glance icon");
		commonPageLeftPane.clickGlanceIcon();
	
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicking on Individual");
		commonPageLeftPane.clickIndividual();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicking on Individual name");
		commonPageLeftPane.clickOnProjectName(individualName1);
		test.log(LogStatus.INFO, "Verifying No dashboard elements defined page");
		//Assert.assertTrue(dashBoardPage.verifyElementMessage());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		commonPageLeftPane = new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on logout button");
		commonPageLeftPane.clickLogout();
		
	}
}
