package com.lx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.mediaDao;
import com.lx.model.media;
@Service
public class mediaServiceImpl implements mediaService{
	@Autowired
	private mediaDao dao;

	@Override
	public void insertMedia(media media) {
		// TODO Auto-generated method stub
		dao.insertMedia(media);
	}

	@Override
	public media selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	

}
