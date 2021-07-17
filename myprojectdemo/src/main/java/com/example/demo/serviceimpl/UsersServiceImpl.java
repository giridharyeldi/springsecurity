package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repo.UsersRepository;
import com.example.demo.service.UsersService;
import com.example.demo.utility.ObjectConverter;
import com.example.demo.utility.ResponseUtility;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired private UsersRepository userRepo;
	
	
	@Override
	public Users createUser(Users user) {
		Users tmpUser = userRepo.save(user);
		return tmpUser;
	}

}
