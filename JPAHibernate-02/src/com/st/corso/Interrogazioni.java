package com.st.corso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.st.corso.beans.Appartamento;
import com.st.corso.beans.Citta;
import com.st.corso.beans.Persona;

public class Interrogazioni {
	
	public static void main(String[] args) {
		EntityManager em = EMSingleton.getInstance().getEm();
		
		TypedQuery<Persona> q1 = em.createQuery("select p from Persona p", Persona.class);
		
		List<Persona> persone = q1.getResultList();
		for(Persona p : persone)
			System.out.println(p.getNome());
		
		TypedQuery<String> q2 = em.createQuery("select p.nome from Persona p", String.class);
		
		List<String> nomi = q2.getResultList();
		for(String s : nomi)
			System.out.println(s);
		
		TypedQuery<Citta> q3 = em.createQuery("select DISTINCT c.citta from Condominio c", Citta.class);
		
		List<Citta> citta = q3.getResultList();
		for(Citta c : citta)
			System.out.println(c.getDescrizioneCitta());
		
		TypedQuery<Citta> q4 = em.createQuery("select DISTINCT c.citta from Condominio c where c.citta.provincia='MI'", Citta.class);
		citta = q4.getResultList();
		for(Citta c : citta)
			System.out.println(c.getDescrizioneCitta());
		System.out.println("***");
		String provincia = "MI";
		TypedQuery<Citta> q5 = em.createQuery("select DISTINCT c.citta from Condominio c where c.citta.provincia=:provincia", Citta.class);
		citta = q5
				.setParameter("provincia", provincia)
				.getResultList();
		for(Citta c : citta)
			System.out.println(c.getDescrizioneCitta());
		System.out.println("***");
		TypedQuery<Persona> q6 = em.createNamedQuery("Persona.perCognome", Persona.class);
		persone = q6
					.setParameter("cognome",  "Rossi")
					.getResultList();
		for(Persona p : persone)
			System.out.println(p.getNome());
		System.out.println("***");
		TypedQuery<Appartamento> q7 = em.createQuery("select app from Appartamento app, IN(app.proprietari) prop where prop.cognome='Rossi'", Appartamento.class);
		for(Appartamento a : q7.getResultList())
			System.out.println(a.getCondominio().getNome());

	}

}
