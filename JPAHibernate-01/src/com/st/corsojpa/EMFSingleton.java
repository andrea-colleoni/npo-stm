package com.st.corsojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	
	private EntityManagerFactory emf;
	
	private static EMFSingleton instance;
	
	private EMFSingleton() {
		emf = Persistence.createEntityManagerFactory("JPAHibernate-01");
	}

	public static EMFSingleton getInstance() {
		if (instance == null)
			instance = new EMFSingleton();
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public EntityManager newEm() {
		return emf.createEntityManager();
	}
}
