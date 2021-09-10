package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.service.GameRetrievalService;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.ReviewImpl;

@RestController
@RequestMapping(value ="/game")
public class GameServiceController {

	@Autowired
	private GameRetrievalService gameService;

	/**
	 * TODO 2.0 (Separation of concerns) consider moving all controller endpoints that return a ResponseEntity into a @RestController.
	 */
	
	//TODO 1.0 RequestMapping URL should follow RESTful.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<GameImpl>> fetchAllGames() {
		return new ResponseEntity<List<GameImpl>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	//TODO 1.0 RequestMapping URL should follow RESTful convention
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}