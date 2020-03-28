package com.revature.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.models.Goals;


public interface GoalsService {

	public Goals saveNewGoal(Goals g);
	
	public Goals getGoalByID(int id);
	public Goals updateGoal(Goals g);
	public List<Goals> getAllGoalByUserId(int id);

}
