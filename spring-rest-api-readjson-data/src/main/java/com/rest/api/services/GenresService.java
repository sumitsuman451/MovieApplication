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
import com.rest.api.repository.GenresRepository;

@Service
public class GenresService {
	
	@Autowired
	private GenresRepository genresRepository;
	
	
	public void setGenresData(){
		
		ObjectMapper objectMapper=new ObjectMapper();
		TypeReference<List<Genres>> typeRef=new TypeReference<List<Genres>>() {};
		InputStream inputStream= MovieService.class.getResourceAsStream("/genresdata.json");
		try {
			List<Genres> genre=objectMapper.readValue(inputStream, typeRef);
			System.out.println(genre.get(0));
			genresRepository.saveAll(genre);
			
			
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
	
	public List<Genres> getAllGenresData(){
		return genresRepository.findAll();
	}

}
