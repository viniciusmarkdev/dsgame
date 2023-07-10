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
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> lista= gameListRepository.findAll();
		List<GameListDTO> dto = lista.stream().map(x->new GameListDTO(x)).toList();	
		return dto;
	}
	
	@Transactional
	public void move(Long listId , int sourceIndex ,int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex , obj);
		
		int min= sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max= sourceIndex < destinationIndex ?destinationIndex  : sourceIndex;
		
		for(int i= min ; i<=max ; i++) {
			
			gameListRepository.updateBelongingPosition(listId ,list.get(i).getId(),i);			
		}
		
	}
	

}
