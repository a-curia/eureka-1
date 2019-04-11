package com.dbbyte.mcs.models;

public class Movie {
	
	private String movieId;
	private String name;
	
	
	
	public Movie() {
		super();
		// something that is not an object to an object - marshalling - needs this
	}

	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
