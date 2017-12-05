package com.st.corsojpa.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the automobile database table.
 * 
 */
@Entity
@NamedQuery(name="Automobile.findAll", query="SELECT a FROM Automobile a")
public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String targa;

	@ManyToOne
	@JoinColumn(name="codfisc_proprietario")
	private Persona proprietario;

	private String marca;

	private String modello;

	public Automobile() {
	}

	public String getTarga() {
		return this.targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Persona getProprietario() {
		return proprietario;
	}

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}

}