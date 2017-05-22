package com.skilldistillery.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieStoreDAOImpl implements MovieStoreDAO {

	@Autowired
	ServletContext context;
	private Movie movie;
	private List<Movie> movies = new ArrayList<>();

	@Override
	public List<Movie> loadMoviesFromFile() {
		InputStream is = context.getResourceAsStream("WEB-INF/movielist.csv");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] column = line.split("\\|");
				String id = column[0];
				String name = column[1];
				String year = column[2];
				String genre = column[3];
				Movie movie = new Movie(id, name, year, genre);
				movies.add(movie);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return movies;
	}
	
	@Override
	public List<Movie> getMovieList() {
		if (movies.isEmpty()) {
			movies = loadMoviesFromFile();
		}
		
		return movies;
	}

	@Override
	public void addMovieToList(Movie movie) {
		System.out.println(movie.getName().length());
		System.out.println(movie.getYear().length());
		if ((movie.getName().length() !=0) && (movie.getYear().length()) != 0) {
			movies.add(movie);
		}
	}

	@Override
	public void removeMovieFromList(String name) {
		int i = 0;
		for (Movie m : movies) {
			if (name.equalsIgnoreCase(m.getName())) {
				movies.remove(i);
				break;
			}
			i++;
		}
	}

	@Override
	public int getNextId() {
		int i = movies.size() + 1;
		return i;
	}
	@Override
	public String getMoviePic(Movie m) {
		return "SpringMVCFileCRUD/WebContent/pics/" + m.getId() + ".jpg";
	}
	// private static final String d = "|";
	// private void loadOrders() {
	// String line = "Cat|Dog";
	// line.split("\\|");
	// }

	// @Override
	// public void persistList(List<Movie> movies) {
	// String orderFile = "WEB-INF/movies.csv";
	// String filePath = context.getRealPath(orderFile);
	// System.out.println("DAO: " + filePath);
	// try {
	// PrintWriter out = new PrintWriter(new FileWriter(filePath));
	// for (Movie movie : movies) {
	// out.println(movie.getId()+d+movie.getName()+d+movie.getYear());
	// }
	// out.close();
	// } catch (IOException ioe) {
	// ioe.printStackTrace();
	// }
	// }

}
