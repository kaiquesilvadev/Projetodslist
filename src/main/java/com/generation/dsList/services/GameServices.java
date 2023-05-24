package com.generation.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.generation.dsList.dto.GameDTO;
import com.generation.dsList.dto.GameMinDTO;
import com.generation.dsList.entities.Game;
import com.generation.dsList.repository.GameRepository;

// essa anotação serve para definir que essa classe vai ser usada para servicos 
// você pode usar também a anotação @Component que indentifivca que essa classe serrar usada como classe de composição

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;

	// busca por id

	               // para indicar que um método ou classe deve ser executado em uma
	@Transactional(readOnly = true) // transação.(inpont spring , não é do jakarta)
	public GameDTO findByid(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);

	}
	// reporna o GameMinDTO com os atributos personalisado para a requisição
	@Transactional(readOnly = true)
	public List<GameMinDTO> findall() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}