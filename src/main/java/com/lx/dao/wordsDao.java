package com.lx.dao;

import java.util.List;

import com.lx.model.words;

public interface wordsDao {
	List<words> selectByMedia(int media_id);
	void insertWords(words words);
}
