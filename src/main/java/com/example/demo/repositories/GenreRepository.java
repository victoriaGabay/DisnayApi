package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre,Integer>{

}
