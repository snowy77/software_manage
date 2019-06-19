package com.lx.model;

public class course {
	private int cno;
	private String cname;
	private user user;
	public course() {
		super();
	}
	public course(int cno, String cname, com.lx.model.user user) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.user = user;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	
	
}
