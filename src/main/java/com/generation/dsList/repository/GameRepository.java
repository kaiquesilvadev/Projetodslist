package com.generation.dsList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.dsList.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
