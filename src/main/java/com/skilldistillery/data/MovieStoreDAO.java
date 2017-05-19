package com.skilldistillery.data;

import java.util.List;

public interface MovieStoreDAO {
	List<Movie> loadMoviesFromFile();
}
