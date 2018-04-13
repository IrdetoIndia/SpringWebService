package com.irdeto.androidtv.service;

import java.util.List;

import com.irdeto.androidtv.entity.Live;

public interface ILiveService {
	void addLive(Live live);
	List<Live> getLive();
}
