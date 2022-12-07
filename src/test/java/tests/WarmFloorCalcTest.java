package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WarmFloorCalcTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    public void warmFloorCalculatorTest(){
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        driver.findElement(By.id("el_f_width")).sendKeys("4");
        driver.findElement(By.id("el_f_lenght")).sendKeys("5");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
