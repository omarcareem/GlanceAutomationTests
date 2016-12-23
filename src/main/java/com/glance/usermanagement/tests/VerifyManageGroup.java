package com.glance.usermanagement.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.EditGroupPage;
import com.glance.pageobjects.usermanagement.ManageGroupPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyManageGroup extends BaseTest{
	LoginPage login;
    ManageGroupPage mGroup;
	EditGroupPage eGroup;
	SettingsPage settingspage;
	CommonPageLeftPane comLeftPane;
	CommonPageObject comObj;
	
	
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
	//verify Add group
	@Test(priority = 0)
	public void GL_Settings_UM_24() throws InterruptedException, IOException{
		//login = new LoginPage(driver);
		test=report.startTest("verify Add group");
		comLeftPane = new CommonPageLeftPane(driver);
		mGroup = new ManageGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comObj= new CommonPageObject(driver);
		
	
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		
		int previousManageGroupCount=settingspage.getCountManageGroups();
		System.out.println("Previous Count:"+previousManageGroupCount);
		
		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
		settingspage.clickManageGroupsBtn();
		
		test.log(LogStatus.INFO, "Entering group name");
		mGroup.inputGroupName(grpName);
		Thread.sleep(2000);
	
		test.log(LogStatus.INFO, "uploading group image");
		mGroup.inputGroupImage();
		
		Runtime.getRuntime().exec("C:\\GlanceProject\\GlanceAutomationTests\\GroupImageUpload.exe");
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking Add group button");
		mGroup.clickAddGroup();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking Last page naviagtion button");
		comObj.pageNavigationString("Last");
	
		
		test.log(LogStatus.INFO, "verifying the add group ");
		Assert.assertTrue(mGroup.verifyAdded(grpName));
		
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
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
		
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		comLeftPane.clickLogout();
			
		}
	
	//Verify adding group functionality with empty field
	@Test(priority = 1)
	public void GL_Settings_UM_25() throws InterruptedException, IOException{
	//	login = new LoginPage(driver);
		test=report.startTest("Verify adding group functionality with empty field");
		comLeftPane = new CommonPageLeftPane(driver);
		mGroup = new ManageGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comObj= new CommonPageObject(driver);
		
		
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		int previousManageGroupCount=settingspage.getCountManageGroups();
		System.out.println("Previous Count:"+previousManageGroupCount);
		
		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking Add group button");
		mGroup.clickAddGroup();
		Thread.sleep(2000);
		
		//Assert.assertTrue(mGroup.verifyAlert(""));
				
		Thread.sleep(2000);
		 test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		comLeftPane.clickLogout();
			
		}
	
	
  //Verify cancel Add group directed to settings page
	@Test(priority = 2)
	public void GL_Settings_UM_26() throws InterruptedException{
	//	login = new LoginPage(driver);
		test=report.startTest("Verify cancel Add group directed to settings page");
		mGroup = new ManageGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		comObj= new CommonPageObject(driver);
		
	
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		
		int previousManageGroupCount=settingspage.getCountManageGroups();
		System.out.println("Previous Count:"+previousManageGroupCount);
		
		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking cancel button");
		mGroup.clickCancelGroup();

		test.log(LogStatus.INFO, "Verify navigation to settings page");
		Assert.assertTrue(settingspage.verifyNavigationToSettingPage("Dashboard Management")); 
		
		int newestManageGroupCount=settingspage.getCountManageGroups();
        System.out.println(newestManageGroupCount);
        
        //compare the counts 
        if(newestManageGroupCount > previousManageGroupCount)
               System.out.println("New Group has  been added");
        
        else 
               System.out.println("Group has not been added");  
        
        test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		comLeftPane.clickLogout();
	}
	
		
	//verify navigation to edit group page 
   @Test(priority = 3)
	public void GL_Settings_UM_27() throws InterruptedException{
	//	login = new LoginPage(driver);
	   test=report.startTest("Verify navigation to edit group page ");
		mGroup = new ManageGroupPage(driver);
		eGroup = new EditGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		
		
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking Last page navigation button");
		comObj.pageNavigationString("Last");
        mGroup.clickEdit(grpName);
        
        test.log(LogStatus.INFO, "Verifying navigation to Edit  group page");
		Assert.assertTrue(eGroup.verifyNavigationToEditGroupPage(expectedMessageEdit));  
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking the Logout icon");	 
		comLeftPane.clickLogout();
					
		}
   
   
	//verify editing group details 
   @Test(priority = 4)
	public void GL_Settings_UM_28() throws InterruptedException{
	//	login = new LoginPage(driver);
	   test=report.startTest("Verify  editing group details ");
		mGroup = new ManageGroupPage(driver);
		eGroup = new EditGroupPage(driver);
		settingspage = new SettingsPage(driver);
		comLeftPane = new CommonPageLeftPane(driver);
		
		
		
		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
		comLeftPane.clickSettings();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
		settingspage.clickManageGroupsBtn();
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking Last page naviagtion button");
		comObj.pageNavigationString("Last");
		
		test.log(LogStatus.INFO, "Clicking the edit group button");
        mGroup.clickEdit(grpName);
	    Thread.sleep(2000);
	    
		test.log(LogStatus.INFO, "Entering the new group name");
        eGroup.updateGroupName(grpNameNew);
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Clicking the update group button");
		eGroup.clickUpdateGroupBtn();
		
		test.log(LogStatus.INFO, "Clicking Last page navigation button");
		comObj.pageNavigationString("Last");
		
		test.log(LogStatus.INFO, "Verifying whether the new group name is updated");
		Assert.assertTrue(eGroup.verifyUpdated(grpNameNew));
		
		test.log(LogStatus.INFO, "Clicking the Logout icon");	
		comLeftPane.clickLogout();
		
					
		}
   
   
 //Verify cancel update group details directed to manage group page
	@Test(priority = 5)
 	public void GL_Settings_UM_29() throws InterruptedException{
 	//	login = new LoginPage(driver);
		  test=report.startTest("Verify  cancel update group details directed to manage group page ");
 		mGroup = new ManageGroupPage(driver);
 		settingspage = new SettingsPage(driver);
 		
 		comLeftPane = new CommonPageLeftPane(driver);
 		comObj= new CommonPageObject(driver);
 		
 	
 		
 		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
 		comLeftPane.clickSettings();
 		Thread.sleep(2000);
 		
 		test.log(LogStatus.INFO, "Clicking manage group in the settings page");
 	 	settingspage.clickManageGroupsBtn();
 		Thread.sleep(2000);
 		
 		
		test.log(LogStatus.INFO, "Clicking Last page navigation button");
 		comObj.pageNavigationString("Last");
 		
 		test.log(LogStatus.INFO, "Clicking the edit group button");
 		mGroup.clickEdit(grpNameNew);
 		Thread.sleep(1000);
 		
 		
 		eGroup = new EditGroupPage(driver);
 		
 		test.log(LogStatus.INFO, "Clicking the cancel update button");
 	    eGroup.clickCancelUpdate();
 	    Thread.sleep(1000);
 	    
 		test.log(LogStatus.INFO, "Verify cancel update  directed to manage group page");
 		Assert.assertTrue(mGroup.verifyNavigationToManageGroupPage("Add Group Details"));
 		
 		test.log(LogStatus.INFO, "Clicking the Logout icon");	
		comLeftPane.clickLogout();
 	}
 	
 	
   
 
	//delete existing group
		@Test(priority = 7)
	 	public void GL_Settings_UM_30() throws InterruptedException{
	 		//login = new LoginPage(driver);
			test=report.startTest("Verify  delete existing group ");
	 		mGroup = new ManageGroupPage(driver);
	 		settingspage = new SettingsPage(driver);
	 		comLeftPane = new CommonPageLeftPane(driver);
	 		comObj= new CommonPageObject(driver);
	 		
	 	
	 		
	 		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
	 		comLeftPane.clickSettings();
			Thread.sleep(1000);
			
			test.log(LogStatus.INFO, "Clicking manage group in the settings page");
	 		settingspage.clickManageGroupsBtn();
	 		Thread.sleep(1000);
	 		
	 		test.log(LogStatus.INFO, "Clicking Last page navigation button");
	 		comObj.pageNavigationString("Last");
	 		
	 		test.log(LogStatus.INFO, "Clicking the Delete button");
	 		mGroup.clickDelete(grpNameNew);
	 		Thread.sleep(1000);
	 	    
	 		test.log(LogStatus.INFO, "Verifying the group name is deleted");
	 	    Assert.assertTrue(mGroup.verifyDeleted(grpNameNew));
	 		
	 	   test.log(LogStatus.INFO, "Clicking the Logout icon");	
			comLeftPane.clickLogout();	
	 		}
		
		//cancel deleting  existing group after clicking delete
		@Test(priority = 6)
	 	public void GL_Settings_UM_31() throws InterruptedException{
	 		//login = new LoginPage(driver);
			test=report.startTest("cancel deleting  existing group after clicking delete ");
	 		mGroup = new ManageGroupPage(driver);
	 		settingspage = new SettingsPage(driver);
	 		comLeftPane = new CommonPageLeftPane(driver);
	 		comObj= new CommonPageObject(driver);
	 		
	 	
	 		
	 		test.log(LogStatus.INFO, "Clicking settings in bottom left corner");
	 		comLeftPane.clickSettings();
			Thread.sleep(1000);
			
			test.log(LogStatus.INFO, "Clicking manage group in the settings page");
	 		settingspage.clickManageGroupsBtn();
	 		Thread.sleep(1000);
	 		
	 		test.log(LogStatus.INFO, "Clicking Last page navigation button");
	 		comObj.pageNavigationString("Last");
	 		
	 		 		
	 		test.log(LogStatus.INFO, "Clicking the Delete button");
	 		mGroup.clickCancelDelete(grpNameNew);
	 		Thread.sleep(1000);
	 		
	        test.log(LogStatus.INFO, "Verifying navigation to Edit  group page");
	 		Assert.assertTrue(mGroup.verifyNavigationToManageGroupPage(expectedMessage));  
	 	    Thread.sleep(2000);
	 	    
	 			 		
	 	      test.log(LogStatus.INFO, "Clicking the Logout icon");	
			comLeftPane.clickLogout();	
	 		}
		
}

