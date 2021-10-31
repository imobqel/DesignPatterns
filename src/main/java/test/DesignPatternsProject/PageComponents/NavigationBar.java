package test.DesignPatternsProject.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {

	By flights = By.cssSelector("[title='Flights']");

	public NavigationBar(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		// TODO Auto-generated constructor stub
	}

	public void getFlightAttribute() {

		System.out.println("Attribute is : " + findElement(flights).getAttribute("class"));
	}

}
