package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Filtre;

@Repository
public class DAOFiltre implements IDaoFiltre {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void creerFiltre( Filtre filtre ) {

        sessionFactory.getCurrentSession().persist( filtre );
    }

    public void deleteFiltre( int idFiltre ) {
        // sessionFactory.getCurrentSession().delete( arg0 );
    }

}
