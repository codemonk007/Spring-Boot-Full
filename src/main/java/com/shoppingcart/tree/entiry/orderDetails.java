package com.shoppingcart.tree.entiry;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

public class orderDetails {
	
	@Id
	public String id;
	public LocalDateTime orderTime;
	public String status;
	public List<orderBase> orderDetails;
	
	public orderDetails() {
		// TODO Auto-generated constructor stub
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public LocalDateTime getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<orderBase> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<orderBase> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public orderDetails(String id, LocalDateTime orderTime, String status, List<orderBase> orderDetails) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.status = status;
		this.orderDetails = orderDetails;
	}


	@Override
	public String toString() {
		return "orderDetails [orderTime=" + orderTime + ", status=" + status + ", orderDetails=" + orderDetails + "]";
	}
	
	
}
