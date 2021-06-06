package com.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(value=JsonInclude.Include.NON_NULL)
public class Information {

    private Long info_id;
    private String cates_name;
    private String username;
    private String info_title;
    private String info_content;
    private String info_phone;
    private String info_price;
    private String info_datestart;
    private String info_dateend;

    public java.lang.Long getInfo_id() {
        return info_id;
    }

    public void setInfo_id(java.lang.Long info_id) {
        this.info_id = info_id;
    }

    public java.lang.String getCates_name() {
        return cates_name;
    }

    public void setCates_name(java.lang.String cates_name) {
        this.cates_name = cates_name;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getInfo_title() {
        return info_title;
    }

    public void setInfo_title(java.lang.String info_title) {
        this.info_title = info_title;
    }

    public java.lang.String getInfo_content() {
        return info_content;
    }

    public void setInfo_content(java.lang.String info_content) {
        this.info_content = info_content;
    }

    public java.lang.String getInfo_phone() {
        return info_phone;
    }

    public void setInfo_phone(java.lang.String info_phone) {
        this.info_phone = info_phone;
    }

    public java.lang.String getInfo_price() {
        return info_price;
    }

    public void setInfo_price(java.lang.String info_price) {
        this.info_price = info_price;
    }

    public java.lang.String getInfo_datestart() {
        return info_datestart;
    }

    public void setInfo_datestart(java.lang.String info_datestart) {
        this.info_datestart = info_datestart;
    }

    public java.lang.String getInfo_dateend() {
        return info_dateend;
    }

    public void setInfo_dateend(java.lang.String info_dateend) {
        this.info_dateend = info_dateend;
    }

    public Information(java.lang.Long info_id, java.lang.String cates_name, java.lang.String username, java.lang.String info_title, java.lang.String info_content, java.lang.String info_phone, java.lang.String info_price, java.lang.String info_datestart, java.lang.String info_dateend) {
        this.info_id = info_id;
        this.cates_name = cates_name;
        this.username = username;
        this.info_title = info_title;
        this.info_content = info_content;
        this.info_phone = info_phone;
        this.info_price = info_price;
        this.info_datestart = info_datestart;
        this.info_dateend = info_dateend;
    }
}
