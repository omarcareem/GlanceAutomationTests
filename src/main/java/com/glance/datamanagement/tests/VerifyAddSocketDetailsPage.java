package com.glance.datamanagement.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.AddSocketDetailsPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import junit.framework.Assert;

public class VerifyAddSocketDetailsPage extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	AddSocketDetailsPage addSocket;
	CommonPageObject commonPage;
	
	
	@Test (priority=0)
	public void verifyAddSocketSubmission(){
		
		//get previous count of number of accounts 
		settingsPage=new SettingsPage(driver);
		int previousCount=settingsPage.getCountSockets();
		System.out.println(previousCount);
		settingsPage.clickSocketsBtn();
		
		//add socket
		addSocket=new AddSocketDetailsPage(driver);
		Assert.assertTrue(addSocket.verifyNavigationToAddSocketPage("Add Socket Details"));
		addSocket.enterSocketName(socketName);
		addSocket.enterUrl(url);
		addSocket.enterQuery(query);
		addSocket.enterDestinationTableName(tableName);
		addSocket.clickSubmit();
		Assert.assertTrue(addSocket.verifySubmitSuccessMessage("Sockets data inserted successfully"));
		addSocket.clickOkay();
		addSocket.clickCancel();
		
		//get current count of number of sockets
		leftPane.clickSettings();
		int newestCount=settingsPage.getCountSockets();
		System.out.println(newestCount);
		
		//compare the counts 
		if(newestCount > previousCount)
			System.out.println("New Socket is added");
				
		else
			System.out.println("Socket is not added");	
				
		//logout
		leftPane.clickLogout();
					
	}
	
	@Test (priority=1)
	public void verifyAddSocketCancel(){
		
		settingsPage=new SettingsPage(driver);
		settingsPage.clickSocketsBtn();
		
		//add socket
		addSocket=new AddSocketDetailsPage(driver);
		Assert.assertTrue(addSocket.verifyNavigationToAddSocketPage("Add Socket Details"));
		addSocket.enterSocketName(socketName);
		addSocket.enterUrl(url);
		//addSocket.enterQuery(query);
		addSocket.enterDestinationTableName(tableName);
		addSocket.clickCancel();
		Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));           		
				
		//logout
		leftPane.clickLogout();
		
	}
	
	@Test (priority=2)
	public void verifyAuthentication(){
		
			//click on settings icon in left pane
			leftPane=new CommonPageLeftPane(driver);
			leftPane.clickSettings();
			
			settingsPage=new SettingsPage(driver);
			settingsPage.clickSocketsBtn();
			
			//add socket
			addSocket=new AddSocketDetailsPage(driver);
			Assert.assertTrue(addSocket.verifyNavigationToAddSocketPage("Add Socket Details"));
			addSocket.enterSocketName(socketName);
			addSocket.enterUrl(url);
			addSocket.selectCheckBox();
			addSocket.enterUserName(userName1);
			addSocket.enterPassword(password1);
			addSocket.enterQuery(query);
			addSocket.enterDestinationTableName(tableName);
			addSocket.clickCancel();
			Assert.assertTrue(settingsPage.verifyNavigationToSettingPage("Dashboard Management"));           		
					
			//logout
			leftPane.clickLogout();
			
	}
}
	

