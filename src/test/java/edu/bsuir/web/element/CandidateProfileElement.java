package edu.bsuir.web.element;

import edu.bsuir.element.Element;
import org.openqa.selenium.By;

/**
 * Created by Acer on 05.04.2018.
 */
public class CandidateProfileElement {
    public static final Element EDIT_BUTTON = new Element("Редакировать", By.xpath("//*[@id=\"editButton\"]"));
    public static final Element DELETE_BUTTON = new Element("Удалить", By.xpath("//*[@id=\"removeButton\"]"));
    public static final Element DELETE_POP_UP_BUTTON = new Element("Удалить", By.xpath("//*[@id=\"removeCandidateModal\"]/div[2]/div/div[3]/div/button[2]"));
    public static final Element RETURN_TO_CANDIDATES_LIST = new Element("Кандидаты", By.xpath("//*[@id=\"breadcrumbs\"]/ul/li[2]/a"));
    public static final Element EDUCATION_TAB = new Element("Образование", By.xpath("//*[@id=\"myTab\"]/ul/li[2]/a"));
}
