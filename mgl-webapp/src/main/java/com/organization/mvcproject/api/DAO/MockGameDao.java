package com.organization.mvcproject.api.DAO;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface MockGameDao {
	List<GameImpl> getAllGames();
	GameImpl saveGame(GameImpl game);
	Boolean deleteGame(long id);
	GameImpl findGameById(long id);
	Boolean validateGame(GameImpl game);
}
