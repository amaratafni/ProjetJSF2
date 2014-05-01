package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IDaoAnnonce;
import com.model.Adresse;
import com.model.Annonce;

@Service( "serviceGestionAnnonce" )
public class ServiceGestionAnnonce implements IServiceGestionAnnonce {

    @Autowired
    IDaoAnnonce iDaoAnnonce;

    public void publierAnnonce( Annonce annonce ) {
        getiDaoAnnonce().publierAnnonce( annonce );

    }

    public void updateAnnonce( Annonce annonce ) {
        iDaoAnnonce.updateAnnonce( annonce );
    }

    public Annonce getAnnonce( int idAnnonce ) {

        return getiDaoAnnonce().getAnnonce( idAnnonce );
    }

    public List<Annonce> getAllAnnonce() {

        return getiDaoAnnonce().getAllAnnonce();
    }

    public List<Annonce> findByExample( Annonce annonce ) {

        return getiDaoAnnonce().findByExample( annonce );
    }

    public List<Annonce> findByCreteria( String champs, Object value ) {

        return null;
    }

    public List<Annonce> DeleteCreteria( String champs, Object value ) {

        return null;
    }

    public void deleteAnnonce( int idAnnonce ) {

    }

    public List<Annonce> getALLAnnanceByIdeUser( int idUserCurent ) {

        return getiDaoAnnonce().getALLAnnanceByIdeUser( idUserCurent );
    }

    public List<Annonce> getALLAnnanceByIdAdress( int idAdresseCourant ) {

        return null;
    }

    /* Getter and setter */

    public void deleteAnnonceByIDUser( int idUser ) {

    }

    public IDaoAnnonce getiDaoAnnonce() {
        return iDaoAnnonce;
    }

    public void setiDaoAnnonce( IDaoAnnonce iDaoAnnonce ) {
        this.iDaoAnnonce = iDaoAnnonce;
    }

    @Override
    public void insererAdresse( Adresse adresse ) {
        getiDaoAnnonce().insererAdresse( adresse );

    }

    @Override
    public List<Adresse> findByExampleAdresse( Adresse adresse ) {
        return getiDaoAnnonce().findByExampleAdresse( adresse );

    }

    @Override
    public List<Annonce> findByExampleSql( Annonce annonce, Adresse adresse ) {
        // TODO Auto-generated method stub
        return getiDaoAnnonce().findByExampleSql( annonce, adresse );
    }
}
