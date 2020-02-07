package com.hcl.sandwich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
	
	List<Orders> findByUserId(long userId);
	
}
