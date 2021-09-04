package com.example.demo.repositories;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Characters;

public interface CharactersRepository extends JpaRepository<Characters,Integer> {

	public Optional<Characters> findByName(String name);
	//public List<Characters> findBybirth_date(Date date);
}
