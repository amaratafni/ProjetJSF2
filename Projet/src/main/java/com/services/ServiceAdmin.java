package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IDaoAnnonce;
import com.dao.IDaoUtilisateur;
import com.model.Annonce;
import com.model.Utilisateur;

@Service
public class ServiceAdmin implements IServiceAdmin {

    @Autowired
    IDaoAnnonce     idaoannonce;
    @Autowired
    IDaoUtilisateur idutilisateur;

    public List<Annonce> findAllAnnonce() {

        return idaoannonce.getAllAnnonce();

    };

    public void SupprimerAnnonceById( int id ) {

        idaoannonce.deleteAnnonceByID( id );
    };

    public List<Utilisateur> finAllUtilisateur() {

        return idutilisateur.getAllUtilisteur();

    }

    public void modifierUtilisateur( Utilisateur utilisateur ) {
        idutilisateur.updateUtilisateur( utilisateur );
    }

}
