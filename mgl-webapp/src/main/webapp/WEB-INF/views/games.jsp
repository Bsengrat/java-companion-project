<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mgl" %>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/mgl.module.js" /></script>
        <script src="resources/static/js/game.service.js"></script>
        <script src="resources/static/js/game.controller.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="MGLAPP" class="ng-cloak">
        <mgl:myNav/>
        <br>
        <div class="container" ng-controller="GameController as MGL_T1_ctrl">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="MGL_T1_ctrl.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="MGL_T1_ctrl.game.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_name">Name</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.name" id="game_name" class="game_name form-control input-sm" placeholder="Enter the name of the new game [required]" required />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.game_name.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.game_name.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.game_name.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_genre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.genre" id="game_genre" class="form-control input-sm" placeholder="Enter the genre of the new game [required]" required/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Add" class="btn btn-primary btn-sm">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
                <div class="tablecontainer">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Game Name</th>
                                <th>Game Genre</th>
                                <th>Edit</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentGame in MGL_T1_ctrl.games" ng-model = "MGL_T1_ctrl.games">
                                <td ng-if="!currentGame.selected"><span ng-bind="currentGame.name"></span></td>
                                <td ng-if= "!currentGame.selected"><span ng-bind="currentGame.genre"></span></td>
              
                                <td ng-if="currentGame.selected">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.name" ng-value="currentGame.name" class="form-control input-sm" placeholder="Update Game name" />
                                </td>
                                <td ng-if="currentGame.selected">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.genre" ng-value="currentGame.genre" class="form-control input-sm" placeholder="Update Game Genre" />                                
                                </td>                    
                                <td><span><input type = "checkbox" ng-click="currentGame.selected = (currentGame.selected ? false : true)" class="btn btn-secondary btn-sm" /></span></td>
                                <td><button type="submit" data-ng-click="MGL_T1_ctrl.updateGame(currentGame)" class="btn btn-secondary btn-sm">Update</button></td>
                                <td>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
                <div>
                	<form ng-submit="MGL_T1_ctrl.deleteGame(gameDeleteForm)" name="gameDeleteForm">
                		<label class="panel-heading text-light" for="gameDeleteForm">Delete Game:</label>
                		<select ng-model="gameDeleteForm">
                		<option ng-repeat="currentGame in MGL_T1_ctrl.games" ng-value="{{currentGame}}">
                		{{currentGame.name}}
                		</option>
                	</select>
                	<input type="submit" value="Submit" class="btn btn-primary btn-sm">
                	</form>
                </div>
        </div>

    </body>
    <script type="text/javascript"></script>

    </html>