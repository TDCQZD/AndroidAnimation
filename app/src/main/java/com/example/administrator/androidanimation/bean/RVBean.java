package com.example.administrator.androidanimation.bean;


public class RVBean {

    private String name;

    private int resId;

    private String desc;

    public RVBean(String name, int resId, String desc) {
        this.name = name;
        this.resId = resId;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
