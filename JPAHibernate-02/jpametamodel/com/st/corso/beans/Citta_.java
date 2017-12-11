package com.st.corso.beans;

import com.st.corso.beans.Condominio;
import com.st.corso.beans.Regione;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T17:03:21")
@StaticMetamodel(Citta.class)
public class Citta_ { 

    public static volatile SingularAttribute<Citta, Integer> idCitta;
    public static volatile SingularAttribute<Citta, String> nome;
    public static volatile ListAttribute<Citta, Condominio> condominii;
    public static volatile SingularAttribute<Citta, String> provincia;
    public static volatile SingularAttribute<Citta, Regione> regione;

}