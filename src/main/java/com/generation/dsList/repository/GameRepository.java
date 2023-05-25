package com.generation.dsList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.dsList.entities.Game;
import com.generation.dsList.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{

	// consulta personalizada
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS GameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_bilonging.position
			FROM tb_game
			INNER JOIN tb_bilonging ON tb_game.id = tb_bilonging.game_id
			WHERE tb_bilonging.list_id = :listId
			ORDER BY tb_bilonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}
