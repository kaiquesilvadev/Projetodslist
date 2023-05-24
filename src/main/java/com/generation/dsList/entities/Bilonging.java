package com.generation.dsList.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Bilonging")
public class Bilonging {

	@EmbeddedId //para indicar que uma classe representa uma chave primária composta.
	private BilongingPk id =new BilongingPk();
	private Integer position ;
	
	public Bilonging() {
	}

	public Bilonging(Game game ,GameList gameList, Integer position) {
		id.setGame(game);
		id.setList(gameList);
		this.position = position;
	}

	public BilongingPk getId() {
		return id;
	}

	public void setId(BilongingPk id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilonging other = (Bilonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
