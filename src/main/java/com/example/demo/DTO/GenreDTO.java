package com.example.demo.DTO;

import java.util.Set;


import com.example.demo.entities.MoviesSeries;

public class GenreDTO {

	private String name;
	private String imageUrl;
	private Set<MoviesSeries> moviesOrSeries;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Set<MoviesSeries> getMoviesOrSeries() {
		return moviesOrSeries;
	}


	public void setMoviesOrSeries(Set<MoviesSeries> moviesOrSeries) {
		this.moviesOrSeries = moviesOrSeries;
	}


	public GenreDTO() {
		// TODO Auto-generated constructor stub
	}

}
