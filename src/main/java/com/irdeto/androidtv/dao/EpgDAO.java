package com.irdeto.androidtv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irdeto.androidtv.entity.Epg;

@Transactional
@Repository
public class EpgDAO implements IEpgDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEpg(Epg epg) {
		entityManager.persist(epg);
	}

	@Override
	public List<Epg> getEpg() {
		String hql = "FROM Epg as e ORDER BY e.epgId DESC";
		return (List<Epg>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public List<Epg> getEpgByServiceId(int serviceId) {
		String hql = "FROM Epg as e WHERE e.serviceId = ?";
		return (List<Epg>) entityManager.createQuery(hql).setParameter(1, serviceId).getResultList();
	}

}
