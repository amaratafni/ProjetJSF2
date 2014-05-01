package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Annonce;
import com.model.Utilisateur;
import com.services.IServiceAdmin;
import com.services.IServiceGestionClient;

@SuppressWarnings( "serial" )
@Controller( "adminBean" )
@Scope( "session" )
public class AdminBean implements Serializable {

    @Autowired
    IServiceAdmin            Iserviceadmin;
    @Autowired
    IServiceGestionClient    iserviceClient;

    // variables pour la gestion d'annonces
    public List<Annonce>     annonces;
    public List<Annonce>     selectedannonce;
    private Annonce          annonce;

    // variables pour la gestion d'utilisateur
    public List<Utilisateur> utilisateurs;

    // constructeur par default
    public AdminBean() {
        this.annonces = new ArrayList<>();
        this.annonce = new Annonce();
        this.utilisateurs = new ArrayList<>();
    }

    /**
     * recuperer tous les utilisateurs
     */
    public String listUtilisateur() {
        // permet de renvoyé tous les utilisateurs inscrit dans notre systeme

        return null;

    }

    /**
     * 
     */
    public void modifierUtilisateur() {
        // permet de modifier un utilisatuer

    }

    /**
     * bloquer un utilisateurs par son identifiant
     */
    public String supprimerUtilisateur() {
        // permet de bloquer un utilisateur
        utilisateurs = Iserviceadmin.finAllUtilisateur();
        return "listeutilisateur";

    }

    /**
     * supprimer l'annonce selection
     */
    public void supprimerAnnonceById() {
        Iserviceadmin.SupprimerAnnonceById( annonce.getIdAnnonce() );
    }

    /**
     * recuperation de toutes les annonce depuis la BDD
     * 
     * @return
     */
    public String listAnnonce() {
        annonces = Iserviceadmin.findAllAnnonce();

        return "listeAnnonce";
    }

    public List<Annonce> getAnnonces() {
        annonces = Iserviceadmin.findAllAnnonce();
        return annonces;
    }

    public void setAnnonces( List<Annonce> annonces ) {
        this.annonces = annonces;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs( List<Utilisateur> utilisateurs ) {
        this.utilisateurs = utilisateurs;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce( Annonce annonce ) {
        this.annonce = annonce;
    }

    public List<Annonce> getSelectedannonce() {
        return selectedannonce;
    }

    public void setSelectedannonce( List<Annonce> selectedannonce ) {
        this.selectedannonce = selectedannonce;
    }

    // bean pour la table supprimer user
    public void onEdit( RowEditEvent event ) {

        Utilisateur aUser = (Utilisateur) event.getObject();
        iserviceClient.updateUtilisateur( aUser );

        FacesMessage msg = new FacesMessage( "L'utilisateur modifier est",
                ( (Utilisateur) event.getObject() ).getAlias() );

        FacesContext.getCurrentInstance().addMessage( null, msg );

    }

    public void onCancel( RowEditEvent event ) {
        FacesMessage msg = new FacesMessage( "Car Cancelled", ( (Utilisateur) event.getObject() ).getAlias() );

        FacesContext.getCurrentInstance().addMessage( null, msg );
    }

}
