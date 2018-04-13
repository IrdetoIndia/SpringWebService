package com.irdeto.androidtv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irdeto.androidtv.entity.Vod;

@Transactional
@Repository
public class VodDAO implements IVodDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addVod(Vod vod) {
		entityManager.persist(vod);
	}

	@Override
	public List<Vod> getVod() {
		String hql = "FROM Vod as v ORDER BY v.vodId DESC";
		return (List<Vod>) entityManager.createQuery(hql).getResultList();
	}

}
