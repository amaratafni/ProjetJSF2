package com.model;

// Generated 25 f�vr. 2014 18:04:58 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Adresse generated by hbm2java
 */
@Entity
@Table( name = "adresse"
        , schema = "public" )
public class Adresse implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int               idAdresse;
    private String            ville;
    private Integer           codePostale;
    private String            cartier;
    private Set<Annonce>      annonces         = new HashSet<Annonce>( 0 );

    public Adresse() {
    }

    public Adresse( int idAdresse ) {
        this.idAdresse = idAdresse;
    }

    public Adresse( int idAdresse, String ville, Integer codePostale, String cartier, Set<Annonce> annonces ) {
        this.idAdresse = idAdresse;
        this.ville = ville;
        this.codePostale = codePostale;
        this.cartier = cartier;
        this.annonces = annonces;
    }

    @Id
    @Column( name = "id_adresse", unique = true, nullable = false )
    @GenericGenerator( name = "kaugen", strategy = "increment" )
    @GeneratedValue( generator = "kaugen" )
    public int getIdAdresse() {
        return this.idAdresse;
    }

    public void setIdAdresse( int idAdresse ) {
        this.idAdresse = idAdresse;
    }

    @Column( name = "ville" )
    public String getVille() {
        return this.ville;
    }

    public void setVille( String ville ) {
        this.ville = ville;
    }

    @Column( name = "code_postale" )
    public Integer getCodePostale() {
        return this.codePostale;
    }

    public void setCodePostale( Integer codePostale ) {
        this.codePostale = codePostale;
    }

    @Column( name = "cartier" )
    public String getCartier() {
        return this.cartier;
    }

    public void setCartier( String cartier ) {
        this.cartier = cartier;
    }

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "adresse" )
    public Set<Annonce> getAnnonces() {
        return this.annonces;
    }

    public void setAnnonces( Set<Annonce> annonces ) {
        this.annonces = annonces;
    }

}
