package com.lx.model;

import java.sql.Date;



public class news {
	private int id;
	private String head;
	private String summary;
	private String body;
	private Date date;
	private String img;
	private String type;
	public news() {
		super();
	}
	
	public news(int id, String head, String summary, String body, Date date, String img, String type) {
		super();
		this.id = id;
		this.head = head;
		this.summary = summary;
		this.body = body;
		this.date = date;
		this.img = img;
		this.type = type;
	}
	
	public news(String head, String summary, String body, Date date, String img, String type) {
		super();
		this.head = head;
		this.summary = summary;
		this.body = body;
		this.date = date;
		this.img = img;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDate() {
		
		return date;
	}
	public void setDate(Date date) {
		
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
