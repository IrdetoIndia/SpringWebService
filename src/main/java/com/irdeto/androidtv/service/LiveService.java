package com.irdeto.androidtv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.androidtv.dao.ILiveDAO;
import com.irdeto.androidtv.entity.Live;

@Service
public class LiveService implements ILiveService{

	@Autowired
	private ILiveDAO liveDAO;
	
	@Override
	public synchronized void addLive(Live live) {
		liveDAO.addLive(live);
	}

	@Override
	public List<Live> getLive() {
		return liveDAO.getLive();
	}

}
