package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import steps.UserStep;

public class FirstStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    public FirstStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("открыт браузер")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("страница логина открыта")
    @Given("дубликат шага")
    public void openLoginPage(){
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("поле username отображается")
    public void isUsernameDisplayed(){
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @Then("поле password отображается")
    public void isPasswordDisplayed(){
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
    }

    @Then("но ошибка не отображается")
    public void isErrorDisplayed() {
        Assert.assertFalse(loginPage.getErrorTextElement().isDisplayed());
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        UserStep userStep = new UserStep(driver);
        dashBoardPage = userStep.loginSuccessful(username,password);
    }

    @Then("title is {string}")
    public void titleIs(String title) {
        Assert.assertEquals(title, dashBoardPage.getTitle());
    }

    @And("project id is {int}")
    public void projectIdIs(int value) {
        Assert.assertEquals(value, 123);
    }
}
