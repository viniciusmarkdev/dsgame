package com.projetcgame.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetcgame.dslist.entities.Game;
import com.projetcgame.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
		

	public List<Game> findAll(){
		
		List<Game> lista= gameRepository.findAll();
		return lista;
	}
}
