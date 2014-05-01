package com.services;

import java.util.List;

import com.model.Annonce;
import com.model.Utilisateur;

public interface IServiceAdmin {

    public List<Annonce> findAllAnnonce();

    public void SupprimerAnnonceById( int id );

    public List<Utilisateur> finAllUtilisateur();

    public void modifierUtilisateur( Utilisateur utilisateur );

}
