package steps;

import baseEntities.BaseStep;
import models.UserGUI;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw){
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }
    public DashBoardPage loginSuccessful(String email, String psw){
        login(email,psw);

        return new DashBoardPage(driver);
    }

    public DashBoardPage loginSuccessful(UserGUI user){
       return loginSuccessful(user.getEmail(),user.getPassword());
    }

    public LoginPage loginIncorrect(String email, String psw){
        login(email,psw);

        return loginPage;
    }

}
