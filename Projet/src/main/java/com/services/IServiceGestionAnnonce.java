package com.services;

import java.util.List;

import com.model.Adresse;
import com.model.Annonce;

public interface IServiceGestionAnnonce {

    public void publierAnnonce( Annonce annonce );

    public void updateAnnonce( Annonce annonce );

    public Annonce getAnnonce( int idAnnonce );

    public List<Annonce> getAllAnnonce();

    public List<Annonce> findByExample( Annonce annonce );

    public List<Annonce> findByCreteria( String champs, Object value );

    public List<Annonce> DeleteCreteria( String champs, Object value );

    public void deleteAnnonce( int idAnnonce );

    public List<Annonce> getALLAnnanceByIdeUser( int idUserCurent );

    public List<Annonce> getALLAnnanceByIdAdress( int idAdresseCourant );

    public void deleteAnnonceByIDUser( int idUser );

    public void insererAdresse( Adresse adresse );

    public List<Adresse> findByExampleAdresse( Adresse adresse );

    public List<Annonce> findByExampleSql( Annonce annonce, Adresse adresse );

}
