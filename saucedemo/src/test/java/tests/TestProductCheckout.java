package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import util.ReadTestData;

public class TestProductCheckout extends TestBase{
	
	@Test(dataProvider="getCsvData", dataProviderClass=ReadTestData.class, description="productCheckout.csv")
	public void verifyProductCheckout(String productName, String firstName, String lastName, String zipcode, String title) {		
		
		String is_product_added = homePage
			.goToHomePage()
			.addProductToCart(productName)
			.clickOnCartLink()
			.clickOnCheckoutButton()
			.enterFirstName(firstName)
			.enterLastName(lastName)
			.enterZipCode(zipcode)
			.clickOnContinue()
			.clickOnFinish()
			.getPageTitle();
				
		Assert.assertEquals(is_product_added, title, "product is not checkout to cart");
		
	}

}
