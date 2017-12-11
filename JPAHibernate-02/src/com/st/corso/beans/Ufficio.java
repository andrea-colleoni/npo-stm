package com.st.corso.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("U")
public class Ufficio extends Appartamento {
	
	private String tipoAttivita;

	public String getTipoAttivita() {
		return tipoAttivita;
	}

	public void setTipoAttivita(String tipopAttivita) {
		this.tipoAttivita = tipopAttivita;
	}

}
