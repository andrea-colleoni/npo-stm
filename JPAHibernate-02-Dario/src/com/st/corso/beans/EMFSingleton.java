package com.st.corso.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	private static EMFSingleton instance;
	private EntityManagerFactory emf;
	
	private EMFSingleton() {
		emf=Persistence.createEntityManagerFactory("pu-condominio");
	}
	
	public static EMFSingleton getInstance() {
		if(instance==null)
			instance=new EMFSingleton();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}
	
}
