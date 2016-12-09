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
		
		settingPage.clickManageUsersBtn();
			

}

//Test what happen when clicking cancel in edit group page
	@Test(priority=1)
	public void GL_Settings_MU_59_cancelEditPage(){
		editUser = new EditUser(driver);
		
		editUser.selectUserToEdit(userNameEdit);
		
		editUser.cancelEditPage();
		Assert.assertTrue(editUser.verifyLabl());
		
//Check whether the user name is validated or not
	}
	
	@Test(priority=2)
	public void GL_Settings_MU_58_2_checkUserNameValidation(){
		editUser = new EditUser(driver);
		
		editUser.selectUserToEdit(userNameEdit);
		editUser.editUserName(wrongUserName);
		editUser.update();
		Assert.assertTrue(editUser.verifyValidation("Please enter user name in valid length !"));
		
		editUser.clickOkWarning();
	}
	
//Check whether the e-mail is validated or not
	@Test(priority=3)
	public void GL_Settings_MU_58_3_checkEmailValidation(){
		editUser = new EditUser(driver);
			
		editUser.selectUserToEdit(userNameEdit);
		editUser.editEmail(wrongEmail);
		editUser.update();

		Assert.assertTrue(editUser.verifyValidation("You have entered an invalid email address!"));
			
		editUser.clickOkWarning();
	
	}
	
//verify edit user details
	@Test(priority=4)
	public void GL_Settings_MU_58_1_verifyEditUser() throws InterruptedException, IOException {
		editUser = new EditUser(driver);
		
		editUser.selectUserToEdit(userNameEdit);
		editUser.editUserName(newUserName);
		editUser.editFirstName(firstName);
		editUser.editLastName(lastName);
		
		//editUser.editUserImage();
		//Thread.sleep(5000);
		//Runtime.getRuntime().exec("C:\\Shobana2\\Glance\\Glance Automation\\GlanceAutomationTests\\ImageUpload.exe");
		
		editUser.editEmail(email);
		editUser.changePassword(newPassword, confirmPassword);
		editUser.changeJobRole(role);
		editUser.update();
		Thread.sleep(1000);

		editUser.clickOk();
	
		Thread.sleep(2000);
		
		Assert.assertTrue(editUser.verifyUpdate(newUserName, firstName, lastName, role));

	}
	@Test (priority=5)
	public void GL_Settings_MU_62_verifyGoBackFromDeleteUser() throws InterruptedException{
	
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		deleteUser.selectUserToDelete(user1);
		
		//deleteUser.selectUserToDelete(userDelete);
		deleteUser.goBack();
		
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	@Test (priority=6)
	public void GL_Settings_MU_61_verifyCancelDeleteUser() throws InterruptedException{
		
		deleteUser = new DeleteUser(driver);
		settingPage = new SettingsPage(driver);
		leftPanel = new CommonPageLeftPane(driver);
		
		deleteUser.selectUserToDelete(user1);
		deleteUser.deleteUsers();
		deleteUser.CancelDeleteUser();
		
		Assert.assertTrue(deleteUser.getTitle());
		
		//deleteUser.verifyDelete(userDelete);
		
		
	}
	
	
	
@Test(priority=7)
public void GL_Settings_MU_60_verifyDeleteUser() throws InterruptedException{
	
	deleteUser = new DeleteUser(driver);
	settingPage = new SettingsPage(driver);
	leftPanel = new CommonPageLeftPane(driver);
	
	
	deleteUser.selectUserToDelete(newUserName);
	deleteUser.deleteUsers();
	
	
	//leftPanel.clickSettings();
	
	//settingPage.clickManageUsersBtn();
	Thread.sleep(5000);
	
	Assert.assertTrue(deleteUser.getTitle());
	Assert.assertTrue(deleteUser.verifyDelete(newUserName));
	
	//deleteUser.verifyDelete(userDelete);
	
}


}
