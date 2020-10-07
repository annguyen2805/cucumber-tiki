package pageObject;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUI.HomePageUI;

public class HomePageObject extends AbtractPage {

	WebDriver driver;
	

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void cancelPopup() {
		waitForElementClickable(driver, HomePageUI.CANCEL_POPUP);
		clickToElement(driver, HomePageUI.CANCEL_POPUP);
	}
	public void inputToSearchTextbox(String value) {
		waitForElementVisble(driver, HomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, value);
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
	}

	public void clickToTikiNowCheckbox() {
		waitForElementClickable(driver, HomePageUI.TIKI_NOW_CHECKBOX);
		clickToElement(driver, HomePageUI.TIKI_NOW_CHECKBOX);
	}

	public void handelPopupAddress() {
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

	public String getTitleProduct() {
		waitForElementVisble(driver, HomePageUI.GET_TITLE_PRODUCT);
		return getAttributeValue(driver, HomePageUI.GET_TITLE_PRODUCT, "data-title");
	}

	public void chooseProduct() {
		waitForElementClickable(driver, HomePageUI.PRODUCT_CHOSSE);
		clickToElementByJS(driver, HomePageUI.PRODUCT_CHOSSE);
	}

}
