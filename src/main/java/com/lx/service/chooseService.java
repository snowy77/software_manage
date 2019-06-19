package com.lx.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.lx.model.choose;

public interface chooseService {
	void addChoose(@Param("cno") int cno,@Param("uno") int uno);
	ArrayList<choose> queryAll();
	void deleteChoose(@Param("cno") int cno,@Param("uno") int uno);
	void updateChoose_teacher(@Param("no") int no,@Param("grade") int grade);
	void updateChoose_student(int uno);
	choose queryByUno(int uno);
	ArrayList<choose> queryByCno(int cno);
	ArrayList<choose> queryByGrade(int cno);
	void deleteChooseNo(int no);
}
