package com.lx.model;

import java.util.Date;

public class media {
	private int id;
	private String title;
	private String name;
	private String src;
	private String picture;
	private String descript;
	private String uptime;
	
	public media() {
		super();
	}
	public media(int id, String title, String name, String src, String picture, String descript, String uptime) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.src = src;
		this.picture = picture;
		this.descript = descript;
		this.uptime = uptime;
	}
	public media(String title, String name, String src, String picture, String descript, String uptime) {
		super();
		this.title = title;
		this.name = name;
		this.src = src;
		this.picture = picture;
		this.descript = descript;
		this.uptime = uptime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
}
