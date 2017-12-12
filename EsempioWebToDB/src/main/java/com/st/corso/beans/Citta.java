package com.st.corso.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Citta.all", query="select c from Citta c")
})
public class Citta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCitta;
	private String nome;
	private String provincia;
	
	@OneToMany(mappedBy="citta")
	private List<Persona> abitanti;

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

	public List<Persona> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(List<Persona> abitanti) {
		this.abitanti = abitanti;
	}
	
	

}
