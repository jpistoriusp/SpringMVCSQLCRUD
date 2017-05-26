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
	private static String url = "jdbc:mysql://localhost:3306/moviedb";
	private String user = "moviewatcher";
	private String pass = "moviewatcher";
	private List<Movie> movies = new ArrayList<>();
	private String tempPic = "pics/noImg.jpg";

	public MovieDAODbImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

	@Override
	public List<Movie> getMovieList() {
		if (movies.isEmpty()) {
			movies = getInitialMovieList();
			return movies;
		}
		else {
			List<Movie> m = new ArrayList<>();
			try {
				Connection conn = DriverManager.getConnection(url, user, pass);
				String sql = "SELECT id, name, year, genre, pic FROM movie;";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Movie movie = new Movie();
					movie.setId(rs.getInt(1));
					movie.setName(rs.getString(2));
					movie.setYear(rs.getString(3));
					movie.setGenre(rs.getString(4));
					movie.setPic(rs.getString(5));
					m.add(movie);
				}
				stmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return m;
		}
	}

	@Override
	public List<Movie> getInitialMovieList() {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, name, year, genre, pic FROM movie;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setYear(rs.getString(3));
				movie.setGenre(rs.getString(4));
				movie.setPic(rs.getString(5));
				movies.add(movie);
			}
			stmt.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void addMovie(String name, String year, String genre, String pic) {
		if (pic.length() == 0) {
			pic = tempPic;
		}
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO movie (name, year, genre, pic) values (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, year);
			stmt.setString(3, genre);
			stmt.setString(4, pic);
			stmt.execute();
			// ResultSet key = stmt.getGeneratedKeys();
			// if (key.next()) {
			// id = key.getInt(1);
			// }
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMovieNameById(int input) {
		String title = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT name FROM movie WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, input);
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
	public Movie getMovieById(int input) {
		Movie movie = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			//
			String sql = "SELECT id, name, year, genre, pic FROM movie WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, input);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String year = rs.getString(3);
				String genre = rs.getString(4);
				String pic = rs.getString(5);
				movie = new Movie(id, name, year, genre, pic);
				List<Actor> actors = getActorFromMovieById(id);
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
			String sql = "SELECT id, name, year, genre, pic FROM film movie LIKE ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + query + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String year = rs.getString(3);
				String genre = rs.getString(4);
				String pic = rs.getString(5);
				movie = new Movie(id, name, year, genre, pic);
				List<Actor> actors = getActorFromMovieById(id);
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
	public void deleteMovie(String moviename) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql2 = "SELECT id FROM MOVIE Where name = ?;";
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, moviename);
			ResultSet set = stmt2.executeQuery();
			if(set.next()){
			String sql1 = "DELETE FROM movie_has_actor Where movie_id = ?;";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, set.getInt(1));
			stmt1.executeUpdate();
			}
			String sql = "DELETE FROM movie Where name = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, moviename);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Actor> getActorFromMovieById(int movieId) {
		Actor actor = null;
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT a.name FROM movie m JOIN movie_has_actor mha ON mha.movie_id = m.id JOIN actor a ON mha.actor_id = a.id WHERE m.id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorId = rs.getInt(1);
				String sql2 = "SELECT name FROM actor WHERE id = " + actorId + ";";
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
				ResultSet rs2 = stmt2.executeQuery();
				if (rs2.next()) {
					int actorid = rs2.getInt(1);
					String name = rs2.getString(2);
					actor = new Actor(actorid, name);
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

}
