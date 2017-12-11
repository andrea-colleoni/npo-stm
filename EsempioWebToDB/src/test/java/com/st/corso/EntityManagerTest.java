package com.st.corso;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class EntityManagerTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbweb");
		assertNotNull(emf);
		
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
		
		em.close();
		emf.close();
	}

}
