package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Acer on 08.04.2018.
 */
public class DeleteCandidateTest {
    private static WebDriver driver = WebDriverSingleton.getInstance();
    CreatePage cp = new CreatePage();
    CandidatesListPage clp = new CandidatesListPage();
    CandidateProfilePage cpp = new CandidateProfilePage();

    String name = "Федор";
    String surname = "Федоров";
    String phone = "12345";
    String email = "qwe@asd.zxc";

    @Before
    public void createCandiate() throws Exception{
        Login login = new Login();
        login.login("Генеральный директор");
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.clickCreate();
        Helper.setRequiredFields(name,surname,phone,email);
        cp.clickSave();
        Helper.waitForTime(2);
        cpp.clickReturnToCandidateList();
        Helper.waitForTime(1);
    }

    @Test
    public void deleteCandidate() throws Exception{
        Helper.waitForTime(1);
        clp.typeSearch(name + " " + surname);
        Helper.waitForTime(2);
        clp.clickCandidate();
        Helper.waitForTime(1);
        cpp.clickDelete();
        Helper.waitForTime(1);
        cpp.clickPopUpDelete();
        Helper.waitForTime(1);
        Assert.assertEquals("Профиль кандидата был успешно удален из системы", driver.findElement(By.xpath("//*[@id=\"successMessage\"]")).getText() );
        clp.typeSearch(name + " " + surname);
        Assert.assertEquals("Список кандидатов пуст", driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div/div/section/div/div/div/div/div[2]/div/div[7]/div/div[2]/tc-alert/div/div[2]")).getText());
    }


}
