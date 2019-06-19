package com.lx.service;

import com.lx.model.media;

public interface mediaService {
	void insertMedia(media media);
	media selectByName(String name);
}
