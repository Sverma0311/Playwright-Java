package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;

public class TestHomePage extends TestBase {
	
	@Test
	public void verifyHomePageTitle() {
		
		String act_title = homePage.goToHomePage().getHomePageTitle();
		Assert.assertEquals(act_title, "Swag Labs","home page title is not as expected");
	}

}
