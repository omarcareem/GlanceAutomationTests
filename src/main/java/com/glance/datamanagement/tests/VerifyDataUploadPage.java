package com.glance.datamanagement.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataUploadPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

import junit.framework.Assert;

public class VerifyDataUploadPage extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	DataUploadPage dataUploadPage;
	CommonPageObject commonPage;
	
	@Test (priority=0)
	public void verifyDataUploading(){
		
		//click on settings icon in left pane
		leftPane=new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		
		//click data upload 
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();
		
		//select table
		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.selectDataTable(tableName);
		
		//	select file	//
		
		/*dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifySubmitSuccess("Information"));
		dataUploadPage.clickDone();*/
				
	}
	
	@Test (priority=1)
	public void verifyDataUploadingWrongFile(){
		
		//click on settings icon in left pane
		leftPane=new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		
		//click data upload 
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataUploadBtn();
		
		//select table
		dataUploadPage = new DataUploadPage(driver);
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Upload Your Files Here"));
		dataUploadPage.selectDataTable(tableName);
		
		//	select file	//
		
		/*dataUploadPage.clickUpload();
		Assert.assertTrue(dataUploadPage.verifyWrongFileErrorMessage("Please select a file you wish to upload"));
		Assert.assertTrue(dataUploadPage.verifyNavigationToDataUploadPage("Information"));
		dataUploadPage.clickDone();*/
				
	}
}
