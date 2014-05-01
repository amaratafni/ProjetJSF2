package com.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Adresse;
import com.model.Annonce;

@Repository
public class DAOAnnonce implements IDaoAnnonce {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void publierAnnonce( Annonce annonce ) {
        getSessionFactory().getCurrentSession().persist( annonce );
    }

    @Transactional
    public void updateAnnonce( Annonce annonce ) {
        System.out.println( "je suis arriver" + annonce.getTitre() );

        sessionFactory.getCurrentSession().update( annonce );
    }

    @Transactional
    public Annonce getAnnonce( int idAnnonce ) {

        return (Annonce) sessionFactory.getCurrentSession().get( Annonce.class, idAnnonce );
    }

    @SuppressWarnings( "unchecked" )
    @Transactional
    public List<Annonce> getAllAnnonce() {

        Query aQuery = sessionFactory.getCurrentSession().createQuery( " from Annonce " );

        return aQuery.list();

    }

    @SuppressWarnings( "unchecked" )
    @Transactional
    public List<Annonce> findByExample( Annonce annonce ) {
        Criteria aCriteria = sessionFactory.getCurrentSession()
                .createCriteria( "com.model.Annonce" )
                .add( create( annonce ) );

        @SuppressWarnings( "unchecked" )
        List<Annonce> results = (List<Annonce>) aCriteria.list();

        return results;
    }

    public List<Annonce> findByCreteria( String champs, Object value ) {

        return null;
    }

    public List<Annonce> DeleteCreteria( String champs, Object value ) {

        return null;
    }

    public void deleteAnnonce( int idAnnonce ) {

    }

    @Transactional
    public List<Annonce> getALLAnnanceByIdeUser( int idUserCurent ) {
        @SuppressWarnings( "unchecked" )
        List<Annonce> allAnonce = sessionFactory.getCurrentSession()
                .createSQLQuery( "select * from annonce  where id_user = :id_user" ).addEntity( Annonce.class
                ).setParameter( "id_user", idUserCurent ).list();
        return allAnonce;

    }

    public List<Annonce> getALLAnnanceByIdAdress( int idAdresseCourant ) {

        return null;
    }

    public void deleteAnnonceByIDUser( int idUser ) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insererAdresse( Adresse adresse ) {
        sessionFactory.getCurrentSession().persist( adresse );

    }

    @Transactional
    public List<Adresse> findByExampleAdresse( Adresse adresse ) {
        @SuppressWarnings( "unchecked" )
        List<Adresse> results = (List<Adresse>) sessionFactory.getCurrentSession()
                .createCriteria( "com.model.Adresse" )
                .add( create( adresse ) )
                .list();

        return results;
    }

    @Transactional
    @Override
    public List<Annonce> findByExampleSql( Annonce annonce, Adresse adresse ) {

        StringBuilder query;

        if ( ( adresse.getVille() != null && adresse.getVille().length() > 0 )
                || ( adresse.getCodePostale() != null && adresse.getCodePostale().longValue() > 0 ) ) {
            query = new StringBuilder(
                    "select * from annonce, adresse where annonce.type_bien = :type_bien and annonce.type_annonce = :type_annonce " );
        } else {
            query = new StringBuilder(
                    "select * from annonce where annonce.type_bien = :type_bien and annonce.type_annonce = :type_annonce " );
        }
        // 1.
        if ( annonce.getTitre() != null && annonce.getTitre().length() > 0 ) {
            query.append( "and annonce.titre =:titre " );
        }
        // 2.

        // 3.
        if ( annonce.getSurface() != null ) {
            query.append( "and annonce.surface =:surface " );
        }
        // 4.
        if ( annonce.getSurfaceCarry() != null ) {
            query.append( "and annonce.surface_carry =:surface_carry " );
        }
        // 5.
        if ( annonce.getDescription() != null && annonce.getDescription().length() > 0 ) {
            query.append( "and annonce.description =:description " );
        }
        // 6.
        if ( annonce.getClasseEnergitique() != null && annonce.getClasseEnergitique().length() > 0 ) {
            query.append( "and annonce.classe_energitique =:classe_energitique " );

        }
        // 7.
        if ( annonce.getPrix() != null ) {
            query.append( "and annonce.prix <= :prix " );

        }
        // adresse :
        if ( adresse.getVille() != null && adresse.getVille().length() > 0 ) {
            query.append( "and adresse.ville = :ville and annonce.id_adresse = adresse.id_adresse " );
            System.out.println( "je suis entré ici" );
        }

        // 2.
        if ( adresse.getCodePostale() != null && adresse.getCodePostale().longValue() > 0 ) {
            query.append( "and adresse.code_postale = :code_postale and annonce.id_adresse = adresse.id_adresse " );
        }
        /* Les filtres pour annonce : */

        /* thisssss annonce sssssssssssssssssssssssssss */
        SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery( query.toString() );

        createSQLQuery.addEntity( Annonce.class ).setParameter( "type_bien", annonce.getTypeBien() )
                .setParameter( "type_annonce", annonce.getTypeAnnonce() );

        // setter for annonce :
        // 1.titre :
        if ( annonce.getTitre() != null && annonce.getTitre().length() > 0 ) {
            createSQLQuery.setParameter( "titre", annonce.getTitre() );
        }
        // 2 date :

        // 3. surface:
        if ( annonce.getSurface() != null ) {
            createSQLQuery.setParameter( "surface", annonce.getSurface() );
        }
        // 4.
        if ( annonce.getSurfaceCarry() != null ) {
            createSQLQuery.setParameter( "surface_carry", annonce.getSurfaceCarry() );
        }
        // 5.
        if ( annonce.getDescription() != null && annonce.getDescription().length() > 0 ) {
            createSQLQuery.setParameter( "description", annonce.getDescription() );
        }
        // 6.
        if ( annonce.getClasseEnergitique() != null && annonce.getClasseEnergitique().length() > 0 ) {
            createSQLQuery.setParameter( "classe_energitique", annonce.getClasseEnergitique() );
        }
        // 7.
        if ( annonce.getPrix() != null ) {
            query.append( "and annonce.prix <= :prix " );
            createSQLQuery.setParameter( "prix", annonce.getPrix() );
        }
        // pour les setParametter il fau aussi mettre if
        if ( adresse.getVille() != null && adresse.getVille().length() > 0 ) {
            createSQLQuery.setParameter( "ville", adresse.getVille() );
        }
        // 2
        if ( adresse.getCodePostale() != null && adresse.getCodePostale().longValue() > 0 ) {
            createSQLQuery.setParameter( "code_postale", adresse.getCodePostale() );
        }
        return createSQLQuery.list();

    }

    @Transactional
    @Override
    public void deleteAnnonceByID( int idAnnonce ) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "delete from Annonce  where id_annonce = :id_annonce" )
                .addEntity( Annonce.class )
                .setParameter( "id_annonce", idAnnonce );
        query.executeUpdate();
    }

}
