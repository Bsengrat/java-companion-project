package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.MockGameDao;
import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImplementation implements GameRetrievalService {

	/**
	 * TODO 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistance of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 */
	
	@Autowired
	private MockGameDao mockgameDao;
	//put all the methods that modify the data into this file from the mockDao.
	@Override
	public List<Game> retrieveAllGames() {
		return mockgameDao.getAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockgameDao.saveGame(game);
	}
	

	public Boolean deleteGame(long id){
		return mockgameDao.deleteGame(id);
	}
}