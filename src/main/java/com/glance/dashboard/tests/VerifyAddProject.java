package com.glance.dashboard.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.common.tests.RandomNameGenerator;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddProjectPage;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class VerifyAddProject extends BaseTest {

	CommonPageObject commonPage;
	String projectName;
	LoginPage login;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	AddProjectPage addProject;
	DashboardPage dashboard;
	
	@BeforeMethod
	public void login() {
	// Login to Glance By entering user name and password
	login=new LoginPage(driver);
	login.enterUsername(userName);
	login.enterPassword(password);
	login.clickLoginBtn();
	
	}
	@Test (priority=0)
	public void GL_Settings_AP_15_verifyAddProjectNavigation() throws Exception{
		
		
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
				
		
		//click on add new project from left panal in array
		leftPanel.clickOnAddNewProjectLink();
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		System.out.println("Navigation done through left panal");
		
		
	}
	
	@Test (priority=1)
	public void GL_Settings_AP_16_verifyAddProject() throws Exception{
	
				// click on settings button in left panal
				leftPanel=new CommonPageLeftPane(driver);
				leftPanel.clickSettings();
				
				
				commonPage = new CommonPageObject(driver);
				commonPage.waitForPageLoad(10);
				
				// Get the count of Number of Projects before adding a project and click on add project button
				settingPage=new SettingsPage(driver);
				int previousCountProject=settingPage.getCountAddProject();
				System.out.println("Previous Count:"+previousCountProject);
				commonPage.waitForPageLoad(10);
				settingPage.clickAddProjectBtn();
				commonPage.waitForPageLoad(10);
				
				//Add Project Page
				
				addProject=new AddProjectPage(driver);
				
				// check whether navigated to Add Project page
				Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
				
				
		        projectName=RandomNameGenerator.getName();
		        System.out.println(projectName);
				addProject.enterProjectName(projectName);
				addProject.enterClientProjectId(clientProjectId);
				commonPage.waitForPageLoad(30);
				addProject.selectEngagementName(engagementName);
				addProject.selectApplicationName(applicationName);
				addProject.selectFundingStartDate(fundStartDate);
				addProject.selectFundingEndDate(fundEndDate);
				addProject.selectFundingReleaseDate(fundReleaseDate);
				addProject.selectStatus(status);
				
				//Click on submit button
				addProject.clickSubmitBtn();
				System.out.println("Project has been added successfully by happy path");
				commonPage.waitForPageLoad(30);
				//click on dashboard button
				addProject.clickGoToDashBoardBtn();
				commonPage.waitForPageLoad(30);
				
				dashboard =new DashboardPage(driver);
				// check whether navigated to dashboard page
				Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
				
				//click on settings page
				leftPanel.clickSettings();
				Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
		));
				
				//get current count of number of accounts 
				int newestCountProject=settingPage.getCountAddProject();
		        System.out.println(newestCountProject);
		        
		        //compare the counts 
		        if(newestCountProject > previousCountProject)
		               System.out.println("New Project has been added");
		        
		        else 
		               System.out.println("Project has not been added");     
		        commonPage.waitForPageLoad(10);
				
	
		
	}
	
	
	@Test (priority=2)
	public void GL_Settings_AP_17_verifyAddProjectSubmission() throws Exception{
	
				// click on settings button in left panal
				leftPanel=new CommonPageLeftPane(driver);
				leftPanel.clickSettings();
				
				
				commonPage = new CommonPageObject(driver);
				commonPage.waitForPageLoad(10);
				
				//click on add project button
				settingPage=new SettingsPage(driver);
				settingPage.clickAddProjectBtn();
				commonPage.waitForPageLoad(10);
				
				//Add Project Page
				
				addProject=new AddProjectPage(driver);
				
				// check whether navigated to Add Project page
				Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
				
				
		        projectName=RandomNameGenerator.getName();
		        System.out.println(projectName);
				addProject.enterProjectName(projectName);
				addProject.enterClientProjectId(clientProjectId);
				addProject.selectEngagementName(engagementName);
				addProject.selectApplicationName(applicationName);
				addProject.selectFundingStartDate(fundStartDate);
				addProject.selectFundingEndDate(fundEndDate);
				addProject.selectFundingReleaseDate(fundReleaseDate);
				addProject.selectStatus(status);
				
				//Click on submit button
				addProject.clickSubmitBtn();
				System.out.println("New Project has been added when clicking submit button");
				commonPage.waitForPageLoad(30);
				//click on dashboard button
				addProject.clickGoToDashBoardBtn();
				commonPage.waitForPageLoad(30);
				
				dashboard =new DashboardPage(driver);
				// check whether navigated to dashboard page
				Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
	
		
	}
	
	@Test (priority=3)
	public void GL_Settings_AP_18_verifyAddedProjectValidation() throws Exception{
	
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		// Get the count of Number of Projects before adding a project and click on add project button
		settingPage=new SettingsPage(driver);
		int previousCountProject=settingPage.getCountAddProject();
		System.out.println("Previous Count:"+previousCountProject);
		commonPage.waitForPageLoad(10);
		settingPage.clickAddProjectBtn();
		commonPage.waitForPageLoad(10);
		
		//Add Project Page
		
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		
		
        projectName=RandomNameGenerator.getName();
        System.out.println(projectName);
		addProject.enterProjectName(projectName);
		addProject.enterClientProjectId(clientProjectId);
		addProject.selectEngagementName(engagementName);
		addProject.selectApplicationName(applicationName);
		addProject.selectFundingStartDate(fundStartDate);
		addProject.selectFundingEndDate(fundEndDate);
		addProject.selectFundingReleaseDate(fundReleaseDate);
		addProject.selectStatus(status);
		
		//Click on submit button
		addProject.clickSubmitBtn();
		commonPage.waitForPageLoad(30);
		
		//click on dashboard button
		addProject.clickGoToDashBoardBtn();
		commonPage.waitForPageLoad(30);
		
		dashboard =new DashboardPage(driver);
		// check whether navigated to dashboard page
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
		
		//click on settings page
		leftPanel.clickSettings();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		
		//get current count of number of accounts 
		int newestCountProject=settingPage.getCountAddProject();
        System.out.println(newestCountProject);
        
        //compare the counts 
        if(newestCountProject > previousCountProject)
               System.out.println("New Project has been added");
        
        else 
               System.out.println("Project has not been added");     
        commonPage.waitForPageLoad(10);
        
	}
	
	
	@Test (priority=4)
	public void GL_Settings_AP_19_verifyCancelAddProject() throws Exception{
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		
		commonPage = new CommonPageObject(driver);
					
		// Get the count of Number of Projects before adding a project and click on add project button
		settingPage=new SettingsPage(driver);
		int previousCountProject=settingPage.getCountAddProject();
		System.out.println("Previous Count:"+previousCountProject);
		commonPage.waitForPageLoad(10);
		settingPage.clickAddProjectBtn();
		commonPage.waitForPageLoad(10);
		
		
		//Add Project Page
		
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));

		
        projectName=RandomNameGenerator.getName();
        System.out.println(projectName);
		addProject.enterProjectName(projectName);
		addProject.enterClientProjectId(clientProjectId);
		addProject.selectEngagementName(engagementName);
		addProject.selectApplicationName(applicationName);
		addProject.selectFundingStartDate(fundStartDate);
		addProject.selectFundingEndDate(fundEndDate);
		addProject.selectFundingReleaseDate(fundReleaseDate);
		addProject.selectStatus(status);
		
		
		//Click on Cancel button
		addProject.clickCancelBtn();
		commonPage.waitForPageLoad(10);
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		//get current count of number of accounts 
        int newestCountProject=settingPage.getCountAddProject();
        System.out.println(newestCountProject);

        //compare the counts 
        if(newestCountProject > previousCountProject)
               System.out.println("New Project has been added");
        
        else 
               System.out.println("Project has not been added");     
        commonPage.waitForPageLoad(10);
		
		
		
	}
	
	
/*	@Test (priority=5)
	public void GL_Settings_AP_20_verifyCloseCurrentPane() throws Exception{
	
		
		settingPage=new SettingsPage(driver);
		settingPage.clickAddProjectBtn();
		
		addProject=new AddProjectPage(driver);
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
        addProject.btnClickCloseBtn();
        leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();

		
	}*/
	
/*	@Test (priority=6)
	public void GL_Settings_AP_21_verifyCollapseCurrentPane() throws Exception{
		
		leftPanel=new CommonPageLeftPane(driver);
		leftPanel.clickSettings();
		
		settingPage=new SettingsPage(driver);
		settingPage.clickAddProjectBtn();
		
		addProject=new AddProjectPage(driver);
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
        addProject.btnClickCollapseBtn();
        
      

	}
	*/
	
	@AfterMethod
	public void logout() {
	
		 //Logout
        leftPanel.clickLogout();
	
	}

}

	
