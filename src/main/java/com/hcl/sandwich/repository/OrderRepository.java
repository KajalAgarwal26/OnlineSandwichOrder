package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}
