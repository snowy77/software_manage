package com.lx.dao;

import com.lx.model.image;
import com.lx.model.media;

public interface mediaDao {
	void insertMedia(media media);
	media selectByName(String name);
}
