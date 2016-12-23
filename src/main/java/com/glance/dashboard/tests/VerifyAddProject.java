package com.glance.dashboard.tests;

import org.testng.Assert;

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
import com.relevantcodes.extentreports.LogStatus;

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
	test=report.startTest("verifyLogin");
	login=new LoginPage(driver);
	test.log(LogStatus.INFO, "Entering User name");
	login.enterUsername(userName);
	test.log(LogStatus.INFO, "Entering Password");
	login.enterPassword(password);
	test.log(LogStatus.INFO, "Clicking on login button");
	login.clickLoginBtn();
	
	}
	@Test (priority=0)
	public void GL_Settings_DM_15_verifyAddProjectNavigation() throws Exception{
		
		test=report.startTest("verifyAddProjectNavigation");
		settingPage=new SettingsPage(driver);
		leftPanel=new CommonPageLeftPane(driver);
		
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
				
		
		//click on add new project from left panal in array
		test.log(LogStatus.INFO, "Clicking on on add new project from left panal in array");
		leftPanel.clickOnAddNewProjectLink();
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		System.out.println("Navigation done through left panal");
		
		 //Logout
		test.log(LogStatus.INFO, "Clicking on logout button in left panal");
        leftPanel.clickLogout();
	}
	
	@Test (priority=1)
	public void GL_Settings_DM_16_verifyAddProjectCreation() throws Exception{
		
				test=report.startTest("verifyAddNewProjectElement");
				// click on settings button in left panal
				leftPanel=new CommonPageLeftPane(driver);
				test.log(LogStatus.INFO, "Clicking on settings button in left panal");
				leftPanel.clickSettings();
				
				
				commonPage = new CommonPageObject(driver);
				commonPage.waitForPageLoad(10);
				
				// Get the count of Number of Projects before adding a project and click on add project button
				settingPage=new SettingsPage(driver);
				test.log(LogStatus.INFO, "Getting the count of Number of Projects before adding a project");
				int previousCountProject=settingPage.getCountAddProject();
				System.out.println("Previous Count:"+previousCountProject);
				commonPage.waitForPageLoad(10);
				test.log(LogStatus.INFO, "clicking on add project button");
				settingPage.clickAddProjectBtn();
				commonPage.waitForPageLoad(10);
				
				//Add Project Page
				
				addProject=new AddProjectPage(driver);
				
				// check whether navigated to Add Project page
				test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
				Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
				
				test.log(LogStatus.INFO, "Entering Project name");
		        projectName=RandomNameGenerator.getName();
		        System.out.println(projectName);
				addProject.enterProjectName(projectName);
				test.log(LogStatus.INFO, "Entering clientProjectId");
				addProject.enterClientProjectId(clientProjectId);
				test.log(LogStatus.INFO, "Entering engagementName");
				addProject.selectEngagementName(engagementName);
				test.log(LogStatus.INFO, "Entering applicationName");
				addProject.selectApplicationName(applicationName);
				test.log(LogStatus.INFO, "Entering fundStartDate");
				addProject.selectFundingStartDate(fundStartDate);
				test.log(LogStatus.INFO, "Entering fundEndDate");
				addProject.selectFundingEndDate(fundEndDate);
				test.log(LogStatus.INFO, "Entering fundReleaseDate");
				addProject.selectFundingReleaseDate(fundReleaseDate);
				test.log(LogStatus.INFO, "Entering status");
				addProject.selectStatus(status);
				
				//Click on submit button
				test.log(LogStatus.INFO, "clicking on submit button");
				addProject.clickSubmitBtn();
				System.out.println("Project has been added successfully by happy path");
				commonPage.waitForPageLoad(30);
				//click on dashboard button
				test.log(LogStatus.INFO, "clicking on dashboard button");
				addProject.clickGoToDashBoardBtn();
				commonPage.waitForPageLoad(30);
				
				dashboard =new DashboardPage(driver);
				// check whether navigated to dashboard page
				test.log(LogStatus.INFO, "checking whether navigated to dashboard page");
				Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
				
				//click on settings page
				test.log(LogStatus.INFO, "Clicking on settings button in left panal");
				leftPanel.clickSettings();
				test.log(LogStatus.INFO, "checking whether navigated to settings page");
				Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
		));
				
				//get current count of number of accounts 
				test.log(LogStatus.INFO, "Getting the count of Number of Projects after adding a project");
				int newestCountProject=settingPage.getCountAddProject();
		        System.out.println(newestCountProject);
		        
		        //compare the counts 
		        test.log(LogStatus.INFO, "comparing the counts");
		        if(newestCountProject > previousCountProject)
		               System.out.println("New Project has been added");
		        
		        else 
		               System.out.println("Project has not been added");     
		        commonPage.waitForPageLoad(10);
				
	
		        //Logout
		        test.log(LogStatus.INFO, "Clicking on logout button in left panal");
		        leftPanel.clickLogout();
		
	}
	
	
	@Test (priority=2)
	public void GL_Settings_DM_17_verifyAddedProjectValidation() throws Exception{
	
		test=report.startTest("verifyAddedProjectValidation");
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		
		
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		
		// Get the count of Number of Projects before adding a project and click on add project button
		settingPage=new SettingsPage(driver);
		test.log(LogStatus.INFO, "Getting the count of Number of Projects before adding a project");
		int previousCountProject=settingPage.getCountAddProject();
		System.out.println("Previous Count:"+previousCountProject);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "clicking on add project button");
		settingPage.clickAddProjectBtn();
		commonPage.waitForPageLoad(10);
		
		//Add Project Page
		
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		
		
		test.log(LogStatus.INFO, "Entering Project name");
        projectName=RandomNameGenerator.getName();
        System.out.println(projectName);
		addProject.enterProjectName(projectName);
		test.log(LogStatus.INFO, "Entering clientProjectId");
		addProject.enterClientProjectId(clientProjectId);
		test.log(LogStatus.INFO, "Entering engagementName");
		addProject.selectEngagementName(engagementName);
		test.log(LogStatus.INFO, "Entering applicationName");
		addProject.selectApplicationName(applicationName);
		test.log(LogStatus.INFO, "Entering fundStartDate");
		addProject.selectFundingStartDate(fundStartDate);
		test.log(LogStatus.INFO, "Entering fundEndDate");
		addProject.selectFundingEndDate(fundEndDate);
		test.log(LogStatus.INFO, "Entering fundReleaseDate");
		addProject.selectFundingReleaseDate(fundReleaseDate);
		test.log(LogStatus.INFO, "Entering status");
		addProject.selectStatus(status);
		
		//Click on submit button
		test.log(LogStatus.INFO, "clicking on submit button");
		addProject.clickSubmitBtn();
		commonPage.waitForPageLoad(30);
		
		//click on dashboard button
		test.log(LogStatus.INFO, "clicking on dashboard button");
		addProject.clickGoToDashBoardBtn();
		commonPage.waitForPageLoad(30);
		
		dashboard =new DashboardPage(driver);
		// check whether navigated to dashboard page
		test.log(LogStatus.INFO, "checking whether navigated to dashboard page");
		Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
		
		//click on settings page
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		
		//get current count of number of accounts 
		test.log(LogStatus.INFO, "Getting the count of Number of Projects after adding a project");
		int newestCountProject=settingPage.getCountAddProject();
        System.out.println(newestCountProject);
        
        //compare the counts 
        test.log(LogStatus.INFO, "comparing the counts");
        if(newestCountProject > previousCountProject)
               System.out.println("New Project has been added");
        
        else 
               System.out.println("Project has not been added");     
        commonPage.waitForPageLoad(10);
        
        //Logout
        test.log(LogStatus.INFO, "Clicking on logout button in left panal");
        leftPanel.clickLogout();
	}
	
	
	@Test (priority=3)
	public void GL_Settings_DM_18_verifyCancelAddProject() throws Exception{
		
		test=report.startTest("verifyCancelAddProject");
		// click on settings button in left panal
		leftPanel=new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		test.log(LogStatus.INFO, "checking whether navigated to settings page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		
		commonPage = new CommonPageObject(driver);
					
		// Get the count of Number of Projects before adding a project and click on add project button
		settingPage=new SettingsPage(driver);
		test.log(LogStatus.INFO, "Getting the count of Number of Projects before adding a project");
		int previousCountProject=settingPage.getCountAddProject();
		System.out.println("Previous Count:"+previousCountProject);
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "clicking on add project button");
		settingPage.clickAddProjectBtn();
		commonPage.waitForPageLoad(10);
		
		
		//Add Project Page
		
		addProject=new AddProjectPage(driver);
		
		// check whether navigated to Add Project page
		test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));

		
		test.log(LogStatus.INFO, "Entering Project name");
        projectName=RandomNameGenerator.getName();
        System.out.println(projectName);
		addProject.enterProjectName(projectName);
		test.log(LogStatus.INFO, "Entering clientProjectId");
		addProject.enterClientProjectId(clientProjectId);
		test.log(LogStatus.INFO, "Entering engagementName");
		addProject.selectEngagementName(engagementName);
		test.log(LogStatus.INFO, "Entering applicationName");
		addProject.selectApplicationName(applicationName);
		test.log(LogStatus.INFO, "Entering fundStartDate");
		addProject.selectFundingStartDate(fundStartDate);
		test.log(LogStatus.INFO, "Entering fundEndDate");
		addProject.selectFundingEndDate(fundEndDate);
		test.log(LogStatus.INFO, "Entering fundReleaseDate");
		addProject.selectFundingReleaseDate(fundReleaseDate);
		test.log(LogStatus.INFO, "Entering status");
		addProject.selectStatus(status);
		
		
		//Click on Cancel button
		test.log(LogStatus.INFO, "clicking on cancel button");
		addProject.clickCancelBtn();
		commonPage.waitForPageLoad(10);
		test.log(LogStatus.INFO, "checking whether navigated to dashboard page");
		Assert.assertTrue(settingPage.verifyNavigationToSettingPage("Dashboard Management"
));
		//get current count of number of accounts 
		test.log(LogStatus.INFO, "Getting the count of Number of Projects after adding a project");
        int newestCountProject=settingPage.getCountAddProject();
        System.out.println(newestCountProject);

        //compare the counts 
        test.log(LogStatus.INFO, "comparing the counts ");
        if(newestCountProject > previousCountProject)
               System.out.println("New Project has been added");
        
        else 
               System.out.println("Project has not been added");     
        commonPage.waitForPageLoad(10);
        
        //Logout
        test.log(LogStatus.INFO, "Clicking on logout button in left panal");
        leftPanel.clickLogout();
		
		
	}
	
	
