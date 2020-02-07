package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.sandwich.entity.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

}
