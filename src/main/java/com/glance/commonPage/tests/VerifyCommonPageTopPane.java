package com.glance.commonPage.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyCommonPageTopPane extends BaseTest {
	CommonPageTopPane comTop;
	LoginPage login;
	DashboardPage DbPage;
	CommonPageLeftPane comLeft;
	ProfileUpdatePage profileUpdate;
	SettingsPage settings;
	
	
	
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
	
	
	//verify the userName  in the topPane
	@Test (priority=0)
		public void GL_Main_20() throws InterruptedException {
		
		test=report.startTest("verify user name in the top pane");
		comTop =new	CommonPageTopPane(driver);
		comLeft= new 	CommonPageLeftPane(driver);
		
		test.log(LogStatus.INFO, "verifying the user name in the top pane");
		Assert.assertTrue(comTop.verifyUserName());
		Thread.sleep(2000);
			
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		comLeft.clickLogout();
	       
				
		}
	//verify the  user Image in the topPane
	@Test (priority=1)
	public void GL_Main_20_Sub() throws InterruptedException {
		test=report.startTest("verify user Image in the top pane");
		comTop =new	CommonPageTopPane(driver);
		 comLeft= new 	CommonPageLeftPane(driver);
	
		 test.log(LogStatus.INFO, "verifying the user image in the top pane");
        Assert.assertTrue(comTop.verifyUserImage());
       
        test.log(LogStatus.INFO, "Clicking the Logout icon");	 
   	    comLeft.clickLogout();
			
	}
		
		//Verify the drop down icon in the top pane
		@Test(priority=2)
		public void GL_Main_21() throws InterruptedException {
			test=report.startTest("verify  the drop down icon in the top pane");
			comTop =new	CommonPageTopPane(driver);
			comLeft = new CommonPageLeftPane(driver);
	
			 test.log(LogStatus.INFO, "Clicking the drop down option in the top right corner");
			comTop.clickDropDownIcon();
			
			test.log(LogStatus.INFO, "verifying the options under drop down");
			Assert.assertTrue(comTop.verifyDropDownOptions());
			
			 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
			 comLeft.clickLogout();
			
		}
		
		//verify navigation to Profile Update Page
		@Test( priority = 3 )
		public void GL_Main_22() throws InterruptedException{
	
			
			test=report.startTest("verify  navigation to Profile Update Page");
			comTop = new CommonPageTopPane(driver);
			
			 test.log(LogStatus.INFO, "Clicking the drop down option in the top right corner");
			comTop.clickDropDownIcon();
			Thread.sleep(700);
			
			test.log(LogStatus.INFO, "Clicking the Profile from the drop down list");
			comTop.clickProfile();
		
			
			profileUpdate=new ProfileUpdatePage(driver);
			
			test.log(LogStatus.INFO, "verifying the navigation to profile update page");
	        Assert.assertTrue(profileUpdate.getProfileUpdateTitle(profileUpdateTitle));
	        Thread.sleep(700);
	        
	        comLeft= new CommonPageLeftPane(driver);
	   	 
	   	     comLeft.clickLogout();
	      
		
		}
		
		//verify navigation to Settings Page
		@Test( priority = 4 )
		public void GL_Main_23() throws InterruptedException{
	
			test=report.startTest("verify navigation to Settings Page");
			
			
			comTop = new CommonPageTopPane(driver);
			
			 test.log(LogStatus.INFO, "Clicking the drop down option in the top right corner");
			comTop.clickDropDownIcon();
			Thread.sleep(700);
		
			test.log(LogStatus.INFO, "Clicking the Settings from the drop down list");
			comTop.clickSettings();
			Thread.sleep(5000);
			
			settings =  new SettingsPage(driver);
			
			test.log(LogStatus.INFO, "verifying the navigation to settings page");
			Assert.assertTrue(settings.verifyNavigationToSettingPage("Dashboard Management"));
	        
            
	    	Thread.sleep(700);
	    	 comLeft= new 	CommonPageLeftPane(driver);
	    	 
	    	 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
	    	 comLeft.clickLogout();
	    	

		
		}
		
		//verify Logout Option
		@Test( priority = 5)
		public void GL_Main_24() throws InterruptedException{
	
			
			test=report.startTest("verify Logout Option in the top pane");
			comTop = new CommonPageTopPane(driver);
			
			 test.log(LogStatus.INFO, "Clicking the drop down option in the top right corner");
			comTop.clickDropDownIcon();
			Thread.sleep(700);
			
			
			test.log(LogStatus.INFO, "Clicking the Logout from the drop down list");
			comTop.clickLogout();
			
			test.log(LogStatus.INFO, "verifying the navigation to Login page");
			Assert.assertTrue(login.getLoginTitle(lblLoginTitle));
			Thread.sleep(700);
			
		
			   
	}
	
	//verify the pancake icon
	@Test(priority=6)
	public void GL_Main_25() throws InterruptedException {
		test=report.startTest("verify  the pancake icon");
		comTop =new	CommonPageTopPane(driver);
		comLeft = new CommonPageLeftPane(driver);
		
		 test.log(LogStatus.INFO, "Clicking the pancake icon"); 
		comTop.clickPanCakeIcon();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "verifying the toggling of page");
		Assert.assertTrue(comLeft.verifyToggling());
		Thread.sleep(2000);
		
		 test.log(LogStatus.INFO, "Clicking the pancake icon again"); 
		comTop.clickPanCakeIcon();
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
		
			
	}
	
	
	
	
  //verify the category wise search suggestions if two letters typed
	@Test (priority=7)
	public void GL_Main_26_01() throws InterruptedException {
		test=report.startTest("verify  category wise search suggestions if two letters typed");
		comTop =new	CommonPageTopPane(driver);
		
		test.log(LogStatus.INFO, "searching using two letter key word");
		comTop.searchTwo(searchTwo);
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "verifying the search suggestions");
		Assert.assertTrue(comTop.verifySearchSuggestions());
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
	}
	
	//verify the  search text is added to the search text box if selected from the two words suggestions
	@Test (priority=8)
	public void GL_Main_26_02() throws InterruptedException {
		test=report.startTest("verify the  search text is added to the search text box");
		comTop =new	CommonPageTopPane(driver);
		DbPage = new DashboardPage(driver);
		
		test.log(LogStatus.INFO, "selecting from the drop down search suggestions");
		comTop.selectFromSuggestions(searchTwo);
		Thread.sleep(2000);
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
	    
		
	}
	
	//verify dashboards related to the selected entity is displayed
	@Test (priority=9)
	public void GL_Main_26_03() throws InterruptedException {
		test=report.startTest("verify the  dashboards related to the selected entity is displayed");
		comTop =new	CommonPageTopPane(driver);
		DbPage = new DashboardPage(driver);
	
		test.log(LogStatus.INFO, "selecting from the drop down search suggestions");
		comTop.selectFromSuggestions(searchTwo);
		Thread.sleep(2000);
		
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
		
	}
		
	
	
	
	
	//verify whether dashboards related to the selected entity is displayed in the main page if full text is typed
	@Test (priority=10)	
	public void GL_Main_26_04() throws InterruptedException {
		test=report.startTest("verify the  dashboards related to the selected entity is displayed if full text is typed");
			comTop =new	CommonPageTopPane(driver);
			DbPage = new DashboardPage(driver);
			
		
			test.log(LogStatus.INFO, "searching using full letter key word");
			comTop.searchTopPane(searchFullText);
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "clicking go in the search text box");
			comTop.clickGo();
			
			test.log(LogStatus.INFO, "verifying the dashboards for the selected key word");
			DbPage.verifyChartTitle();
			
			comLeft= new CommonPageLeftPane(driver);
			 
			 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
			 comLeft.clickLogout();
		
		}
		
		
	
	//verify access denied message
	@Test (priority=11)
	public void GL_Main_26_05() throws InterruptedException {
		test=report.startTest("verify access denied message");
		comTop =new	CommonPageTopPane(driver);
		
	
		test.log(LogStatus.INFO, "searching an entity which is not given access");
		comTop.searchTopPane(searchAD);
	
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "clicking go in the search text box");
		comTop.clickGo();
		
		
		test.log(LogStatus.INFO, "verfying access denied error message");
		Assert.assertTrue(comTop.verifyInvalidAccess("Access Denied"));
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
			
	}	
	//verify the search field empty error message
	@Test (priority=12)
	public void GL_Main_26_06() throws InterruptedException {
		test=report.startTest("verify  the search field empty error message");
		comTop =new	CommonPageTopPane(driver);
		
		test.log(LogStatus.INFO, "searching using empty key word");
		comTop.searchTopPane(searchEmpty);
	
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "clicking go in the search text box");
		comTop.clickGo();
		
		
		test.log(LogStatus.INFO, "verify search field empty error message");
		Assert.assertTrue(comTop.verifySearchEmpty());
		
		test.log(LogStatus.INFO, "clicking ok ");
        comTop.clickErrorPopUpOk();
		
		
		 comLeft= new 	CommonPageLeftPane(driver);
		 
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
	}
	
	//verify  no search results error message
	@Test (priority=13)
	public void GL_Main_26_07() throws InterruptedException {
		test=report.startTest("verify no search results error message");
		comTop =new	CommonPageTopPane(driver);
		
		test.log(LogStatus.INFO, "searching an unexisting key word");
		comTop.searchTopPane(searchUnexisting);
	    Thread.sleep(2000);
	   
	    test.log(LogStatus.INFO, "clicking go in the search text box");
	    comTop.clickGo();
	  
	    test.log(LogStatus.INFO, "verify no search results error message");
		Assert.assertTrue(comTop. verifyNoSearchResults());
		 comLeft= new 	CommonPageLeftPane(driver);
		
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		 comLeft.clickLogout();
			
	}
	
	
	
	
}
