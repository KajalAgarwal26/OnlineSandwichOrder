package com.hcl.sandwich.controller;
/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.sandwich.dto.ItemResponseDto;
import com.hcl.sandwich.service.ItemsService;
import com.hcl.sandwich.util.SANDUTIL;

@RestController
@RequestMapping("/items")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class ItemsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
	
	
	 @Autowired 
	 ItemsService itemsService;
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @PostMapping("/allitems") 
	 public ResponseEntity<ItemResponseDto> getAllItems() { 
		 LOGGER.info(SANDUTIL.LOGIN_METHOD);
		 ItemResponseDto itemResponseDto = itemsService.getAllItems();
		 return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
	 }
}