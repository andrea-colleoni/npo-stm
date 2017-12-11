package com.st.corso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.st.corso.beans.Condominio;
import com.st.corso.beans.Condominio_;

public class ProgrammaCriteriaAPI {

	public static void main(String[] args) {
		EntityManager em = EMSingleton.getInstance().getEm();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Condominio> cq = cb.createQuery(Condominio.class);
		
//		Metamodel m = em.getMetamodel();
//		EntityType<Condominio> Condominio = m.entity(Condominio.class);
		
		Root<Condominio> condominio = cq.from(Condominio.class);
		//cq.select(condominio.get(Condominio_.indirizzo.getName()));
		//cq.select(condominio.get("indirizzo"));
		cq.select(condominio);
		cq.orderBy(cb.desc(condominio.get("indirizzo")));
		
		TypedQuery<Condominio> q = em.createQuery(cq);
		List<Condominio> lista = q.getResultList();
		
		for(Condominio c : lista)
			System.out.println(c.getIndirizzo());

	}

}
