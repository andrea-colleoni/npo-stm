package com.st.corso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(schema="`stm-commons`")
public class Citta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCitta;
	
	private String nome;
	
	private String provincia;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Regione regione;

	@OneToMany(mappedBy="citta", cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch=FetchType.LAZY)
	private List<Condominio> condominii;
	
	// nel costruttore inizializzo tutte le liste di oggetti
	public Citta() {
		condominii = new ArrayList<>();
	}
	
	public void addCondominio(Condominio condominio) {
		condominii.add(condominio);
		condominio.setCitta(this);
	}
	
	public void removeCondominio(Condominio condominio) {
		condominii.remove(condominio);
		condominio.setCitta(null);
	}

	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	public List<Condominio> getCondominii() {
		return condominii;
	}

	public void setCondominii(List<Condominio> condominii) {
		this.condominii = condominii;
	}
	
	

}
