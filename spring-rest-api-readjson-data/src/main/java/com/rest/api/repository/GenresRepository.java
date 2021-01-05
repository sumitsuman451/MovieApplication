package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.model.Genres;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer>{

}
