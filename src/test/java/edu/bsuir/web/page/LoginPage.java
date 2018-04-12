package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.LoginElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Acer on 02.04.2018.
 */
public class LoginPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Входим на страницу логина")
    public void enterLoginPage(){
        driver.get(LoginElements.URL);
    }

    @Step("Вводим логин {0}")
    public void typeUsername(String username){
      LoginElements.USERNAME.type(username);
    }

    @Step("Вводим пароль {0}")
    public void typePassword(String password){
        LoginElements.PASSWORD.type(password);
    }

    @Step("Нажимаем на кнопку логина")
    public void clickLoginButton(){
        LoginElements.LOGIN_BUTTON.click();
    }

}
