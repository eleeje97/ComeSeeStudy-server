package org.m2c.dto;

import java.util.HashMap;

public class AnswerCheckResponse {
    String attrName;
    int pageNo;
    int quizNum; // 문제 수
    HashMap<String, String> userAnswers; // 사용자가 입력한 답
    HashMap<String, String> answerCodes; // 정답 코드
    HashMap<String, Boolean> answerCheck; // 정답 여부


    public AnswerCheckResponse(String attrName, int pageNo, int quizNum, HashMap<String, String> userAnswers, HashMap<String, String> answerCodes, HashMap<String, Boolean> answerCheck) {
        this.attrName = attrName;
        this.pageNo = pageNo;
        this.quizNum = quizNum;
        this.userAnswers = userAnswers;
        this.answerCodes = answerCodes;
        this.answerCheck = answerCheck;
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

    public int getQuizNum() {
        return quizNum;
    }

    public void setQuizNum(int quizNum) {
        this.quizNum = quizNum;
    }

    public HashMap<String, String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(HashMap<String, String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public HashMap<String, String> getAnswerCodes() {
        return answerCodes;
    }

    public void setAnswerCodes(HashMap<String, String> answerCodes) {
        this.answerCodes = answerCodes;
    }

    public HashMap<String, Boolean> getAnswerCheck() {
        return answerCheck;
    }

    public void setAnswerCheck(HashMap<String, Boolean> answerCheck) {
        this.answerCheck = answerCheck;
    }
}
