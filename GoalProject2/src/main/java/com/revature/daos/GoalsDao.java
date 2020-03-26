package com.revature.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Goals;
import com.revature.models.Users;

@Repository//This is all we need

public interface GoalsDao extends JpaRepository<Goals,Integer> {

	public List<Goals> findByUserId(int id);
	
}
