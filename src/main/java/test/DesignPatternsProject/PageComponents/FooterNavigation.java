package test.DesignPatternsProject.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {

	// method to handle flights
	// scope os selenium should be in the footer only

	WebDriver driver;

	By sectionElement = By.id("traveller-home");
	By flights = By.cssSelector("[title='Flights']");
	By links = By.cssSelector("a");

	public FooterNavigation(WebDriver driver, By sectionElement) {
		super(driver, sectionElement); // when you inherit parent you should invoke poarent class constructor in your
										// own child constructor
	}

	public void getFlightAttribute() {

		System.out.println("Attribute is : " + findElement(flights).getAttribute("class"));
	}

	public void getLinkCount() {

		System.out.println(findElements(links).size());

	}

}
