package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
	Page page;
	private static final String TEXTBOX_FIRST_NAME = "#first-name";
	private static final String TEXTBOX_LAST_NAME = "#last-name";
	private static final String TEXTBOX_ZIP_CODE = "#postal-code";
	private static final String BUTTON_CANCEL = "#cancel";
	private static final String BUTTON_CONTINUE = "#continue";
	private static final String BUTTON_FINISH = "#finish";
	private static final String TITLE = "//*[@class='complete-header']";
	
	public CheckoutPage(Page page) {
		this.page = page;
	}
	
	public CheckoutPage enterFirstName(String firstName) {
		page.fill(TEXTBOX_FIRST_NAME, firstName);
		
		return this;		
	}
	
	public CheckoutPage enterLastName(String lastName) {
		page.fill(TEXTBOX_LAST_NAME, lastName);
		
		return this;		
	}
	
	public CheckoutPage enterZipCode(String zipCode) {
		page.fill(TEXTBOX_ZIP_CODE, zipCode);
		
		return this;		
	}
	
	public CartPage clickOnCancel() {
		page.click(BUTTON_CANCEL);
		
		return new CartPage(page);
	}
	
	public CheckoutPage clickOnContinue() {
		page.click(BUTTON_CONTINUE);
		
		return this;
	}
	
	public CheckoutPage clickOnFinish() {
		page.click(BUTTON_FINISH);
		
		return this;
	}
	
	public String getPageTitle() {
		
		return page.innerText(TITLE);
	}
	

}
