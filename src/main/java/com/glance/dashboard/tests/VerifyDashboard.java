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
import com.glance.pageobjects.userlogin.LoginPage;



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
	public void verifyDashboardElementDateRangeSubmit() throws Exception{
		
		
		dashBoardPage = new DashboardPage(driver);
		Assert.assertTrue(dashBoardPage.getPageName("Account Level Dashboard"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashBoardPage.clickDateRange();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		dashBoardPage.selectDateRange(dateRange);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=1)
	public void verifyDashboardElementCustomeDateRangeSubmit() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
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
		
	}
	
	@Test (priority=2)
	public void verifyDashboardElementCustomeDateRangeClear() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
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
	
	}
	
	@Test (priority=3)
	public void verifyDashboardElementMaxMInIcons() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectMaxMin();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=4)
	public void verifyDashboardElementCloseIcons() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectClose();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=5)
	public void verifyDashboardElementCloseInDeletePopup() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		dashBoardPage.selectCloseInPopup();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=6)
	public void verifyDashboardElementDeleteIcons() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectDelete();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDelete("Confirm element deletion!"));
		dashBoardPage.selectDeleteInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue(dashBoardPage.verifyDeleteDone("Done!"));
		dashBoardPage.selectOkayInPopup();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=7)
	public void verifyDashboardElementAddNewElement() throws Exception{
		
		dashBoardPage = new DashboardPage(driver);
		dashBoardPage.selectAddNewElement();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		addElementWizardPage = new AddElementWizardPage(driver);
		Assert.assertTrue(addElementWizardPage.getElementWizardPageTitle("Elements Wizard Account level"));
		
	}
	
	
}
