package com.lx.model;

public class words {
	private int id;
	private String name;
	private String date;
	private String content;
	private int media_id;
	public words() {
		super();
	}
	public words(String name, String date, String content, int media_id) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.media_id = media_id;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	
}
