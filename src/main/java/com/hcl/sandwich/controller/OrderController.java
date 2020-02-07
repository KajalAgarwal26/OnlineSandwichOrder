package com.hcl.sandwich.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Orders")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class OrderController {
	
}
