package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;
import commons.AbtractPage;
import pageUI.ProductPageUI;

public class ProductPageObject extends AbtractPage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	HomePageObject homePage;
	public void verifyInformationProduct(String title) {
		waitForElementVisble(driver, ProductPageUI.TEXT_TITTLE);		
		if (title.equals(getTextElement(driver, ProductPageUI.TEXT_TITTLE))) {
			sleepInSecond(1);
			waitForElementVisble(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX);
			sendkeyToElement(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX, "2");
			sendKeyboardToElement(driver, ProductPageUI.SIZE_PRODUCT_TEXTBOX, Keys.TAB);
			sleepInSecond(1);
			
			waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
			clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
			
			sleepInSecond(1);

			waitForElementClickable(driver, ProductPageUI.CART_BUTTON);
			clickToElement(driver, ProductPageUI.CART_BUTTON);
			
			waitForElementVisble(driver, ProductPageUI.SIZE_PRODUCT);
			Assert.assertTrue(isElementDisplayed(driver,  ProductPageUI.SIZE_PRODUCT));
			
			waitForElementVisble(driver, ProductPageUI.TOTAL_PRICE);
			Assert.assertTrue(isElementDisplayed(driver,  ProductPageUI.TOTAL_PRICE));
			
		} else {
			driver.quit();
		}
	}
}
