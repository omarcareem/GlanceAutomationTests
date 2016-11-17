package com.glance.dashboard.tests;

import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.dashboard.AddElementWizardPage;

public class VerifyAddElementWizard extends BaseTest{
	
	@Test
	public void myFirstTest(){
		AddElementWizardPage wizardPage = new AddElementWizardPage(driver);
		wizardPage.enterFooter("Test");
	}

}
