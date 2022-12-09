package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void sauceDemoTest(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.className("btn_action")).click();

        driver.findElement(By.cssSelector("[alt $= Light")).click();

        driver.findElement(By.xpath("//button [contains(text(),'Add to cart')]")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Bike Light");
        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$9.99");
    }
}
