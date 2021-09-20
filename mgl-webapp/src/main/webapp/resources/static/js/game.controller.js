'use strict';

angular.module('MGLAPP').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				self.game.id = '';
				self.game.name = '';
				self.game.genre = '';
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game){
				return GameService.deleteGame(game.id).then(function (){
					self.fetchAllGames();
				})
			}
			
			self.updateGame = function(game){	
				self.game.id = String(game.id)
				return GameService.updateGame(self.game).then(function (){									
					self.fetchAllGames();
				})
			}

			self.fetchAllGames();
		} ]);
