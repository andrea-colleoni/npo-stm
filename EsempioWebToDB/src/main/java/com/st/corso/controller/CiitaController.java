package com.st.corso.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.corso.beans.Citta;

@Controller
public class CiitaController {

	@Autowired
	private EntityManager em;
	
	@RequestMapping(path="/elencoCitta", method=RequestMethod.GET)
	public @ResponseBody List<Citta> elencoCitta() {
		return em.createNamedQuery("Citta.all", Citta.class).getResultList();
	}
}
