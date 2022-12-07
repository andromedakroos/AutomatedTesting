package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WarmFloorCalcTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }
    @Test
    public void warmFloorCalculatorTest(){
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("4");
        driver.findElement(By.id("el_f_lenght")).sendKeys("5");

        WebElement roomType = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(roomType);
        selectRoomType.selectByValue("2");


        WebElement heatingType = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(heatingType);
        selectHeatingType.selectByValue("3");

        driver.findElement(By.id("el_f_losses")).sendKeys("2141");
        driver.findElement(By.cssSelector("[name='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"),
                "1191");

        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"),
                "60");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
