package edu.bsuir.web.page;

import edu.bsuir.web.element.CandidateProfileElement;

/**
 * Created by Acer on 05.04.2018.
 */
public class CandidateProfilePage {
    public void clickEdit(){
        CandidateProfileElement.EDIT_BUTTON.click();
    }
    public void clickDelete(){
        CandidateProfileElement.DELETE_BUTTON.click();
    }
    public void clickPopUpDelete(){
        CandidateProfileElement.DELETE_POP_UP_BUTTON.click();
    }
    public void clickReturnToCandidateList() {
        CandidateProfileElement.RETURN_TO_CANDIDATES_LIST.moveToElement();
        CandidateProfileElement.RETURN_TO_CANDIDATES_LIST.click();}
    public void clickEducationTab(){
        CandidateProfileElement.EDUCATION_TAB.click();
    }
}
