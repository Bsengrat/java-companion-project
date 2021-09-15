package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameRetrievalService;
import com.organization.mvcproject.dao.MockGameDaoImpl;
import com.organization.mvcproject.model.GameImpl;

@Service
public class GameServiceImplementation implements GameRetrievalService {

	/**
	 * TODO 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistance of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 */
	
	@Autowired
	private MockGameDaoImpl mockgameDao;
	//put all the methods that modify the data into this file from the mockDao.
	@Override
	public List<GameImpl> retrieveAllGames() {
		return mockgameDao.getAllGames();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return mockgameDao.saveGame(game);
	}
	
	@Override
	public boolean deleteGame(long id){
		return mockgameDao.deleteGame(id);
	}
}