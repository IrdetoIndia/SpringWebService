package com.irdeto.androidtv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.androidtv.dao.IVodDAO;
import com.irdeto.androidtv.entity.Vod;

@Service
public class VodService implements IVodService{

	@Autowired
	private IVodDAO vodDAO;
	
	@Override
	public void addVod(Vod vod) {
		vodDAO.addVod(vod);
	}

	@Override
	public List<Vod> getVod() {
		return vodDAO.getVod();
	}

}
