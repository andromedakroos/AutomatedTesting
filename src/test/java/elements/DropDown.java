package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class DropDown {
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;
    public DropDown(WebDriver driver, String attributeNameValue){
        UIElement dropDown = new UIElement(driver, By.id(attributeNameValue));
        uiElementList = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.name(attributeNameValue))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(new UIElement(driver, webElement));
            valueList.add(element.getAttribute("value"));
            textList.add(element.findUIElement(By.xpath("parent::*/strong")).getText().trim());
        }
    }

}
