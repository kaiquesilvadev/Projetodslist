package com.generation.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.generation.dsList.dto.GameListDTO;
import com.generation.dsList.entities.GameList;
import com.generation.dsList.repository.GameListRepository;

// essa anotação serve para definir que essa classe vai ser usada para servicos 
// você pode usar também a anotação @Component que indentifivca que essa classe serrar usada como classe de composição

@Service
public class GameListServices {

	@Autowired
	private GameListRepository gameListRepository;

	
	// reporna o GameListDTO com os atributos personalisado para a requisição
	@Transactional(readOnly = true)
	public List<GameListDTO> findall() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}