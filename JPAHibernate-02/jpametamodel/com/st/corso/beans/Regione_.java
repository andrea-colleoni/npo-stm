package com.st.corso.beans;

import com.st.corso.beans.Citta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T11:55:01")
@StaticMetamodel(Regione.class)
public class Regione_ { 

    public static volatile SingularAttribute<Regione, String> nome;
    public static volatile ListAttribute<Regione, Citta> citta;

}