package com.projetcgame.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetcgame.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList , Long> {

}
