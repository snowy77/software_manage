package com.lx.service;

import java.util.ArrayList;

import com.lx.model.course;
import com.lx.model.user;

public interface courseService {
	ArrayList<course> queryAll();
	void insertCourse(user u);
	void deleteCourse(int uno);
	course queryByNo(int cno);
	course queryByUno(int uno);
}
