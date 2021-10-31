package test.DesignPatternsProject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver initializeDriver() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		return driver;

	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

		// Convert JSON file into JSON String
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		// Help our JSON to HashMap
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> data = objectMapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

}
