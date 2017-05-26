package com.skilldistillery.movie.data;

import java.util.List;

import com.skilldistillery.movie.models.Actor;
import com.skilldistillery.movie.models.Movie;

public interface MovieDAODb {

	List<Movie> getMovieByKeyword(String query);
	void deleteMovie(String moviename);
	List<Actor> getActorFromMovieById(int movieId);
	public void addMovie(String name, String year, String genre, String pic);
	String getMovieNameById(int id);
	Movie getMovieById(int id);
	List<Movie> getMovieList();
	List<Movie> getInitialMovieList();
}
