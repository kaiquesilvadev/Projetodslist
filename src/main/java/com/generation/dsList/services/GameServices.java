package com.generation.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.dsList.dto.GameMinDTO;
import com.generation.dsList.entities.Game;
import com.generation.dsList.repository.GameRepository;

 // essa anotação serve para definir que essa classe vai ser usada para servicos 
 // você pode usar também a anotação @Component que indentifivca que essa classe serrar usada como classe de composição

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findall() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new  GameMinDTO(x)).toList();
	}
}