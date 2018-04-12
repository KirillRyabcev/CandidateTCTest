package edu.bsuir.web.page;

import edu.bsuir.web.element.CandidateProfileElement;
import io.qameta.allure.Step;

/**
 * Created by Acer on 05.04.2018.
 */
public class CandidateProfilePage {
    @Step("Нажимаем на кнопку 'Редактировать' ")
    public void clickEdit(){
        CandidateProfileElement.EDIT_BUTTON.click();
    }
    @Step("Нажимаем на кнопку 'Удалить' ")
    public void clickDelete(){
        CandidateProfileElement.DELETE_BUTTON.click();
    }
    @Step("Нажимаем на кнопку 'Удалить' в всплывающем окне")
    public void clickPopUpDelete(){
        CandidateProfileElement.DELETE_POP_UP_BUTTON.click();
    }
    @Step("Нажимаем на кнопку 'Назад к списку' ")
    public void clickReturnToCandidateList() {
        CandidateProfileElement.RETURN_TO_CANDIDATES_LIST.moveToElement();
        CandidateProfileElement.RETURN_TO_CANDIDATES_LIST.click();}
    @Step("Нажимаем на таб 'Образование' ")
    public void clickEducationTab(){
        CandidateProfileElement.EDUCATION_TAB.click();
    }
}
