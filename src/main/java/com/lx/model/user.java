package com.lx.model;

public class user {
	private int uno;
	private String name;
	private String shool;
	private String no;
	private String password;
	private String email;
	private String flag;
	public user() {
		super();
	}
	
	public user( String shool, String no,String name, String password, String email, String flag) {
		super();
		this.name = name;
		this.shool = shool;
		this.no = no;
		this.password = password;
		this.email = email;
		this.flag = flag;
	}

	public user(int uno,String shool, String no, String name, String password, String email, String flag) {
		super();
		this.uno=uno;
		this.name = name;
		this.shool = shool;
		this.no = no;
		this.password = password;
		this.email = email;
		this.flag = flag;
	}
	
	public user(String name, String no, String password) {
		super();
		this.name = name;
		this.no = no;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShool() {
		return shool;
	}
	public void setShool(String shool) {
		this.shool = shool;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	
}
