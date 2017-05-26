package com.skilldistillery.movie.data;

import java.util.List;

import com.skilldistillery.movie.models.Movie;

public interface MovieStoreDAO {
	List<Movie> loadMoviesFromFile();
	List<Movie> getMovieList();
	void addMovieToList(Movie movie);
	int getNextId();
	void removeMovieFromList(String name);
	Movie getRandomMovie();
	void persistList(List<Movie> movies);
}
