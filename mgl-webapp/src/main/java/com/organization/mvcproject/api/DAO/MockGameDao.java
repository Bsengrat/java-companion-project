package com.organization.mvcproject.api.DAO;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface MockGameDao {
	public boolean deleteGame(Long deleteGameId);

	List<GameImpl> getAllGames();
	GameImpl saveGame(GameImpl game);
	
}
