package com.rest.api.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.model.Genres;
import com.rest.api.model.Movies;
import com.rest.api.repository.GenresRepository;
import com.rest.api.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public void setMoviesData(){
		
		ObjectMapper objectMapper=new ObjectMapper();
		TypeReference<List<Movies>> typeRef=new TypeReference<List<Movies>>() {};
		InputStream inputStream= MovieService.class.getResourceAsStream("/moviedata.json");
		try {
			List<Movies> movie=objectMapper.readValue(inputStream, typeRef);
			System.out.println(movie.get(0));
			movieRepository.saveAll(movie);
			
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public List<Movies> getAllMoviesData(){
		return movieRepository.findAll();
	}
	

}
