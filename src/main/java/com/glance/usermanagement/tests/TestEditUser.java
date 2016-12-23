package com.glance.usermanagement.tests;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.userlogin.CreateAccountPage;
import com.glance.pageobjects.userlogin.LoginPage;
import com.glance.pageobjects.userlogin.SettingsPage;
import com.glance.pageobjects.usermanagement.DeleteUser;
import com.glance.pageobjects.usermanagement.EditUser;
import com.glance.pageobjects.usermanagement.GroupMembershipPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestEditUser extends BaseTest {
	
	LoginPage loginPage;
	CommonPageLeftPane leftPanel;
	SettingsPage settingPage;
	EditUser editUser;
	CreateAccountPage createAccount;
	GroupMembershipPage groupMembership;
	DeleteUser deleteUser;
	
	@BeforeMethod
	public void verifyGoToEditUserPage() throws InterruptedException {

		loginPage = new LoginPage(driver);
		createAccount =  new CreateAccountPage(driver);
		groupMembership = new GroupMembershipPage(driver);
		leftPanel =  new CommonPageLeftPane(driver);
		
//go to create account page and create new user
		loginPage.navigateCreateAccountPage();
		createAccount.createUsername(userNameEdit);
		createAccount.addemailAdd(emailAddEdit);
		createAccount.createpassword(passwordEdit);
		createAccount.confirmPassword(passwordEdit);
		createAccount.clickSubmitBtn();
		groupMembership.clickDone();
		Thread.sleep(5000);
		
		createAccount.clickLoginLink();
		

		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
//Navigate to setting
		
		leftPanel.clickSettings();
		
//Navigate to manage user page
		settingPage = new SettingsPage(driver);
		editUser = new EditUser(driver);
		
		settingPage.ClickManageUsersBtn();
			

}

//Test what happen when clicking cancel in edit group page
	@Test(priority=1)
	public void GL_Settings_UM_5_cancelEditPage(){
		test=report.startTest("verifyCancelEditPage");
		editUser = new EditUser(driver);
		
		test.log(LogStatus.INFO, "Select the user to edit");
		editUser.selectUserToEdit(userNameEdit);
		
		test.log(LogStatus.INFO, "Cancel EditUser");
		editUser.cancelEditPage();
		Assert.assertTrue(editUser.verifyLabl());
		
//Check whether the user name is validated or not
	}
	
	@Test(priority=2)
	public void GL_Settings_UM_3_2_checkUserNameValidation(){
		test=report.startTest("Checking user name validation");
		editUser = new EditUser(driver);
		
		test.log(LogStatus.INFO, "Select the user to edit");
		editUser.selectUserToEdit(userNameEdit);
		
		test.log(LogStatus.INFO, "Editing user name");
		editUser.editUserName(wrongUserName);
		
		test.log(LogStatus.INFO, "Updating");
		editUser.update();
		Assert.assertTrue(editUser.verifyValidation("Please enter user name in valid length !"));
		
		test.log(LogStatus.INFO, "Selecting ok in the alert message");
		editUser.clickOkWarning();
	}
	
//Check whether the e-mail is validated or not
	@Test(priority=3)
	public void GL_Settings_UM_3_3_checkEmailValidation(){
		test=report.startTest("Checking E-mail validation");
		editUser = new EditUser(driver);
		
		test.log(LogStatus.INFO, "Select the user to edit");
		editUser.selectUserToEdit(userNameEdit);
		
		test.log(LogStatus.INFO, "Edit email address with wronh format");
		editUser.editEmail(wrongEmail);
		
		test.log(LogStatus.INFO, "Clicking update");
		editUser.update();

		test.log(LogStatus.INFO, "Verifying whether the alert message is displayed or not");
		Assert.assertTrue(editUser.verifyValidation("You have entered an invalid email address!"));
			
		editUser.clickOkWarning();
	
	}
	
//verify edit user details
	@Test(priority=4)
	public void GL_Settings_UM_3_1_verifyEditUser() throws InterruptedException, IOException {
		test=report.startTest("Verifying edit user with valid details");
		editUser = new EditUser(driver);
		
		test.log(LogStatus.INFO, "Selecting user to edit");
		editUser.selectUserToEdit(userNameEdit);
		
		test.log(LogStatus.INFO, "Editing User name");
		editUser.editUserName(newUserName);
		
		test.log(LogStatus.INFO, "Selecting First name");
		editUser.editFirstName(firstName);
		
		test.log(LogStatus.INFO, "Selecting Last name");
		editUser.editLastName(lastName);
		
		//editUser.editUserImage();
		//Thread.sleep(5000);
		//Runtime.getRuntime().exec("C:\\Shobana2\\Glance\\Glance Automation\\GlanceAutomationTests\\ImageUpload.exe");
		test.log(LogStatus.INFO, "Editing E-mail address");
		editUser.editEmail(email);
		
		test.log(LogStatus.INFO, "Changing password");
		editUser.changePassword(newPassword, confirmPassword);
		
		test.log(LogStatus.INFO, "Editing job role");
		editUser.changeJobRole(role);
		
		test.log(LogStatus.INFO, "Updating new details");
		editUser.update();
		Thread.sleep(1000);

		editUser.clickOk();
	
		Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "Verifying whether the new details are updated");
		Assert.assertTrue(editUser.verifyUpdate(newUserName, firstName, lastName, role));

	}
	@Test (priority=5)
	public void GL_Settings_UM_7_verifyGoBackFromDeleteUser() throws InterruptedException{
	
		test=report.startTest("Verifying go back from delete user page");
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		test.log(LogStatus.INFO, "selecting user to be deleted");
		deleteUser.selectUserToDelete(user1);
		
		//deleteUser.selectUserToDelete(userDelete);
		test.log(LogStatus.INFO, "Going back from Delete user page");
		deleteUser.goBack();
		
		test.log(LogStatus.INFO, "Verifying whether it is navigated to manage user page");
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	@Test (priority=6)
	public void GL_Settings_UM_6_verifyCancelDeleteUser() throws InterruptedException{
		
		test=report.startTest("Verify Cancelling delete user");
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		test.log(LogStatus.INFO, "Selecting the user to be deleted");
		deleteUser.selectUserToDelete(user1);
		
		test.log(LogStatus.INFO, "Clicking delete user");
		deleteUser.deleteUsers();
		
		test.log(LogStatus.INFO, "selecting cancel in conformation message");
		deleteUser.CancelDeleteUser();
		
		test.log(LogStatus.INFO, "Verifying whether it is navigated to delete user page");
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	
	
@Test(priority=7)
public void GL_Settings_UM_5_verifyDeleteUser() throws InterruptedException{
	test=report.startTest("Verify deleting user");
	deleteUser = new DeleteUser(driver);
	settingPage = new SettingsPage(driver);
	leftPanel = new CommonPageLeftPane(driver);
	
	test.log(LogStatus.INFO, "Selecting the user top be deleted");
	deleteUser.selectUserToDelete(newUserName);
	
	test.log(LogStatus.INFO, "Deleting the user");
	deleteUser.deleteUsers();
	
	
	//leftPanel.clickSettings();
	
	//settingPage.clickManageUsersBtn();
	Thread.sleep(5000);
	
	test.log(LogStatus.INFO, "Verifying the page");
	Assert.assertTrue(deleteUser.getTitle());
	
	test.log(LogStatus.INFO, "Verifying deleted or not");
	Assert.assertTrue(deleteUser.verifyDelete(newUserName));
	
	//deleteUser.verifyDelete(userDelete);
	
}


}
