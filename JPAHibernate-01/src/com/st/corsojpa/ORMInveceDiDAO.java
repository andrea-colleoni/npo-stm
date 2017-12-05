package com.st.corsojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.st.corsojpa.beans.Persona;

public class ORMInveceDiDAO {
	
	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHibernate-01");

		diversiEntityManager(emf);
	}
	
	static void diversiEntityManager(EntityManagerFactory emf) {
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		Persona p1 = em2.find(Persona.class, "VRDGSP76576576");
		
		em1.getTransaction().begin();
		//p1 = em1.merge(p1);
		
		em1.persist(p1);
		
		p1.setCognome("Cambio EM");
		em1.getTransaction().commit();
	}
	
	static void cancella(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Persona p1 = em.find(Persona.class, "XXX45678987");
		em.getTransaction().begin();
		
		em.remove(p1);
		
		em.getTransaction().commit();
		System.out.println("fatto.");
	}
	
	static void eccezioniETransazioni(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Persona p1 = em.find(Persona.class, "VRDGSP76576576");
		p1.setCognome("Blu");
		
		Persona p2 = em.find(Persona.class, "BNCNNA87875785");
		p2.setNome("Blu");
		
		try {
			if (System.currentTimeMillis() % 2 == 0)
				throw new Exception("eccezione");
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
		System.out.println("fatto.");
	}
	
	static void varie(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Persona p1 = em.find(Persona.class, "VRDGSP76576576");
		p1.setCognome("Blu");
		
		em.detach(p1);
		
		p1.setNome("Flavio");
		
		// persisto tutti gli oggetti che QUI sono managed
		em.getTransaction().commit();
		System.out.println("fatto.");
	}
	
	static void modifica(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Persona p1 = em.find(Persona.class, "RSSMRSA45678987");
//		p1.setNome("Caio");

		Persona p2 = new Persona();
		p2.setCognome("Neri");
		p2.setNome("Carlo");
		p2.setCodiceFiscale("XXXYYY45678987");
		
		// merge accetta un detached object e restituisce un managed (attached) object
		Persona p3 = em.merge(p2);
		
		p3.setCognome("Gialli");
		
		// verifio ce un oggetto è già nell'EntityManager
		em.contains(p2);
//		
//		em.persist(p2);
		
		
		em.getTransaction().commit();
		System.out.println("fatto.");
		
	}
	
	static void letturaPerChiave(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		// lettura (select)
		// 1 record (per chiave)
		Persona p = em.find(Persona.class, "RSSMRSA45678987");
		System.out.println(p.getCognome());
		em.close();
	}
	
	static void letturaTutto(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		// lettura (select)
		// tutti i record
		// JPQL
		TypedQuery<Persona> q = em.createQuery("select p from Persona p", Persona.class);
		List<Persona> elenco = q.getResultList();
		for(Persona p : elenco) 
			System.out.println(p.getCodiceFiscale());
		
		em.close();
	}
	
	static void inserimento(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Persona p = new Persona();
		p.setNome("Mario");
		p.setCognome("Rossi");
		p.setCodiceFiscale("RSSMRSA45678987");
		p.setDataNascita(new Date());
		
		// insert
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
	}

}
