package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverview{
    private final By finishButtonLocator = By.id("finish");
    public SelenideElement getFinishButtonLocator(){
        return $(finishButtonLocator).shouldBe(visible);
    }
}