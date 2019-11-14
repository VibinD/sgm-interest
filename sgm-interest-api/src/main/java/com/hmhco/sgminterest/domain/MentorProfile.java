package com.hmhco.sgminterest.domain;

public class MentorProfile {
	private String profileId;
	private String name;
	
	public String getProfileId() {
		return profileId;
	}
	
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MentorProfile [profileId=" + profileId + ", name=" + name + "]";
	}
}
