package com.generation.dsList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.dsList.dto.GameMinDTO;
import com.generation.dsList.services.GameServices;

@RestController // diz que essa classe vai ser um repository
@RequestMapping("/games") // define uma  requisição http
@CrossOrigin(origins = "*",allowedHeaders = "*") // define que a rest api pode ser usada para todos dos tipo de requisição, web , mobile etc...
public class GameController {

	@Autowired
	private GameServices gameServices;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameServices.findall();
		return result;
	}
}