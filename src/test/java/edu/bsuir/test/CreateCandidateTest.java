package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.GeneratorMode;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import org.junit.*;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Acer on 05.04.2018.
 */
@RunWith(Theories.class)
public class CreateCandidateTest {

    private static WebDriver driver = WebDriverSingleton.getInstance();
    CreatePage cp = new CreatePage();
    CandidatesListPage clp = new CandidatesListPage();
    CandidateProfilePage cpp = new CandidateProfilePage();

    @BeforeClass
    public static void comeToCreatePage() throws Exception{
        Login login = new Login();
        login.login("Генеральный директор");
        Helper.comeToCandidatesList();
        Helper.waitForTime(2);
    }

    @Before
    public void clickCreate() {
        clp.clickCreate();
    }

    static String name = "Иван";
    static String surname = "Соколов";
    static String fatherName= "Иванович";
    static String phone = "123456789";
    static String email = "qwe@gmail.com";
    static String skype = "ivan_ivanov";
    static String country = "Беларусь";
    static String city = "Минск";
    static String day = "01";
    static String month = "05";
    static String year = "1997";
    static String valueOfEducation = "4";
    static String desiredPosition = "Junior Java Developer";

    //-------------------------------------Positive tests----------------------------------//

    @Test
    public void createCandidateTest() throws Exception{
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typeFatherName(fatherName);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeSkype(skype);
        cp.typeCountry(country);
        cp.typeCity(city);
        cp.clickRelocation();
        cp.typeDay(day);
        cp.typeMonth(month);
        cp.typeYear(year);
        cp.selectEducationByValue(valueOfEducation);
        cp.typePosition(desiredPosition);
        cp.clickSave();
        cpp.clickReturnToCandidateList();
        Helper.waitForTime(2);
        clp.typeSearch(surname);
        Helper.waitForTime(1);
        clp.clickCandidate();
        Assert.assertEquals(surname + " " + name + " " + fatherName, driver.findElement(By.xpath("//div[@class=\"tc-theme-page-name\"]")).getText());
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"profileForm\"]/div[2]/div[3]/div/div[2]/div[2]/div/div/div[2]")).getText().contains(day + "." + month + "." + year));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(country));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(city));
        Assert.assertEquals("высшее",driver.findElement(By.xpath("//*[@id=\"education\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    public void PhoneWithPlusBracketsAndDashTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typePhone("+12(34)-56-78");
        cp.clickSave();
        Assert.assertEquals("+12(34)-56-78",driver.findElement(By.xpath("//*[@id=\"primaryTelephone\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    public void nameWithAnyCharachtersTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        String name2 = Helper.generateRandomString(15,GeneratorMode.ANY_CHARACTERS);
        cp.typeName(name2);
        cp.clickSave();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().contains(name2));
        Helper.waitForTime(1);
    }

    @Test
    public void emailWithUnderscoreAndDashTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeEmail("iv-an@ivan_ivan.ivan");
        cp.clickSave();
        Assert.assertEquals("iv-an@ivan_ivan.ivan",driver.findElement(By.xpath("//*[@id=\"primaryEmail\"]")).getText());
        Helper.waitForTime(1);
    }


    //----------------------------------Negative tests-----------------------------------//


    @Test
    public void tooLongNameTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeName(Helper.generateRandomString(55, GeneratorMode.ALPHANUMERIC));
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"maxLength\"]")).getText(),"Пожалуйста, введите не более 50 символов");
        Helper.waitForTime(1);
    }

    @Test
    public void emptyNameTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeName(" ");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"required\"]")).getText(),"Обязательное поле");
        Helper.waitForTime(1);
    }

    @Test
    public void alphabeticalPhoneTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typePhone(Helper.generateRandomString(10,GeneratorMode.ALPHA));
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"validateTelephone\"]")).getText(),"Неверный формат номера");
        Helper.waitForTime(1);
    }

    @Test
    public void alphabeticalEmailTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeEmail(Helper.generateRandomString(10,GeneratorMode.ALPHA));
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    public void emptyEmailTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeEmail( " ");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    public void twoDotsEmailTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeEmail("ivan@ivan..com");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    public void twoAtEmailTest() throws Exception{
        Helper.waitForTime(1);
        Helper.setRequiredFields(name, surname, phone, email);
        cp.typeEmail("ivan@@ivan.com");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }


    @After
    public void deleteCandidate() throws Exception{
        Helper.waitForTime(1);
        if (driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().equals("Создание резюме")){
            cp.clickCancel();
        }
        if (driver.findElement(By.xpath("//*[@id=\"successMessage\"]")).getText().equals("Резюме было успешно сохранено")
                || driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().contains(name)) {
            Helper.waitForTime(1);
            cpp.clickDelete();
            Helper.waitForTime(1);
            cpp.clickPopUpDelete();
            Helper.waitForTime(1);
        }
        Helper.waitForTime(1);
    }

}
