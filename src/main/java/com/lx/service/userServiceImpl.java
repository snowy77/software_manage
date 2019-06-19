package com.lx.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.userDao;
import com.lx.model.user;
@Service
public class userServiceImpl implements userSerivice{
	@Autowired
	private userDao dao;
	
	public int login(String name,String no,String password){
		
		int r=0;
		user u=dao.queryByid(no,name);
		if(u!=null){
			System.out.println("sisjf");
			if(u.getPassword().equals(password))
				r=1;
			else
				r=2;
		}
		return r;
	}

	@Override
	public user queryByUno(int uno) {
		// TODO Auto-generated method stub
		return dao.queryByUno(uno);
	}

	@Override
	public List<user> queryByFlag(String flag) {
		// TODO Auto-generated method stub
		return dao.queryByFlag(flag);
	}

	@Override
	public void updateUser(user u) {
		// TODO Auto-generated method stub
		dao.updateUser(u);
	}

	@Override
	public void deleteUser(int uno) {
		// TODO Auto-generated method stub
		dao.deleteUser(uno);
	}

	@Override
	public int addUser(user u) {
		// TODO Auto-generated method stub
		return dao.addUser(u);
	}

	@Override
	public user queryByid(String no, String name) {
		// TODO Auto-generated method stub
		return dao.queryByid(no, name);
	}

	
	
	

	
}
