package com.st.corso.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.st.corso.beans.Persona;

@Controller
public class PersonaController {
	
	@Autowired
	private EntityManager em;

	@RequestMapping(path="/personePage", method=RequestMethod.GET)
	public ModelAndView elencoPersone() {
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("persone", em.createNamedQuery("Persona.all", Persona.class).getResultList());
		
		mav.setViewName("persona/elenco");
		return mav;
	}
	
	@RequestMapping(path="/persone", method=RequestMethod.GET)
	public @ResponseBody List<Persona> elencoPersoneRest() {
		return em.createNamedQuery("Persona.all", Persona.class).getResultList();
	}	
	
	@RequestMapping(path="/nuovaPersona", method=RequestMethod.POST)
	public @ResponseBody boolean nuovaPersona(@RequestBody Persona p) {
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
