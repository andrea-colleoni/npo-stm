package com.st.corso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
//@Table(schema="`stm-condominio`")
//@MappedSuperclass  => non entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TIPO_APPARTAMENTO")
public class Appartamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAppartamento;
	
	private int piano;
	
	private String scala;
	
	private float metriQuadrati;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Condominio condominio;

	@ManyToMany(cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch=FetchType.LAZY)
	private List<Persona> proprietari;
	
	public Appartamento() {
		proprietari = new ArrayList<>();
	}
	
	public void addProprietario(Persona persona) {
		this.proprietari.add(persona);
		persona.getAppartamentiPosseduti().add(this);	
	}
	
	public void removeProprietario(Persona persona) {
		this.proprietari.remove(persona);
		persona.getAppartamentiPosseduti().remove(this);	
	}	
	
	public int getIdAppartamento() {
		return idAppartamento;
	}

	public void setIdAppartamento(int idAppartamento) {
		this.idAppartamento = idAppartamento;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public String getScala() {
		return scala;
	}

	public void setScala(String scala) {
		this.scala = scala;
	}

	public float getMetriQuadrati() {
		return metriQuadrati;
	}

	public void setMetriQuadrati(float metriQuadrati) {
		this.metriQuadrati = metriQuadrati;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Persona> getProprietari() {
		return proprietari;
	}

	public void setProprietari(List<Persona> proprietari) {
		this.proprietari = proprietari;
	}

}
