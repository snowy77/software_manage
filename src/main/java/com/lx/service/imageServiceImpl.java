package com.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.imageDao;
import com.lx.model.image;

@Service
public class imageServiceImpl implements imageService{
	@Autowired
	private imageDao dao;

	@Override
	public image selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public void insertImage(image img) {
		// TODO Auto-generated method stub
		dao.insertImage(img);
	}

	@Override
	public void updateImage(image img) {
		// TODO Auto-generated method stub
		dao.updateImage(img);
	}

	@Override
	public List<image> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void deleteImage(int id) {
		// TODO Auto-generated method stub
		dao.deleteImage(id);
	}

}
