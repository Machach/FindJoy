package com.fuxuemingzhu.findjoy.joy.model.bean;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyPage {
    private int allNum;
    private int allPage;

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public com.fuxuemingzhu.findjoy.model.bean.ImageJoy[] getContentlist() {
        return contentlist;
    }

    public void setContentlist(com.fuxuemingzhu.findjoy.model.bean.ImageJoy[] contentlist) {
        this.contentlist = contentlist;
    }

    private com.fuxuemingzhu.findjoy.model.bean.ImageJoy[] contentlist;
}
