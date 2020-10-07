package stepDefinitions;


import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pageObject.PageGeneratorManager;
import pageObject.ProductPageObject;

public class ProductPageSteps extends AbtractPage {
	WebDriver driver;
	ProductPageObject productPage;
	public ProductPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		productPage =PageGeneratorManager.getProductPage(driver);
	}

	@Then("^Verify product information has been selected$")
	public void verifyProductInformationHasBeenSelected() {
		productPage.verifyInformationProduct(HomePageSteps.nameProduct);
	}
}
