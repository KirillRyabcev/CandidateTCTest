package edu.bsuir.web.page;

import edu.bsuir.web.element.CandidatesListElement;
import edu.bsuir.web.element.CreateElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 07.04.2018.
 */
public class CandidatesListPage {
    @Step("Вводим текст в поле поиска")
    public void typeSearch(String search){
        CandidatesListElement.SEARCH_FIELD.type(search);
    }
    @Step("Нажимаем создать кандидата")
    public void clickCreate(){
        CandidatesListElement.CREATE_BUTTON.click();
    }
    @Step("Выбираем опыт работы по значению {0}")
    public void selectExperienceByValue(String value){
        Select select = new Select(CandidatesListElement.EXPERIENCE_SELECT.getWebElement());
        select.selectByValue(value);
    }
    @Step("Нажимаем 'переезд невозможен' ")
    public void clickRelocation(){
        CandidatesListElement.RELOCATION_UNAVAILABLE.click();
    }
    @Step("Нажимаем select 'Образование' ")
    public void clickEducation(){
        CandidatesListElement.EDUCATION_BUTTON.click();
    }
    @Step("Нажимаем option в select 'Образование' ")
    public void clickEducationItem(){
        CandidatesListElement.EDUCATION_ITEM.click();
    }
    @Step("Нажимаем select 'Университет'")
    public void clickUniversity(){
        CandidatesListElement.UNIVERSITY_BUTTON.click();
    }
    @Step("Нажимаем option в select 'Университет'")
    public void clickUniversityItem(){
        CandidatesListElement.UNIVERSITY_ITEM.click();
    }
    @Step("Нажимаем на первого кандидата в списке")
    public void clickCandidate(){
        CandidatesListElement.CANDIDATE.click();
    }

}
