package com.test.demo.entity;

public class SwiperUrl {
    //数据类
    private int num;
    private String url;

    public SwiperUrl(int num, String url) {
        this.num = num;
        this.url = url;
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
}
