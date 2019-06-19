package com.lx.model;

public class choose {
	private int no;
	private course course;
	private user user;
	private int grade;
	public choose() {
		super();
	}
	public choose(int no, com.lx.model.course course, com.lx.model.user user, int grade) {
		super();
		this.no = no;
		this.course = course;
		this.user = user;
		this.grade = grade;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public course getCourse() {
		return course;
	}
	public void setCourse(course course) {
		this.course = course;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	

	
}
