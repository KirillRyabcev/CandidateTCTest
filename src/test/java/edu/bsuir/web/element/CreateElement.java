package edu.bsuir.web.element;

import edu.bsuir.element.Element;
import org.openqa.selenium.By;

/**
 * Created by Acer on 05.04.2018.
 */
public class CreateElement {
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
    public static final Element SAVE = new Element("Образование", By.xpath("//*[@id=\"saveButton\"]"));
    public static final Element CHANGE_AVATAR = new Element("Поменять изображение", By.id("changeImgLink"));
    public static final Element ADD_ATTACHMENT = new Element("Прикрепить файл", By.xpath("//*[@id=\"add-attachment\"]"));
    public static final Element LOAD_CV_INPUT = new Element("Загрузить резюме",By.xpath("//*[@id=\"profileCVInput\"]"));
}
