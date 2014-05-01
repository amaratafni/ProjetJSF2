package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IDaoFiltre;
import com.model.Filtre;

@Service( "serviceGestionFiltre" )
public class ServiceGestionFiltre implements IServiceGestionFiltre {

    @Autowired
    IDaoFiltre iDaoFiltre;

    public IDaoFiltre getiDaoFiltre() {
        return iDaoFiltre;
    }

    public void setiDaoFiltre( IDaoFiltre iDaoFiltre ) {
        this.iDaoFiltre = iDaoFiltre;
    }

    // normalement appeler la dao
    public void creerFiltre( Filtre filtre ) {

        getiDaoFiltre().creerFiltre( filtre );
    }

    public void deleteFiltre( int idFiltre ) {

    }

}
