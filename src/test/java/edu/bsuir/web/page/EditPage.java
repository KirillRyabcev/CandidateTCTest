package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.EditElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 04.04.2018.
 */
public class EditPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вводим в поле имя {0}")
    public void typeName(String name){
        EditElement.NAME.type(name);
    }
    @Step("Вводим в поле фамилия {0}")
    public void typeSurname(String surname){
        EditElement.SURNAME.type(surname);
    }
    @Step("Вводим в поле Отчество {0}")
    public void typeFatherName(String fatherName){
        EditElement.FATHERNAME.type(fatherName);
    }
    @Step("Вводим в поле Телефон {0}")
    public void typePhone(String phone){
        EditElement.PHONE.type(phone);
    }
    @Step("Вводим в поле Email {0}")
    public void typeEmail(String email){
        EditElement.EMAIL.type(email);
    }
    @Step("Вводим в поле Skype {0}")
    public void typeSkype(String skype){
        EditElement.SKYPE.type(skype);
    }
    @Step("Вводим в поле Страна {0}")
    public void typeCountry(String country){
        EditElement.COUNTRY.type(country);
    }
    @Step("Вводим в поле Город {0}")
    public void typeCity(String city){
        EditElement.CITY.type(city);
    }
    @Step("Нажимаем 'переезд невозможен' ")
    public void clickRelocation(){
        EditElement.RELOCATION.click();
    }
    @Step("Вводим в поле День {0}")
    public void typeDay(String day){
        EditElement.DAY.type(day);
    }
    @Step("Вводим в поле Месяц {0}")
    public void typeMonth(String month){
        EditElement.MONTH.type(month);
    }
    @Step("Вводим в поле Год {0}")
    public void typeYear(String year){
        EditElement.YEAR.type(year);
    }
    @Step("Выбираем уровень образования по значению {0}")
    public void selectEducationByValue(String value){
        Select select = new Select(EditElement.EDUCATION.getWebElement());
        select.selectByValue(value);
    }
    @Step("Вводим в поле Желаемая должность {0}")
    public void typePosition(String position){
        EditElement.DESIRED_POSITION.type(position);
    }
    @Step("Нажимаем кнопку 'Отменить' ")
    public void clickCancel(){
        EditElement.CANCEL.click();
    }
    @Step("Нажимаем кнопку 'Сохранить' ")
    public void clickSave(){
        EditElement.SAVE.click();
    }
    @Step("Нажимаем кнопку 'Редактировать компетенции' ")
    public void clickEditCompetences() {
        EditElement.EDIT_COMPETENCE.click();
    }
    @Step("Нажимаем на список 'Иностранные языки' ")
    public void clickLanguages() {
        EditElement.LANGUAGES.click();
    }
    @Step("Нажимаем на элемент списка 'Английский язык' ")
    public void clickEnglish() {
        EditElement.ENGLISH.moveToElement();
        EditElement.ENGLISH.doubleClick();
    }
    @Step("Нажимаем на список 'MS Office' ")
    public void clickMSOffice() {
        EditElement.MSOFFICE.click();
    }
    @Step("Нажимаем на элемент списка 'MS Access' ")
    public void clickMSAccess() {
        EditElement.MSACCESS.moveToElement();
        EditElement.MSACCESS.doubleClick();
    }
    @Step("Нажимаем на кнопку ОК")
    public void clickOK(){
        EditElement.OKBUTTON.click();
    }
    @Step("Нажимаем на кнопку ОК")
    public void clickOK2(){
        EditElement.OKBUTTON2.click();
    }
    @Step("Нажимаем на кнопку 'Удалить компетенцию' ")
    public void clickRemoveCompetence() {EditElement.REMOVE_COMPETENCE.click();}
}
