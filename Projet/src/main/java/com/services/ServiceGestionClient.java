package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IDaoUtilisateur;
import com.model.Utilisateur;

@Service( "serviceGestionClient" )
public class ServiceGestionClient implements IServiceGestionClient {

    @Autowired
    IDaoUtilisateur iDaoUtilisateur;

    @Override
    public void ajouterUser( Utilisateur utilisateur ) {
        getiDaoUtilisateur().ajouterUser( utilisateur );

    }

    @Override
    public void deleteUser( int idUser ) {

    }

    @Override
    public Utilisateur findUserById( int idUtilisateur ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Utilisateur> findUserByExample( Utilisateur utilisateur ) {
        return getiDaoUtilisateur().findUserByExample( utilisateur );
    }

    @Override
    public List<Utilisateur> findUserByChamps( String champs, Object value ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Utilisateur> findUserByAlias( String alias, Object value ) {

        return getiDaoUtilisateur().findUserByAlias( alias, value );
    }

    public IDaoUtilisateur getiDaoUtilisateur() {
        return iDaoUtilisateur;
    }

    public void setiDaoUtilisateur( IDaoUtilisateur iDaoUtilisateur ) {
        this.iDaoUtilisateur = iDaoUtilisateur;
    }

    @Override
    public void updateUtilisateur( Utilisateur utilisateur ) {
        iDaoUtilisateur.updateUtilisateur( utilisateur );

    }

}
