package com.test.demo.entity;
//和数据库字段匹配
public class NavigationUrl {
    private int num;
    private String url;
    private String name;
    private String tips;

    public NavigationUrl(int num, String url, String name, String tips) {
        this.num = num;
        this.url = url;
        this.name = name;
        this.tips = tips;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
