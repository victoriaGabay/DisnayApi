package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.CharactersDTO;
import com.example.demo.DTO.CharactersDescriptionDTO;
import com.example.demo.DTO.CharactersPerMovieDTO;
import com.example.demo.entities.Characters;
import com.example.demo.repositories.CharactersRepository;

@Service
public class CharactersServices {

	@Autowired
	private CharactersRepository charactersRepo;
	@Autowired
	private MoviesSeriesServices mysServ;

	public Characters createCharacter(Characters character) {
		return charactersRepo.save(character);
	}

	
	public List<CharactersDTO> getCharacterList(){
		return charactersRepo.findAll().stream().map(this::convertCharacterToDto).collect(Collectors.toList());
	}
	
	public CharactersDTO convertCharacterToDto(Characters character) {
		CharactersDTO cDTO = new CharactersDTO();
		cDTO.setName(character.getName());
		cDTO.setImageUrl(character.getImageUrl());
		return cDTO;
	}
	
	public Set<CharactersDescriptionDTO> getCharacterById(int id) {
		return charactersRepo.findById(id).stream().map(this::convertCharacterDescriptionToDto).collect(Collectors.toSet());
	}
	public Set<CharactersDescriptionDTO> getCharacterByName(String name) {
		return charactersRepo.findByName(name).stream().map(this::convertCharacterDescriptionToDto).collect(Collectors.toSet());
	}
	
	public Set<CharactersPerMovieDTO> getCharactersByMovieOrSerieId(int id) {
		return mysServ.getCharactersPerMovieId(id);
	}
	
	public List<CharactersDescriptionDTO> getCharactersByAge(int age){
		return charactersRepo.findByAge(age).stream().map(this::convertCharacterDescriptionToDto).collect(Collectors.toList());
	}

	
	
	public CharactersDescriptionDTO convertCharacterDescriptionToDto(Characters charac) {
		CharactersDescriptionDTO charDTO = new CharactersDescriptionDTO();
		charDTO.setAge(charac.getAge());
		charDTO.setImageUrl(charac.getImageUrl());
		charDTO.setMoviesOrSeries(charac.getMoviesOrSeries());
		charDTO.setName(charac.getName());
		charDTO.setWeight(charac.getWeight());
		return charDTO;
	}
	
	public Characters updateCharacterById(Characters character) {
        Optional<Characters> characterFound = charactersRepo.findById(character.getId());
        
        if(characterFound.isPresent()) {
        	Characters characterUpdate = characterFound.get();
        	characterUpdate.setImageUrl(character.getImageUrl());
        	characterUpdate.setAge(character.getAge());
        	characterUpdate.setName(character.getName());
        	characterUpdate.setWeight(character.getWeight());;
        	return charactersRepo.save(character);
        }
        else {
        	return null;
        }

	}
	
	public String deleteCharacterById(int id) {
		charactersRepo.deleteById(id);
		return "Person "+ id +" deleted";
	}
}
