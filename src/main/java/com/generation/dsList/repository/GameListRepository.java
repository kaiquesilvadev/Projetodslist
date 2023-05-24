package com.generation.dsList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.dsList.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
