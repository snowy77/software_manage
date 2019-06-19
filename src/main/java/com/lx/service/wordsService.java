package com.lx.service;

import java.util.List;

import com.lx.model.words;

public interface wordsService {
	List<words> selectByMedia(int media_id);
	void insertWords(words words);
}
