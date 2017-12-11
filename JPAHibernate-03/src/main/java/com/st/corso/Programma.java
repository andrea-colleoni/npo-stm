package com.st.corso;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.st.corso.beans.Condominio;

public class Programma {

	public static void main(String[] args) {
		EntityManager em = EMSingleton.getInstance().getEm();
		
		for(Condominio c : em.createQuery("select c from Condominio c", Condominio.class)
				.getResultList())
			System.out.println(c.getIndirizzo());

		EMSingleton.getInstance().shutdown();
	}
}
