package com.rest.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String genres_name;
	
	@ManyToMany(mappedBy = "genres")
	@JsonIgnore
	private List<Movies> movies=new ArrayList<>();
	
	
	public List<Movies> getMovies() {
		return movies;
	}
	public void addMovies(Movies movie) {
		this.movies.add(movie);
	}
	public Genres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Genres(String genres_name) {
		super();
		this.genres_name = genres_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenres_name() {
		return genres_name;
	}
	public void setGenres_name(String genres_name) {
		this.genres_name = genres_name;
	}
	@Override
	public String toString() {
		return "Genres [id=" + id + ", genres_name=" + genres_name + "]";
	}
	
}
