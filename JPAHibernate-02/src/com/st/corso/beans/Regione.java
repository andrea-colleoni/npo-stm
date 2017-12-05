package com.st.corso.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="`stm-commons`")
public class Regione {
	
	@Id
	private String nome;
	
	@OneToMany(mappedBy="regione")
	private List<Citta> citta;

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
