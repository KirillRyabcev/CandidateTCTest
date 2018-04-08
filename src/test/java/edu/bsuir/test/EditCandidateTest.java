package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.GeneratorMode;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.element.EditElement;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import edu.bsuir.web.page.EditPage;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import static edu.bsuir.test.CreateCandidateTest.phone;
import static edu.bsuir.test.CreateCandidateTest.surname;

/**
 * Created by Acer on 04.04.2018.
 */
public class EditCandidateTest {
    private static WebDriver driver = WebDriverSingleton.getInstance();
    EditPage ep = new EditPage();
    CreatePage cp = new CreatePage();
    static CandidatesListPage clp = new CandidatesListPage();
    static CandidateProfilePage cpp = new CandidateProfilePage();

    @BeforeClass
    public static void comeToEditPage() throws Exception{
        Login login = new Login();
        login.login("Генеральный директор");
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
        clp.typeSearch("Петров");
        Helper.waitForTime(2);
        clp.clickCandidate();
    }

    @Before
    public void clickEdit(){
        Helper.waitForTime(1);
        cpp.clickEdit();
        Helper.waitForTime(1);
    }

    String name = "Иван";
    String surname = "Петров";
    String fatherName= "Петрович";
    String skype = "petr_petrov";
    String country = "Украина";
    String city = "Киев";
    String day = "23";
    String month = "10";
    String year = "1995";
    String valueOfEducation = "3";
    String desiredPosition = "Бизнес-аналитик";

    @Test
    public void editTest() throws Exception{
        Helper.waitForTime(1);
        ep.typeName(name);
        ep.typeSurname(surname);
        ep.typeFatherName(fatherName);
        ep.typeSkype(skype);
        ep.typeCountry(country);
        ep.typeCity(city);
        ep.clickRelocation();
        ep.typeDay(day);
        ep.typeMonth(month);
        ep.typeYear(year);
        ep.selectEducationByValue(valueOfEducation);
        ep.typePosition(desiredPosition);
        ep.clickSave();

        Assert.assertEquals(surname + " " + name + " " + fatherName, driver.findElement(By.xpath("//div[@class=\"tc-theme-page-name\"]")).getText());
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"profileForm\"]/div[2]/div[3]/div/div[2]/div[2]/div/div/div[2]")).getText().contains(day + "." + month + "." + year));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(country));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(city));
        Assert.assertEquals("среднее специальное",driver.findElement(By.xpath("//*[@id=\"education\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    public void longNameTest() throws Exception{
        Helper.waitForTime(1);
        ep.typeSurname(Helper.generateRandomString(55, GeneratorMode.ALPHANUMERIC));
        ep.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"maxLength\"]")).getText(),"Пожалуйста, введите не более 50 символов");
        Helper.waitForTime(1);
    }

    @Test
    public void emptyNameTest() throws Exception{
        Helper.waitForTime(1);
        ep.typeSurname(" ");
        ep.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"required\"]")).getText(),"Обязательное поле");
        Helper.waitForTime(1);
    }

    @Test
    public void nonExistantDateTest() throws Exception{
        Helper.waitForTime(1);
        ep.typeDay("33");
        ep.typeMonth("0");
        ep.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"validateDate\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    public void futureTimeDateTest() throws Exception{
        Helper.waitForTime(1);
        ep.typeYear("2020");
        ep.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"validateDateWithToday\"]")).getText(),"Дата не может быть позднее сегодняшней");
        Helper.waitForTime(1);
    }

    @Test
    public void tooMuchTimeAgo() throws Exception{
        Helper.waitForTime(1);
        ep.typeYear("1899");
        ep.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"validateDate\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @After
    public void returnToCandidateProfilePage(){
        Helper.waitForTime(1);
        if (EditElement.SAVE.getText().equals("Сохранить")){
            Helper.scrollUp();
            ep.clickCancel();
        }
        Helper.waitForTime(1);
    }



}
