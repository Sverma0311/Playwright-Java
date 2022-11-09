package base;

import java.nio.file.Paths;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.microsoft.playwright.*;

import pages.HomePage;
import pages.LoginPage;
import util.ReadPropertiesFile;

public class TestBase {
	static Playwright playwright;
	protected static Page page;
	protected static HomePage homePage;
	
	@BeforeSuite
	public void setup(){
		playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		page = browser.newPage();
		page.navigate("https://www.saucedemo.com/");		
		login();
		homePage= new HomePage(page);		
	}
	
	public HomePage login() {
		LoginPage login = new LoginPage(page);			
		login.enterUserName("standard_user")
		.enterPassword("secret_sauce")
		.clickOnLoginButton();
		
		return new HomePage(page);
	}
	
	public void takeScreenshot() {
		page.screenshot(new Page.ScreenshotOptions()
				  .setPath(Paths.get("screenshot.png"))
				  .setFullPage(true));
	}
	
	@AfterSuite
	public void tearDown() {
		page.close();		
	}
}
