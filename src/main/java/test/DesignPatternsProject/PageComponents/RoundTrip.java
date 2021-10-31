package test.DesignPatternsProject.PageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;
import abstractComponents.SearchFlightAvail;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

	public RoundTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
	}

	private By roundTripButton = By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By cb = By.id("ctl00_mainContent_chk_IndArm");
	private By sb = By.id("ctl00_mainContent_btn_FindFlights");

	public void checkAvail1(HashMap<String, String> reservationDetails) {

		System.out.println("I am inside RoundTrip Trip");
		findElement(roundTripButton).click();
		selectOriginCity(reservationDetails.get("origin"));
		selectDestinationCity(reservationDetails.get("destination"));
		findElement(cb).click();
		findElement(sb).click();
	}

	public void selectOriginCity(String origin) {

		findElement(from).click();
		findElement(By.xpath("//a[@value='" + origin + "']")).click();

	}

	public void selectDestinationCity(String destination) {

		findElement(to).click();
		findElement(By.xpath("//a[@value='" + destination + "']")).click();

	}

	public void checkAvail(HashMap<String, String> reservationDetails) {
		// TODO Auto-generated method stub

	}

}
