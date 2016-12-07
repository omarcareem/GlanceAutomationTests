package com.glance.usermanagement.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.CommonPageTopPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.EditGroupPage;
import com.glance.pageobjects.usermanagement.ManageGroupPage;

public class ManageGroup extends BaseTest{
	LoginPage login;
    ManageGroupPage mGroup;
	EditGroupPage eGroup;
	SettingsPage settingspage;
	CommonPageLeftPane comLeftPane;
	CommonPageObject comObj;
	
	//Add group
	@Test(priority = 0)
	public void testAddgroup() throws InterruptedException{
		login = new LoginPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		mGroup = new ManageGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comObj= new CommonPageObject(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		int previousManageGroupCount=settingspage.getCountManageGroups();
		System.out.println("Previous Count:"+previousManageGroupCount);
		
		settingspage.clickManageGroupsBtn();
		mGroup.inputGroupName(grpName);
		Thread.sleep(2000);
		mGroup.clickAddGroup();
		Thread.sleep(2000);
		comObj.lastPageNavigation();
	
		Assert.assertTrue(mGroup.verifyAdded(grpName));
		
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		
		int newestManageGroupCount=settingspage.getCountManageGroups();
        System.out.println(newestManageGroupCount);
        
        //compare the counts 
        if(newestManageGroupCount > previousManageGroupCount)
               System.out.println("New Group has been added");
        
        else 
               System.out.println("Group has not been added");     
        
		
		comLeftPane.clickLogout();
			
		}
	
	
  //Verify cancel Add group directed to settings page
	@Test(priority = 1)
	public void testCancelBtn() throws InterruptedException{
		login = new LoginPage(driver);
		mGroup = new ManageGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		comObj= new CommonPageObject(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		int previousManageGroupCount=settingspage.getCountManageGroups();
		System.out.println("Previous Count:"+previousManageGroupCount);
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		mGroup.clickCancelGroup();

	
		Assert.assertTrue(settingspage.verifyNavigationToSettingPage("Dashboard Management")); 
		
		int newestManageGroupCount=settingspage.getCountManageGroups();
        System.out.println(newestManageGroupCount);
        
        //compare the counts 
        if(newestManageGroupCount > previousManageGroupCount)
               System.out.println("New Group has been added");
        
        else 
               System.out.println("Group has not been added");   
		comLeftPane.clickLogout();
	}
	
		
	//update group details
   @Test(priority = 2)
	public void testEditGroup() throws InterruptedException{
		login = new LoginPage(driver);
		mGroup = new ManageGroupPage(driver);
		eGroup = new EditGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLoginBtn();
		
		
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		comObj.lastPageNavigation();
        mGroup.clickEdit(grpName);
		Assert.assertTrue(eGroup.verifyNavigationToEditGroupPage(expectedMessageEdit));  
		Thread.sleep(2000);
        eGroup.updateGroupName(grpNameNew);
		Thread.sleep(2000);
		eGroup.clickUpdateGroupBtn();
		comObj.lastPageNavigation();
		Assert.assertTrue(eGroup.verifyUpdated(grpNameNew));
		comLeftPane.clickLogout();
			
		
		
	
			
		}
   
 //delete existing group
 	@Test(priority = 3)
 	public void testDeleteGroup() throws InterruptedException{
 		login = new LoginPage(driver);
 		mGroup = new ManageGroupPage(driver);
 		settingspage = new SettingsPage(driver);
 		comLeftPane = new CommonPageLeftPane(driver);
 		
 		login.enterUsername(userName);
 		login.enterPassword(password);
 		login.clickLoginBtn();
 		
 		
 		comLeftPane.clickSettings();
		Thread.sleep(1000);
 		settingspage.clickManageGroupsBtn();
 		Thread.sleep(1000);
 		comObj.lastPageNavigation();
 		mGroup.clickDelete(grpNameNew);
 		Thread.sleep(1000);
 		comObj.lastPageNavigation();
 	   Assert.assertTrue(mGroup.verifyDeleted(grpNameNew));
 		comLeftPane.clickLogout();
 			
 		}

}
