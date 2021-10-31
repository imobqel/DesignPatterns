package test.DesignPatternsProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.TravelHomePage;

public class DemoTest extends BaseTest {

	WebDriver driver;
	TravelHomePage travelHomePage;

	@BeforeTest
	public void setup() {

		driver = initializeDriver();
		travelHomePage = new TravelHomePage(driver);

	}

	@Test(dataProvider = "getData")
	public void flightTest(HashMap<String, String> reservationDetails) {

		travelHomePage.goTo();
		travelHomePage.getFooterNavigation().getFlightAttribute();
		travelHomePage.getNavigationBar().getFlightAttribute();
		travelHomePage.getFooterNavigation().getLinkCount();

		// Check availability / Strategy Design Pattern

//		travelHomePage.setBookingStrategy(new MultiTrip(driver, sectionElement));

		// Factory Design Pattern
		travelHomePage.setBookingStrategy("roundTrip");

//		travelHomePage.setBookingStrategy(new RoundTrip(driver, sectionElement));
		travelHomePage.checkAvail(reservationDetails);
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

	// Parameterizing the test data with data provider
	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * // Implementing HashMap for pairs values HashMap<String, String>
	 * reservationDetails = new HashMap<String, String>(); HashMap<String, String>
	 * reservationDetails1 = new HashMap<String, String>();
	 * 
	 * reservationDetails.put("origin", "MAA");
	 * reservationDetails.put("destination", "DEL");
	 * 
	 * reservationDetails1.put("origin", "DEL");
	 * reservationDetails1.put("destination", "MAA");
	 * 
	 * // Here, we intialize a List to hold all HashMaps and send them together
	 * List<HashMap<String, String>> l = new ArrayList();
	 * 
	 * l.add(reservationDetails); l.add(reservationDetails1);
	 * 
	 * return new Object[][] { { l.get(0) }, { l.get(1) } };
	 * 
	 * }
	 */

	// Here we will use JSON file
	// Below is a combination of (HashMap, DataProvider, JSON, Jackson, List)
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir") + "/src/test/java/test/DesignPatternsProject/dataLoads/reservationDetails.json");
		return new Object[][] { { l.get(0) }, { l.get(1) } };

	}
}
