package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.DAO.MockGameDao;
import com.organization.mvcproject.api.service.GameRetrievalService;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class MockGameDaoImpl  implements MockGameDao {
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<GameImpl>();

	static {
		games = populateGames();
	}
	
	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	@Override
	public boolean deleteGame(Long deleteGameId) {
		for(GameImpl gameItem : games) {
			if(deleteGameId == gameItem.getId()) {
				return games.remove(gameItem);
			}
		}
		return false;
	}

	@Override
	public List<GameImpl> getAllGames() {
		return games;
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		if(game.getId() != null) {
		long nGameId = game.getId();
		
		for(GameImpl gameItem : games) {
			if(nGameId == gameItem.getId()) {
				GameImpl updatedGame = gameItem;
				updatedGame.setName(game.getName());
				updatedGame.setGenre(game.getGenre());
				return updatedGame;
				}
			}
		}
		
		game.setId(++gameId);
		games.add(game);
		return game;
	}
}
