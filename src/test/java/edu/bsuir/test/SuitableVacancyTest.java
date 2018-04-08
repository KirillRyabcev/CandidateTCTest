package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.EditPage;
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


    @BeforeClass
    public static void comeToCandidatePage() throws Exception{
        Login login = new Login();
        login.login("Генеральный директор");
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.typeSearch("Петров");
        Helper.waitForTime(2);
        clp.clickCandidate();
    }

    @Test
    public void partlySuitableVacancyTest() throws Exception{
        Helper.waitForTime(1);
        cpp.clickEdit();
        ep.clickEditCompetences();
        ep.clickLanguages();
        Helper.waitForTime(2);
        ep.clickEnglish();
        Helper.waitForTime(2);
        ep.clickOK();
        Helper.waitForTime(2);
        Helper.scrollUp();
        ep.clickSave();
        Helper.waitForTime(2);
        Assert.assertEquals("Дизайнер", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[2]/a")).getText());
        Assert.assertEquals("50%", driver.findElement(By.xpath("//*[@id=\"vacanciesBody\"]/div/span[3]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    public void suitableVacancyTest() throws Exception{
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

    @AfterClass
    public static void removeCompetences(){
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
