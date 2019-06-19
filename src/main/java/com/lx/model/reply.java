package com.lx.model;

public class reply {
	private int id;
	private String name;
	private String date;
	private String content;
	private int words_id;
	private int media_id;
	public reply() {
		super();
	}
	public reply(String name, String date, String content, int words_id,int media_id) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.words_id = words_id;
		this.media_id=media_id;
	}
	
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
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
	public int getWords_id() {
		return words_id;
	}
	public void setWords_id(int words_id) {
		this.words_id= words_id;
	}
	
}
