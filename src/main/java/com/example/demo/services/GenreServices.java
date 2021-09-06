package com.example.demo.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.GenreDTO;
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
	
	public Set<GenreDTO> getMoviesByGenre(int id){
		return genreRepo.findById(id).stream().map(this::convertToGenreDTO).collect(Collectors.toSet());
	}
	
	private GenreDTO convertToGenreDTO(Genre genre) {
		GenreDTO gDTO = new GenreDTO();
		gDTO.setImageUrl(genre.getImageUrl());
		gDTO.setMoviesOrSeries(genre.getMoviesOrSeries());
		gDTO.setName(genre.getName());
		return gDTO;
		
		
	}
}
