package com.hcl.sandwich.service;


import com.hcl.sandwich.dto.OrderRequestBodyDto;
import com.hcl.sandwich.dto.ResponseDto;
import com.hcl.sandwich.dto.ResponseViewOrderDto;
import com.hcl.sandwich.exception.DataNotFoundException;

public interface OrderService {
	
	public ResponseDto placeOrder(OrderRequestBodyDto orderRequestDto) throws DataNotFoundException;
	public ResponseViewOrderDto viewOrder(Long orderId) throws DataNotFoundException;

}
