package com.lx.dao;

import java.util.ArrayList;

import com.lx.model.news;

public interface newsDao {
	ArrayList<news> getAllNews();   //获取所有新闻
	void addNews(news ni);       //向数据库添加一条记录
	void deleteNews(int id);         //根据id删除数据库中一条记录
	void updateNews(news ni);    //根据id更新数据库中某条记录
	news getContent(int id);     //根据id获得该条新闻的内容
	ArrayList<news> getByType(String type);
	
}
