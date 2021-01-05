package com.rest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Genres;
import com.rest.api.model.Movies;
import com.rest.api.services.GenresService;
import com.rest.api.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GenresService genresService;
	
	@GetMapping("/movies")
	public List<Movies> retrieveAllMovieData(){
		movieService.setMoviesData();
		return movieService.getAllMoviesData();
	}
	
	@GetMapping("/genres")
	public List<Genres> retrieveAllGenresData(){
		genresService.setGenresData();
		return genresService.getAllGenresData();
	}
	
}
