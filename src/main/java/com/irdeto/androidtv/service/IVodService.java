package com.irdeto.androidtv.service;

import java.util.List;

import com.irdeto.androidtv.entity.Vod;

public interface IVodService {
	void addVod(Vod vod);
	List<Vod> getVod();
}
