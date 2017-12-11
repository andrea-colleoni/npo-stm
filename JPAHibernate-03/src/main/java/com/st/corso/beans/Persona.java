package com.st.corso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Persona.tutte", query="select p from Persona p"),
	@NamedQuery(name="Persona.perCognome", query="select p from Persona p where p.cognome=:cognome")
})
public class Persona {
	
	@Id
	private String codiceFiscale;
	
	private String nome;
	
	private String cognome;
	
	@ManyToMany(mappedBy="proprietari", cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch=FetchType.LAZY)
	//private List<Abitazione> appartamentiPosseduti; => NO CON MAPPEDSUPERCLASS
	private List<Appartamento> appartamentiPosseduti;
	
	public Persona() {
		appartamentiPosseduti = new ArrayList<>();
	}
	
	public void addAppartamento(Abitazione appartamento) {
		this.appartamentiPosseduti.add(appartamento);
		appartamento.getProprietari().add(this);
	}
	
	public void removeAppartamento(Abitazione appartamento) {
		this.appartamentiPosseduti.remove(appartamento);
		appartamento.getProprietari().remove(this);
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Appartamento> getAppartamentiPosseduti() {
		return appartamentiPosseduti;
	}

	public void setAppartamentiPosseduti(List<Appartamento> appartamentiPosseduti) {
		this.appartamentiPosseduti = appartamentiPosseduti;
	}
	
	

}
