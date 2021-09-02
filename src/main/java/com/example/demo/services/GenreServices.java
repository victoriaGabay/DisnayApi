package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Genre;
import com.example.demo.repositories.GenreRepository;

@Service
public class GenreServices {

	
	@Autowired
	private GenreRepository genreRepo;

	
	public List<Genre> getPersonList(){
		return genreRepo.findAll();
	}
	
	public Genre getCharacterById(int id) {
		return genreRepo.getById(id);
	}
	
	public List<Genre> getGenreByMovies(){
		return genreRepo.findAll();
	}
}
