package com.hcl.sandwich.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.sandwich.dto.OrderRequestBodyDto;
import com.hcl.sandwich.dto.ResponseDto;
import com.hcl.sandwich.dto.ResponseViewOrderDto;
import com.hcl.sandwich.exception.DataNotFoundException;
import com.hcl.sandwich.service.OrderService;

@RestController
@RequestMapping("/Orders")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Void> placeOrder(@RequestBody OrderRequestBodyDto orderRequestBodyDto) throws DataNotFoundException
	{
		orderService.placeOrder(orderRequestBodyDto);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	

	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<ResponseViewOrderDto> viewOrder(@PathVariable("id") Long id) throws DataNotFoundException
	{
			
		ResponseViewOrderDto responseViewOrderDto=orderService.viewOrder(id);
		responseViewOrderDto.setMessage("Success");
		return new ResponseEntity<>(responseViewOrderDto,HttpStatus.OK);
	}
	
	
}
