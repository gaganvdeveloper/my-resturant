package com.tyss.myresturantapplication.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String role = "STAFF";

	@ManyToOne
	BranchManager branchManager;

	@OneToMany
	List<Item> items;

	@OneToMany
	List<FoodOrder> foodOrders;

}
