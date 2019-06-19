package com.lx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.chooseDao;
import com.lx.model.choose;
@Service
public class chooseServiceImpl implements chooseService{
	@Autowired
	private chooseDao dao;

	@Override
	public void addChoose(int cno, int uno) {
		// TODO Auto-generated method stub
		dao.addChoose(cno, uno);
		
	}

	@Override
	public ArrayList<choose> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public void deleteChoose(int cno, int uno) {
		// TODO Auto-generated method stub
		dao.deleteChoose(cno, uno);
	}

	
	@Override
	public void updateChoose_student(int uno) {
		// TODO Auto-generated method stub
		dao.updateChoose_student(uno);
	}

	@Override
	public choose queryByUno(int uno) {
		// TODO Auto-generated method stub
		return dao.queryByUno(uno);
	}

	@Override
	public ArrayList<choose> queryByCno(int cno) {
		// TODO Auto-generated method stub
		return dao.queryByCno(cno);
	}

	@Override
	public void updateChoose_teacher(int no, int grade) {
		// TODO Auto-generated method stub
		dao.updateChoose_teacher(no, grade);
	}

	@Override
	public ArrayList<choose> queryByGrade(int cno) {
		// TODO Auto-generated method stub
		return dao.queryByGrade(cno);
	}

	@Override
	public void deleteChooseNo(int no) {
		// TODO Auto-generated method stub
		dao.deleteChooseNo(no);
	}

	
	

	

}
