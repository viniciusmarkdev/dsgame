package com.projetcgame.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetcgame.dslist.dto.GameListDTO;
import com.projetcgame.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	
	@Autowired
	GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> lista = gameListService.findAll();
		return lista;
		
	}

}
