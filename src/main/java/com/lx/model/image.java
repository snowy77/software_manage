package com.lx.model;

public class image {
	private int id;
	private String name;
	private String img;
	public image() {
		super();
	}
	public image(String name, String img) {
		super();
		this.name = name;
		this.img = img;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
