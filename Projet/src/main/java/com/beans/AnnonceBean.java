package com.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Adresse;
import com.model.Annonce;
import com.model.Photo;
import com.model.Utilisateur;
import com.services.IServiceGestionAnnonce;
import com.services.IServiceGestionClient;

@Controller( "annonceBean" )
@Scope( "session" )
public class AnnonceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Annonce                   annonce;
    Adresse                   adresse;
    private String            titre;
    @Autowired
    IServiceGestionAnnonce    iServiceGestionAnnonce;
    @Autowired
    IServiceGestionClient     iServiceGestionClient;
    @Autowired
    UtilisateurBean           aUserBean;
    @Autowired
    private FileUploadBean    fileUploadBean;
    @Autowired
    UtilisateurBean           aUtilisateurBean;
    Photo                     photo;
    /* to upload: */
    private String            cheminPhoto;
    private String            nomPhoto;

    private String            destination      = "G:\\Tout les tp J2EE/workspace jEE/Projet/webapp/images/annonce/";
    /* to modify annonce : */
    private List<Annonce>     listeAnn;
    private Annonce           selectedAnnonce;

    public AnnonceBean() {

        this.annonce = new Annonce();
        this.adresse = new Adresse();
        this.listeAnn = new ArrayList<Annonce>();
    }

    /* Methode pour Ajouter une annonce */
    public String publierAnnonce() {
        /* trouver le user */
        Utilisateur utilisateur;
        utilisateur = aUserBean.getaUtilisateurSession();

        /* Recupérer l'id de l'utilisateur : */

        List<Utilisateur> aListUser = iServiceGestionClient.findUserByAlias( "alias", utilisateur.getAlias() );

        for ( Utilisateur utilisateur2 : aListUser ) {
            utilisateur = utilisateur2;
            System.out.println( utilisateur.getIdUser() );
        }
        annonce.setUtilisateur( utilisateur );

        /* il faut insérer d'abord l'adresse ensuite j'insére direct l'annonce */

        List<Adresse> aListAdresse = iServiceGestionAnnonce.findByExampleAdresse( adresse );
        for ( Adresse adresse1 : aListAdresse ) {
            adresse = adresse1;
        }

        /* Je test est ce que l'adresse existe ou nan avant d'insérer */
        if ( aListAdresse.isEmpty() ) {

            iServiceGestionAnnonce.insererAdresse( adresse );
            List<Adresse> aListAdresse2 = iServiceGestionAnnonce.findByExampleAdresse( adresse );
            for ( Adresse adresse1 : aListAdresse2 ) {
                adresse = adresse1;
            }
        }

        annonce.setAdresse( adresse );
        /* je vais ajouter les tof: */

        annonce.setBytes( fileUploadBean.getDatas() );
        annonce.setCheminphoto( nomPhoto );
        // aFileUploadController.getCheminPhoto();

        iServiceGestionAnnonce.publierAnnonce( annonce );

        annonce = new Annonce();
        adresse = new Adresse();

        return "CompteUser";
    }

    public List<Annonce> getListeAnn() {
        // celle du client qui est authentifier.
        listeAnn = new ArrayList<Annonce>();
        Utilisateur aUtilisateur = new Utilisateur();
        System.out.println( "le id user =  " + aUtilisateurBean.getaUtilisateurSession().getIdUser() );
        List<Utilisateur> aListUtilisateur = iServiceGestionClient.findUserByAlias( "alias", aUtilisateurBean
                .getaUtilisateurSession().getAlias() );
        for ( Utilisateur utilisateur : aListUtilisateur ) {
            aUtilisateur = utilisateur;
        }

        listeAnn = iServiceGestionAnnonce
                .getALLAnnanceByIdeUser( aUtilisateur.getIdUser() );
        // listeAnn = iServiceGestionAnnonce.getAllAnnonce();
        return listeAnn;
    }

    public void setListeAnn( List<Annonce> listeAnn ) {
        this.listeAnn = listeAnn;
    }

    /* upload immage : */
    public void upload( FileUploadEvent event ) {

        FacesMessage msg = new FacesMessage( "Success! ", event.getFile().getFileName() + " is uploaded." );
        FacesContext.getCurrentInstance().addMessage( null, msg );
        // Do what you want with the file
        try {
            copyFile( event.getFile().getFileName(), event.getFile().getInputstream() );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    public void copyFile( String fileName, InputStream in ) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(
                    new File( destination + fileName ) );
            cheminPhoto = destination + fileName;
            nomPhoto = fileName;
            int read = 0;
            byte[] bytes = new byte[1024];

            while ( ( read = in.read( bytes ) ) != -1 ) {
                out.write( bytes, 0, read );
            }

            in.close();
            out.flush();
            out.close();

            System.out.println( "New file created!" );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    /* Modifier Annonce : */

    /***** getter and setter : *****************/
    public Annonce getSelectedAnnonce() {
        return selectedAnnonce;
    }

    public void setSelectedAnnonce( Annonce selectedAnnonce ) {
        this.selectedAnnonce = selectedAnnonce;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce( Annonce annonce ) {
        this.annonce = annonce;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse( Adresse adresse ) {
        this.adresse = adresse;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public void setCheminPhoto( String cheminPhoto ) {
        this.cheminPhoto = cheminPhoto;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto( String nomPhoto ) {
        this.nomPhoto = nomPhoto;
    }

}
