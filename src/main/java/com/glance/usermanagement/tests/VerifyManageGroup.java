package com.glance.usermanagement.tests;

import java.io.IOException;

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

public class VerifyManageGroup extends BaseTest{
	LoginPage login;
    ManageGroupPage mGroup;
	EditGroupPage eGroup;
	SettingsPage settingspage;
	CommonPageLeftPane comLeftPane;
	CommonPageObject comObj;
	
	//verify Add group
	@Test(priority = 0)
	public void GL_Settings_MG_80() throws InterruptedException, IOException{
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
	
		mGroup.inputGroupImage();
		
		Runtime.getRuntime().exec("C:\\GlanceProject\\GlanceAutomationTests\\GroupImageUpload.exe");
		Thread.sleep(2000);
		mGroup.clickAddGroup();
		Thread.sleep(2000);
		comObj.pageNavigationString("Last");
	
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
        
		Thread.sleep(2000);
		comLeftPane.clickLogout();
			
		}
	
	//Verify adding group functionality with empty field
	@Test(priority = 1)
	public void GL_Settings_MG_81() throws InterruptedException, IOException{
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
		Thread.sleep(2000);
		mGroup.clickAddGroup();
		Thread.sleep(2000);
		
	
		
		Assert.assertTrue(mGroup.verifyAlert(""));
		
		
		Thread.sleep(2000);
		comLeftPane.clickLogout();
			
		}
	
	
  //Verify cancel Add group directed to settings page
	@Test(priority = 1)
	public void GL_Settings_MG_82() throws InterruptedException{
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
               System.out.println("New Group has  been added");
        
        else 
               System.out.println("Group has not been added");   
		comLeftPane.clickLogout();
	}
	
		
	//verify navigation to edit group page 
   @Test(priority = 2)
	public void GL_Settings_MG_83() throws InterruptedException{
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
		comObj.pageNavigationString("Last");
        mGroup.clickEdit(grpName);
		Assert.assertTrue(eGroup.verifyNavigationToEditGroupPage(expectedMessageEdit));  
		Thread.sleep(2000);
     
		comLeftPane.clickLogout();
					
		}
   
   
	//verify editing group details 
   @Test(priority = 3)
	public void GL_Settings_MG_84() throws InterruptedException{
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
		comObj.pageNavigationString("Last");
        mGroup.clickEdit(grpName);
	    Thread.sleep(2000);
        eGroup.updateGroupName(grpNameNew);
		Thread.sleep(2000);
		eGroup.clickUpdateGroupBtn();
		comObj.pageNavigationString("Last");
		Assert.assertTrue(eGroup.verifyUpdated(grpNameNew));
		comLeftPane.clickLogout();
		
					
		}
   
   
 //Verify cancel update group details directed to manage group page
	@Test(priority = 4)
 	public void GL_Settings_MG_85() throws InterruptedException{
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
 	 	settingspage.clickManageGroupsBtn();
 		Thread.sleep(2000);
 		comObj.pageNavigationString("Last");
 		mGroup.clickEdit(grpNameNew);
 		Thread.sleep(1000);
 		eGroup = new EditGroupPage(driver);
 	    eGroup.clickCancelUpdate();
 	    Thread.sleep(1000);
 		Assert.assertTrue(mGroup.verifyNavigationToManageGroupPage("Add Group Details"));
 		
       
 	}
 	
 	
   
 //delete existing group
	@Test(priority = 5)
 	public void GL_Settings_MG_86() throws InterruptedException{
 		login = new LoginPage(driver);
 		mGroup = new ManageGroupPage(driver);
 		settingspage = new SettingsPage(driver);
 		comLeftPane = new CommonPageLeftPane(driver);
 		comObj= new CommonPageObject(driver);
 		
 		login.enterUsername(userName);
 		login.enterPassword(password);
 		login.clickLoginBtn();
 		
 		
 		comLeftPane.clickSettings();
		Thread.sleep(1000);
 		settingspage.clickManageGroupsBtn();
 		Thread.sleep(1000);
 		comObj.pageNavigationString("Last");
 		mGroup.clickDelete(grpNameNew);
 		Thread.sleep(1000);
 	    
 	    Assert.assertTrue(mGroup.verifyDeleted(grpNameNew));
 		
 			
 		}

}

