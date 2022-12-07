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

public class LaminateCalculatorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void laminateCalculatorTest(){
        driver.get("https://calc.by/building-calculators/laminate.html");

        driver.findElement(By.xpath("//a[contains(text(),'Принять и закрыть')]")).click();

        WebElement methodType = driver.findElement(By.id("laying_method_laminate"));
        Select selectHeatingType = new Select(methodType);
        selectHeatingType.selectByValue("0");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement laminatLength = driver.findElement(By.id("ln_lam_id"));
        laminatLength.clear();
        laminatLength.sendKeys("2000");

        WebElement laminatWidth = driver.findElement(By.id("wd_lam_id"));
        laminatWidth.clear();
        laminatWidth.sendKeys("200");

        driver.findElement(By.xpath("//label[contains(text(),'по ширине комнаты')]")).click();

        driver.findElement(By.className("calc-btn")).click();

        driver.findElement(By.className("mfp-close")).click();

       WebElement countOfPlanks =  driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]/span"));
        Assert.assertEquals(countOfPlanks.getText(),"51");

        WebElement countOfLaminatPacks =  driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]/span"));
        Assert.assertEquals(countOfLaminatPacks.getText(),"7");



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
