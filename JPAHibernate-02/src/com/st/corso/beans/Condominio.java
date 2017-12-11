package com.st.corso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
//@Table(schema = "`stm-condominio`")
public class Condominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCondominio;

	private String nome;

	private String indirizzo;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Citta citta;

	@OneToMany(mappedBy = "condominio", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Appartamento> appartamenti;

	public Condominio() {
		appartamenti = new ArrayList<>();
	}
	
	public void addAppartamento(Appartamento appartamento) {
		appartamenti.add(appartamento);
		appartamento.setCondominio(this);
	}	
	
	public void removeAppartamento(Appartamento appartamento) {
		appartamenti.remove(appartamento);
		appartamento.setCondominio(null);
	}	

	public int getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(int idCondominio) {
		this.idCondominio = idCondominio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public List<Appartamento> getAppartamenti() {
		return appartamenti;
	}

	public void setAbitazioni(List<Appartamento> appartamenti) {
		this.appartamenti = appartamenti;
	}

}
