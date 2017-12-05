package com.st.corsojpa.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citta database table.
 * 
 */
@Entity
@NamedQuery(name="Citta.findAll", query="SELECT c FROM Citta c")
public class Citta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcitta;

	@Column(name="nome_citta")
	private String nomeCitta;

	private String provincia;

	private String regione;

	public Citta() {
	}

	public int getIdcitta() {
		return this.idcitta;
	}

	public void setIdcitta(int idcitta) {
		this.idcitta = idcitta;
	}

	public String getNomeCitta() {
		return this.nomeCitta;
	}
	
	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return this.regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

}