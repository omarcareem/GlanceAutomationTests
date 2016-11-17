package com.glance.dashboard.tests;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.AddElementWizardPage;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyAddElementWizard extends BaseTest{
	
	LoginPage loginPage;
	CommonPageObject commonPage;
	DashboardPage dashBoardPage;
	
	@Test
	public void verifyAddNewDashboardElement(){
		
		
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		commonPage = new CommonPageObject(driver);
		commonPage.waitForPageLoad(10);
		dashBoardPage= new DashboardPage(driver);
		
		dashBoardPage.selectAddNewElement();
		commonPage.waitForPageLoad(10);
		
		AddElementWizardPage wizardPage = new AddElementWizardPage(driver);
		wizardPage.selectMetric("Other Bar Chart");
		wizardPage.enterMetricTitle("Test Other Bar Chart");
		wizardPage.enterFooter("Bar chart footer");
		wizardPage.enterDescription("Bar chart description");
		wizardPage.clickFirstPageNextButton();
		commonPage.waitForPageLoad(5);
	}

}
