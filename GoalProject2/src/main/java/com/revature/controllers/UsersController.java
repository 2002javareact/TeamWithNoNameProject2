package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Credentials;
import com.revature.models.Users;
import com.revature.services.UsersService;

@RestController // this is the same as @Controller and @responsebody above every method
@RequestMapping("users")//base path for the class, 
@CrossOrigin//for doing cors on a per controller basis
public class UsersController {
	
	
	private UsersService us;
	
	@Autowired
	public UsersController(UsersService us) {
		this.us = us;
	}
	
	@PostMapping("login")
	public ResponseEntity<Users> login(@RequestBody Credentials cred){
		return new ResponseEntity(us.loginUser(cred.getUsername(), cred.getPassword()), HttpStatus.OK);
	}
	
	@PostMapping// this matches post key word
	public ResponseEntity<Users> saveNewUser(@RequestBody Users u){// will try and turn the body into the object type on its right
		if(u.getUserId() != 0) {
			return new ResponseEntity("userId must be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Users>(us.saveNewUser(u), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")// how to do pathvariables in spring
	public ResponseEntity<Users> getUserById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Users>(us.getUserByID(id), HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<Users> updateUser(@RequestBody Users u){// will try and turn the body into the object type on its right
		if(u.getUserId() == 0) {
			return new ResponseEntity("userId must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Users>(us.updateUser(u), HttpStatus.CREATED);
	}
	
	
	
	
}