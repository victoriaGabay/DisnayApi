package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "genero")
public class Genre implements Serializable{

	@Id //SET ID AS PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")//SPECIFY COLUMN NAME
	private String name;
	
	@Column(name = "imagen")
	private String imageUrl;
	
	
	@ManyToMany(targetEntity = MoviesSeries.class,cascade = CascadeType.MERGE)
	@JoinTable(name = "genero_peliculas_series", joinColumns = {
    	@JoinColumn(name = "id_genero", referencedColumnName = "id",nullable = false,updatable = false)},
    	inverseJoinColumns = {
    	@JoinColumn(name = "id_peliculas_series", referencedColumnName = "id",nullable = false, updatable = false)})
	private Set<MoviesSeries> moviesOrSeries;
	//SETTING GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public Genre() {
		// TODO Auto-generated constructor stub
	}

}
