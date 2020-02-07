package com.hcl.sandwich.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.sandwich.dto.ItemsDto;
import com.hcl.sandwich.dto.OrderRequestBodyDto;
import com.hcl.sandwich.dto.ResponseDto;
import com.hcl.sandwich.dto.ResponseViewOrderDto;
import com.hcl.sandwich.entity.Items;
import com.hcl.sandwich.entity.OrderItems;
import com.hcl.sandwich.entity.Orders;
import com.hcl.sandwich.exception.DataNotFoundException;
import com.hcl.sandwich.repository.ItemRepository;
import com.hcl.sandwich.repository.OrderItemRepository;
import com.hcl.sandwich.repository.OrderRepository;
import com.hcl.sandwich.util.LibraryUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public ResponseDto placeOrder(OrderRequestBodyDto orderRequestDto) throws DataNotFoundException {

		ResponseDto responseDto= new ResponseDto();
		if (!Objects.isNull(orderRequestDto)) {
		    Orders orders = new Orders();
			orders.setOrderdateTime(LocalDateTime.now().toString());
			orders.setUserId(orderRequestDto.getUserId());
			orders.setStatus("Success");
			orderRepository.save(orders);
			orders.getOrderId();
			Double totalAmount = 0d;
			for (ItemsDto items : orderRequestDto.getItemDetail()) {
				OrderItems orderItems = new OrderItems();
				orderItems.setItemId(items.getItemId());
				orderItems.setQuantity(items.getQuantity());
				orderItems.setOrderId(orders.getOrderId());
				Items itemsData = itemRepository.findById(items.getItemId()).get();
				orderItems.setItemUnitPrice(itemsData.getPrice());
				double itemCost=itemsData.getPrice()*items.getQuantity();
				totalAmount = totalAmount +itemCost;
				orderItemRepository.save(orderItems);
			}
	orders=	orderRepository.findById(orders.getOrderId()).get();
	orders.setTotalAmount(totalAmount);
	orderRepository.save(orders);
		

		} else {
			
			throw new DataNotFoundException(LibraryUtil.NO_ITEM_SELECTED);
			
		}
		return  responseDto;
	}

	@Override
	public ResponseViewOrderDto viewOrder(Long orderId) throws DataNotFoundException {
	if(!Objects.isNull(orderId))
	{
		
		
	}else
	{  
		throw new DataNotFoundException(LibraryUtil.NO_ITEM_SELECTED);
		
	}
		
		
		
		return null;
	}

}
