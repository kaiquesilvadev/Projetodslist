package com.generation.dsList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.dsList.dto.GameListDTO;
import com.generation.dsList.dto.GameMinDTO;
import com.generation.dsList.services.GameListServices;
import com.generation.dsList.services.GameServices;

@RestController // diz que essa classe vai ser um repository
@RequestMapping("/lists") // define uma  requisição http
@CrossOrigin(origins = "*",allowedHeaders = "*") // define que a rest api pode ser usada para todos dos tipo de requisição, web , mobile etc...
public class GameListController {

	@Autowired
	private GameListServices gameListServices;
	
	@Autowired
	private GameServices gameServices;
	
	// lista todos os games so que usando a classe GameListDTO
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListServices.findall();
		return result;
	}
	
	@GetMapping("/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameServices.findaByList(listId);
		return result;
	}
}
