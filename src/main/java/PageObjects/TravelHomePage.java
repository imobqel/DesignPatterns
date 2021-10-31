package PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.SearchFlightAvail;
import abstractComponents.StrategyFactor;
import test.DesignPatternsProject.PageComponents.FooterNavigation;
import test.DesignPatternsProject.PageComponents.MultiTrip;
import test.DesignPatternsProject.PageComponents.NavigationBar;

public class TravelHomePage {

	public TravelHomePage(WebDriver driver) {

		this.driver = driver;
	}

	By sectionElement = By.id("traveller-home");
	By footerNavSectionElement = By.id("buttons");
	WebDriver driver;
	SearchFlightAvail searchFlightAvail;

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	}

	public NavigationBar getNavigationBar() {

		return new NavigationBar(driver, footerNavSectionElement);

	}

	public FooterNavigation getFooterNavigation() {

		return new FooterNavigation(driver, sectionElement);

	}

	// To define which section to go into
	public void setBookingStrategy(String strategyType) {

		StrategyFactor strategyFactor = new StrategyFactor(driver);
		searchFlightAvail = strategyFactor.createStrategy(strategyType);
		this.searchFlightAvail = searchFlightAvail;

	}

	public void checkAvail(HashMap<String, String> reservationDetails) {

		searchFlightAvail.checkAvail(reservationDetails);

	}

}
