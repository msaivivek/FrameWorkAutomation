package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	public static FileInputStream fis2;
	public static Properties locatorProp;
	
	@BeforeTest
	public void filesUp() throws IOException{
		fis1=new FileInputStream("config.properties");
		configProp=new Properties();
		configProp.load(fis1);
		
		fis2=new FileInputStream("locator.properties");
		locatorProp=new Properties();
		locatorProp.load(fis2);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
