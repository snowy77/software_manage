package com.lx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.newsDao;
import com.lx.model.news;


@Service
public class newsServiceImpl implements newsService{
	@Autowired
	private newsDao dao;

	@Override
	public ArrayList<news> getAllNews() {
		// TODO Auto-generated method stub
		return dao.getAllNews();
	}

	@Override
	public void addNews(news ni) {
		// TODO Auto-generated method stub
	 dao.addNews(ni);
	}

	@Override
	public void deleteNews(int id) {
		// TODO Auto-generated method stub
		 dao.deleteNews(id);
	}

	@Override
	public void updateNews(news ni) {
		// TODO Auto-generated method stub
		 dao.updateNews(ni);
	}

	@Override
	public news getContent(int id) {
		// TODO Auto-generated method stub
		return dao.getContent(id);
	}

	@Override
	public ArrayList<news> getByType(String type) {
		// TODO Auto-generated method stub
		return dao.getByType(type);
	}
	
	
}
