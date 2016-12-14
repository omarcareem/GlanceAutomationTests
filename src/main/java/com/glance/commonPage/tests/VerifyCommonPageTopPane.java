package com.glance.commonPage.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.ProfileUpdatePage;
import com.glance.pageobjects.userlogin.SettingsPage;

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
		login = new LoginPage(driver);
			
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
	}
	
	@AfterMethod
	//logout
	public void logout() {
	 comLeft= new 	CommonPageLeftPane(driver);
	 
	 comLeft.clickLogout();
	}
	

	/*//verify the userName  in the topPane
	@Test (priority=0)
		public void GL_Main_22() throws InterruptedException {

			comTop =new	CommonPageTopPane(driver);
			
		
		
			Assert.assertTrue(comTop.verifyUserName());
			Thread.sleep(2000);
	       
				
		}
	//verify the  user Image in the topPane
	@Test (priority=1)
	public void GL_Main_22_Sub() throws InterruptedException {
	
		comTop =new	CommonPageTopPane(driver);
		
	
	
        Assert.assertTrue(comTop.verifyUserImage());
			
	}
		
		//Verify the drop down icon in the top pane
		@Test(priority=2)
		public void GL_Main_23() throws InterruptedException {
	
			comTop =new	CommonPageTopPane(driver);
			comLeft = new CommonPageLeftPane(driver);
	
			comTop.clickDropDownIcon();
			Assert.assertTrue(comTop.verifyDropDownOptions());
			
		}
		
		//verify navigation to Profile Update Page
		@Test( priority = 3 )
		public void GL_Main_24() throws InterruptedException{
	
			
			
			comTop = new CommonPageTopPane(driver);
			comTop.clickDropDownIcon();
			Thread.sleep(700);
			comTop.clickProfile();
		
			
			profileUpdate=new ProfileUpdatePage(driver);
	        Assert.assertTrue(profileUpdate.getProfileUpdateTitle(profileUpdateTitle));
	        Thread.sleep(700);
	      
		
		}
		
		//verify navigation to Settings Page
		@Test( priority = 4 )
		public void GL_Main_25() throws InterruptedException{
	
			
			
			
			comTop = new CommonPageTopPane(driver);
			comTop.clickDropDownIcon();
			Thread.sleep(700);
		
			
			comTop.clickSettings();
			Thread.sleep(5000);
			
			settings =  new SettingsPage(driver);
			Assert.assertTrue(settings.verifyNavigationToSettingPage("Dashboard Management"));
	        
            
	    	Thread.sleep(700);
	    	

		
		}
		
		//verify Logout Option
		@Test( priority = 5)
		public void GL_Main_26() throws InterruptedException{
	
			
			
			comTop = new CommonPageTopPane(driver);
			comTop.clickDropDownIcon();
			Thread.sleep(700);
			comTop.clickLogout();
			Assert.assertTrue(login.getLoginTitle(lblLoginTitle));
			Thread.sleep(700);
			
			login = new LoginPage(driver);
			
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			Thread.sleep(1000);
			   
	}
	
	//verify the pancake icon
	@Test(priority=6)
	public void GL_Main_27() throws InterruptedException {

		comTop =new	CommonPageTopPane(driver);
		comLeft = new CommonPageLeftPane(driver);
		
	
		comTop.clickPanCakeIcon();
		Thread.sleep(2000);
		Assert.assertTrue(comLeft.verifyToggling());
		Thread.sleep(2000);
		comTop.clickPanCakeIcon();
		
			
	}
	
	
	
	
  //verify the category wise search suggestions if two letters typed
	@Test (priority=7)
	public void GL_Main_28() throws InterruptedException {

		comTop =new	CommonPageTopPane(driver);
		
		
		comTop.searchTwo(searchTwo);
		Thread.sleep(2000);
		
		Assert.assertTrue(comTop.verifySearchSuggestions());
			
	}
	
	//verify the  search text is added to the search text box if selected from the two words suggestions
	@Test (priority=8)
	public void GL_Main_29() throws InterruptedException {

		comTop =new	CommonPageTopPane(driver);
		DbPage = new DashboardPage(driver);
		
	
		comTop.selectFromSuggestions(searchTwo);
		Thread.sleep(2000);
	    
		
	}
	
	//verify dashboards related to the selected entity is displayed
	@Test (priority=9)
	public void GL_Main_30() throws InterruptedException {
	
		comTop =new	CommonPageTopPane(driver);
		DbPage = new DashboardPage(driver);
	
		comTop.selectFromSuggestions(searchTwo);
		Thread.sleep(2000);
	    
		
	}
		
	
	
	
	
	//verify whether dashboards related to the selected entity is displayed in the main page if full text is typed
	@Test (priority=10)	
	public void GL_Main_31() throws InterruptedException {
	
			comTop =new	CommonPageTopPane(driver);
			DbPage = new DashboardPage(driver);
			
		
			
			comTop.searchTopPane(searchFullText);
			Thread.sleep(2000);
			comTop.clickGo();
			DbPage.verifyChartTitle();
			
		
		}
		
		
	
	//verify access denied message
	@Test (priority=11)
	public void GL_Main_32() throws InterruptedException {

		comTop =new	CommonPageTopPane(driver);
		
	
		
		comTop.searchTopPane(searchAD);
	
		Thread.sleep(2000);
		comTop.clickGo();
		Assert.assertTrue(comTop.verifyInvalidAccess("Access Denied"));
			
	}*/
	
	//verify the search field empty error message
	@Test (priority=12)
	public void GL_Main_33() throws InterruptedException {
	
		comTop =new	CommonPageTopPane(driver);
		
		comTop.searchTopPane(searchEmpty);
	
		Thread.sleep(2000);
		comTop.clickGo();
		comTop.clickErrorPopUpOk();
		
		Assert.assertTrue(comTop.verifySearchEmpty());
		comTop.clickErrorPopUpOk();	
	}
	
	//verify the no search results error message
	@Test (priority=13)
	public void GL_Main_34() throws InterruptedException {

		comTop =new	CommonPageTopPane(driver);
		
		comTop.searchTopPane(searchUnexisting);
	    Thread.sleep(2000);
	    comTop.clickGo();
	  
		
		Assert.assertTrue(comTop. verifyNoSearchResults());
			
	}
	
	
	
	
}
