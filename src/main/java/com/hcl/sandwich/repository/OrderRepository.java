package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.sandwich.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
