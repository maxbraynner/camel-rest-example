package com.max.camelrest.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.max.camelrest.dto.Order;

@Service
@Validated
public class OrderService {

	private List<Order> orders = new ArrayList<>();

	@PostConstruct
	public void init() {
		orders.add(new Order(1, "Mobile", 50));
		orders.add(new Order(2, "Back-End", 60));
		orders.add(new Order(1, "Full-Stack", 70));
		orders.add(new Order(1, "Python", 80));
	}

	public Order addOrder(@Valid Order order) {
		orders.add(order);
		return order;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
}
