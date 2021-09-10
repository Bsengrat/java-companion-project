package com.organization.mvcproject.api.model;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface Company {

	public void setId(Long id);
	public void setName(String name);
	public void setGamesMade(List<GameImpl> gamesMade);
	
	public Long getId();	
	public String getName();	
	public List<GameImpl> getGamesMade();
}
