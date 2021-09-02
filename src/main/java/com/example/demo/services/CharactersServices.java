package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Characters;
import com.example.demo.repositories.CharactersRepository;


@Service
public class CharactersServices {

	@Autowired
	private CharactersRepository charactersRepo;

	public Characters createCharacter(Characters character) {
		return charactersRepo.save(character);
	}

	
	public List<Characters> getCharacterList(){
		return charactersRepo.findAll();
	}
	

	
	public Characters getCharacterById(int id) {
		return charactersRepo.getById(id);
	}
	
	public Characters updateCharacterById(Characters character) {
        Optional<Characters> characterFound = charactersRepo.findById(character.getId());
        
        if(characterFound.isPresent()) {
        	Characters characterUpdate = characterFound.get();
        	characterUpdate.setImageUrl(character.getImageUrl());
        	characterUpdate.setBirth_date(character.getBirth_date());
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
