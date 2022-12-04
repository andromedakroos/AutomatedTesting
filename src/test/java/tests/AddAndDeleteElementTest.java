package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddAndDeleteElementTest {
    private BrowserFactory browserFactory = new BrowserFactory();
    private WebDriver driver = browserFactory.getDriver();

    @Test
    public void AddAndDeleteElementsTest(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
    }

}
