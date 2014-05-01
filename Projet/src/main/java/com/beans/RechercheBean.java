package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Adresse;
import com.model.Annonce;
import com.services.IServiceGestionAnnonce;

@Controller( "rechercheBean" )
@Scope( "session" )
public class RechercheBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Annonce           selectedCar;
    Annonce                   annonce;
    Adresse                   adresse;
    @Autowired
    IServiceGestionAnnonce    iServiceGestionAnnonce;

    private List<Annonce>     listAnnonce;

    private Annonce           selectedAnnonce;

    public RechercheBean() {
        super();
        listAnnonce = new ArrayList<Annonce>();
        this.annonce = new Annonce( new Adresse() );
        this.adresse = new Adresse();
    }

    /* Methode recherche : */
    public String recherche() {

        listAnnonce = iServiceGestionAnnonce.findByExampleSql( annonce, adresse );

        return "rechercheResultat";

    }

    public Annonce getSelectedAnnonce() {
        return selectedAnnonce;
    }

    public void setSelectedAnnonce( Annonce selectedAnnonce ) {
        this.selectedAnnonce = selectedAnnonce;
    }

    public List<Annonce> getlistAnnonce() {

        return listAnnonce;
    }

    public Annonce getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar( Annonce selectedCar ) {
        this.selectedCar = selectedCar;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce( Annonce annonce ) {
        this.annonce = annonce;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse( Adresse adresse ) {
        this.adresse = adresse;
    }

}