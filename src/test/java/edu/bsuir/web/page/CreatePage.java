package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.CreateElement;
import edu.bsuir.web.element.EditElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 05.04.2018.
 */
public class CreatePage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void typeName(String name){
        CreateElement.NAME.type(name);
    }
    public void typeSurname(String surname){
        CreateElement.SURNAME.type(surname);
    }
    public void typeFatherName(String fatherName){
        CreateElement.FATHERNAME.type(fatherName);
    }
    public void typePhone(String phone){
        CreateElement.PHONE.type(phone);
    }
    public void typeEmail(String email){
        CreateElement.EMAIL.type(email);
    }
    public void typeSkype(String skype){
        CreateElement.SKYPE.type(skype);
    }
    public void typeCountry(String country){
        CreateElement.COUNTRY.type(country);
    }
    public void typeCity(String city){
        CreateElement.CITY.type(city);
    }
    public void clickRelocation(){
        CreateElement.RELOCATION.click();
    }
    public void typeDay(String day){
        CreateElement.DAY.type(day);
    }
    public void typeMonth(String month){
        CreateElement.MONTH.type(month);
    }
    public void typeYear(String year){
        CreateElement.YEAR.type(year);
    }
    public void selectEducationByValue(String value){
        Select select = new Select(CreateElement.EDUCATION.getWebElement());
        select.selectByValue(value);
    }
    public void typePosition(String position){
        CreateElement.DESIRED_POSITION.type(position);
    }
    public void clickCancel(){
        CreateElement.CANCEL.click();
    }
    public void clickSave(){
        CreateElement.SAVE.click();
    }
}
