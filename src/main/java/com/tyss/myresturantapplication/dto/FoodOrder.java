package com.tyss.myresturantapplication.dto;

import java.time.LocalDateTime;
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
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private double totalAmount;
	private LocalDateTime orderCreatedTime;
	private LocalDateTime orderDeliverdTime;
	private String customerName;
	private long customerPhone;
	
	@OneToMany
	List<Item> items;

	@ManyToOne
	Staff staff;

}
