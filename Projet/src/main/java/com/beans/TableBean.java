package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Annonce;
import com.services.IServiceGestionAnnonce;

@Controller( "tableBean" )
@Scope( "session" )
public class TableBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<Annonce>     cars;

    private Annonce           selectedCar;

    @Autowired
    IServiceGestionAnnonce    aIServiceGestionAnnonce;

    public TableBean() {
        cars = new ArrayList<Annonce>();

    }

    public Annonce getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar( Annonce selectedCar ) {
        this.selectedCar = selectedCar;
    }

    public List<Annonce> getCars() {
        // je doi récupérer d'abord le Client
        cars = aIServiceGestionAnnonce.getAllAnnonce();
        return cars;
    }

}