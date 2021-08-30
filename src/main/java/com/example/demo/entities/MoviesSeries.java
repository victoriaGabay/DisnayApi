package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula_serie")
public class MoviesSeries {

	
	//ENTITY ATRIBUTES
	@Id //SET ID AS PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo")//SPECIFY COLUMN NAME
	private String title;

	@Column(name = "imagen")
	private String imageUrl;
	
	@Column(name = "fecha_creacion")
	private String creationDate;
	
	@Column(name = "calificacion")
	private int rate;
	
	@Column(name = "id_genero")
	private int genre_id;
	
	@Column(name = "")
	
	//SETTING GETTERS AND SETTERS

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public MoviesSeries() {
		// TODO Auto-generated constructor stub
	}

}
