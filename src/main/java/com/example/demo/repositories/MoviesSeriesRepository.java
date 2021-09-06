package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MoviesSeries;

public interface MoviesSeriesRepository extends JpaRepository<MoviesSeries,Integer>{

	public Optional<MoviesSeries> findByTitle(String title);
	//public List<MoviesSeries> findByOrderBycreationDateAsc();


	
}
