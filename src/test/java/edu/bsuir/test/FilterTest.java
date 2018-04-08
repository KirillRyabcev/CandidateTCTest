package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import edu.bsuir.web.page.EditPage;
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

    @BeforeClass
    public static void comeToCandidatesListPage() throws Exception{
        Login login = new Login();
        login.login("Генеральный директор");
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
    }

    @Test
    public void simpleFilterTest(){
        clp.clickRelocation();
        clp.clickEducation();
        clp.clickEducationItem();
        clp.clickEducation();
        clp.clickUniversity();
        clp.clickUniversityItem();
        clp.clickUniversity();
        clp.clickCandidate();
        cpp.clickEducationTab();
        cpp.clickEducationTab();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText(),"переезд невозможен");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"education\"]")).getText(),"высшее");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"tab-content\"]/div[2]/div/div/div/div")).getText(),"БГЭУ");
    }
}
