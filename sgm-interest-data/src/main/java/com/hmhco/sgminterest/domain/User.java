/**
 * 
 */
package com.hmhco.sgminterest.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author damodaranv
 *
 */
@Document(collection = "userQuestionAnswer")
public class User {
	
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String grade;
	private List<Question> questions;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> quesions) {
		this.questions = quesions;
	}

}
