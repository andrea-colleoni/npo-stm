package com.st.corso.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Abitazione extends Appartamento {
	
	private int componentiFamiglia;

	public int getComponentiFamiglia() {
		return componentiFamiglia;
	}

	public void setComponentiFamiglia(int componentiFamiglia) {
		this.componentiFamiglia = componentiFamiglia;
	}	

}
