package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;


public interface GameRetrievalService {

	List<GameImpl> retrieveAllGames();

	GameImpl saveGame(GameImpl game);

	boolean deleteGame(long id);


}
