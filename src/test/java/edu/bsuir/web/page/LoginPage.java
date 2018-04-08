package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Acer on 02.04.2018.
 */
public class LoginPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterLoginPage(){
        driver.get(LoginElements.URL);
    }

    public void typeUsername(String username){
      LoginElements.USERNAME.type(username);
    }

    public void typePassword(String password){
        LoginElements.PASSWORD.type(password);
    }

    public void clickLoginButton(){
        LoginElements.LOGIN_BUTTON.click();
    }

}
