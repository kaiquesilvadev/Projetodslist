package com.generation.dsList.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //significa que ela pode ser usada como um atributo dentro de outra classe 
public class BilongingPk {

	@ManyToOne  //uma associação muitos-para-um
	@JoinColumn(name = "game_id")
	private Game game ;
	@ManyToOne  //uma associação muitos-para-um
	@JoinColumn(name = "list_id")
	private GameList list ;
	
	public  BilongingPk() {
	}

	public BilongingPk(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BilongingPk other = (BilongingPk) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}

	
}
