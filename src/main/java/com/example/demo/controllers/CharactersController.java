package com.example.demo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.CharactersDTO;
import com.example.demo.DTO.CharactersDescriptionDTO;
import com.example.demo.DTO.CharactersPerMovieDTO;
import com.example.demo.entities.Characters;
import com.example.demo.services.CharactersServices;

@RestController
@RequestMapping("/apiDisney/characters")
public class CharactersController {

	@Autowired
	private CharactersServices cServ;
	
	@GetMapping()
	public ResponseEntity<List<CharactersDTO>> getAllCharacters(){
		return ResponseEntity.ok(cServ.getCharacterList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Set<CharactersDescriptionDTO>> getCharacterById(@PathVariable int id){
        return ResponseEntity.ok().body(this.cServ.getCharacterById(id));
	}

	@GetMapping("/name={name}")
	public ResponseEntity<Set<CharactersDescriptionDTO>> getCharacterByName(@PathVariable String name){
		return ResponseEntity.ok().body(this.cServ.getCharacterByName(name));
	}
	
	@GetMapping("/movies={idMovies}")
	public ResponseEntity<Set<CharactersPerMovieDTO>> getCharactersByMovieOrSerieId(@PathVariable int idMovies){
		return ResponseEntity.ok().body(cServ.getCharactersByMovieOrSerieId(idMovies));
	}
	@GetMapping("/age={age}")
	public ResponseEntity<List<CharactersDescriptionDTO>> getCharactersByAge(@PathVariable int age){
		return ResponseEntity.ok().body(this.cServ.getCharactersByAge(age));
	}
	
	
    @PutMapping("update")
    public ResponseEntity<Characters> updateCharacters(@RequestBody Characters charac){
    	return ResponseEntity.ok().body(this.cServ.updateCharacterById(charac));	
    }
	
    @DeleteMapping("/{id}") 
	public HttpStatus deleteCharacter(@PathVariable int id) {
	    this.cServ.deleteCharacterById(id);
	    return HttpStatus.OK;
	}
    
    @PostMapping()
	public ResponseEntity<Characters> addCharacter(@RequestBody Characters charac){
		return ResponseEntity.ok(this.cServ.createCharacter(charac));
	}
	

}
