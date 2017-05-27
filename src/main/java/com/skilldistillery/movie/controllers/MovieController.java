package com.skilldistillery.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.movie.data.MovieDAODb;
import com.skilldistillery.movie.models.Movie;

@Controller
@SessionAttributes({ "movies" })
public class MovieController {
	@Autowired
	private MovieDAODb dao;

	@ModelAttribute("movies")
	public List<Movie> currentMovieList() {
		return dao.getMovieList();
	}
	
	@RequestMapping(path = "homepage.do", method = RequestMethod.GET)
	public String login() {
		return "WEB-INF/views/homepage.jsp";
	}
	
	@RequestMapping(path = "listmovies.do", method = RequestMethod.GET)
	public ModelAndView listMoviesGet(@ModelAttribute("movies") List<Movie> movies) {
		movies = dao.getMovieList();
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listmovies.jsp", "movies", movies);
		mv.addObject("dao", dao);
		return mv;
	}
	
	@RequestMapping(path ="addmovie.do", method = RequestMethod.GET)
	public ModelAndView addMovieGet() {
		ModelAndView mv = new ModelAndView("WEB-INF/views/addmovie.jsp");
		mv.addObject("dao", dao);
		return mv;
	}

	@RequestMapping(path ="addmovie.do", method = RequestMethod.POST)
	public ModelAndView addMoviePost(@RequestParam("name") String name, @RequestParam("year") String year, @RequestParam("genre") String genre, @RequestParam("pic") String pic) {
		dao.addMovie(name, year, genre, pic);
		ModelAndView mv = new ModelAndView("WEB-INF/views/homepage.jsp");
		return mv;
	}
	
	@RequestMapping(path ="removemovie.do", method = RequestMethod.POST)
	public ModelAndView removeMoviePost(@RequestParam("name") String name) {
		dao.deleteMovie(name);
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listmovies.jsp", "movies", dao.getMovieList());
		return mv;
	}
	
	@RequestMapping(path ="updatemovie.do", method = RequestMethod.GET)
	public ModelAndView updateMovieGet(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("year") String year, @RequestParam("genre") String genre, @RequestParam("pic") String pic) {
		ModelAndView mv = new ModelAndView("/WEB-INF/views/updatemovie.jsp");
		mv.addObject("id", id);
		mv.addObject("name", name);
		mv.addObject("year", year);
		mv.addObject("genre", genre);
		mv.addObject("pic", pic);
		return mv;
	}
	
	@RequestMapping(path ="updatemovie.do", method = RequestMethod.POST)
	public ModelAndView updateMoviePost(@ModelAttribute("movies") List<Movie> movies, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("year") String year, @RequestParam("genre") String genre, @RequestParam("pic") String pic) {
		dao.updateMovie(id, name, year, genre, pic);
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listmovies.jsp");
		movies = dao.getMovieList();
		mv.addObject("movies", movies);
		mv.addObject("dao", dao);
		return mv;
	}
	
	@RequestMapping(path ="randommovie.do", method = RequestMethod.GET)
	public ModelAndView randomMovieGet() {
		Movie movie = dao.getRandomMovie();
		ModelAndView mv = new ModelAndView("WEB-INF/views/randommovie.jsp");
		mv.addObject("movie", movie);
		return mv;
	}
	
	@RequestMapping(path ="filtermovie.do", method = RequestMethod.GET)
	public ModelAndView filterMovieGet(@RequestParam("filtername") String filterName) {
		List<Movie> m = dao.getMovieByKeyword(filterName);
		ModelAndView mv = new ModelAndView("WEB-INF/views/listmovies.jsp");
		mv.addObject("movies", m);
		return mv;
	}
}
