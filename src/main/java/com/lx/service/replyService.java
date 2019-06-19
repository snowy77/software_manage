package com.lx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lx.model.reply;
import com.lx.model.words;

public interface replyService {
	List<reply> selectByWords(@Param("words_id") int words_id,@Param("media_id") int media_id);
	void insertReply(reply reply);
}
