package org.m2c.dto;

public class MainPageResponse {
    String attrName;
    String attrMainTitle;
    String prevAttr;
    String nextAttr;

    public MainPageResponse(String attrName, String attrMainTitle, String prevAttr, String nextAttr) {
        this.attrName = attrName;
        this.attrMainTitle = attrMainTitle;
        this.prevAttr = prevAttr;
        this.nextAttr = nextAttr;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrMainTitle() {
        return attrMainTitle;
    }

    public void setAttrMainTitle(String attrMainTitle) {
        this.attrMainTitle = attrMainTitle;
    }

    public String getPrevAttr() {
        return prevAttr;
    }

    public void setPrevAttr(String prevAttr) {
        this.prevAttr = prevAttr;
    }

    public String getNextAttr() {
        return nextAttr;
    }

    public void setNextAttr(String nextAttr) {
        this.nextAttr = nextAttr;
    }
}
