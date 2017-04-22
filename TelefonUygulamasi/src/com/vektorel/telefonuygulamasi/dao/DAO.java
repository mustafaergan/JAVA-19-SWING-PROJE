package com.vektorel.telefonuygulamasi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vektorel.telefonuygulamasi.entity.Person;

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

}
