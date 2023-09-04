package com.tyss.myresturantapplication.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.myresturantapplication.dto.BranchManager;

public class BranchManagerDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public BranchManager saveBranchManager(BranchManager branchManager) {
		transaction.begin();
		manager.merge(branchManager);
		transaction.commit();
		return branchManager;
	}

	public BranchManager findBranchManagerById(int id) {
		return manager.find(BranchManager.class, id);
	}

	public boolean deleteBranchManagerById(int id) {
		BranchManager branchManager = findBranchManagerById(id);
		if (branchManager != null) {
			transaction.begin();
			manager.remove(branchManager);
			transaction.commit();
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	

}
