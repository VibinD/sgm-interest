package com.hmhco.sgminterest.domain;

import java.util.List;

public class Recommendation {
	private List<Profile> profiles;
	private List<Book> books;
	
	public Recommendation(List<Profile> profiles, List<Book> books) {
		super();
		this.profiles = profiles;
		this.books = books;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Recommendation [profiles=" + profiles + ", books=" + books + "]";
	}
	
}
