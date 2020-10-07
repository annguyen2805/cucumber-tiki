package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import PageUI.ProductPageUI;
import commons.AbtractPage;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;

public class ProductPageSteps extends AbtractPage {
	WebDriver driver;

	public ProductPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
	}

	@Then("^Verify product information has been selected$")
	public void verifyProductInformationHasBeenSelected() {
		waitForElementVisble(driver, ProductPageUI.TEXT_TITTLE);
		Assert.assertEquals(homePageSteps.nameProduct, getTextElement(driver, ProductPageUI.TEXT_TITTLE));

		if (homePageSteps.nameProduct.contains(getTextElement(driver, ProductPageUI.TEXT_TITTLE))) {
			waitForElementVisble(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX);
			sendkeyToElement(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX, "2");
			sendKeyboardToElement(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX, Keys.TAB);

			waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
			clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);

			waitForElementClickable(driver, ProductPageUI.CART_BUTTON);
			clickToElement(driver, ProductPageUI.CART_BUTTON);

			waitForElementVisble(driver, ProductPageUI.PRICE_TEXT);

			float price = Float.parseFloat(getTextElement(driver, ProductPageUI.PRICE_TEXT).replace("đ", "").trim());
			price = price * 2;

			float priceTotal = Float.parseFloat(getTextElement(driver, ProductPageUI.TOTAL_PRICE).trim());

			Assert.assertTrue(price == priceTotal);

		} else {
			driver.quit();
		}
	}
}
