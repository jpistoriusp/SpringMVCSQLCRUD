package com.skilldistillery.data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

public class MovieStoreDAOImpl implements MovieStoreDAO {

	@Autowired
	ServletContext context;
	private Movie movie;
	private List<Movie> movies = new ArrayList<>();

	@Override
	public List<Movie> loadMoviesFromFile() {
		InputStream is = context.getResourceAsStream("WEB-INF/movies.csv");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] column = line.split("\\|");
				String id = column[0];
				String name = column[1];
				String year = column[2];
				Movie movie = new Movie(id, name, year);
				movies.add(movie);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return movies;
	}

	@Override
	public List<Movie> getMovieList() {
		movies.clear();
		movies = loadMoviesFromFile();
		return movies;
	}

	@Override
	public void addMovieToList(Movie movie) {
		movies.add(movie);
	}
	
//	private static final String d = "|";
//	    private void loadOrders() {
//	        String line = "Cat|Dog";
//	        line.split("\\|");
//	}
//
//	@Override
//	public void persistList(Order order) {
//	        String orderFile = "WEB-INF/orders.csv";
//	        String filePath = context.getRealPath(orderFile);
//	        System.out.println("DAO: " + filePath);
//	        try {
//	            PrintWriter out = new PrintWriter(new FileWriter(filePath));
//	            for (Movie m : order.getPizzas()) {
//	                out.println(order.getCustomerEmail()+d+m.getName()+d+m.getYear());    
//	            }
//	            out.close();
//	        } catch (IOException ioe) {
//	            ioe.printStackTrace();
//	        }
//	    }

}
