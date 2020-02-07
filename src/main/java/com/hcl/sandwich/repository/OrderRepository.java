package com.hcl.sandwich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
	
	@Query(value="select * from orders where user_id=? order by order_id desc limit 1",nativeQuery=true)
	Orders findOrderByUserId(Long userId);
	
	List<Orders> findByUserId(long userId);
	
}
