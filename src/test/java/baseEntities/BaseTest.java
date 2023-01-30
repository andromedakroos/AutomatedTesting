package baseEntities;

import factory.BrowserFactory;
import models.User;
import org.openqa.selenium.UnableToSetCookieException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.AddToCartStep;
import steps.CheckoutStep;
import steps.LoginStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected AddToCartStep addToCartStep;
    protected CheckoutStep checkoutStep;
    protected User user;

    @BeforeMethod
    public void setUp(ITestContext iTestContext){
        driver = new BrowserFactory().getDriver();
        loginStep = new LoginStep(driver);
        addToCartStep = new AddToCartStep(driver);
        checkoutStep = new CheckoutStep(driver);
        iTestContext.setAttribute("driver", driver);
        user = User.builder()
                .name("Andrew")
                .lastName("Moroz")
                .zipCode("30-605")
                .username("standard_user")
                .password("secret_sauce")
                .build();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}