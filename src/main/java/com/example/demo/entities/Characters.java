package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class Characters {

	@Id //SET ID AS PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "imagen")//SPECIFY COLUMN NAME
	private String imageUrl;
	
	@Column(name = "fecha_nacimiento")
	private Date birth_date;
	
	@Column(name = "peso")
	private float weight;
	
	
	@ManyToMany(targetEntity = MoviesSeries.class,cascade = CascadeType.MERGE)//TARGET ENTITY IS THE OTHER SIDE OF THE MANYTOMANY
	@JoinTable(name = "pelicula_serie_character", joinColumns = {
    		@JoinColumn(name = "id_character", referencedColumnName = "id",nullable = false,updatable = false)},
    		inverseJoinColumns = {
    				@JoinColumn(name = "id_peliculas_serie", referencedColumnName = "id",nullable = false, updatable = false)})
	private Set<MoviesSeries> moviesOrSeries;
	
	public Characters() {
		
	}

	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public Set<MoviesSeries> getMoviesOrSeries() {
		return moviesOrSeries;
	}

	public void setMoviesOrSeries(Set<MoviesSeries> moviesOrSeries) {
		this.moviesOrSeries = moviesOrSeries;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	
}
