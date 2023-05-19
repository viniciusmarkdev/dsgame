package com.projetcgame.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetcgame.dslist.entities.GameList;
import com.projetcgame.dslist.projections.GameMinProjection;

public interface GameListRepository extends JpaRepository<GameList , Long> {
	
	

}
