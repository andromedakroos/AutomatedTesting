package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExampleTest {
    @Test
    public void ExampleTest() throws InterruptedException {
        // Создаем экземпляр WebDriver
        // Следует отметить что скрипт работает с интерфейсом,
        // а не с реализацией.
        WebDriver driver = new ChromeDriver();

        // Открываем гугл, используя драйвер
        driver.get("http://www.google.com");
        // По-другому это можно сделать так:
        // driver.navigate().to("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();


        // Находим элемент по атрибуту name
        WebElement element = driver.findElement(By.name("q"));

        // Вводим текст
        element.sendKeys("Selenium");

        // Отправляем форму, при этом дравер сам определит как отправить форму по элементу
        element.submit();

        // Проверяем тайтл страницы
        System.out.println("Page title is: " + driver.getTitle());

        // Страницы гугл динамически отрисовывается с помощью javascript
        // Ждем загрузки страницы с таймаутом в 10 секунд
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium");
            }
        });

        // Ожидаем увидеть: "Selenium - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Закрываем браузер
        driver.quit();
    }
}

