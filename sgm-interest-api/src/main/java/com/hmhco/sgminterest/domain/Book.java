package com.hmhco.sgminterest.domain;

public class Book {
	private String id;
	private String name;
	private String category;
	private String imageUrl;
	
	public Book(String id, String name, String category, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imageUrl = imageUrl;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", imageUrl=" + imageUrl + "]";
	}
}
