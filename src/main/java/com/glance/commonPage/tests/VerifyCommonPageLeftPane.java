package com.glance.commonPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyCommonPageLeftPane extends BaseTest {
	CommonPageTopPane comTop;
	LoginPage login;
	DashboardPage DbPage;
	CommonPageLeftPane comLeft;
	
	
	//verify the userName in the topPane
		@Test (priority=0)
		public void GL_Main_22() throws InterruptedException {
			login = new LoginPage(driver);
			comTop =new	CommonPageTopPane(driver);
			
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			Thread.sleep(2000);
			
			comTop.clickDropDownIcon();
			Assert.assertTrue(comTop.verifyUserName());
			
				
		}
	
	//verify the pancake icon
	@Test(priority=0)
	public void GL_Main_27() throws InterruptedException {
		login = new LoginPage(driver);
		comTop =new	CommonPageTopPane(driver);
		comLeft = new CommonPageLeftPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		Thread.sleep(2000);
		
		comTop.clickPanCakeIcon();
		Thread.sleep(2000);
		Assert.assertTrue(comLeft.verifyToggling());
		Thread.sleep(2000);
	
		
			
	}
	
  //verify the category wise search suggestions if two letters typed
	@Test (priority=1)
	public void GL_Main_28() throws InterruptedException {
		login = new LoginPage(driver);
		comTop =new	CommonPageTopPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		Thread.sleep(2000);
		
		comTop.searchTopPane(searchTwo);
		Thread.sleep(2000);
		
		Assert.assertTrue(comTop.verifySearchSuggestions());
			
	}
	
	//verify the  search text is added to the search text box if selected
		@Test (priority=2)
		public void GL_Main_31() throws InterruptedException {
			login = new LoginPage(driver);
			comTop =new	CommonPageTopPane(driver);
			DbPage = new DashboardPage(driver);
			
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			Thread.sleep(2000);
			
			comTop.searchTopPane(searchFullText);
			Thread.sleep(2000);
			comTop.clickGo();
			DbPage.verifyChartTitle();
			
		
		}
		
		
	
	//verify access denied message
	@Test (priority=3)
	public void GL_Main_32() throws InterruptedException {
		login = new LoginPage(driver);
		comTop =new	CommonPageTopPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		Thread.sleep(2000);
		
		
		comTop.searchTopPane(searchAD);
	
		Thread.sleep(2000);
		comTop.clickGo();
		Assert.assertTrue(comTop.verifyInvalidAccess());
			
	}
	
	//verify the first default details if nothing is clicked
	@Test (priority=4)
	public void GL_Main_33() throws InterruptedException {
		login = new LoginPage(driver);
		comTop =new	CommonPageTopPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		Thread.sleep(2000);
		
		
		comTop.searchTopPane(searchEmpty);
	
		Thread.sleep(2000);
		comTop.clickGo();
		Assert.assertTrue(comTop.verifyFirstDefaultDet());
			
	}
	//verify the no search results error message
	@Test (priority=5)
	public void GL_Main_34() throws InterruptedException {
		login = new LoginPage(driver);
		comTop =new	CommonPageTopPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		Thread.sleep(2000);
		
		
		comTop.searchTopPane(searchAPE);
	    Thread.sleep(2000);
	  
		
		Assert.assertTrue(comTop. verifyNoSearchReults());
			
	}
	
		
	
	
	
}
