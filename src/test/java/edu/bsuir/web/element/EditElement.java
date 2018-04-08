package edu.bsuir.web.element;

import edu.bsuir.element.Element;
import org.openqa.selenium.By;

/**
 * Created by Acer on 04.04.2018.
 */
public class EditElement {
    public static final Element NAME = new Element("Имя", By.xpath("//*[@id=\"name\"]"));
    public static final Element SURNAME = new Element("Фамилия", By.xpath("//*[@id=\"surname\"]"));
    public static final Element FATHERNAME = new Element("Отчество", By.xpath("//*[@id=\"secondName\"]"));
    public static final Element PHONE = new Element("Телефон", By.xpath("//*[@id=\"primaryTelephone\"]"));
    public static final Element EMAIL = new Element("Email", By.xpath("//*[@id=\"primaryEmail\"]"));
    public static final Element SKYPE = new Element("Skype", By.xpath("//*[@id=\"skype\"]"));
    public static final Element COUNTRY = new Element("Страна", By.xpath("//*[@id=\"country\"]"));
    public static final Element CITY = new Element("Город", By.xpath("//*[@id=\"city\"]"));
    public static final Element RELOCATION = new Element("Переезд", By.xpath("//*[@id=\"relocation\"]"));
    public static final Element DAY = new Element("День рождения", By.xpath("//*[@id=\"dateOfBirthDay\"]"));
    public static final Element MONTH = new Element("Месяц рождения", By.xpath("//*[@id=\"dateOfBirthMonth\"]"));
    public static final Element YEAR = new Element("Год рождения", By.xpath("//*[@id=\"dateOfBirthYear\"]"));
    public static final Element EDUCATION = new Element("Образование", By.xpath("//*[@class=\"form-control\"]"));
    public static final Element DESIRED_POSITION = new Element("Желаемая должность", By.xpath("//*[@id=\"desiredPosition\"]"));
    public static final Element CANCEL = new Element("Образование", By.xpath(" //*[@id=\"cancelButton\"]"));
    public static final Element SAVE = new Element("Сохранить", By.xpath("//*[@id=\"saveButton\"]"));
    public static final Element EDIT_COMPETENCE = new Element("Редактировать компетенции", By.xpath("//*[@id=\"editCompetence\"]"));
    public static final Element LANGUAGES = new Element("Иностранные языки", By.xpath("//*[@id=\"layer_1\"]/ul/li[2]/div/span"));
    public static final Element ENGLISH = new Element("Английиский язык", By.xpath("//*[@id=\"layer_1\"]/ul/li[2]/ul/li/div/span"));
    public static final Element MSOFFICE = new Element("MS OFFICE", By.xpath("//*[@id=\"layer_2\"]/ul/li/div/span"));
    public static final Element MSACCESS = new Element("MS ACCESS", By.xpath("//*[@id=\"layer_2\"]/ul/li/ul/li/div/span"));
    public static final Element OKBUTTON = new Element("OK", By.xpath("/html/body/div[3]/div/div[3]/div/button[2]"));
    public static final Element REMOVE_COMPETENCE = new Element("Удалить компетенцию", By.xpath("//*[@class=\"table\"]/tbody/tr/td[3]/span/i"));
    public static final Element OKBUTTON2 = new Element("OK", By.xpath("//button[2]"));

}
