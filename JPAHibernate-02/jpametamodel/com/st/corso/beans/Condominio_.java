package com.st.corso.beans;

import com.st.corso.beans.Appartamento;
import com.st.corso.beans.Citta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T17:03:21")
@StaticMetamodel(Condominio.class)
public class Condominio_ { 

    public static volatile SingularAttribute<Condominio, Integer> idCondominio;
    public static volatile ListAttribute<Condominio, Appartamento> appartamenti;
    public static volatile SingularAttribute<Condominio, String> indirizzo;
    public static volatile SingularAttribute<Condominio, String> nome;
    public static volatile SingularAttribute<Condominio, Citta> citta;

}