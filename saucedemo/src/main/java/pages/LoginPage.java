package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private static final String TEXTBOX_USERNAME = "#user-name";
	private static final String TEXTBOX_PASSWORD = "#password";
	private static final String BUTTON_LOGIN = "#login-button";
	Page page;
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public LoginPage enterUserName(String name) {
		page.fill(TEXTBOX_USERNAME, name);
		
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		page.fill(TEXTBOX_PASSWORD, password);
		
		return this;
	}
	
	public HomePage clickOnLoginButton() {
		page.click(BUTTON_LOGIN);
		
		return new HomePage(page);
	}
	
	
}
