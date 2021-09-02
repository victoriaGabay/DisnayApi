package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.MoviesSeries;
import com.example.demo.repositories.MoviesSeriesRepository;

public class MoviesSeriesServices {

	private MoviesSeriesRepository mysRepo;
	
	public MoviesSeries createMovie(MoviesSeries mys) {
		return mysRepo.save(mys);
	}

	public List<MoviesSeries> getMoviesList(){
		return mysRepo.findAll();
	}
	
	//FUTURE METHODS TO FIND MOVIES BY SPECIFICS PARAMS
	
	//PUBLIC MOVIE GETMOVIEBYCHARACTER --> MANYTOMANY NOT IMPLEMENTED YET
	
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
	
	public String deletePersonById(int id) { //CRUD
		mysRepo.deleteById(id);
		return "Person "+ id +" deleted";
	}
}
