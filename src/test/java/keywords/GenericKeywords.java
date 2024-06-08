package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class GenericKeywords extends BaseTest {

	public void lunchBrowser() {
		String browserName = configProp.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

	}

	public void lunchApp() {
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicityWait"))));
	}

	public void type(String locatorkey, String text) {
		//driver.findElement(By.xpath(configProp.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);

	}

	public WebElement getElement(String locatorkey) {
		WebElement element = null;
		element = driver.findElement(getLocator(locatorkey));

		return element;

	}
	
	public void click(String locatorKey) {
		getElement(locatorKey).click();
		
	}
	public void clear(String locatorkey) {
		getElement(locatorkey).clear();
	}
	
	public void selectOptionsFromDropdown(String locatorkey ,String options) {
		new Select(getElement(locatorkey)).selectByValue(options);
	}

	public By getLocator(String locatorKey) {
		By by = null;
		if (locatorKey.endsWith("_id")) {
			by = By.id(locatorProp.getProperty(locatorKey));

		} else if (locatorKey.endsWith("_name")) {
			by = By.name(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_linkText")) {
			by = By.linkText(locatorProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(locatorProp.getProperty(locatorKey));
		}else {
			by = By.xpath(locatorProp.getProperty(locatorKey));
		}

		return by;

	}
}
