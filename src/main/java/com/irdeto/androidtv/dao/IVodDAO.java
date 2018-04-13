package com.irdeto.androidtv.dao;

import java.util.List;

import com.irdeto.androidtv.entity.Vod;

public interface IVodDAO {
	void addVod(Vod vod);
	List<Vod> getVod();
}
