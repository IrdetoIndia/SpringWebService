package com.irdeto.androidtv.service;

import java.util.List;

import com.irdeto.androidtv.entity.Epg;

public interface IEpgService {
	void addEpg(Epg epg);
	List<Epg> getEpg();
}
