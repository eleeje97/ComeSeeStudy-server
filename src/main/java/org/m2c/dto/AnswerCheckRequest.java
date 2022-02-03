package org.m2c.dto;

import java.util.HashMap;

public class AnswerCheckRequest {
    String attrName;
    int pageNo;
    HashMap<String, String> answers;

    public AnswerCheckRequest(String attrName, int pageNo, HashMap<String, String> answers) {
        this.attrName = attrName;
        this.pageNo = pageNo;
        this.answers = answers;
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

    public HashMap<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, String> answers) {
        this.answers = answers;
    }
}
