package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.Items;


@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{

}
