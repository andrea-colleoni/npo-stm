package com.st.corso.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="`stm-common`")
public class Citta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nome;
	private String provincia;
	
	@ManyToOne
	private Regione regione;
	
	@OneToMany(mappedBy="citta")
	private List<Condominio> condominii;

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
