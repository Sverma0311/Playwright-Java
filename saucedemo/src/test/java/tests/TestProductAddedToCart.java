package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import util.ReadTestData;

public class TestProductAddedToCart extends TestBase{
	
	@Test(dataProvider="getCsvData", dataProviderClass=ReadTestData.class, description="productAddedToCart.csv")
	public void verifyProductAddedToCart(String p1, String p2) {		
		boolean is_product_added = homePage
			.goToHomePage()
			.addProductToCart(p1)
			.clickOnCartLink()
			.isProductPresent(p2);
		Assert.assertEquals(is_product_added, true, "product is not added to cart");
		
	}

}
