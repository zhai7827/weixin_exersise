package com.zhai.entity.book;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer id;

    private String name; //作品书名


    private String recommend; //推荐语（短简介）
    private byte status; //状态

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
