package com.revature.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Think of this as a table in our Database
@Entity
public class Goals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goal_id")
	private int goalId;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "goals", referencedColumnName = "user_id")
	@Column(name = "user_id")
	private int userId;

	private String name;

	private String description;
	
	//Time in Weeks?
	@Column(name = "goal_length")
	private int goalLength;

	//One to many
	//This needs needs to be another table one to many
	private List<String> milestones;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "complete_date")
	private Date completeDate;
	
	
	// If they achieved their goal
	private boolean successful;


	public Goals() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getGoalId() {
		return goalId;
	}


	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getGoalLength() {
		return goalLength;
	}


	public void setGoalLength(int goalLength) {
		this.goalLength = goalLength;
	}


	public List<String> getMilestones() {
		return milestones;
	}


	public void setMilestones(List<String> milestones) {
		this.milestones = milestones;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getCompleteDate() {
		return completeDate;
	}


	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}


	public boolean isSuccessful() {
		return successful;
	}


	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}


	public Goals(int goalId, int userId, String name, String description, int goalLength, List<String> milestones,
			Date startDate, Date completeDate, boolean successful) {
		super();
		this.goalId = goalId;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.goalLength = goalLength;
		this.milestones = milestones;
		this.startDate = startDate;
		this.completeDate = completeDate;
		this.successful = successful;
	}


	@Override
	public String toString() {
		return "Goals [goalId=" + goalId + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", goalLength=" + goalLength + ", milestones=" + milestones + ", startDate=" + startDate
				+ ", completeDate=" + completeDate + ", successful=" + successful + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completeDate == null) ? 0 : completeDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + goalId;
		result = prime * result + goalLength;
		result = prime * result + ((milestones == null) ? 0 : milestones.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (successful ? 1231 : 1237);
		result = prime * result + userId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goals other = (Goals) obj;
		if (completeDate == null) {
			if (other.completeDate != null)
				return false;
		} else if (!completeDate.equals(other.completeDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (goalId != other.goalId)
			return false;
		if (goalLength != other.goalLength)
			return false;
		if (milestones == null) {
			if (other.milestones != null)
				return false;
		} else if (!milestones.equals(other.milestones))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (successful != other.successful)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}	
	
}


