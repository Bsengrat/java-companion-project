package com.organization.mvcproject.api.model;

public interface Game {
	public void setName(String name);
	public void setId(Long id);
	public void setGenre(String genre);
	
	Long getId();		
	public String getGenre();
	public String getName();

}
