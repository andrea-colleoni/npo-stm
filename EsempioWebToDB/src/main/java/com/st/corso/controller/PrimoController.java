package com.st.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrimoController {

	// se un metodo restituisce una stringa, quella string verrà
	// utilizzata dal viewResolver per individuare una view da renderizzare
	@RequestMapping(path="/primo", method=RequestMethod.GET)
	public String primo() {
		return "primo";
	}
	
	// un metodo che restituisce un ModelAndView, oltre alla view recupera
	// anche le info (beans) che a questa devono essere passate
	@RequestMapping(path="/secondo", method=RequestMethod.GET)
	public ModelAndView secondo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("primo");
		mav.getModel().put("testo", "Ciao io sono un testo dinamico; il MODEL di questo controller MVC");
		return mav;
	}
	
	
}
