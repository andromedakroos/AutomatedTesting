package stepDefs;

import baseEntities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoLoginPage;


public class SauceDemoE2EDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    public SauceDemoE2EDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

//    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
    @Given("open login page")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com");
    }

    @And("user {string} with password {string} logged in")
    public void login(){

    }
    @And("add item in the cart")
    public void addItemInTheCart() {
    }

    @And("open cart page")
    public void openCartPage() {
        
    }

    @And("open checkout page")
    public void openCheckoutPage() {
        
        
    }

    @And("input data for checkout name {string}, lastname {string}, zipcode {string}")
    public void inputDataForCheckoutNameLastnameZipcode(String arg0, String arg1, String arg2) {
    }

    @When("checkout is completed")
    public void checkoutIsCompleted() {
        
    }

    @Then("open finish page")
    public void openFinishPage() {
    }
}
