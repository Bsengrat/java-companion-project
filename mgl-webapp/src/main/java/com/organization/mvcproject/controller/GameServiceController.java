package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<GameImpl>> fetchAllGames() {
		return new ResponseEntity<List<GameImpl>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	//Return a game instead of a void to check data.
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createGame(@RequestBody GameImpl game) {
			if(!gameService.validateGame(game)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			gameService.saveGame(game);
			return new ResponseEntity<>(HttpStatus.CREATED);			

	}
	//made 9/14/2021
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deleteGame(@PathVariable String id){
		gameService.deleteGame(Long.valueOf(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<?> updateGame(@RequestBody GameImpl game){
		if(!gameService.validateGame(game)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		gameService.saveGame(game);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}