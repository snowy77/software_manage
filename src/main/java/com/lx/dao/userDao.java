package com.lx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lx.model.user;

public interface userDao {
	
    user queryByUno(int uno);

 	List<user> queryByFlag(String flag);
 	void updateUser(user u);
 	void deleteUser(int uno);
 	int addUser(user u);
 	user queryByid(@Param("no") String no,@Param("name") String name);
 	
}
