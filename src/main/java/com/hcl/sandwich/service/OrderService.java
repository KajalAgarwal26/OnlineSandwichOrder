package com.hcl.sandwich.service;


import java.util.List;

import com.hcl.sandwich.dto.OrderRequestBodyDto;
import com.hcl.sandwich.dto.ResponseDto;
import com.hcl.sandwich.dto.ResponseViewOrderDto;
import com.hcl.sandwich.entity.Items;
import com.hcl.sandwich.exception.DataNotFoundException;
import com.hcl.sandwich.exception.UserNotFoundException;

public interface OrderService {
	
	public ResponseDto placeOrder(OrderRequestBodyDto orderRequestDto) throws DataNotFoundException;
	public ResponseViewOrderDto viewOrder(Long orderId) throws DataNotFoundException;
	List<Items> getUserOrderPrefrenceDetails(Long userId) throws UserNotFoundException;

}
