package com.glance.commonPage.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LockScreenPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyCommonPageLeftPane extends BaseTest {
	LoginPage login;
	CommonPageLeftPane leftPane;
	CommonPageTopPane topPane;
	DashboardPage dashboard;
	SettingsPage settings;
	LockScreenPage lockscreen;
	
	@BeforeMethod
	//login
	public void login() {
	
		test=report.startTest("Logging into system");
		login = new LoginPage(driver);
		
		
		test.log(LogStatus.INFO, "Entering user name");	
		login.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering password");
		login.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking Login button");
		login.clickLoginBtn();
	}
	

	
	//verify the glance icon and link
	@Test(priority=0)
	public void GL_Main_02() throws InterruptedException {
		test=report.startTest("verify Glance icon");
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		dashboard = new DashboardPage(driver);
		
		test.log(LogStatus.INFO, "Clicking the Glance icon in the top pane");		
		leftPane.clickGlanceIcon();
		

		Thread.sleep(1000);
	     test.log(LogStatus.INFO, "verifying the naviagtion to dashboard page");
	    Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
	    test.log(LogStatus.INFO, "Clicking the Logout icon");
	    leftPane.clickLogout();
	   
	}	
	
	//verify the welcome note and user name
	@Test(priority=1)
	public void GL_Main_03() throws InterruptedException {
		test=report.startTest("verify user name in the left");
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		dashboard = new DashboardPage(driver);
	
		test.log(LogStatus.INFO, "verifying the user name in the left panel");
		Assert.assertTrue(leftPane.verifyUserNameLeft());
		
		 test.log(LogStatus.INFO, "Clicking the Logout icon");
		 leftPane.clickLogout();
		
	}	
	
	//verify the User Image
		@Test(priority=2)
		public void GL_Main_03_Sub() throws InterruptedException {
			test=report.startTest("verify user image in the left");
			leftPane = new CommonPageLeftPane(driver);
			topPane = new CommonPageTopPane(driver);
			dashboard = new DashboardPage(driver);
		
			test.log(LogStatus.INFO, "verifying the user image in the left panel");
			Assert.assertTrue(leftPane.verifyUserImageLeft());
		
			 test.log(LogStatus.INFO, "Clicking the Logout icon");
			 leftPane.clickLogout();
			
		}	
	
	//verify navigation to Settings Page
     @Test( priority=3)
	public void GL_Main_04() throws InterruptedException {
    	 test=report.startTest("verify settings page");
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
	
		
		
		leftPane.clickSettings();
		settings =  new SettingsPage(driver);
		test.log(LogStatus.INFO, "verifying the navigation to settings page");
	    Assert.assertTrue(settings.verifyNavigationToSettingPage("Dashboard Management"));
	    
    	Thread.sleep(2000);
   	     test.log(LogStatus.INFO, "Clicking the Logout icon");
    	 leftPane.clickLogout();
    

}
     
  //verify Full Screen Option(need to check manually)
 	@Test(priority=4)
 	public void GL_Main_05() throws InterruptedException {
 		
 		test=report.startTest("verifying  Full Screen function");
 		leftPane = new CommonPageLeftPane(driver);
 		
 		test.log(LogStatus.INFO, "Clicking the full screen");
 		leftPane.clickFullScreen();
 	    
 		Thread.sleep(2000);
 		
 		test.log(LogStatus.INFO, "Clicking the Logout icon");
 		 leftPane.clickLogout();
 		

 	}	

	
	//verify navigation to Lock screen page
	@Test(priority=15)
	public void GL_Main_06() throws InterruptedException {
		
		test=report.startTest("verifying lock screen function");
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		
		test.log(LogStatus.INFO, "Entering the user name");
		login.enterUsername(userName);
		test.log(LogStatus.INFO, "Entering the password");
		login.enterPassword(password);
		test.log(LogStatus.INFO, "Clicking the Login button");
		login.clickLoginBtn();
	
		test.log(LogStatus.INFO, "Clicking the screen lock icon");
		leftPane.clickScreenLock();
		Thread.sleep(2000);
		
		lockscreen= new LockScreenPage(driver);
		test.log(LogStatus.INFO, "verifying the navigation to lock screen page");
	    Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
	    Thread.sleep(2000);
	}
	
 	
	//verify Logout Option
		@Test(priority=5)
		public void GL_Main_7() throws InterruptedException {
			
			test=report.startTest("verifying logout function");
		    leftPane = new CommonPageLeftPane(driver);
		    
		    test.log(LogStatus.INFO, "Clicking the Login button");
			leftPane.clickLogout();
			
			test.log(LogStatus.INFO, "verifying the navigation to login page");
			Assert.assertTrue(login.getLoginTitle("Login Form"));
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Clicking the Logout icon");
			 leftPane.clickLogout();
		}	
		
		
		//verify the default account dashboards
		@Test(priority=6)
		public void GL_Main_10() throws InterruptedException {
		
			
			test=report.startTest("verifying the default account dashboards");
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(1000);
			
		    dashboard = new DashboardPage(driver);
		    test.log(LogStatus.INFO, "Verifying navigation to Dashboard page");
		    Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
			test.log(LogStatus.INFO, "Clicking the Logout icon");
		    leftPane.clickLogout();
		}	
		
	
    // verify the defined account dashboards
	@Test(priority=7)
		public void GL_Main_11() throws InterruptedException {
			
			
		    test=report.startTest("verifying the defined account dashboards");
			leftPane = new CommonPageLeftPane(driver);
			
			 test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(1000);
			
			 test.log(LogStatus.INFO, "Clicking on Affinion Account in left panel");
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(1000);
		    
		    dashboard = new DashboardPage(driver);
		    
		    test.log(LogStatus.INFO, "Verifying the defined account dashoboards");
		    Assert.assertEquals(dashboard.verifyChartTitle(),"Other Bar Chart");
		    
			test.log(LogStatus.INFO, "Clicking the Logout icon");
		    leftPane.clickLogout();
		}
		
	
	
		//verify the no dashboard define error with define now button
		@Test(priority=8)
		public void GL_Main_11_01() throws InterruptedException {
	
			test=report.startTest("verifying the no dashboard define error message");
			leftPane = new CommonPageLeftPane(driver);
			
			 test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(1000);
			
			 test.log(LogStatus.INFO, "Clicking on John Wiley Account in left panel");
			leftPane.clickOnAccountName("John Wiley");
		    Thread.sleep(1000);
		    
		    test.log(LogStatus.INFO, "Verifying the error message");
		    Assert.assertTrue(leftPane.verifyNoDashboardDefineAcc());
		    
			test.log(LogStatus.INFO, "Clicking the Logout icon");
		    leftPane.clickLogout();
		    
		}	
		
		
		//verify the availability of engagements under selected account
		@Test(priority=9)
		public void GL_Main_12() throws InterruptedException {
			
			test=report.startTest("verifying the availability of engagements under selected account");
			leftPane = new CommonPageLeftPane(driver);
			
			 test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
			 test.log(LogStatus.INFO, "Clicking on Affinion Account in left panel");
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
		      
		    test.log(LogStatus.INFO, "Getting the engagement names under selected Account list");
		    leftPane.getEngagementNameList();
		    
		    test.log(LogStatus.INFO, "Clicking on Engagement in left panel");
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		    
		    test.log(LogStatus.INFO, "Verifying the availability of Engagement under selected account");
		    Assert.assertTrue(leftPane.getEngagementNameList().contains("Loyalty Solutions"));
		    
		    
			test.log(LogStatus.INFO, "Clicking the Logout icon");
		    leftPane.clickLogout();
		}
		
			//checking the engagements under default account
		 @Test(priority=10)
		public void GL_Main_13() throws InterruptedException {
			
		    test=report.startTest("verifying the availability of engagements under selected account");
			leftPane = new CommonPageLeftPane(driver);
			
			test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
		    
			 test.log(LogStatus.INFO, "Getting the engagement names under selected Account list");
		    leftPane.getEngagementNameList();
		    
		    test.log(LogStatus.INFO, "Clicking on Engagement in left panel");
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		    
		    test.log(LogStatus.INFO, "Verifying the availability of Engagement under default account"); 
		    Assert.assertTrue(leftPane.getEngagementNameList().contains("AVA"));
		    
		    
			test.log(LogStatus.INFO, "Clicking the Logout icon");
		    leftPane.clickLogout();
		}	
		
	
		//checking the projects under selected engagement
		@Test(priority=11)
		public void GL_Main_15() throws InterruptedException {
			test=report.startTest("verifying the projects under selected engagement");
			leftPane = new CommonPageLeftPane(driver);
			
			test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "Clicking on Affinion Account in left panel");
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
			 test.log(LogStatus.INFO, "Getting the engagement names under selected Account list");
		    leftPane.getEngagementNameList();
		    
		    test.log(LogStatus.INFO, "Clicking on Engagement in left panel");
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		    
		    test.log(LogStatus.INFO, "Clicking on particluar Engagement name in left panel");
			leftPane.clickOnEngagementName("Loyalty Solutions");
			
			 test.log(LogStatus.INFO, "Getting the project names under selected engagement list");
			leftPane.getProjectNameList();
			
			  test.log(LogStatus.INFO, "Clicking on project in left panel");
			leftPane.clickOnProject();
			Thread.sleep(10000);
			
			  test.log(LogStatus.INFO, "Verifying the availability of project under selected engagement"); 
		    Assert.assertTrue(leftPane.getProjectNameList().contains("Red Pineapple"));
			Thread.sleep(5000);
			
			
			test.log(LogStatus.INFO, "Clicking the Logout icon");
			 leftPane.clickLogout();
		}	
			
		//checking the availabilty of default project
	@Test(priority=12)
		public void GL_Main_16() throws InterruptedException {
			
		test=report.startTest("verifying the default project");
			leftPane = new CommonPageLeftPane(driver);
			
			test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
			 test.log(LogStatus.INFO, "Getting the engagement names under selected Account list");
	        leftPane.getEngagementNameList();
	        
	        test.log(LogStatus.INFO, "Clicking on Engagement in left panel");
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		
		    test.log(LogStatus.INFO, "Getting the project names under selected engagement list");
			leftPane.getProjectNameList();
			
			test.log(LogStatus.INFO, "Clicking on project in left panel");
			leftPane.clickOnProject();
			
			  test.log(LogStatus.INFO, "Verifying the availability of project under default engagement"); 
			Assert.assertTrue(leftPane.getProjectNameList().contains("Gold Pineapple"));
			Thread.sleep(1000);
			
			test.log(LogStatus.INFO, "Clicking the Logout icon");
			 leftPane.clickLogout();
	
			
		
		}	
		
	   //checking the availability of individuals under selected project
	@Test(priority=13)
		public void GL_Main_18() throws InterruptedException {
		
		test=report.startTest("verifying the individuals under selected project");
			leftPane = new CommonPageLeftPane(driver);
			
			test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
			
			test.log(LogStatus.INFO, "Clicking on Affinion Account in left panel");
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
		    test.log(LogStatus.INFO, "Getting the engagement names under selected Account list");
		    leftPane.getEngagementNameList();
		    
		    test.log(LogStatus.INFO, "Clicking on Engagement in left panel");
		    leftPane.clickOnEngagement();
		    
		    
		    Thread.sleep(1000); 
		    
		    test.log(LogStatus.INFO, "Clicking on particluar Engagement name in left panel");
			leftPane.clickOnEngagementName("Loyalty Solutions");
			
			
			test.log(LogStatus.INFO, "Getting the project names under selected engagement list");
			leftPane.getProjectNameList();
			
			test.log(LogStatus.INFO, "Clicking on project in left panel");
			leftPane.clickOnProject();
			
			
			test.log(LogStatus.INFO, "Clicking on particluar project name in left panel");
			leftPane.clickOnProjectName("Red Pineapple");
			Thread.sleep(10000);
		 
			Thread.sleep(5000);
			
			test.log(LogStatus.INFO, "Getting the individual names under selected project ");
			leftPane.getIndividualNameList();
			
			test.log(LogStatus.INFO, "Clicking on individual in left panel");
			leftPane.clickOnIndividual();
			
			test.log(LogStatus.INFO, "Verifying the availability of individual under selected project");
			Assert.assertTrue(!leftPane.getIndividualNameList().contains("abc"));
			Thread.sleep(1000);
			
			
			test.log(LogStatus.INFO, "Clicking the Logout icon");
			 leftPane.clickLogout();
		}	
		
		
		
		//checking the individuals under default account
		@Test(priority=14)
		public void GL_Main_19() throws InterruptedException {
	
			test=report.startTest("verifying the individuals under default account");
			
			leftPane = new CommonPageLeftPane(driver);
			
			test.log(LogStatus.INFO, "Getting the Account name list");
			leftPane.getAccountNameList();
			
			 test.log(LogStatus.INFO, "Clicking on Account in left panel");
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
			
			test.log(LogStatus.INFO, "Getting the individual names under selected project ");
			leftPane.getIndividualNameList();
			

			test.log(LogStatus.INFO, "Clicking on individual in left panel");
			leftPane.clickOnIndividual();
			Thread.sleep(1000);
			
			test.log(LogStatus.INFO, "Verifying the availability of individual under default project");
			Assert.assertTrue(leftPane.getIndividualNameList().contains("Tonie Falco"));
			
			
			test.log(LogStatus.INFO, "Clicking the Logout icon");
			
			 leftPane.clickLogout();
			 
		}	

	}	

