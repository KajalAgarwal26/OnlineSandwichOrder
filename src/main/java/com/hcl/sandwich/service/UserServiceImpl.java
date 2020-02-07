package com.hcl.sandwich.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hcl.sandwich.dto.LoginDto;
import com.hcl.sandwich.dto.LoginResponseDto;
import com.hcl.sandwich.entity.Users;
import com.hcl.sandwich.exception.UserNotFoundException;
import com.hcl.sandwich.repository.UserRepository;
import com.hcl.sandwich.util.LibraryUtil;
import com.hcl.sandwich.util.SANDUTIL;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		List<Users> users = userRepository.findAll();
		
		LoginResponseDto responseDto = new LoginResponseDto();

		for (Users user : users) {
			if((userDto.getuName().equalsIgnoreCase(user.getUserName()))&& (user.getUserPassword()).equals(userDto.getPassword())) {
				responseDto.setMessage(LibraryUtil.LOGIN_SUCCESS);
				responseDto.setStatusCode(HttpStatus.OK.value());
				responseDto.setUserId(user.getUserId());
				return responseDto;
			}
			else {
				throw new UserNotFoundException(SANDUTIL.USER_NOT_FOUND);
			}
		}
		return responseDto;
	}

}
