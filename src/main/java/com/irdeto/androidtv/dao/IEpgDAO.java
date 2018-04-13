package com.irdeto.androidtv.dao;

import java.util.List;

import com.irdeto.androidtv.entity.Epg;

public interface IEpgDAO {
	void addEpg(Epg epg);
	List<Epg> getEpg();
}
