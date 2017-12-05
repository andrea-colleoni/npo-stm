package com.st.corso.beans;

import javax.persistence.EntityManager;


public class Programma {

	public static void main(String[] args) {
		EntityManager em = EMFSingleton.getInstance().getEm();
	}

}
