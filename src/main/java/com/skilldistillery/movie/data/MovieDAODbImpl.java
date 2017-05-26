package com.skilldistillery.movie.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.movie.models.Actor;
import com.skilldistillery.movie.models.Movie;

public class MovieDAODbImpl implements MovieDAODb {
	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";
	private List<Movie> movies;

	public MovieDAODbImpl() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Error loading MySQL Driver!!!");
			}
		}

	@Override
	public String getMovieNameById(int id) {
		String title = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT title FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				title = rs.getString(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return title;
	}

	@Override
	public Movie getMovieById(int id) {
		Movie movie = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			//
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int filmId = rs.getInt(1);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
//				film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
//						features);
				List<Actor> actors = getActorById(filmId);
				movie.setActors(actors);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

	@Override
	public List<Movie> getMovieByKeyword(String query) {
		List<Movie> mo = new ArrayList<>();
		Movie movie = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			//
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film WHERE title LIKE ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + query + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int movieId = rs.getInt(1);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
//				movie = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
//						features);
				List<Actor> actors = getActorById(movieId);
				movie.setActors(actors);
				mo.add(movie);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mo;

	}

	@Override
	public void deleteMovie(int movieId) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "DELETE FROM film Where id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, movieId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Actor> getActorById(int movieId) {
		Actor actor = null;
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT actor_id FROM Film_actor WHERE film_id = " + movieId;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorId = rs.getInt(1);
				String sql2 = "SELECT  first_name, last_name FROM actor WHERE id = " + actorId + ";";
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
				ResultSet rs2 = stmt2.executeQuery();
				if (rs2.next()) {
					int actorid = rs2.getInt(1);
					String name = rs2.getString(2);
					actor = new Actor(actorId, name);
					actors.add(actor);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public Movie addMovie(Movie movie) {
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			String sql = "INSERT INTO film (title,description,release_year,language_id,length,rating,special_features) values (?,?,?,?,?,?,?)";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, movie.getTitle());
//			stmt.setString(2, movie.getDescription());
//			stmt.setInt(3, movie.getYear());
//			stmt.setInt(4, movie.getLanguageId());
//			stmt.setInt(5, movie.getLength());
//			stmt.setString(6, movie.getRating());
//			stmt.setString(7, movie.getSpecialFeatures());
//			stmt.execute();
//
//			ResultSet key = stmt.getGeneratedKeys();
//			int id = 0;
//			if (key.next()) {
//				id = key.getInt(1);
//			}
//
//			film.setId(id);
//			stmt.close();
//			conn.close();
//			// rs.close();
//			return film;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return null;
	}

}
