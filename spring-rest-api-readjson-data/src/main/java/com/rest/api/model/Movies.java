package com.rest.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movies {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String year;
	private String runtime;
	private String director;
	private String actors;
	
	@Column(length = 1000)
	private String plot;
	private String posterUrl;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Genres> genres=new ArrayList<>();
	
	public List<Genres> getGenres() {
		return genres;
	}
	public void addGenres(Genres genre) {
		this.genres.add(genre);
	}
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movies(String title, String year, String runtime, String director, String actors, String plot,
			String posterUrl) {
		super();
		this.title = title;
		this.year = year;
		this.runtime = runtime;
		this.director = director;
		this.actors = actors;
		this.plot = plot;
		this.posterUrl = posterUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", year=" + year + ", runtime=" + runtime + ", director="
				+ director + ", actors=" + actors + ", plot=" + plot + ", posterUrl=" + posterUrl + "]";
	}
	
}
