/**
 * 
 */
package com.hmhco.sgminterest.domain;

import java.util.List;

/**
 * @author damodaranv
 *
 */
public class UserSurvey {
	
	private String userId;
    private String firstName;
    private String lastName;
    private String grade;
    private List<QuestionAnswer> questions;
    
	public UserSurvey(String userId, String firstName, String lastName, String grade, List<QuestionAnswer> questions) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.questions = questions;
	}
	
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

	public List<QuestionAnswer> getSurveyInfo() {
		return questions;
	}

	public void setSurveyInfo(List<QuestionAnswer> surveyInfo) {
		this.questions = surveyInfo;
	}

	@Override
	public String toString() {
		return "UserSurvey [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", grade="
				+ grade + ", surveyInfo=" + questions + "]";
	}
    
}
