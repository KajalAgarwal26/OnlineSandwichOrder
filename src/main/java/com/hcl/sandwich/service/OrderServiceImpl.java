package com.hcl.sandwich.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.hcl.sandwich.exception.UserNotFoundException;
import com.hcl.sandwich.repository.ItemRepository;
import com.hcl.sandwich.repository.OrderItemRepository;
import com.hcl.sandwich.repository.OrderRepository;
import com.hcl.sandwich.util.LibraryUtil;
import com.hcl.sandwich.util.SANDUTIL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderServiceImpl implements OrderService {

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
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
	
	
	/**
	 * Method to get user order preference based on particular userId.
	 * 
	 * @throws UserNotFoundException 
	 */
	@Override
	public List<Items> getUserOrderPrefrenceDetails(Long userId) throws UserNotFoundException {

		logger.debug("Inside OrderServiceImpl :: getUserOrderPrefrenceDetails");
		
		if(userId == null) {
			throw new UserNotFoundException(SANDUTIL.USER_NOT_FOUND);
		}			
		
		List<Items> listItems = new ArrayList<Items>();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		// fetch all the orders for userId.
		List<Orders> orderList = orderRepository.findByUserId(userId);
		for(Orders order : orderList) {			
			List<OrderItems> orderItemsList = orderItemRepository.findByOrderId(order.getOrderId());
			for(OrderItems orderItems : orderItemsList) {				
				if(!map.containsKey(orderItems.getItemId())) {					
					map.put(orderItems.getItemId(), 1);
				}else {					
					map.put(orderItems.getItemId(), map.get(orderItems.getItemId()) + 1);
				}
			}			
		}
				
        //populate item list.
        for (Map.Entry<Long, Integer> en : map.entrySet()) {         	
        	if(en.getValue() >= 3) {
        		java.util.Optional<Items> item = itemRepository.findById(en.getKey());
            	if(item.isPresent()) {
            		listItems.add(item.get());
            	} 
        	}        	
        }          
		return listItems;
	}

}
