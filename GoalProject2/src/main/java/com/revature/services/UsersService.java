package com.revature.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.models.Users;

public interface UsersService {
	public Users loginUser(String username, String password);	
	public Users saveNewUser(Users u);
	
	public Users getUserByID(int id);
	public Users updateUser(Users u);
	public List<Users> getAllUsers();
	public Users deleteUserByID(int id);
	
	public long getTotalUsers();
}
