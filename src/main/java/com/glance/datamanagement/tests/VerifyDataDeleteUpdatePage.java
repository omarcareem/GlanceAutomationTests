package com.glance.datamanagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.datamanagement.DataDeleteUpdatePage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;

public class VerifyDataDeleteUpdatePage extends BaseTest{
	
	LoginPage loginPage;
	CommonPageLeftPane leftPane;
	SettingsPage settingsPage;
	DataDeleteUpdatePage dataDUPage;
	
	@Test (priority=0)
	public void verifySelectTable(){
						
		//click on settings icon in left pane
		leftPane=new CommonPageLeftPane(driver);
		leftPane.clickSettings();
		
		//select table
		settingsPage = new SettingsPage(driver);
		settingsPage.clickDataDeleteModifyBtn();
		
		dataDUPage = new DataDeleteUpdatePage(driver);
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.selectTable(tableName);
		dataDUPage.clickSubmit();
		Assert.assertTrue(dataDUPage.verifyNavigationToDataDeleteUpdatePage("Delete/Update data"));
		dataDUPage.clickDelete(userin);
		Assert.assertTrue(dataDUPage.verifydeleteConfirmationMessage("Confirm Delete ?"));
		dataDUPage.clickDeleteOkay();
		Assert.assertTrue(dataDUPage.verifyDeleted(userin));
	
	}
}
