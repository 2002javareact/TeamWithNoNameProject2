package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UsersDao;
import com.revature.models.Users;

@Service
public class UsersServiceImpl implements UsersService{

	private UsersDao ud;
	
	@Autowired
	public UsersServiceImpl(UsersDao ud) {
		this.ud = ud;
	}
	
	@Override
	public Users loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return ud.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public Users saveNewUser(Users u) {
		
		return ud.save(u);
	}

	
}
