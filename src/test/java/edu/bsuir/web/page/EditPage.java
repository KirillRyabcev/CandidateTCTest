package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.element.EditElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 04.04.2018.
 */
public class EditPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void typeName(String name){
        EditElement.NAME.type(name);
    }
    public void typeSurname(String surname){
        EditElement.SURNAME.type(surname);
    }
    public void typeFatherName(String fatherName){
        EditElement.FATHERNAME.type(fatherName);
    }
    public void typePhone(String phone){
        EditElement.PHONE.type(phone);
    }
    public void typeEmail(String email){
        EditElement.EMAIL.type(email);
    }
    public void typeSkype(String skype){
        EditElement.SKYPE.type(skype);
    }
    public void typeCountry(String country){
        EditElement.COUNTRY.type(country);
    }
    public void typeCity(String city){
        EditElement.CITY.type(city);
    }
    public void clickRelocation(){
        EditElement.RELOCATION.click();
    }
    public void typeDay(String day){
        EditElement.DAY.type(day);
    }
    public void typeMonth(String month){
        EditElement.MONTH.type(month);
    }
    public void typeYear(String year){
        EditElement.YEAR.type(year);
    }
    public void selectEducationByValue(String value){
        Select select = new Select(EditElement.EDUCATION.getWebElement());
        select.selectByValue(value);
    }
    public void typePosition(String position){
        EditElement.DESIRED_POSITION.type(position);
    }
    public void clickCancel(){
        EditElement.CANCEL.click();
    }
    public void clickSave(){
        EditElement.SAVE.click();
    }
    public void clickEditCompetences() {
        EditElement.EDIT_COMPETENCE.click();
    }
    public void clickLanguages() {
        EditElement.LANGUAGES.click();
    }
    public void clickEnglish() {
        EditElement.ENGLISH.moveToElement();
        EditElement.ENGLISH.doubleClick();
    }
    public void clickMSOffice() {
        EditElement.MSOFFICE.click();
    }
    public void clickMSAccess() {
        EditElement.MSACCESS.moveToElement();
        EditElement.MSACCESS.doubleClick();
    }
    public void clickOK(){
        EditElement.OKBUTTON.click();
    }
    public void clickOK2(){
        EditElement.OKBUTTON2.click();
    }
    public void clickRemoveCompetence() {EditElement.REMOVE_COMPETENCE.click();}

}
