package com.irdeto.androidtv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irdeto.androidtv.entity.Live;

@Transactional
@Repository
public class LiveDAO implements ILiveDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addLive(Live live) {
		entityManager.persist(live);
	}

	@Override
	public List<Live> getLive() {
		String hql = "FROM Live as l ORDER BY l.liveId DESC";
		return (List<Live>) entityManager.createQuery(hql).getResultList();
	}
}
