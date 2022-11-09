package pages;

import com.microsoft.playwright.Page;

public class CartPage {
	Page page;
	private static final String BUTTON_REMOVE = "#remove-sauce-labs-backpack";
	private static final String BUTTON_CONTINUE_SHOPPING = "#continue-shopping";
	private static final String BUTTON_CHECKOUT = "#checkout";
	
	
	public CartPage(Page page) {
		this.page = page;
	}
	
	public void clickOnRemoveButton() {
		page.click(BUTTON_REMOVE);
	}
	
	public void clickOnContinueShoping() {
		page.click(BUTTON_CONTINUE_SHOPPING);
	}
	
	public CheckoutPage clickOnCheckoutButton() {
		page.click(BUTTON_CHECKOUT);
		
		return new CheckoutPage(page);
	}
	
	public boolean isProductPresent(String name){
		String locator = "text="+name;		
		return page.isVisible(locator);
	}

}
