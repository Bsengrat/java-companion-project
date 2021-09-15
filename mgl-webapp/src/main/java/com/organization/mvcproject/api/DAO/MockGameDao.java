package com.organization.mvcproject.api.DAO;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface MockGameDao {
	List<GameImpl> getAllGames();
	GameImpl saveGame(GameImpl game);
	boolean deleteGame(long id);
	
}
