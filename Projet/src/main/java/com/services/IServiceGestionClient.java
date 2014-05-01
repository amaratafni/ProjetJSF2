package com.services;

import java.util.List;

import com.model.Utilisateur;

public interface IServiceGestionClient {

    public void ajouterUser( Utilisateur utilisateur );

    public void deleteUser( int idUser );

    public Utilisateur findUserById( int idUtilisateur );

    public List<Utilisateur> findUserByExample( Utilisateur utilisateur );

    public List<Utilisateur> findUserByChamps( String champs, Object value );

    public List<Utilisateur> findUserByAlias( String alias, Object value );

    public void updateUtilisateur( Utilisateur utilisateur );

}
