package com.skilldistillery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.data.Movie;
import com.skilldistillery.data.MovieStoreDAO;

@Controller
public class ListMoviesController {

	@Autowired
	private MovieStoreDAO dao;
	List<Movie> movies;

	@RequestMapping(path = "listmovies.do", method = RequestMethod.GET)
	public ModelAndView login() {
		movies = dao.getMovieList();
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listmovies.jsp", "movies", movies);
		return mv;
	}
}
