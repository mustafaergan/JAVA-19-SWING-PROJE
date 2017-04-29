package com.vektorel.telefonuygulamasi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vektorel.telefonuygulamasi.entity.Person;
import com.vektorel.telefonuygulamasi.entity.SorgulaEntity;

public class DAO {
	
	SessionFactory sessionFactory;

	public DAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void addValue(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx =null;
		try{
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		}catch (Exception e) {
			if(tx != null)
				tx.rollback();
		}finally {
			session.close();
		}			
	}

	public List<Person> sorgula(SorgulaEntity sorgulaEntity) {
		Session session = sessionFactory.openSession();
		Transaction tx =null;
		List<Person> myList = null;
		try{
			Criteria criteria = session.createCriteria(Person.class);
			if(sorgulaEntity.getAdSoyad() != null && sorgulaEntity.getAdSoyad().length() > 0)
				criteria.add(Restrictions.ilike("adSoyad", sorgulaEntity.getAdSoyad()));
//			criteria.add(Restrictions.between("gorusmeZamani", sorgulaEntity.getBasTarihi(), sorgulaEntity.getBitisTarihi()));
			if(sorgulaEntity.getBasTarihi() != null)
				criteria.add(Restrictions.ge("gorusmeZamani", sorgulaEntity.getBasTarihi()));
			if(sorgulaEntity.getBitisTarihi() != null)
				criteria.add(Restrictions.lt("gorusmeZamani", sorgulaEntity.getBitisTarihi()));
			if(sorgulaEntity.getType() != 0)
				criteria.add(Restrictions.eq("gorusmeTipi", sorgulaEntity.getType()));
			myList = (List<Person>)criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return myList;
	}

}
