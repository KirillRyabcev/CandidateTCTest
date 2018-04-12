package edu.bsuir.util.helper;
import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.page.CreatePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/**
 * Created by Acer on 05.04.2018.
 */
public class Helper {
    public static void waitForTime(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForTimeInMilliseconds(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomString(int length, GeneratorMode mode) {
        StringBuffer buffer = new StringBuffer();
        String characters = "";
        switch (mode) {
            case ALPHA:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case ALPHANUMERIC:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
            case NUMERIC:
                characters = "1234567890";
                break;
            case ANY_CHARACTERS:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()_+=-<>?/.,|}{][";
                break;
        }
        int charactersLength = characters.length();
        for (int i = 0; i < length; i++) {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }

    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }

    public static void setAttributeValue(String webElementId, String attr, String value){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        js.executeScript("document.getElementById('" + webElementId + "').setAttribute('" + attr + "', '" + value + "')");
    }

    public static void setRequiredFields(String name, String surname, String phone, String email){
        CreatePage cp = new CreatePage();
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
    }
    @Step("Переходим на страницу кандидатов")
    public static void comeToCandidatesList(){
        WebDriver driver = WebDriverSingleton.getInstance();
        WebElement recruitmentButton = driver.findElement(By.xpath("//*[@id=\"navigationIcon3\"]"));
        Helper.waitForTime(3);
        Actions action = new Actions(driver);
        action.moveToElement(recruitmentButton).perform();
        WebElement candidatesButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/nav/ul/li[2]/ul/li[3]/a/div/div[2]/div/div"));
        candidatesButton.click();
    }

    public static void scrollUp(){
        WebDriver driver = WebDriverSingleton.getInstance();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -500);");
    }

    public static void scrollDown(){
        WebDriver driver = WebDriverSingleton.getInstance();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 500);");
    }
}
