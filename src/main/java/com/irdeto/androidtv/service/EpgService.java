package com.irdeto.androidtv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irdeto.androidtv.dao.IEpgDAO;
import com.irdeto.androidtv.entity.Epg;

@Service
public class EpgService implements IEpgService {

	@Autowired
	private IEpgDAO epgDAO;
	
	@Override
	public void addEpg(Epg epg) {
		epgDAO.addEpg(epg);
	}

	@Override
	public List<Epg> getEpg() {
		return epgDAO.getEpg();
	}

	@Override
	public List<Epg> getEpgByServiceId(int serviceId) {
		return epgDAO.getEpgByServiceId(serviceId);
	}

}
