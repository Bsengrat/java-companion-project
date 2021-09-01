package com.organization.mvcproject.MGL_Task1.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	/**
	 * TODO 1.0 java object member variable naming convention declared here are not object oriented,
	 *  rename the variables, and their setter/getter methods to match convention. 
	 */
	private Long gameId;
	private String gameName;
	private String gameGenre;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

}
