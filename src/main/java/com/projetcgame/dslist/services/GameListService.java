package com.projetcgame.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetcgame.dslist.dto.GameListDTO;
import com.projetcgame.dslist.dto.GameMinDTO;
import com.projetcgame.dslist.entities.GameList;
import com.projetcgame.dslist.projections.GameMinProjection;
import com.projetcgame.dslist.repositories.GameListRepository;
import com.projetcgame.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	GameListRepository gameListRepository;
	
	

	
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> lista= gameListRepository.findAll();
		List<GameListDTO> dto = lista.stream().map(x->new GameListDTO(x)).toList();	
		return dto;
	}
	
	

}
