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
	import com.revature.models.Goals;
	import com.revature.services.GoalsService;

	
	@RestController // this is the same as @Controller and @responsebody above every method
	@RequestMapping("goals")//base path for the class, 
	@CrossOrigin//for doing cors on a per controller basis
	public class GoalsController {
		
		
		private GoalsService gs;
		
		@Autowired
		public GoalsController(GoalsService gs) {
			this.gs = gs;
		}
		

		
		@PostMapping// this matches post key word
		public ResponseEntity<Goals> saveNewGoal(@RequestBody Goals g){// will try and turn the body into the object type on its right
			if(g.getGoalId() != 0) {
				return new ResponseEntity("goalId must be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Goals>(gs.saveNewGoal(g), HttpStatus.CREATED);
		}
		
		@GetMapping("{id}")// how to do pathvariables in spring
		public ResponseEntity<Goals> getGoalById(@PathVariable int id){
			if(id == 0) {
				return new ResponseEntity("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Goals>(gs.getGoalByID(id), HttpStatus.OK);
		}

		@PatchMapping
		public ResponseEntity<Goals> updateGoal(@RequestBody Goals g){// will try and turn the body into the object type on its right
			if(g.getGoalId() == 0) {
				return new ResponseEntity("goalId must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Goals>(gs.updateGoal(g), HttpStatus.CREATED);
		}
		
		@GetMapping("user/{id}")// how to do pathvariables in spring
		public ResponseEntity<List<Goals>> getAllGoalByUserId(@PathVariable int id){
			if(id == 0) {
				return new ResponseEntity("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity(gs.getAllGoalByUserId(id), HttpStatus.OK);
		}
		
		
	}


