package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import edu.bsuir.web.page.EditPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Acer on 08.04.2018.
 */
public class FilterTest {
    private static WebDriver driver = WebDriverSingleton.getInstance();
    static CandidatesListPage clp = new CandidatesListPage();
    static CandidateProfilePage cpp = new CandidateProfilePage();

    @Step("Логинимся в систему")
    private void login() {
        driver.get("http://testing.cld.iba.by/");
        driver.findElement(By.id("_58_login")).sendKeys("kabanov@tc.by");
        driver.findElement(By.id("_58_password")).sendKeys("welcome");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    @DisplayName("Фильтр списка кандидатов")
    @Description("Фильтр списка кандидатов по указанным параметрам")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 4 – Фильтр кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void simpleFilterTest() throws Exception{
        login();
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.clickRelocation();
        Helper.waitForTime(1);
        Helper.scrollDown();
        Helper.waitForTime(1);
        clp.clickEducation();
        Helper.waitForTime(1);
        clp.clickEducationItem();
        Helper.waitForTime(1);
        clp.clickEducation();
        Helper.waitForTime(1);
        clp.clickUniversity();
        Helper.waitForTime(1);
        clp.clickUniversityItem();
        Helper.waitForTime(1);
        clp.clickUniversity();
        Helper.waitForTime(1);
        Helper.scrollUp();
        Helper.waitForTime(1);
        clp.clickCandidate();
        Helper.waitForTime(1);
        cpp.clickEducationTab();
        cpp.clickEducationTab();
        Helper.waitForTime(1);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText(),"переезд невозможен");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"education\"]")).getText(),"высшее");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"tab-content\"]/div[2]/div/div/div/div")).getText(),"БГЭУ");
    }

    @After
    public void logout(){
        Helper.waitForTime(1);
        driver.findElement(By.xpath("//*[@id=\"heading\"]/ul/li[6]/a/img")).click();
    }
}
