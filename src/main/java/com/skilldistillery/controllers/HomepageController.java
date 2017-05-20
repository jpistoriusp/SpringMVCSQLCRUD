package com.skilldistillery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@RequestMapping(path = "homepage.do", method = RequestMethod.GET)
	public String login() {
		return "WEB-INF/views/homepage.jsp";
	}
}
