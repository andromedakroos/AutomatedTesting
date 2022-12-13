package baseEntities;

import org.openqa.selenium.WebDriver;
import steps.UserStep;

public class BaseStep {
    protected WebDriver driver;
    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }
}
