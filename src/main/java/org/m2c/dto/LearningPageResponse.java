package org.m2c.dto;

import java.util.HashMap;
import java.util.List;

public class LearningPageResponse {
    String attrName;
    int pageNo; // 해당 속성의 현재 페이지 번호
    int totalPage; // 해당 속성의 총 페이지 수
    String contentTitle;
    String contentDesc;
    String quiz_value; // 문제에서 요구하는 정확한 수치 값
    HashMap requiredElements; // 현재 페이지에서 필요한 요소들 이름
    int quiz_num; // 현재 페이지에서의 문제 수
    List<String> settingCodes; // 현재 페이지에 세팅할 코드 (배열의 크기는 quizNum + 1)

    public LearningPageResponse(String attrName, int pageNo, int totalPage, String contentTitle, String contentDesc, String quiz_value, HashMap requiredElements, int quiz_num, List<String> settingCodes) {
        this.attrName = attrName;
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.contentTitle = contentTitle;
        this.contentDesc = contentDesc;
        this.quiz_value = quiz_value;
        this.requiredElements = requiredElements;
        this.quiz_num = quiz_num;
        this.settingCodes = settingCodes;
    }


    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getQuiz_value() {
        return quiz_value;
    }

    public void setQuiz_value(String quiz_value) {
        this.quiz_value = quiz_value;
    }

    public HashMap getRequiredElements() {
        return requiredElements;
    }

    public void setRequiredElements(HashMap requiredElements) {
        this.requiredElements = requiredElements;
    }

    public int getQuiz_num() {
        return quiz_num;
    }

    public void setQuiz_num(int quiz_num) {
        this.quiz_num = quiz_num;
    }

    public List<String> getSettingCodes() {
        return settingCodes;
    }

    public void setSettingCodes(List<String> settingCodes) {
        this.settingCodes = settingCodes;
    }
}
