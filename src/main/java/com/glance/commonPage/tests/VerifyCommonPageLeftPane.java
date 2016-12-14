package com.glance.commonPage.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LockScreenPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

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
		login = new LoginPage(driver);
			
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
	}
	
	@AfterMethod
	//logout
	public void logout() {
	 leftPane= new 	CommonPageLeftPane(driver);
	 
	 leftPane.clickLogout();
	}
	
	//verify the glance icon and link
	@Test(priority=0)
	public void GL_Main_02() throws InterruptedException {
	
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		dashboard = new DashboardPage(driver);
				
		leftPane.clickGlanceIcon();
		Thread.sleep(1000);
	    Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
	
	}	
	
	//verify the welcome note and user name
	@Test(priority=1)
	public void GL_Main_03() throws InterruptedException {
	
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		dashboard = new DashboardPage(driver);
	
		Assert.assertTrue(leftPane.verifyUserNameLeft());
		
		
	}	
	
	//verify the User Image
		@Test(priority=2)
		public void GL_Main_03_Sub() throws InterruptedException {
		
			leftPane = new CommonPageLeftPane(driver);
			topPane = new CommonPageTopPane(driver);
			dashboard = new DashboardPage(driver);
		
			Assert.assertTrue(leftPane.verifyUserImageLeft());
			
			
		}	
	
	//verify navigation to Settings Page
     @Test( priority=3)
	public void GL_Main_04() throws InterruptedException {
		
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
	
		
		
		leftPane.clickSettings();
		settings =  new SettingsPage(driver);
	    Assert.assertTrue(settings.verifyNavigationToSettingPage("Dashboard Management"));
    	Thread.sleep(2000);
    	
	     
}
     
  //verify Full Screen Option
 	@Test(priority=4)
 	public void GL_Main_05() throws InterruptedException {
 		
 		
 		leftPane = new CommonPageLeftPane(driver);
 	    leftPane.clickFullScreen();
 		Thread.sleep(2000);
 		
 	     
 	}	

	
	//verify navigation to Lock screen page(need to check manually)
	/*@Test(priority=4)
	public void GL_Main_06() throws InterruptedException {
		//login = new LoginPage(driver);
		leftPane = new CommonPageLeftPane(driver);
		topPane = new CommonPageTopPane(driver);
		
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
	
		
		leftPane.clickScreenLock();
		Thread.sleep(2000);
		
		lockscreen= new LockScreenPage(driver);
	    Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
	    Thread.sleep(2000);
	}	*/
	
	//verify Logout Option
		@Test(priority=5)
		public void GL_Main_7() throws InterruptedException {
			
			
		    leftPane = new CommonPageLeftPane(driver);
			leftPane.clickLogout();
			Assert.assertTrue(login.getLoginTitle("Login Form"));
			Thread.sleep(2000);
		}	
		
		
		//verify the default account dashboards
		@Test(priority=6)
		public void GL_Main_10() throws InterruptedException {
		
			
			//click on AccountDropdown and select an account
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(1000);
		    dashboard = new DashboardPage(driver);
		    Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
		    
		}	
		
	
    // verify the defined account dashboards
	@Test(priority=7)
		public void GL_Main_11() throws InterruptedException {
			
			
			//click on AccountDropdown and select an account
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(1000);
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(1000);
		    dashboard = new DashboardPage(driver);
		    Assert.assertEquals(dashboard.verifyChartTitle(),"Other Bar Chart");
		}
		
	
	
		//verify the no dashboard define error with define now button
		@Test(priority=8)
		public void GL_Main_12() throws InterruptedException {
	
			
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(1000);
			leftPane.clickOnAccountName("John Wiley");
		    Thread.sleep(1000);
		    Assert.assertTrue(leftPane.verifyNoDashboardDefineAcc());
		    
		    
		}	
		
		
		//verify the availability of engagements under selected account
		@Test(priority=10)
		public void GL_Main_14() throws InterruptedException {
			
		
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
		      
		   
		    leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		    Assert.assertTrue(leftPane.getEngagementNameList().contains("Loyalty Solutions"));
		
		}
		
			//checking the engagements under default account
		 @Test(priority=11)
		public void GL_Main_15() throws InterruptedException {
			

			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
		    
		    leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		    Assert.assertTrue(leftPane.getEngagementNameList().contains("AVA"));
	
		}	
		
	
		//checking the projects under selected engagement
		@Test(priority=13)
		public void GL_Main_17() throws InterruptedException {
	
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
		    leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
			leftPane.clickOnEngagementName("Loyalty Solutions");
			
			leftPane.getProjectNameList();
			leftPane.clickOnProject();
			Thread.sleep(10000);
		    Assert.assertTrue(leftPane.getProjectNameList().contains("Red Pineapple"));
			Thread.sleep(5000);
		   
		}	
			
		//checking the availabilty of default project
	@Test(priority=14)
		public void GL_Main_18() throws InterruptedException {
			
			
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
	        leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		
			
			leftPane.getProjectNameList();
			leftPane.clickOnProject();
			Assert.assertTrue(leftPane.getProjectNameList().contains("Gold Pineapple"));
			Thread.sleep(1000);
	
			
		
		}	
		
	   //checking the availability of individuals under selected project
	@Test(priority=15)
		public void GL_Main_20() throws InterruptedException {
		
			
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			leftPane.clickOnAccountName("Affinion");
		    Thread.sleep(2000);
		    
		    leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
			leftPane.clickOnEngagementName("Loyalty Solutions");
			
			leftPane.getProjectNameList();
			leftPane.clickOnProject();
			leftPane.clickOnProjectName("Red Pineapple");
			Thread.sleep(10000);
		 
			Thread.sleep(5000);
			
			leftPane.getIndividualNameList();
			leftPane.clickOnIndividual();
			Assert.assertTrue(!leftPane.getIndividualNameList().contains("abc"));
			Thread.sleep(1000);
		}	
		
		
		
		//checking the individuals under default account
		@Test(priority=16)
		public void GL_Main_21() throws InterruptedException {
	
			
			
			leftPane = new CommonPageLeftPane(driver);
			leftPane.getAccountNameList();
			leftPane.clickOnAccount();
			Thread.sleep(2000);
			
	        leftPane.getEngagementNameList();
		    leftPane.clickOnEngagement();
		    Thread.sleep(1000); 
		
			
			leftPane.getProjectNameList();
			leftPane.clickOnProject();
			Thread.sleep(1000);
			
			leftPane.getIndividualNameList();
			leftPane.clickOnIndividual();
			Thread.sleep(1000);
			Assert.assertTrue(leftPane.getIndividualNameList().contains("Tonie Falco"));
		}	

	}	

