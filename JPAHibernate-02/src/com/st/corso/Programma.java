package com.st.corso;

import javax.persistence.EntityManager;

import com.st.corso.beans.Appartamento;
import com.st.corso.beans.Citta;
import com.st.corso.beans.Condominio;
import com.st.corso.beans.Persona;
import com.st.corso.beans.Regione;

public class Programma {

	public static void main(String[] args) {
		EntityManager em = EMSingleton.getInstance().getEm();
		em.getTransaction().begin();
		
		Condominio cond = new Condominio();
		em.persist(cond);
		
		Citta citta = new Citta();
		citta.setNome("Milano");
		citta.setProvincia("MI");
		
		Regione regione = new Regione();
		regione.setNome("Lombardia");
		citta.setRegione(regione);
		
		cond.setCitta(citta);
		
		cond.setIndirizzo("Via Verdi, 1");
		cond.setNome("ASTRA");
		
		Appartamento app = new Appartamento();
		cond.addAppartamento(app);
		app.setMetriQuadrati(70);
		app.setPiano(2);
		app.setScala("B");
		
		Persona p1 = new Persona();
		app.addProprietario(p1);
		p1.setCodiceFiscale("ABCDEF345678");
		p1.setNome("Mario");
		p1.setCognome("Rossi");
		
		p1 = new Persona();
		app.addProprietario(p1);
		p1.setCodiceFiscale("GHIJKL345678");
		p1.setNome("Anna");
		p1.setCognome("Bianchi");
		
		em.getTransaction().commit();
	}

}
