package com.hcl.sandwich.dto;

import java.util.List;

public class ResponseViewOrderDto {
	private List<OrderItemDetailsDto> orderItems;
	private String orderDate;
	private double totalAmount;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<OrderItemDetailsDto> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDetailsDto> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
