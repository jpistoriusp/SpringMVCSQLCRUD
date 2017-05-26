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

import com.skilldistillery.movie.data.MovieStoreDAO;
import com.skilldistillery.movie.models.Movie;

@Controller
@SessionAttributes({ "currentMovieList" })
public class MovieController {
	@Autowired
	private MovieStoreDAO dao;

	@ModelAttribute("currentMovieList")
	public List<Movie> currentMovieList() {
		return dao.getMovieList();
	}
	
	@RequestMapping(path = "homepage.do", method = RequestMethod.GET)
	public String login() {
		return "WEB-INF/views/homepage.jsp";
	}
	@RequestMapping(path = "listmovies.do", method = RequestMethod.GET)
	public ModelAndView listMovies(@ModelAttribute("currentMovieList") List<Movie> movies) {
		movies = dao.getMovieList();
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listmovies.jsp", "movies", movies);
		mv.addObject("dao", dao);
		return mv;
	}
	
	@RequestMapping(path ="addmovie.do", method = RequestMethod.GET)
	public ModelAndView addMovie() {
		ModelAndView mv = new ModelAndView("WEB-INF/views/addmovie.jsp");
		mv.addObject("dao", dao);
		return mv;
	}

	@RequestMapping(path ="addmovie.do", method = RequestMethod.POST)
	public ModelAndView addMovie(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("year") String year, @RequestParam("genre") String genre, @RequestParam("pic") String pic) {
		Movie movie = new Movie(id, name, year, genre, pic);
		dao.addMovieToList(movie);
		ModelAndView mv = new ModelAndView("WEB-INF/views/homepage.jsp");
		return mv;
	}
	@RequestMapping(path ="removemovie.do", method = RequestMethod.GET)
	public ModelAndView removeMovie(@ModelAttribute("currentMovieList") List<Movie> movies) {
		movies = dao.getMovieList();
		ModelAndView mv = new ModelAndView("WEB-INF/views/removemovie.jsp", "movies", movies);
		mv.addObject("dao", dao);
		return mv;
	}
	@RequestMapping(path ="removemovie.do", method = RequestMethod.POST)
	public ModelAndView removeMovie(@RequestParam("name") String name) {
		dao.removeMovieFromList(name);
		ModelAndView mv = new ModelAndView("WEB-INF/views/homepage.jsp");
		return mv;
	}
	@RequestMapping(path ="randommovie.do", method = RequestMethod.GET)
	public ModelAndView removeMovie() {
		Movie mo = dao.getRandomMovie();
		ModelAndView mv = new ModelAndView("WEB-INF/views/randommovie.jsp", "movie", mo);
		mv.addObject("dao", dao);
		return mv;
	}
}
