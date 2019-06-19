package com.lx.service;

import java.util.ArrayList;

import com.lx.model.news;

public interface newsService {
	ArrayList<news> getAllNews();
	void addNews(news ni);
	void deleteNews(int id);
	void updateNews(news ni);
	news getContent(int id);
	ArrayList<news> getByType(String type);
}
