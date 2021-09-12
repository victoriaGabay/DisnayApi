package com.example.demo.DTO;

import java.util.Set;
import com.example.demo.entities.MoviesSeries;



public class CharactersDescriptionDTO {

	
	private String name;
	private String imageUrl;
	private int age;
	private float weight;
	private String history;
	private Set<MoviesSeries> moviesOrSeries;

	
	public CharactersDescriptionDTO() {
		// TODO Auto-generated constructor stub
	}
	public Set<MoviesSeries> getMoviesOrSeries() {
		return moviesOrSeries;
	}

	public void setMoviesOrSeries(Set<MoviesSeries> moviesOrSeries) {
		this.moviesOrSeries = moviesOrSeries;
	}


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

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
}
