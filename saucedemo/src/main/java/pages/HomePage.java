package pages;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class HomePage {
	Page page;	
	private static final String DROPDOWN_SORTING = "//*[@class='product_sort_container']";
	private static final String LINK_CART = "//*[@class='shopping_cart_link']";
	private static final String BUTTON_MENU = "#react-burger-menu-btn";
	private static final String LINK_ALL_ITEMS = "#inventory_sidebar_link";
	
	public HomePage(Page page) {
		this.page = page;		
	}
	
	public HomePage goToHomePage() {
		boolean isAlreadyLogin = page.isVisible("text='Products'");		
		if(!isAlreadyLogin) {
			page.click(BUTTON_MENU);
			page.click(LINK_ALL_ITEMS);
		}
		
		return this;
	}

	
	public String getHomePageTitle() {
		System.out.println(page.title());
		return page.title();
	}
	
	public HomePage selectSortingOption(int index) {
		page.selectOption(DROPDOWN_SORTING, new SelectOption().setIndex(index));
		
		return this;		
	}
	
	public HomePage addProductToCart(String name) {
		String locator = "#add-to-cart-"+name;
		System.out.println("locator: "+locator);
		/*page.screenshot(new Page.ScreenshotOptions()
				  .setPath(Paths.get("screenshot2.png"))
				  .setFullPage(true));*/
		//page.locator(locator).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
		page.click(locator);
		
		return this;
	}
	
	public CartPage clickOnCartLink() {
		page.click(LINK_CART);
		
		return new CartPage(page);
	}
	
	

}
