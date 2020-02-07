package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.sandwich.entity.Items;

public interface ItemRepository extends JpaRepository<Items, Long>{

}
