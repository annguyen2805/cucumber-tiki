package stepDefinitions;

import org.openqa.selenium.WebDriver;

import PageUI.HomePageUI;
import commons.AbtractPage;

import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class homePageSteps extends AbtractPage {
	WebDriver driver;
	
	public homePageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
	}
	public static String nameProduct;
	
	@When("^I input to search textbox with \"([^\"]*)\"$")
	public void iInputToSearchTextboxWith(String value) {
		waitForElementVisble(driver, HomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, value);
	}

	@When("^I click to search button$")
	public void iClickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
	}

	@When("^I click to Tiki Now$")
	public void iClickToTikiNow() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
		
		waitForElementClickable(driver, HomePageUI.CONFIRM_BUTTON);
		clickToElement(driver, HomePageUI.CONFIRM_BUTTON);
		
		waitForElementVisble(driver, HomePageUI.CITY_DROPDOWN);
		selectItemIDropdown(driver, HomePageUI.CITY_DROPDOWN, "Hà Nội");
		
		waitForElementVisble(driver, HomePageUI.DISTRICT_DROPDOWN);
		selectItemIDropdown(driver, HomePageUI.DISTRICT_DROPDOWN, "Quận Hoàn Kiếm");
		
		waitForElementVisble(driver, HomePageUI.WARD_DROPDOWN);
		selectItemIDropdown(driver, HomePageUI.WARD_DROPDOWN, "Phường Cửa Nam");
		
		waitForElementClickable(driver, HomePageUI.CONFIRM_ADDRESS);
		clickToElement(driver, HomePageUI.CONFIRM_ADDRESS);
		
	}

	@When("^I select the (\\d+)th product$")
	public void iSelectTheThProduct(int arg1) {
		waitForElementVisble(driver, HomePageUI.PRODUCT_CHOSSE);
		nameProduct= getAttributeValue(driver, HomePageUI.PRODUCT_CHOSSE, "data-title");
		
		waitForElementClickable(driver, HomePageUI.PRODUCT_CHOSSE);
		clickToElement(driver, HomePageUI.PRODUCT_CHOSSE);
	}

	
}
