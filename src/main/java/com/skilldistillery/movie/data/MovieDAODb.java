package com.skilldistillery.movie.data;

import java.util.List;

import com.skilldistillery.movie.models.Actor;
import com.skilldistillery.movie.models.Movie;

public interface MovieDAODb {

	List<Movie> getMovieByKeyword(String query);
	void deleteMovie(int movieid);
	List<Actor> getActorById(int movieId);
	Movie addMovie(Movie film);
	String getMovieNameById(int id);
	Movie getMovieById(int id);
}
