package com.homes.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.home.base.TestUtilities;

public class HomePage extends BasePageObject {

	//home page url
	private String pageUrl = "http://homes.com";
	
	//homes.com page title
	private String title = "Homes.com - Homes for Sale, Homes for Rent and Real Estate Listings";
	
	//webelement for searchbox
	@FindBy(how = How.XPATH, using = "//div[@class='bg-white flex space-between items-center mt-1']/input[@class='autosuggest-input w-full subtitle subtitle--m font-weight--regular bg-white' and 1]")
	private WebElement homeSearchBox;
	
	//searchButton
	@FindBy(how = How.XPATH, using = "//span[@class='icon icon--search select-none search-icon font-color--white']")
	private WebElement homeSearchButton;
	
	//SixthListing
	@FindBy(how = How.XPATH, using = "//article[@id='undefinedCa-7']/div[@class='property-card__inner' and 1]/span[@class='pointer pointer' and 1]/div[@class='property-card-content grid-cell property-card-content--short-card' and 1]/div[@class='property-card-content__inner grid grid--column' and 1]/div[@class='property-card-content__description-wrapper' and 1]/div[@class='description-wrapper__column column column--description' and 1]")
	private WebElement sixthListing;
	
	
	
	
	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	/** Open homes homepage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
		verifyTitle(title);
	}

	/** Search through given text in search box */
	public void search(String txt) {
		log.info("clicking search box");
		homeSearchBox.click();
		
		log.info("Type text into address bar");
		homeSearchBox.sendKeys(txt);
		
		log.info("searching to recommended location");
		TestUtilities.sleep(8000);
	
		homeSearchBox.sendKeys(Keys.DOWN, Keys.ENTER); // search dropdown
		
		TestUtilities.sleep(3000);
		log.info("Navigating to " + getCurrentUrl());
	}
	
	/** Find the 6th listing in each search */
	public void find6thListing() {
		log.info("Looking for 6th element in div class property list");
		TestUtilities.sleep(3000);
		sixthListing.click();
		TestUtilities.sleep(3000);
		log.info("Opening property page in" + driver.getCurrentUrl());
	}
	
	
}
