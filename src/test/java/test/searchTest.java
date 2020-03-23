package test;
import org.testng.annotations.Test;

import com.home.base.BaseTest;
import com.home.base.TestUtilities;
import com.homes.pages.HomePage;

public class searchTest extends TestUtilities {

	
	/* Test entering Miami in search box */
	@Test
	public void searchTestMiami() {
		log.info("Starting search test");

		// open main page
		HomePage homes = new HomePage(driver, log);
		homes.openPage();
		sleep(1000);
		
		homes.search("Miami");
		
		homes.find6thListing();
		sleep(1000);
	}
	
	/* Test entering Los Angeles in search box */
	@Test
	public void searchTestLosAngeles() {
		log.info("Starting search test");

		// open main page
		HomePage homes = new HomePage(driver, log);
		homes.openPage();
		sleep(1000);
		
		homes.search("Los");
		
		homes.find6thListing();
		sleep(1000);
	}
	
	/* Test entering Seattle in search box */
	@Test
	public void searchTestSeattle() {
		log.info("Starting search test");

		// open main page
		HomePage homes = new HomePage(driver, log);
		homes.openPage();
		sleep(1000);
		
		homes.search("Seattle");
		
		homes.find6thListing();
		sleep(1000);
	}
	
	
}
