package com.example.demo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.MoviesSeriesDTO;
import com.example.demo.DTO.MoviesSeriesDesriptionDTO;
import com.example.demo.entities.Characters;
import com.example.demo.entities.MoviesSeries;
import com.example.demo.services.MoviesSeriesServices;

@RestController
@RequestMapping("/apiDisney/moviesSeries")
public class MoviesSeriesController {
	
	@Autowired
	private MoviesSeriesServices mysServ;

    @PostMapping
	public ResponseEntity<MoviesSeries> addCharacter(@RequestBody MoviesSeries mys){
		return ResponseEntity.ok(mysServ.createMovie(mys));
	}
    
    @GetMapping
	public ResponseEntity<List<MoviesSeriesDTO>> getAllMoviesSeries(){
		return ResponseEntity.ok(mysServ.getMoviesList());
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<Set<MoviesSeriesDesriptionDTO>> getCharacterById(@PathVariable int id){
        return ResponseEntity.ok().body(this.mysServ.getMovieSerieById(id));
	}
    
    
    @PutMapping
    public ResponseEntity<MoviesSeries> updateMoviesSeriesById(@RequestBody MoviesSeries mys){
    	return ResponseEntity.ok().body(this.mysServ.updateMoviesSeriesById(mys));	
    }
    
    @DeleteMapping("/{id}") 
	public HttpStatus deleteMovieSerie(@PathVariable int id) {
	    this.mysServ.deleteMovieSeriesById(id);
	    return HttpStatus.OK;
	}

}
