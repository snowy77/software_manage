package com.lx.dao;

import java.util.List;

import com.lx.model.image;

public interface imageDao {
	image selectById(int id);
	/**
	 * 添加用户信息
	 * @return 
	 */
	void insertImage(image img);
	
	/**
	 * 修改用户信息
	 */
	void updateImage(image img);
	
	/**
	 * 显示用户信息
	 */
	List<image> selectAll();
	
	/**
	 * 删除用户信息
	 */
	void deleteImage(int id);
}
