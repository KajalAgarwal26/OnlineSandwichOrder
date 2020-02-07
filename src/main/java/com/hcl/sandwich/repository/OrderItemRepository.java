package com.hcl.sandwich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.OrderItems;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

	List<OrderItems> findByOrderId(Long orderId);

}
