package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Characters;
import com.example.demo.services.CharactersServices;

@RestController
@RequestMapping("/apiDisney")
public class CharactersController {

	@Autowired
	private CharactersServices cServ;
	
	@GetMapping("/characters")
	public ResponseEntity<List<Characters>> getAllCharacters(){
		return ResponseEntity.ok(cServ.getCharacterList());
	}
	
	@GetMapping("/characters/{id}")
	public ResponseEntity<Characters> getCharacterById(@PathVariable int id){
        return ResponseEntity.ok().body(this.cServ.getCharacterById(id));
	}
	
	
    @PutMapping("/characters/update")
    public ResponseEntity<Characters> updateCharacters(@RequestBody Characters charac){
    	return ResponseEntity.ok().body(this.cServ.updateCharacterById(charac));	
    }
	
    @DeleteMapping("/characters/delete/{id}") 
	public HttpStatus deleteCharacter(@PathVariable int id) {
	    this.cServ.deleteCharacterById(id);
	    return HttpStatus.OK;
	}
    
    @PostMapping("/characters/create")
	public ResponseEntity<Characters> addCharacter(@RequestBody Characters charac){
		return ResponseEntity.ok(this.cServ.createCharacter(charac));
	}
	

}
