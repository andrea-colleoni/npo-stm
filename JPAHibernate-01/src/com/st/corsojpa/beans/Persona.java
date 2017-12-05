package com.st.corsojpa.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="individuo")
public class Persona {
	
	private String nome;
	private String cognome;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@Id
	private String codiceFiscale;
	
	@Transient
	private float pesoInKg;
	
	private String email;
	
	@Column(name="CAMPOINCOMPRENSIBILE")
	private String indirizzo;
	
	@OneToMany(mappedBy="proprietario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Automobile> automobiliPossedute;
	
	
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public float getPesoInKg() {
		return pesoInKg;
	}
	public void setPesoInKg(float pesoInKg) {
		this.pesoInKg = pesoInKg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public List<Automobile> getAutomobiliPossedute() {
		return automobiliPossedute;
	}
	public void setAutomobiliPossedute(List<Automobile> automobiliPossedute) {
		this.automobiliPossedute = automobiliPossedute;
	}
	
	

}
