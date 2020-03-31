package com.homes.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomeForSalePage extends BasePageObject {

	
	public HomeForSalePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void verifyAllLinks() {
		log.info("Verifying all the links in the current page");
		indexLinks(null);
	}
}
