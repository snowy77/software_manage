package com.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.replyDao;
import com.lx.model.reply;
import com.lx.model.words;
@Service
public class replyServiceImpl implements replyService{
	
	@Autowired
	private replyDao dao;
	
	
	
	@Override
	public void insertReply(reply reply) {
		// TODO Auto-generated method stub
		dao.insertReply(reply);
	}



	@Override
	public List<reply> selectByWords(int words_id, int media_id) {
		// TODO Auto-generated method stub
		return dao.selectByWords(words_id, media_id);
	}





}
