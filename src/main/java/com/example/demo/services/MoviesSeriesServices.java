package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CharactersDTO;
import com.example.demo.DTO.MoviesSeriesDTO;
import com.example.demo.DTO.MoviesSeriesDesriptionDTO;
import com.example.demo.entities.Characters;
import com.example.demo.entities.MoviesSeries;
import com.example.demo.repositories.MoviesSeriesRepository;

@Service
public class MoviesSeriesServices {

	@Autowired
	private MoviesSeriesRepository mysRepo;
	
	public MoviesSeries createMovie(MoviesSeries mys) {
		return mysRepo.save(mys);
	}

	public List<MoviesSeriesDTO> getMoviesList(){
		return mysRepo.findAll().stream().map(this::convertMSToDto).collect(Collectors.toList());
	}
	
	public MoviesSeriesDTO convertMSToDto(MoviesSeries mYs) {
		MoviesSeriesDTO msDTO = new MoviesSeriesDTO();
		msDTO.setTitle(mYs.getTitle());
		msDTO.setImageUrl(mYs.getImageUrl());
		msDTO.setCreationDate(mYs.getCreationDate());
		return msDTO;
	}
	
	public Set<MoviesSeriesDesriptionDTO> getMovieSerieById(int id) {
		return mysRepo.findById(id).stream().map(this::convertoMSdetailsToDTO).collect(Collectors.toSet());	}
	
	public MoviesSeriesDesriptionDTO convertoMSdetailsToDTO(MoviesSeries mys) {
		MoviesSeriesDesriptionDTO msDTO = new MoviesSeriesDesriptionDTO();
		msDTO.setTitle(mys.getTitle());
		msDTO.setImageUrl(mys.getImageUrl());
		msDTO.setCreationDate(mys.getCreationDate());
		msDTO.setRate(mys.getRate());
		msDTO.setCharacters(mys.getCharacters());
		msDTO.setGenres(mys.getGenres());
		return msDTO;
	}
	
	public MoviesSeries updateMoviesSeriesById(MoviesSeries mys) {
        Optional<MoviesSeries> mysFound = mysRepo.findById(mys.getId());
        
        if(mysFound.isPresent()) { //SAVING UPDATES, GENRE MISSING 
        	MoviesSeries mysUpdate = mysFound.get();
        	mysUpdate.setImageUrl(mys.getImageUrl());
        	mysUpdate.setCreationDate(mys.getCreationDate());
        	mysUpdate.setRate(mys.getRate());
        	mysUpdate.setTitle(mys.getTitle());
        	return mysRepo.save(mys);
        }
        else {
        	return null;
        }

	}
	
	public String deleteMovieSeriesById(int id) { //CRUD
		mysRepo.deleteById(id);
		return "Person "+ id +" deleted";
	}
}
