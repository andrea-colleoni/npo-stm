package com.st.corso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMSingleton {
	
	private static EMSingleton instance;
	
	private EntityManagerFactory emf;
	
	private EMSingleton() {
		emf = Persistence.createEntityManagerFactory("pu-condominio");
	}
	
	public static EMSingleton getInstance() {
		if(instance == null)
			instance = new EMSingleton();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

}