/*	@Test (priority=4)
	public void GL_Settings_DM_19_verifyCloseCurrentPane() throws Exception{
	
		test=report.startTest("verifyCloseCurrentPane");
		settingPage=new SettingsPage(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		
		test.log(LogStatus.INFO, "clicking on add project button");
		settingPage.clickAddProjectBtn();
		
		addProject=new AddProjectPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		
		test.log(LogStatus.INFO, "clicking on close button");
        addProject.btnClickCloseBtn();
        leftPanel=new CommonPageLeftPane(driver);
        test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();

		
	}*/
	
/*	@Test (priority=5)
	public void GL_Settings_DM_20_verifyCollapseCurrentPane() throws Exception{
		test=report.startTest("verifyCollapseCurrentPane");
		leftPanel=new CommonPageLeftPane(driver);
		test.log(LogStatus.INFO, "Clicking on settings button in left panal");
		leftPanel.clickSettings();
		
		settingPage=new SettingsPage(driver);
		test.log(LogStatus.INFO, "clicking on add project button");
		settingPage.clickAddProjectBtn();
		
		addProject=new AddProjectPage(driver);
		test.log(LogStatus.INFO, "checking whether navigated to Add Project page");
		Assert.assertTrue(addProject.verifyNavigationToAddProjectPage("Project "));
		test.log(LogStatus.INFO, "Clicking on collapse button");
        addProject.btnClickCollapseBtn();
        
      

	}
	*/
	
	
	
		
	
	

}

	
