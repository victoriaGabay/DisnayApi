package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Characters;

public interface CharactersRepository extends JpaRepository<Characters,Integer> {

	public List<Characters> findsByName(String name);
}
