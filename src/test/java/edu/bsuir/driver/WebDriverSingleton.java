package edu.bsuir.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 04.04.2018.
 */
public class WebDriverSingleton {
    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        if (webDriver == null) {
            //System.setProperty("webdriver.gecko.driver", "lib/drivers/geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void destroyInstance() {
        webDriver = null;
    }
}
