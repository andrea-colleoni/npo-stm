package com.st.corso.beans;

import com.st.corso.beans.Appartamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T17:03:21")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> cognome;
    public static volatile ListAttribute<Persona, Appartamento> appartamentiPosseduti;
    public static volatile SingularAttribute<Persona, String> nome;
    public static volatile SingularAttribute<Persona, String> codiceFiscale;

}