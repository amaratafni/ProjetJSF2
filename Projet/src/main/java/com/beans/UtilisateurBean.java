package com.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Annonce;
import com.model.Utilisateur;
import com.services.IServiceGestionAnnonce;
import com.services.IServiceGestionClient;

@Controller( "utilisateurBean" )
@Scope( "session" )
public class UtilisateurBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Utilisateur       utilisateur;

    /* j'ai besoin de le garder user en session : */
    private Utilisateur       aUtilisateurSession;
    private Annonce           annonce;

    @Autowired
    IServiceGestionClient     iServiceGestionClient;
    @Autowired
    IServiceGestionAnnonce    iServiceGestionAnnonce;

    /* Constructeur */
    public UtilisateurBean() {
        this.utilisateur = new Utilisateur();
        this.annonce = new Annonce();
        this.aUtilisateurSession = new Utilisateur();
    }

    /* Authentification : */
    public String login() {

        aUtilisateurSession = utilisateur;
        utilisateur.setAlias( utilisateur.getAlias() );
        utilisateur.setEmail( utilisateur.getEmail() );

        List<Utilisateur> aUtilisateur = iServiceGestionClient.findUserByExample( utilisateur );
        if ( aUtilisateur.isEmpty() ) {
            /* je les ajouter pour initialiser juste l'interface IHM de login */
            utilisateur = new Utilisateur();

            return null;

        } else {
            /* je les ajouter pour initialiser juste l'interface IHM de login */
            utilisateur = new Utilisateur();

            return "CompteUser";
        }
    }

    public void validerLogAlias( FacesContext contexte, UIComponent composant, Object objet ) throws IOException {
        utilisateur = new Utilisateur();
        String valeur = null;
        valeur = objet.toString();
        boolean estValide = false;
        utilisateur.setAlias( valeur );
        List<Utilisateur> aUtilisateur = iServiceGestionClient.findUserByExample( utilisateur );
        if ( aUtilisateur.isEmpty() ) {
            estValide = true;
        }
        if ( estValide ) {
            throw new ValidatorException( new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "not valide",
                    "not valide" ) );
        }
    }

    public void validerLogEmail( FacesContext contexte, UIComponent composant, Object objet ) {

        String valeur = null;
        valeur = objet.toString();
        boolean estValide = false;

        utilisateur.setEmail( valeur );
        List<Utilisateur> aUtilisateur = iServiceGestionClient.findUserByExample( utilisateur );

        if ( aUtilisateur.isEmpty() ) {
            estValide = true;
        }
        if ( estValide ) {
            throw new ValidatorException( new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "not valide",
                    "not valide" ) );
        }
    }

    public String inscription() {

        /* je commit vers la base de donée le new user : */
        utilisateur.setEtat( true );
        // je vais tester est le alias existe déja ou non :
        iServiceGestionClient.findUserByAlias( "alias", utilisateur.getAlias() );
        /* J'apel le service : */
        iServiceGestionClient.ajouterUser( utilisateur );

        return "CompteUser";
    }

    public void validerAlias( FacesContext contexte, UIComponent composant, Object objet ) {

        String valeur = null;
        boolean estValide = false;
        valeur = objet.toString();
        utilisateur.setAlias( valeur );
        List<Utilisateur> aList = iServiceGestionClient.findUserByAlias( "alias", valeur );
        if ( aList.isEmpty() ) {
        } else {
            estValide = true;
        }
        if ( estValide ) {
            throw new ValidatorException( new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Entrée non valide",
                    "Entrée non valide" ) );
        }
    }

    /* Methode editer annonce to modify */
    public void onEdit( RowEditEvent event ) {

        Annonce aAnnonce = new Annonce();
        aAnnonce = (Annonce) event.getObject();
        System.out.println( aAnnonce.getIdAnnonce() );
        System.out.println( aAnnonce.getTitre() );
        iServiceGestionAnnonce.updateAnnonce( aAnnonce );
        // iServiceGestionAnnonce.updateByID( aAnnonce.getIdAnnonce() );
        FacesMessage msg = new FacesMessage( "L'annonce modifier est",
                ( (Annonce) event.getObject() ).getTitre() );

        FacesContext.getCurrentInstance().addMessage( null, msg );

    }

    /* **********************Getter and Setter *************** */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur( Utilisateur utilisateur ) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce( Annonce annonce ) {
        this.annonce = annonce;
    }

    public IServiceGestionClient getiServiceGestionClient() {
        return iServiceGestionClient;
    }

    public void setiServiceGestionClient( IServiceGestionClient iServiceGestionClient ) {
        this.iServiceGestionClient = iServiceGestionClient;
    }

    public Utilisateur getaUtilisateurSession() {
        return aUtilisateurSession;
    }

    public void setaUtilisateurSession( Utilisateur aUtilisateurSession ) {
        this.aUtilisateurSession = aUtilisateurSession;
    }

}
