package com.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Utilisateur;

@Repository
public class DAOUtilisateur implements IDaoUtilisateur {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void ajouterUser( Utilisateur utilisateur ) {

        sessionFactory.getCurrentSession().persist( utilisateur );
    }

    @Transactional
    public void deleteUser( int idUser ) {
        // TODO Auto-generated method stub

    }

    @Transactional
    @Override
    public Utilisateur findUserById( int idUtilisateur ) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings( "unchecked" )
    @Transactional
    @Override
    public List<Utilisateur> findUserByExample( Utilisateur utilisateur ) {

        List<Utilisateur> results = (List<Utilisateur>) sessionFactory.getCurrentSession()
                .createCriteria( "com.model.Utilisateur" )
                .add( create( utilisateur ) )
                .list();

        return results;

    }

    @Override
    public List<Utilisateur> findUserByChamps( String champs, Object value ) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    @Transactional
    @Override
    public List<Utilisateur> findUserByAlias( String alias, Object value ) {

        List crit = sessionFactory.getCurrentSession().createCriteria( Utilisateur.class )
                .add( Restrictions.eq( alias, value ) ).list();
        return crit;

    }

    @Override
    @Transactional
    public void updateUtilisateur( Utilisateur utilisateur ) {
        sessionFactory.getCurrentSession().update( utilisateur );
    }

    @SuppressWarnings( "unchecked" )
    @Transactional
    public List<Utilisateur> getAllUtilisteur() {

        return sessionFactory.getCurrentSession().createQuery( " from Utilisateur "
                ).list();
    }

}
