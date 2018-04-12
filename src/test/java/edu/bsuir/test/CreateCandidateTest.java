package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.util.helper.GeneratorMode;
import edu.bsuir.util.helper.Helper;
import edu.bsuir.web.Login;
import edu.bsuir.web.page.CandidateProfilePage;
import edu.bsuir.web.page.CandidatesListPage;
import edu.bsuir.web.page.CreatePage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
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
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Step("Логинимся в систему")
    private void login() {
        driver.get("http://testing.cld.iba.by/");
        driver.findElement(By.id("_58_login")).sendKeys("kabanov@tc.by");
        driver.findElement(By.id("_58_password")).sendKeys("welcome");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void sendFile(String path) {
        try {
            setClipboardData(path);
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CANCEL);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private String getAbsolutePath(String file) {
        Path path = Paths.get(file);
        return path.toAbsolutePath().toString();
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    //-------------------------------------Positive tests----------------------------------//

    @Test
    @DisplayName("Создание кандидата")
    @Description("Создание кандидата за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.BLOCKER)
    public void createCandidateTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
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
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates");
        Helper.waitForTime(2);
        clp.typeSearch(surname);
        Helper.waitForTime(1);
        clp.clickCandidate();
        Helper.waitForTime(2);
        Assert.assertEquals(surname + " " + name + " " + fatherName, driver.findElement(By.xpath("//div[@class=\"tc-theme-page-name\"]")).getText());
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"profileForm\"]/div[2]/div[3]/div/div[2]/div[2]/div/div/div[2]")).getText().contains(day + "." + month + "." + year));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(country));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"residence\"]")).getText().contains(city));
        Assert.assertEquals("высшее",driver.findElement(By.xpath("//*[@id=\"education\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата c +,),-")
    @Description("Создание кандидата c +,),- за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void PhoneWithPlusBracketsAndDashTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typePhone("+12(34)-56-78");
        cp.clickSave();
        Helper.waitForTime(2);
        Assert.assertEquals("+12(34)-56-78",driver.findElement(By.xpath("//*[@id=\"primaryTelephone\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата c любыми символами в имени")
    @Description("Создание кандидата c любыми символами в имени за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void nameWithAnyCharachtersTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        String name2 = Helper.generateRandomString(15,GeneratorMode.ANY_CHARACTERS);
        cp.typeName(name2);
        cp.clickSave();
        Helper.waitForTime(2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().contains(name2));
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата с нижними подчеркиваниями и тире в email")
    @Description("Создание кандидата с нижними подчеркиваниями и тире в email за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void emailWithUnderscoreAndDashTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeEmail("iv-an@ivan_ivan.ivan");
        cp.clickSave();
        Helper.waitForTime(2);
        Assert.assertEquals("iv-an@ivan_ivan.ivan",driver.findElement(By.xpath("//*[@id=\"primaryEmail\"]")).getText());
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Загрузка фотогафии через селениум")
    @Description("Загрузка фотогафии через селениум за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 2 – Загрузка фото")
    @Severity(SeverityLevel.MINOR)
    public void uploadFileUsingSelenium() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        cp.loadCV(getAbsolutePath("resources/resume.pdf"));
        Helper.waitForTime(2);
        cp.clickSave();
        Helper.waitForTime(2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().contains("Рябцев Кирилл"));
    }

    @Test
    @DisplayName("Загрузка фотогафии через Robot")
    @Description("Загрузка фотогафии через Robot за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 2 – Загрузка фото")
    @Severity(SeverityLevel.MINOR)
    public void uploadFileUsingRobot() {
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        cp.clickAddAttachment();
        sendFile(getAbsolutePath("resources/resume.pdf"));
        Helper.waitForTime(2);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        Helper.waitForTime(1);
        cp.clickSave();
        Helper.waitForTime(1);
        Assert.assertEquals("resume.pdf",driver.findElement(By.xpath("//*[@id=\"attachedFiles\"]/div/a")).getText());
    }
/*
    @Test
    public void uploadFileUsingSikuli() throws Exception {
        final String noAvatar = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";
        Pattern filePath = new Pattern("resources/sikuli/FilePath.JPG");
        Pattern openButton = new Pattern("resources/sikuli/OpenButton.JPG");
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        cp.clickChangeAvatar();
        Screen screen = new Screen();
        screen.wait(filePath, 20);
        screen.type(filePath, getAbsolutePath("resources/human.png"));
        screen.click(openButton);
        Helper.waitForTime(3);
        WebElement picture = driver.findElement(By.id("currentImage"));
        Assert.assertNotEquals(picture.getAttribute("src"), noAvatar);
    }
*/

    //----------------------------------Negative tests-----------------------------------//


    @Test
    @DisplayName("Создание кандидата с слишком длинным именем")
    @Description("Создание кандидата с слишком длинным именем за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void tooLongNameTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeName(Helper.generateRandomString(55, GeneratorMode.ALPHANUMERIC));
        Helper.scrollUp();
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"maxLength\"]")).getText(),"Пожалуйста, введите не более 50 символов");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата с пустым именем")
    @Description("Создание кандидата с пустым именем за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void emptyNameTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeName(" ");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"required\"]")).getText(),"Обязательное поле");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата только с буквами в поле Телефон")
    @Description("Создание кандидата только с буквами в поле Телефон за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void alphabeticalPhoneTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typePhone(Helper.generateRandomString(10,GeneratorMode.ALPHA));
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"validateTelephone\"]")).getText(),"Неверный формат номера");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата только с буквами в поле Email")
    @Description("Создание кандидата только с буквами в поле Email за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void alphabeticalEmailTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeEmail(Helper.generateRandomString(10,GeneratorMode.ALPHA));
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата с пустым полем Email")
    @Description("Создание кандидата с пустым полем Email за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void emptyEmailTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeEmail( " ");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата c двумя точками")
    @Description("Создание кандидата c двумя точками за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void twoDotsEmailTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeEmail("ivan@ivan..com");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }

    @Test
    @DisplayName("Создание кандидата с двумя @")
    @Description("Создание кандидата с двумя @ за главного рекрутера")
    @Feature("Подбор и адаптация")
    @Story("Сценарий 1 – Создание кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void twoAtEmailTest() throws Exception{
        login();
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        Helper.waitForTime(1);
        cp.typeName(name);
        cp.typeSurname(surname);
        cp.typePhone(phone);
        cp.typeEmail(email);
        cp.typeEmail("ivan@@ivan.com");
        cp.clickSave();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"email\"]")).getText(),"Неверный ввод");
        Helper.waitForTime(1);
    }


    @After
    public void deleteCandidate() throws Exception{
        Helper.waitForTime(1);
        if (driver.findElement(By.xpath("//*[@id=\"successMessage\"]")).getText().equals("Резюме было успешно сохранено")
                || driver.findElement(By.xpath("//*[@id=\"content\"]/div")).getText().contains(name)) {
            Helper.waitForTime(1);
            cpp.clickDelete();
            Helper.waitForTime(1);
            cpp.clickPopUpDelete();
            Helper.waitForTime(1);
        }
        Helper.waitForTime(1);
        driver.findElement(By.xpath("//*[@id=\"heading\"]/ul/li[6]/a/img")).click();
    }



}
