package com.tyss.myresturantapplication.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.myresturantapplication.dto.SuperAdmin;

public class SuperAdminDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public SuperAdmin verifySuperAdmin(String email, String password) {
		String sql = "select s from SuperAdmin s where s.email=?1 and s.password=?2";
		Query query = manager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (SuperAdmin) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
