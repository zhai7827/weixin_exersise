package com.zhai.vo;

import java.io.Serializable;


public class BookQueryVo implements Serializable{

	private Integer id;

	private String name; //作品书名


	private String recommend; //推荐语（短简介）
	private Integer status; //状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
