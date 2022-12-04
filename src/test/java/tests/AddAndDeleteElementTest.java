package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddAndDeleteElementTest {
    private BrowserFactory browserFactory = new BrowserFactory();
    private WebDriver driver = browserFactory.getDriver();
    Actions actions = new Actions(driver);
    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);

    @Test
    public void AddAndDeleteElementsTest() throws InterruptedException {
        int count = 0;
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add Element']")));
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        actions.doubleClick(addButton).perform();
        actions.doubleClick(addButton).perform();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
//        count = driver.findElements(By.xpath("//button[text()='Add Element']")).size();
        List<WebElement> list = driver.findElements(By.xpath("//button[text()='Add Element']"));
        count = list.size();
        System.out.println("Elements on the page: " + count);
//        driver.quit();

    }

}
