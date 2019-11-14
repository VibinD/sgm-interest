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
    private List<QuestionInfo> surveyInfo;
    
	public UserSurvey(String userId, String firstName, String lastName, String grade, List<QuestionInfo> surveyInfo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.surveyInfo = surveyInfo;
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

	public List<QuestionInfo> getSurveyInfo() {
		return surveyInfo;
	}

	public void setSurveyInfo(List<QuestionInfo> surveyInfo) {
		this.surveyInfo = surveyInfo;
	}

	@Override
	public String toString() {
		return "UserSurvey [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", grade="
				+ grade + ", surveyInfo=" + surveyInfo + "]";
	}
    
}
