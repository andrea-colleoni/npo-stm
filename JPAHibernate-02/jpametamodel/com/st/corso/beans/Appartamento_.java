package com.st.corso.beans;

import com.st.corso.beans.Condominio;
import com.st.corso.beans.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T12:01:02")
@StaticMetamodel(Appartamento.class)
public class Appartamento_ { 

    public static volatile SingularAttribute<Appartamento, Integer> idAppartamento;
    public static volatile SingularAttribute<Appartamento, Integer> piano;
    public static volatile ListAttribute<Appartamento, Persona> proprietari;
    public static volatile SingularAttribute<Appartamento, String> scala;
    public static volatile SingularAttribute<Appartamento, Float> metriQuadrati;
    public static volatile SingularAttribute<Appartamento, Condominio> condominio;

}