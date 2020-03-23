package com.homes.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.home.base.TestUtilities;

public class HomePage extends BasePageObject {

	//home page url
	private String pageUrl = "http://homes.com";
	
	//webelement for searchbox
    private By homeSearchBox = By.xpath("//div[@class='bg-white flex space-between items-center mt-1']/input[@class='autosuggest-input w-full subtitle subtitle--m font-weight--regular bg-white' and 1]"); // search box
    
    //webelement for search button
	private By homeSearchButton = By.xpath("//span[@class='icon icon--search select-none search-icon font-color--white']"); //search address button
	 	
	
	
	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	/** Open homes homepage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Search through given text in search box */
	public void search(String txt) {
		log.info("clicking search box");
		click(homeSearchBox);
		
		log.info("Type text into address bar");
		type(txt, homeSearchBox);
		
		log.info("searching to recommended location");
		TestUtilities.sleep(8000);
		driver.findElement(homeSearchBox).sendKeys(Keys.DOWN, Keys.ENTER);
		TestUtilities.sleep(3000);
		log.info("Navigating to " + driver.getCurrentUrl());
	}
	
	/** Find the 6th listing in each search */
	public void find6thListing() {
		log.info("Looking for 6th element in div class property list");
		TestUtilities.sleep(3000);
		driver.findElement(By.xpath("//article[@id='undefinedCa-7']/div[@class='property-card__inner' and 1]/span[@class='pointer pointer' and 1]/div[@class='property-card-content grid-cell property-card-content--short-card' and 1]/div[@class='property-card-content__inner grid grid--column' and 1]/div[@class='property-card-content__description-wrapper' and 1]/div[@class='description-wrapper__column column column--description' and 1]")).click();
		TestUtilities.sleep(3000);
		log.info("Opening property page in" + driver.getCurrentUrl());
	}
	
	
}
