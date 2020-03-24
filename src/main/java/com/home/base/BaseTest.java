package com.home.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;
	// use for logging purposes
	protected Logger log;
	
	
	
	//This runs before every execution
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, ITestContext context) {
		
		String testName = context.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
	}

	//This runs every execution
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Close driver");
		// Close the browser
		driver.quit();
	}

}
