package com.glance.common.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.logs.TestLog;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends ReadPropertyFile {

	// @Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void initializeTest() throws IOException {

		try {
			if (browser != null) {
				TestLog.log.info("Openning browser");
				try {
					if (browser.equalsIgnoreCase("firefox")) {
						System.setProperty("webdriver.gecko.driver", geckoDriverPath);
						TestLog.log.info("Creating firefox profile");

						FirefoxProfile profile = new FirefoxProfile();
						TestLog.log.info("Created a new firefox profile");
						TestLog.log.info("Accepting untrusted cert");
						profile.setAcceptUntrustedCertificates(true);
						DesiredCapabilities fireFoxCap = DesiredCapabilities.firefox();
						fireFoxCap.setCapability(FirefoxDriver.PROFILE, profile);
						fireFoxCap.setBrowserName("firefox");
						driver = new FirefoxDriver(fireFoxCap);
						driver.manage().window().maximize();
						TestLog.log.info("Firefox browser started");

					} else if (browser.equalsIgnoreCase("chrome")) {
						System.setProperty("webdriver.chrome.driver", chromeDriverPath);
						DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
						chromeCap.setBrowserName("chrome");
						driver = new ChromeDriver(chromeCap);
						driver.manage().window().maximize();
						TestLog.log.info("Chrome browser started");

					} else if (browser.equalsIgnoreCase("ie")) {
						System.setProperty("webdriver.ie.driver", ieDriverPath);
						DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
						ieCap.setBrowserName("ie");
						driver = new InternetExplorerDriver(ieCap);
						driver.manage().window().maximize();
						TestLog.log.info("IE browser started");
					}
					TestLog.log.info("Maximizing the window");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					TestLog.log.info("Navigating to; " + baseUrl);
					driver.get(baseUrl);
				} catch (Exception e) {
					System.out.println("Not able to open the browser: " + e.getMessage());
					TestLog.log.info("Not able to open the browser: " + e.getMessage());
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			TestLog.log.info("Exception: " + ex);
		}

	}

	@AfterMethod()
	public void commonTestFinish(ITestResult result) throws Exception {
		//report = new ExtentReports(reportPath);

		// test=report.startTest("VerifyBlogTitle");

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShot = RandomNameGenerator.getName();
			// String screenshot_path=Utility.captureScreenshot(driver,
			// result.getName());
			//String screenShot = test.
			CommonPageObject commonPageObject = new CommonPageObject(driver);
			String image=commonPageObject.takeScreenShotofFailure(screenShot, driver);
			
			// String failImage= logger.addScreenCapture(screenshot_path);
			// test.log(LogStatus.FAIL, "Title verification", image);
			String failImage= test.addScreenCapture(image);
			test.log(LogStatus.FAIL, screenShot, failImage);
		}else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(LogStatus.PASS, "Test Passed");
			System.out.println("Test passed");
		}else if(result.getStatus()== ITestResult.SKIP){
			test.log(LogStatus.PASS, "Test is Skipped");
			System.out.println("Test Skipped");
		}

		

		
	}

	@AfterClass(alwaysRun = true)
	public void finishTest() {
		try {
			if (driver != null) {
				
				driver.quit();
			}
		} catch (Exception ex) {
			TestLog.log.info("Unable to quit the driver. " + ex);
		}

	}
	
	/*@BeforeTest
	public void glanceBeforeTest(){
		report.startTest("Test Started");
	}*/

}
