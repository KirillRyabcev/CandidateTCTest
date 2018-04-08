package edu.bsuir.web;
import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.page.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import edu.bsuir.parser.Parser;
import edu.bsuir.web.element.LoginElements;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 04.04.2018.
 */
public class Login {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public void login(String role) throws Exception{
        LoginPage lp = new LoginPage();
        Parser pd = new Parser();
        lp.enterLoginPage();
        ArrayList<String> loginAndPassword= pd.getData(role);
        lp.typeUsername(loginAndPassword.get(0));
        lp.typePassword(loginAndPassword.get(1));
        lp.clickLoginButton();
    }
}
