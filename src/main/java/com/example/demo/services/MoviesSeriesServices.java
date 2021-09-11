package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CharactersPerMovieDTO;
import com.example.demo.DTO.GenreDTO;
import com.example.demo.DTO.MoviesSeriesDTO;
import com.example.demo.DTO.MoviesSeriesDesriptionDTO;
import com.example.demo.entities.MoviesSeries;
import com.example.demo.repositories.MoviesSeriesRepository;

@Service
public class MoviesSeriesServices {

	@Autowired
	private MoviesSeriesRepository mysRepo;
	@Autowired
	private GenreServices gServ;
	
	public MoviesSeries createMovie(MoviesSeries mys) {
		return mysRepo.save(mys);
	}

	public List<MoviesSeriesDTO> getMoviesList(){
		return mysRepo.findAll().stream().map(this::convertMSToDto).collect(Collectors.toList());
	}
	
	public Set<CharactersPerMovieDTO> getCharactersPerMovieId(int id){
		return mysRepo.findById(id).stream().map(this::convertMoviesToCharactersPerMovieDTO).collect(Collectors.toSet());	}
	
	public CharactersPerMovieDTO convertMoviesToCharactersPerMovieDTO(MoviesSeries mys) {
		CharactersPerMovieDTO cpmDTO = new CharactersPerMovieDTO();
		cpmDTO.setCharacters(mys.getCharacters());
		cpmDTO.setTitle(mys.getTitle());
		return cpmDTO;
	}
	
	private MoviesSeriesDTO convertMSToDto(MoviesSeries mYs) {
		MoviesSeriesDTO msDTO = new MoviesSeriesDTO();
		msDTO.setTitle(mYs.getTitle());
		msDTO.setImageUrl(mYs.getImageUrl());
		msDTO.setCreationDate(mYs.getCreationDate());
		return msDTO;
	}
	
	public Set<GenreDTO> getMoviesByGenreId(int id) {
		return gServ.getMoviesByGenre(id);
	}
	
	public List<MoviesSeriesDesriptionDTO> getMovieSerieByCreationDate(String order) {
		if(order.equals("ASC")) {
			return mysRepo.findAll(Sort.by(Sort.Direction.ASC, "creationDate")).stream().map(this::convertoMSdetailsToDTO).collect(Collectors.toList());	
			}
		else {
			return mysRepo.findAll(Sort.by(Sort.Direction.DESC, "creationDate")).stream().map(this::convertoMSdetailsToDTO).collect(Collectors.toList());	
			}
		}
	
	
	public Set<MoviesSeriesDesriptionDTO> getMovieSerieById(int id) {
		return mysRepo.findById(id).stream().map(this::convertoMSdetailsToDTO).collect(Collectors.toSet());	}
	
	public Set<MoviesSeriesDesriptionDTO> getMovieSerieByTitle(String title) {
		return mysRepo.findByTitle(title).stream().map(this::convertoMSdetailsToDTO).collect(Collectors.toSet());	}
	
	private MoviesSeriesDesriptionDTO convertoMSdetailsToDTO(MoviesSeries mys) {
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
        	if(mys.getImageUrl() != null) {
        		mysUpdate.setImageUrl(mys.getImageUrl());}
        	if(mys.getCreationDate() != null) {
        		mysUpdate.setCreationDate(mys.getCreationDate());}
        	if(mys.getRate() != 0) {
        		mysUpdate.setRate(mys.getRate());}
        	if(mys.getTitle() != null) {
        		mysUpdate.setTitle(mys.getTitle());}
        	return mysRepo.save(mysUpdate);
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
