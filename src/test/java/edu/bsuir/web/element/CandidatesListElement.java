package edu.bsuir.web.element;

import edu.bsuir.element.Element;
import org.openqa.selenium.By;

/**
 * Created by Acer on 07.04.2018.
 */
public class CandidatesListElement {
    public static final Element SEARCH_FIELD = new Element("Поиск", By.xpath("//*[@class=\"form-control\"]"));
    public static final Element CREATE_BUTTON = new Element("Создать", By.xpath("//*[@id=\"createProfileButton\"]"));
    public static final Element EXPERIENCE_SELECT = new Element("Опыт работы", By.xpath("//*[@id=\"experience\"]"));
    public static final Element RELOCATION_UNAVAILABLE = new Element("Переезд невозможен", By.xpath("//*[@id=\"relocation_Unavailable\"]"));
    public static final Element EDUCATION_BUTTON = new Element("Образование", By.xpath("//*[@id=\"education_filter\"]/span/div/button"));
    public static final Element EDUCATION_ITEM = new Element("Образование", By.xpath("//*[@id=\"education_filtermultiselect-4\"]"));
    public static final Element UNIVERSITY_BUTTON = new Element("Университет", By.xpath("//*[@id=\"universities_filter\"]/span/div/button"));
    public static final Element UNIVERSITY_ITEM = new Element("Университет", By.xpath("//*[@id=\"universities_filtermultiselect-2\"]"));
    public static final Element CANDIDATE = new Element("Кандидат", By.xpath("//table/tbody/tr/td/div/div[2]/a/span"));

}
