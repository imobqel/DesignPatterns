package abstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractComponent {

	WebElement sectionElement;

	// write here the custom findElement
	public AbstractComponent(WebDriver driver, By sectionElement) {
		this.sectionElement = driver.findElement(sectionElement);
	}

	// Below method is a customized findElement to search for webElements in
	// particular area instead of the whole page
	public WebElement findElement(By findElementBy) {

		return sectionElement.findElement(findElementBy);

	}

	public List<WebElement> findElements(By findElementsBy) {

		return sectionElement.findElements(findElementsBy);

	}

}
