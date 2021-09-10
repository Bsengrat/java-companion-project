package com.organization.mvcproject.api.model;

public interface Review {

	void setAuthor(String author);
	void setRating(Integer rating);
	void setDescription(String description);
	
	String getAuthor();
	Integer getRating();
	String getDescription();
}
