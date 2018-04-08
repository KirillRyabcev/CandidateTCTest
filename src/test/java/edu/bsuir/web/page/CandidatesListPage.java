package edu.bsuir.web.page;

import edu.bsuir.web.element.CandidatesListElement;
import edu.bsuir.web.element.CreateElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Acer on 07.04.2018.
 */
public class CandidatesListPage {
    public void typeSearch(String search){
        CandidatesListElement.SEARCH_FIELD.type(search);
    }
    public void clickCreate(){
        CandidatesListElement.CREATE_BUTTON.click();
    }
    public void selectExperienceByValue(String value){
        Select select = new Select(CandidatesListElement.EXPERIENCE_SELECT.getWebElement());
        select.selectByValue(value);
    }
    public void clickRelocation(){
        CandidatesListElement.RELOCATION_UNAVAILABLE.click();
    }
    public void clickEducation(){
        CandidatesListElement.EDUCATION_BUTTON.click();
    }
    public void clickEducationItem(){
        CandidatesListElement.EDUCATION_ITEM.click();
    }
    public void clickUniversity(){
        CandidatesListElement.UNIVERSITY_BUTTON.click();
    }
    public void clickUniversityItem(){
        CandidatesListElement.UNIVERSITY_ITEM.click();
    }
    public void clickCandidate(){
        CandidatesListElement.CANDIDATE.click();
    }

}
