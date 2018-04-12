package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.CreateElement;
import edu.bsuir.web.element.EditElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 05.04.2018.
 */
public class CreatePage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Вводим в поле Имя {0}")
    public void typeName(String name){
        CreateElement.NAME.type(name);
    }
    @Step("Вводим в поле Фамилия {0}")
    public void typeSurname(String surname){
        CreateElement.SURNAME.type(surname);
    }
    @Step("Вводим в поле Отчество {0}")
    public void typeFatherName(String fatherName){
        CreateElement.FATHERNAME.type(fatherName);
    }
    @Step("Вводим в поле Телефон {0}")
    public void typePhone(String phone){
        CreateElement.PHONE.type(phone);
    }
    @Step("Вводим в поле Еmail {0}")
    public void typeEmail(String email){
        CreateElement.EMAIL.type(email);
    }
    @Step("Вводим в поле Skype {0}")
    public void typeSkype(String skype){
        CreateElement.SKYPE.type(skype);
    }
    @Step("Вводим в поле Страна {0}")
    public void typeCountry(String country){
        CreateElement.COUNTRY.type(country);
    }
    @Step("Вводим в поле Город {0}")
    public void typeCity(String city){
        CreateElement.CITY.type(city);
    }
    @Step("Нажимаем 'переезд невозможен'")
    public void clickRelocation(){
        CreateElement.RELOCATION.click();
    }
    @Step("Вводим в поле День {0}")
    public void typeDay(String day){
        CreateElement.DAY.type(day);
    }
    @Step("Вводим в поле Месяц {0}")
    public void typeMonth(String month){
        CreateElement.MONTH.type(month);
    }
    @Step("Вводим в поле Год {0}")
    public void typeYear(String year){
        CreateElement.YEAR.type(year);
    }
    @Step("Выбираем в select Образование значение {0}")
    public void selectEducationByValue(String value){
        Select select = new Select(CreateElement.EDUCATION.getWebElement());
        select.selectByValue(value);
    }
    @Step("Вводим Желаемую должность {0}")
    public void typePosition(String position){
        CreateElement.DESIRED_POSITION.type(position);
    }
    @Step("Нажимаем 'Отмена' ")
    public void clickCancel(){
        CreateElement.CANCEL.click();
    }
    @Step("Нажимаем 'Сохранить' ")
    public void clickSave(){
        CreateElement.SAVE.click();
    }
    @Step("Нажимаем 'Сменить изображение' ")
    public void clickChangeAvatar() {
        CreateElement.CHANGE_AVATAR.click();
    }
    @Step("Нажимаем 'Загрузить резюме' ")
    public void loadCV(String path){
        CreateElement.LOAD_CV_INPUT.type2(path);
    }
    @Step("Нажимаем 'Прикрепить файл'")
    public void clickAddAttachment(){
        CreateElement.ADD_ATTACHMENT.click();
    }
}
