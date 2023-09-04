package com.tyss.myresturantapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.myresturantapplication.dto.BranchManager;
import com.tyss.myresturantapplication.dto.FoodOrder;
import com.tyss.myresturantapplication.dto.Item;
import com.tyss.myresturantapplication.dto.Staff;

public class StaffDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public Staff saveStaff(Staff staff) {

		if (staff != null) {
			transaction.begin();
			manager.merge(staff);
			transaction.commit();
			return staff;
		}
		return null;

	}

	public Staff findStaffById(int id) {
		return manager.find(Staff.class, id);
	}

	public boolean deleteStaffById(int id) {

		Staff staff = findStaffById(id);
		if (staff != null) {
			transaction.begin();
			manager.remove(staff);
			
			
			transaction.commit();
			return true;
		}

		return false;
	}

	public Staff verifyStaffByEmailAndPassword(String email, String password) {
		Query query = manager.createQuery("select s from Staff s where s.email=?1 and s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Staff> staffs = query.getResultList();
		if (staffs.size() > 0) {
			return staffs.get(0);
		}
		return null;

	}

	public List<Item> updateStaffItemList(Staff staff, Item item) {

		if (staff != null) {
			transaction.begin();

			List<Item> items = staff.getItems();
			items.add(item);
			staff.setItems(items);

			manager.merge(staff);
			transaction.commit();
			return items;
		}

		return null;
	}

	public List<FoodOrder> updateStaffFoodOrderList(Staff staff, FoodOrder foodOrder) {

		if (staff != null) {
			transaction.begin();

			List<FoodOrder> foodOrders = staff.getFoodOrders();
			foodOrders.add(foodOrder);
			staff.setFoodOrders(foodOrders);

			manager.merge(staff);
			transaction.commit();
			return foodOrders;
		}
		return null;
	}

	public BranchManager updateStaffBranchManager(Staff staff, BranchManager branchManager) {

		if (staff != null && branchManager != null) {
			transaction.begin();
			staff.setBranchManager(branchManager);
			manager.merge(staff);
			transaction.commit();
			return branchManager;
		}

		return null;
	}

}
