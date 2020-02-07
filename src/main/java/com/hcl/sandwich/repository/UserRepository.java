package com.hcl.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sandwich.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
