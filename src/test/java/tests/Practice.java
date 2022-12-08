package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practice {
    private BrowserFactory browserFactory = new BrowserFactory();
    private WebDriver driver = browserFactory.getDriver();
    Actions actions = new Actions(driver);
    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);

    @Test
    public void AddAndDeleteElementsTest() throws InterruptedException {
        int count = 0;
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        System.out.println();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add Element']")));
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        actions.doubleClick(addButton).perform();
        actions.doubleClick(addButton).perform();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        count = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        System.out.println("Elements on the page: " + count);
        driver.quit();
    }

    @Test
    public void checkboxTest(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        Assert.assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());

        Assert.assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select selectOption = new Select(dropdown);
        selectOption.selectByValue("1");
        Assert.assertEquals(selectOption.getFirstSelectedOption().getText(), "Option 1");

        selectOption.selectByValue("2");
        Assert.assertEquals(selectOption.getFirstSelectedOption().getText(), "Option 2");

        driver.quit();
    }

    @Test
    public void inputsTest(){
        int i = 0;
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));

        inputField.sendKeys("aaaaaaaaaaaaaaaaa");
        inputField.clear();

        inputField.sendKeys("1312312312312312");
        inputField.clear();

        while (i != 112) {
            inputField.sendKeys(Keys.ARROW_UP);
            i++;
        }
        i = 0;

        while (i != 120) {
            inputField.sendKeys(Keys.ARROW_DOWN);
            i++;
        }
        driver.quit();

    }

}
