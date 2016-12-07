package com.glance.commonPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class CommonPageLeftPaneTest extends BaseTest {
	LoginPage login;
	CommonPageLeftPane leftPane;
	CommonPageTopPane topPane;
	
	
	@Test(priority=1)
	public void checkGlanceIcon() throws InterruptedException {
		login = new LoginPage(driver);
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		leftPane.clickGlanceIcon();
		Thread.sleep(1000);
	
	
	}	
	
	
	@Test( priority=2)
	public void leftPaneAccount() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		
		//click on AccountDropdown and select an account
		leftPane = new CommonPageLeftPane(driver);
		leftPane.getAccountNameList();
		leftPane.clickOnAccount();
		Thread.sleep(10000);
		leftPane.clickOnAccountName(accountName3);
	    Thread.sleep(5000);
	    
	    Assert.assertTrue(leftPane.verifyNoDashboardDefineAcc());
	    
      
	    //click on EngagementDropdown under a particular Account and select engagement	
	    leftPane.getEngagementNameList();
	    leftPane.clickOnEngagement();
	    Thread.sleep(10000);
		leftPane.clickOnEngagementName(engagementName);
	    Thread.sleep(5000);
	    
	
	    
	    //click on ProjectDropdown under a particular engagement and select project
		leftPane.getProjectNameList();
		leftPane.clickOnProject();
		Thread.sleep(10000);
		leftPane.clickOnProjectName(projectName);
		Thread.sleep(5000);
		
		
		//click on Individual drop down 
		leftPane.getIndividualNameList();
		leftPane.clickOnIndividual();
		Thread.sleep(10000);
		
		
		leftPane.clickLogout();

}
	
	
	
  @Test( priority=2)
	public void navigateToSettingsPage() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		Thread.sleep(700);
		topPane = new CommonPageTopPane(driver);
		topPane.clickDropDownIcon();
		Thread.sleep(700);
		topPane.clickLogout();
	     
}
	
	
	@Test(priority=3)
	public void checkLogout() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickLogout();
		Thread.sleep(700);
		
	     
	}	
	
	@Test(priority=4)
	public void screenLockPage() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		leftPane = new CommonPageLeftPane(driver);
		leftPane.clickScreenLock();
		Thread.sleep(700);
		topPane = new CommonPageTopPane(driver);
		topPane.clickDropDownIcon();
		Thread.sleep(700);
		topPane.clickLogout();
	     
	}	
	
	
	
	
}