package com.skilldistillery.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieStoreDAOImpl implements MovieStoreDAO {
	
	@Autowired
	private ServletContext context;
	private List<Movie> movies = new ArrayList<>();
	
	public MovieStoreDAOImpl() {
	}
	
	@Override
	public List<Movie> loadMoviesFromFile() {
		InputStream is = context.getResourceAsStream("WEB-INF/movies.csv");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] column = line.split("\\|");
				String name = column[0];
				String year = column[1];
				Movie movie = new Movie(name, year);
				movies.add(movie);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return movies;
	}
}
