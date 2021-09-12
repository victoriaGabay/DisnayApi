package com.example.demo.DTO;

import java.util.Set;

import com.example.demo.entities.Characters;

public class CharactersPerMovieDTO {

	private String title;
	private Set<Characters> characters;

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Set<Characters> getCharacters() {
		return characters;
	}


	public void setCharacters(Set<Characters> characters) {
		this.characters = characters;
	}


	public CharactersPerMovieDTO() {
		// TODO Auto-generated constructor stub
	}

}
