package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Characters;

public interface CharactersRepository extends JpaRepository<Characters,Integer> {

}
