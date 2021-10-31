package test.DesignPatternsProject.PageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;
import abstractComponents.SearchFlightAvail;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

	public MultiTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		// TODO Auto-generated constructor stub
	}

	private By modalPopUp = By.id("MultiCityModelAlert");

	public void checkAvail(String origin, String destination) {
		
		// Below, consumer is another method that will be called after the consumer.accept
//		makeStateReady(s->selectOriginCity(origin));

	}

	public void makeStateReady(Consumer<MultiTrip> consumer) {

		System.out.println("I am inside Multi Trip");
		findElement(modalPopUp).click();
		System.out.println("finished");

		consumer.accept(this);

	}

	public void checkAvail(HashMap<String, String> reservationDetails) {
		// TODO Auto-generated method stub
		
	}

}
