package com.st.corsojpa;

import javax.persistence.EntityManager;

import com.st.corsojpa.beans.Automobile;
import com.st.corsojpa.beans.Persona;

public class ManutenzioneObjectModel {

	public static void main(String[] args) {
		EntityManager em = EMFSingleton.getInstance().newEm();
		em.getTransaction().begin();
		
		Persona p1 = em.find(Persona.class, "RSSMRSA45678987");
		p1.setPesoInKg(85.0F);
		
		for(Automobile auto : p1.getAutomobiliPossedute()) {
			System.out.println(auto.getTarga());
		}
		System.out.println(p1.getIndirizzo());

		Automobile a = new Automobile();
		a.setTarga("JJ777JJ");
		a.setMarca("Oracle");
		a.setModello("JPA");
		a.setProprietario(p1);
		
		p1.getAutomobiliPossedute().add(a);
		
		em.getTransaction().commit();
	}

}
