package com.st.corso;

import java.util.List;

import javax.persistence.EntityManager;

import com.st.corso.beans.Abitazione;
import com.st.corso.beans.Appartamento;
import com.st.corso.beans.Ufficio;

public class ProgrammaAvvioEM {

	public static void main(String[] args) {
		EntityManager em = EMSingleton.getInstance().getEm();
		em.getTransaction().begin();
		
		Abitazione ab = new Abitazione();
		ab.setMetriQuadrati(100);
		ab.setComponentiFamiglia(4);
		
		Ufficio uf =new Ufficio();
		uf.setMetriQuadrati(80);
		uf.setTipoAttivita("Negozio");
		
		em.persist(ab);
		em.persist(uf);
		
		em.getTransaction().commit();
		
		List<Appartamento> abitazioni = em.createQuery("select a from Appartamento a", Appartamento.class)
				.getResultList();
		for(Appartamento app : abitazioni)
			System.out.println(app.getMetriQuadrati());
	}

}
