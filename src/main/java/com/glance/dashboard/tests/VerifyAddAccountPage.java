package com.glance.dashboard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddAccountPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class VerifyAddAccountPage extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	AddAccountPage addAccount;
	String accountName;
	DashboardPage dashboard;
	CommonPageObject commonPage;
	BaseTest baseTest;
	
	@BeforeMethod
	public void login(){
		
		//login 
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	
	}
	
	@BeforeMethod
	public void waitingForPageLoad(){
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(5);
	}
	
	@Test (priority=0)
	public void verifyAddAccountSubmission() throws Exception {
		
		//click on settings icon in left pane
		leftPane=new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		
		//get previous count of number of accounts 
		settingsPage=new SettingsPage(driver);
		int previousCount=settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();
		
		//create an account
		addAccount=new AddAccountPage(driver);

		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		
		accountName=RandomNameGenerator.getName();
		//System.out.println(accountName);
		addAccount.enterAccountName(accountName);
		//System.out.println(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.goToDashboard();
		dashboard=new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
		
		//get current count of number of accounts
		leftPane.clickSettings();
		int newestCount=settingsPage.getCountAddAccount();
		System.out.println(newestCount);
		
		//compare the counts 
		if(newestCount > previousCount)
			System.out.println("New account is added");
		
		else 
			System.out.println("Account is not added");	
		
		//logout
		leftPane.clickLogout();
		
	}
	
	
	@Test (priority=1)
	public void verifyAddAccountWithLeftPane() throws Exception {
				
		//click on add new on left pane
		leftPane.clickOnAddNewAccountLink();
		
		//create an account
		addAccount=new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName=RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickSubmit();
		addAccount.addNewEntry();
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		
		//check account is added
		Assert.assertTrue(leftPane.verifyAdded(accountName));
		
		//logout
		leftPane.clickLogout();
		
	}

	
	@Test (priority=2)
	public void verifyAddAccountCancel() throws Exception {
		
		//click on settings icon in left pane
		leftPane=new CommonPageLeftPane(driver);
		leftPane.clickSettings();
				
		//get previous count of number of accounts 
		settingsPage=new SettingsPage(driver);
		int previousCount=settingsPage.getCountAddAccount();
		System.out.println(previousCount);
		settingsPage.clickAddAccountBtn();
		
		//create an account
		addAccount=new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		accountName=RandomNameGenerator.getName();
		addAccount.enterAccountName(accountName);
		addAccount.selectSegment(segment);
		addAccount.clickCancel();
		
		//checking navigation back to settings page
		Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));
		
		//get current count of number of accounts
		int newestCount=settingsPage.getCountAddAccount();
		System.out.println(newestCount);
		
		//compare the counts 
		if(newestCount > previousCount)
			System.out.println("New account is added");
		
		else 
			System.out.println("Account is not added");	
		
		//logout
		leftPane.clickLogout();
			
	}
	
	
	@Test (priority=3)
	public void verifyCollapse(){
				
		//click on add new on left pane
		leftPane.clickOnAddNewAccountLink();
		
		//create an account
		addAccount=new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickCollapse();
		
	}
	
	
	/*@Test (priority=4)
	public void verifyClose(){
				
		//click on add new on left pane
		leftPane.clickOnAddNewAccountLink();
		
		//create an account
		addAccount=new AddAccountPage(driver);
		Assert.assertTrue(addAccount.verifyNavigationToAddAccountPage("Account"));
		addAccount.clickClose();
		
	}*/
}
