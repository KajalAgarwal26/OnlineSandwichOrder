package com.hcl.sandwich.service;
import com.hcl.sandwich.dto.LoginDto;
import com.hcl.sandwich.dto.LoginResponseDto;

public interface UserService {
	
	 LoginResponseDto usersLogin(LoginDto userDto); 
}
