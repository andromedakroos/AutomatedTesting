package stepDefs;

import baseEntities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.en.Given;

public class SauceDemoE2EDefs extends BaseCucumberTest{
    private BaseCucumberTest baseCucumberTest;
    public SauceDemoE2EDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("open login page")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
        driver.get("https://www.saucedemo.com");
    }
}
