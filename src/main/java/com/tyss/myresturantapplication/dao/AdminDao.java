package com.tyss.myresturantapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.myresturantapplication.dto.Admin;
import com.tyss.myresturantapplication.dto.Branch;

public class AdminDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public Admin saveAdmin(Admin admin) {
		transaction.begin();
		manager.persist(admin);
		transaction.commit();
		return admin;
	}

	public Admin updateAdmin(Admin admin) {
		transaction.begin();
		manager.merge(admin);
		transaction.commit();
		return admin;
	}

	public Admin findAdmin(int id) {
		return manager.find(Admin.class, id);
	}

	public boolean deleteAdmin(int id) {
		Admin admin = findAdmin(id);
		if (admin != null) {
			List<Branch> branchs = admin.getBranchs();
			branchs = null;
			admin.setBranchs(branchs);
			transaction.begin();
			manager.merge(admin);
			manager.remove(admin);
			transaction.commit();
			return true;
		}
		return false;
	}

	public List<Admin> findAllAdmin() {
		return manager.createQuery("from Admin").getResultList();
	}

}
