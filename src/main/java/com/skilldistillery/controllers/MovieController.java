package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.data.Movie;
import com.skilldistillery.data.MovieStoreDAO;

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
		return mv;
	}
	@RequestMapping(path ="addmovie.do", method = RequestMethod.GET)
	public ModelAndView orderPizza() {
		ModelAndView mv = new ModelAndView("WEB-INF/views/addmovie.html");
		return mv;
	}

	@RequestMapping(path ="addmovie.do", method = RequestMethod.POST)
	public ModelAndView orderPizza(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("year") String year) {
		Movie movie = new Movie(id, name, year);
		ModelAndView mv = new ModelAndView("WEB-INF/views/homepage.jsp");
		dao.addMovieToList(movie);
		return mv;
	}
//	@RequestMapping(path = "newCar.do", method = RequestMethod.GET)
//	public ModelAndView newCar(Car car) {
//		System.out.println(car);
//		car.setCarNum(carDao.getCars().size() + 1);
//		carDao.addCar(car);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("carList", carDao.getCars());
//		mv.setViewName("garage.jsp");
//		return mv;
//	}
}
