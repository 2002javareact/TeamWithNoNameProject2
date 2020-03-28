package com.revature.services;

import java.rmi.dgc.DGC;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.GoalsDao;
import com.revature.models.Goals;


@Service
public class GoalsServiceImpl implements GoalsService {
	

	private GoalsDao gd;
	
	@Autowired
	public GoalsServiceImpl(GoalsDao gd) {
		this.gd = gd;
	}
	

	
	@Override
	public Goals saveNewGoal(Goals g) {
		return gd.save(g);
	}
	
	
	@Override
	public Goals getGoalByID(int id) {
		// TODO Auto-generated method stub
		return gd.getOne(id);
	}

	@Override
	@Transactional// is from spring transactions, its special annotation we can put on a method that makes everything in that method become a database transaction
	public Goals updateGoal(Goals g) {
		
		//To do an update we leverage hibernate automatic dirty checking
		//we find the object to update and then set whatever fields to their new values
		// make sure to do it in one transaction using the @transactional annotation
		Goals oldGoal = gd.getOne(g.getGoalId());
		
		if(g.getName() != null) {
			oldGoal.setName(g.getName());
		}
		if(g.getDescription() != null) {
			oldGoal.setDescription(g.getDescription());
		}
		if(g.getGoalLength() != 0) {
			oldGoal.setGoalLength(g.getGoalLength());
		}
		if(g.getStartDate() != null) {
			oldGoal.setCompleteDate(g.getStartDate());
		}
		if(g.getCompleteDate() != null) {
			oldGoal.setCompleteDate(g.getCompleteDate());
		}
		if(g.isSuccessful()) {
			oldGoal.setSuccessful(true);
		} else oldGoal.setSuccessful(false);
		return oldGoal;
	}



	@Override
	public List<Goals> getAllGoalByUserId(int id) {
		// TODO Auto-generated method stub
		return gd.findByUserId(id);
	}


}
