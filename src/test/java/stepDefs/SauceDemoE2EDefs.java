package stepDefs;

import baseEntities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FinishPage;
import steps.AddToCartStep;
import steps.CheckoutStep;
import steps.LoginStep;

public class SauceDemoE2EDefs extends BaseCucumberTest{
    private BaseCucumberTest baseCucumberTest;
    private AddToCartStep addToCartStep;
    private CheckoutStep checkoutStep;
    private FinishPage finishPage;
    public SauceDemoE2EDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }
    @Given("open browser")
    public void openBrowser(){
        driver = new BrowserFactory().getDriver();
    }

    @Given("open login page")
    public void openSauceLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    @And("user with username {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        LoginStep loginStep = new LoginStep(driver);
        addToCartStep = loginStep.login(username, password);
    }

    @And("add item to the cart")
    public void addItemToTheCart() {
        addToCartStep.addItemToTheCart();
    }

    @And("open cart page")
    public void openCartPage(){
        checkoutStep = addToCartStep.goToCheckout();
    }

    @And("go to checkout and input data - name: {string} , lastname: {string}, zipcode: {string}")
    public void inputDataNameLastnameZipcode(String name, String lastname, String zipcode) {
       checkoutStep.checkoutYourInformation(name,lastname,zipcode);
    }

    @When("checkout successful")
    public void checkoutSuccessful() {
       finishPage = checkoutStep.checkoutOverview();
    }

    @Then("finish page opened")
    public void finishPageOpened() {
        finishPage.isFinishPageOpened();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
