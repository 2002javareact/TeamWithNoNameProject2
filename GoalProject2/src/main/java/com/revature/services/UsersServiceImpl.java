package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	
	@Override
	public Users getUserByID(int id) {
		// TODO Auto-generated method stub
		return ud.getOne(id);
	}

	@Override
	@Transactional// is from spring transactions, its special annotation we can put on a method that makes everything in that method become a database transaction
	public Users updateUser(Users u) {
		
		//To do an update we leverage hibernate automatic dirty checking
		//we find the object to update and thern set whatever fields to their new values
		// make sure to do it in one transaction using the @transactional annotation
		Users oldUser = ud.getOne(u.getUserId());
		if(!u.getFirstName().equals("")) {
			oldUser.setFirstName(u.getFirstName());
		}
		if(!u.getEmail().equals("")) {
			oldUser.setEmail(u.getEmail());
		}
		if(!u.getLastName().equals("")) {
			oldUser.setLastName(u.getLastName());
		}
		if(!u.getUsername().equals("")) {
			oldUser.setUsername(u.getUsername());
		}
		if(!u.getPassword().equals("")) {
			oldUser.setPassword(u.getPassword());
		}
		return oldUser;
	}

	@Override
	public List<Users> getAllUsers() {
		return ud.findAll(Sort.by(Sort.Direction.ASC, "userId")); //Sorted By userId asc
	}
	
	@Override
	public Users deleteUserByID(int id) {
		// TODO Auto-generated method stub
		ud.deleteById(id);
		return new Users();
	}
	
	@Override
	public long getTotalUsers()
	{
		return ud.count();		
	}
	
	
}
