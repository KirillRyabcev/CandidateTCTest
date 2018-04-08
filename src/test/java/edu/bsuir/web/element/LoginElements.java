package edu.bsuir.web.element;

import edu.bsuir.element.Element;
import org.openqa.selenium.By;

/**
 * Created by Acer on 02.04.2018.
 */
public class LoginElements {
    public static final String URL = "http://testing.cld.iba.by";
    public static final Element USERNAME = new Element("Логин",By.id("_58_login"));
    public static final Element PASSWORD = new Element("Пароль",By.id("_58_password"));
    public static final Element LOGIN_BUTTON = new Element("Кнопка Войти",By.xpath("//div[@class='button-holder ']//button"));

    public static By getLoginButton(String name){
        return By.xpath("//button[text()=' " + name + " ']");
    }
}
