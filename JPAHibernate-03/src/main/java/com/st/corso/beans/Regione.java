package com.st.corso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(schema="`stm-commons`")
public class Regione {
	
	@Id
	private String nome;

	@OneToMany(mappedBy="regione", cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch=FetchType.LAZY)
	private List<Citta> citta;

	public Regione() {
		citta = new ArrayList<>();
	}
	
	public void addCitta(Citta citta) {
		this.citta.add(citta);
		citta.setRegione(this);
	}	
	
	public void removeCitta(Citta citta) {
		this.citta.remove(citta);
		citta.setRegione(null);
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Citta> getCitta() {
		return citta;
	}

	public void setCitta(List<Citta> citta) {
		this.citta = citta;
	}
	
	

}
