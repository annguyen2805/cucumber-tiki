package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pageObject.HomePageObject;
import pageObject.PageGeneratorManager;

public class HomePageSteps extends AbtractPage {
	WebDriver driver;
	HomePageObject homePage;
	public static String nameProduct;
	public HomePageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomepage(driver);
	}
	
	@When("^I input to search textbox with \"([^\"]*)\"$")
	public void iInputToSearchTextboxWith(String value) {
		homePage.cancelPopup();
		homePage.inputToSearchTextbox(value);
	}

	@When("^I click to search button$")
	public void iClickToSearchButton() {
		homePage.clickToSearchButton();
	}

	@When("^I click to Tiki Now$")
	public void iClickToTikiNow() {
		homePage.clickToTikiNowCheckbox();
		homePage.handelPopupAddress();
	}

	@When("^I select the product$")
	public void iSelectTheProduct() {
		nameProduct= homePage.getTitleProduct();
		homePage.chooseProduct();
	}

	
}
