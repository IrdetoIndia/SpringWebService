package com.irdeto.androidtv.dao;

import java.util.List;

import com.irdeto.androidtv.entity.Live;

public interface ILiveDAO {
	void addLive(Live live);
	List<Live> getLive();
}
