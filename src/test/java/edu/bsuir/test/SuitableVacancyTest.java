package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.EditPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * Created by Acer on 05.04.2018.
 */
public class SuitableVacancyTest {
    private static WebDriver driver = WebDriverSingleton.getInstance();
    static EditPage ep = new EditPage();
    static CandidateProfilePage cp = new CandidateProfilePage();
    static CandidatesListPage clp = new CandidatesListPage();
    static CandidateProfilePage cpp = new CandidateProfilePage();

    @Step("Логинимся в систему")
    private static void login() {
        driver.get("http://testing.cld.iba.by/");
        driver.findElement(By.id("_58_login")).sendKeys("kabanov@tc.by");
        driver.findElement(By.id("_58_password")).sendKeys("welcome");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    @DisplayName("Появление чатично подходящих вакансий")
    @Description("Появление частично подходящих вакансий по заданным компетенциям")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 5 – Появление вакансий")
    @Severity(SeverityLevel.MINOR)
    public void partlySuitableVacancyTest() throws Exception{
        login();
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.typeSearch("Петров");
        Helper.waitForTime(2);
        clp.clickCandidate();
        Helper.waitForTime(1);
        cpp.clickEdit();
        ep.clickEditCompetences();
        ep.clickLanguages();
        Helper.waitForTime(2);
        ep.clickEnglish();
        Helper.waitForTime(2);
        ep.clickOK2();
        Helper.waitForTime(2);
        Helper.scrollUp();
        ep.clickSave();
        Helper.waitForTime(2);
        Assert.assertEquals("Дизайнер", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[2]/a")).getText());
        Assert.assertEquals("50%", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[3]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Появление подходящих вакансий")
    @Description("Появление подходящих вакансий по заданным компетенциям")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 5 – Появление вакансий")
    @Severity(SeverityLevel.MINOR)
    public void suitableVacancyTest() throws Exception{
        login();
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.typeSearch("Петров");
        Helper.waitForTime(2);
        clp.clickCandidate();
        Helper.waitForTime(1);
        cpp.clickEdit();
        ep.clickEditCompetences();
        ep.clickLanguages();
        Helper.waitForTime(2);
        ep.clickEnglish();
        Helper.waitForTime(2);
        ep.clickMSOffice();
        Helper.waitForTime(2);
        ep.clickMSAccess();
        ep.clickMSAccess();
        Helper.waitForTime(2);
        ep.clickOK();
        Helper.waitForTime(2);
        Helper.scrollUp();
        ep.clickSave();
        Helper.waitForTime(2);
        Assert.assertEquals("Дизайнер", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[2]/a")).getText());
        Assert.assertEquals("100%", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[3]")).getText());
        Helper.waitForTime(1);

    }

    @After
    public void logout(){
        Helper.waitForTime(1);
        driver.findElement(By.xpath("//*[@id=\"heading\"]/ul/li[6]/a/img")).click();
    }

    @AfterClass
    public static void removeCompetences(){
        login();
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.typeSearch("Петров");
        Helper.waitForTime(2);
        clp.clickCandidate();
        Helper.waitForTime(1);
        cpp.clickEdit();
        ep.clickEditCompetences();
        ep.clickRemoveCompetence();
        ep.clickRemoveCompetence();
        Helper.waitForTime(1);
        ep.clickOK2();
        Helper.scrollUp();
        Helper.waitForTime(1);
        ep.clickSave();
    }



}
