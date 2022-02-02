package org.m2c.dto;

import java.util.HashMap;
import java.util.List;

public class LearningPageResponse {
    String attrName;
    int pageNo; // 해당 속성의 현재 페이지 번호
    int totalPage; // 해당 속성의 총 페이지 수
    String contentTitle;
    String contentDesc;
    String quizValue; // 문제에서 요구하는 정확한 수치 값
    HashMap requiredElements; // 현재 페이지에서 필요한 요소들 이름
    int quizNum; // 현재 페이지에서의 문제 수
    List<String> settingCodes; // 현재 페이지에 세팅할 코드 (배열의 크기는 quizNum + 1)
    HashMap answerCodes; // 정답 코드

    public LearningPageResponse(String attrName, int pageNo, int totalPage, String contentTitle, String contentDesc, String quizValue, HashMap requiredElements, int quizNum, List<String> settingCodes, HashMap answerCodes) {
        this.attrName = attrName;
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.contentTitle = contentTitle;
        this.contentDesc = contentDesc;
        this.quizValue = quizValue;
        this.requiredElements = requiredElements;
        this.quizNum = quizNum;
        this.settingCodes = settingCodes;
        this.answerCodes = answerCodes;
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

    public String getQuizValue() {
        return quizValue;
    }

    public void setQuizValue(String quizValue) {
        this.quizValue = quizValue;
    }

    public HashMap getRequiredElements() {
        return requiredElements;
    }

    public void setRequiredElements(HashMap requiredElements) {
        this.requiredElements = requiredElements;
    }

    public int getQuizNum() {
        return quizNum;
    }

    public void setQuizNum(int quizNum) {
        this.quizNum = quizNum;
    }

    public List<String> getSettingCodes() {
        return settingCodes;
    }

    public void setSettingCodes(List<String> settingCodes) {
        this.settingCodes = settingCodes;
    }

    public HashMap getAnswerCodes() {
        return answerCodes;
    }

    public void setAnswerCodes(HashMap answerCodes) {
        this.answerCodes = answerCodes;
    }
}
