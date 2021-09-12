package com.example.demo.DTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import com.example.demo.entities.Characters;
import com.example.demo.entities.Genre;

public class MoviesSeriesDesriptionDTO {

	private String title;
	private String imageUrl;
	private Date creationDate;
	private int rate;
	private Set<Characters> characters;
	private Set<Genre> genres; //THIS ONE IS FOR MOVIES/CHARACTERS

	
	
	public MoviesSeriesDesriptionDTO() { }
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getRate() {
		return rate;
	}
	public Set<Characters> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Characters> characters) {
		this.characters = characters;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}





}
