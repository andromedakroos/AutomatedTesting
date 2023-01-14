package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    private UIElement uiElement;
    public Checkbox(WebDriver driver, String attributeName) {
        WebElement checkbox = driver.findElement(By.id(attributeName));
        this.uiElement = new UIElement(driver, checkbox);
    }

    public void select(){
        if(!uiElement.isSelected())
            uiElement.click();
    }

    public void deselect(){
        if(uiElement.isSelected())
            uiElement.click();
    }

    public boolean isSelected(){
        return uiElement.isSelected();
    }

}
