package com.utsi.springwebapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utsi.springwebapp.doaImpl.StudentDAOImpl;

@Controller
public class HomeController {

	@Autowired
	StudentDAOImpl stdImpl;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		stdImpl.getAllStudent();
		return new ModelAndView("home");
	}
}
