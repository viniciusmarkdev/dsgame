package com.projetcgame.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetcgame.dslist.dto.GameListDTO;
import com.projetcgame.dslist.dto.GameMinDTO;
import com.projetcgame.dslist.services.GameListService;
import com.projetcgame.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	
	@Autowired
	GameListService gameListService;
	
	@Autowired
	GameService gameService;
	
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> lista = gameListService.findAll();
		return lista;
		
	}
	
	@GetMapping(value="/{listId}/games")
	public List<GameMinDTO> findByList( @PathVariable Long listId){
		
		List<GameMinDTO> result = gameService.findByList(listId);
	    return result;
	
	}
	
	
	

}
