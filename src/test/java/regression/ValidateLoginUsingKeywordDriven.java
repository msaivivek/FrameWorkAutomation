package regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLoginUsingKeywordDriven extends BaseTest{
	
	@Test
	public void ValidateLoginTest() {
		ApplicationKeywords app=new ApplicationKeywords();
		app.lunchBrowser();
		app.lunchApp();
		app.type("username_textBox", "reyaz0806");
		app.type("passwowrd_textBox", "reyaz123");
		app.click("login_button");
		app.validateTitle("Adactin.com - Search Hotel");
		
	}
	
	

}
