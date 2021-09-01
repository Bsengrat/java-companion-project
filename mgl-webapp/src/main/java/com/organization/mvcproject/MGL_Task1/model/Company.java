
package com.organization.mvcproject.MGL_Task1.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//TODO 1.0 remove @Component annotation, it is not used check...

public class Company {

	private Long id;
	private String name;
	//TODO 1.0 this List doesn't need to be initialized at declaration. check...
	private List<Game> gamesMade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGamesMade() {
		return gamesMade;
	}

	public void setGamesMade(List<Game> gamesMade) {
		this.gamesMade = gamesMade;
	}
}