package com.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Filtre;
import com.model.Utilisateur;
import com.services.IServiceGestionClient;
import com.services.IServiceGestionFiltre;

@Controller( "filtreBean" )
@Scope( "session" )
public class FiltreBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    IServiceGestionFiltre     iServiceGestionFiltre;
    @Autowired
    IServiceGestionClient     iServiceGestionClient;
    // ISer
    Filtre                    filtre;
    @Autowired
    UtilisateurBean           aUserBean;

    public Filtre getFiltre() {
        return filtre;
    }

    public UtilisateurBean getaUserBean() {
        return aUserBean;
    }

    public void setaUserBean( UtilisateurBean aUserBean ) {
        this.aUserBean = aUserBean;
    }

    public void setFiltre( Filtre filtre ) {
        this.filtre = filtre;
    }

    public FiltreBean() {
        this.filtre = new Filtre();
    }

    public String creerFiltre() {

        /* appel service: */

        Utilisateur utilisateur;

        utilisateur = getaUserBean().getUtilisateur();
        System.out.println( utilisateur.getAlias() );

        /* Recupérer l'id de l'utilisateur : */

        List<Utilisateur> aListUser = iServiceGestionClient.findUserByAlias( "alias", utilisateur.getAlias() );

        for ( Utilisateur utilisateur2 : aListUser ) {
            utilisateur = utilisateur2;
            System.out.println( utilisateur.getIdUser() );
        }

        filtre.setUtilisateur( utilisateur );
        iServiceGestionFiltre.creerFiltre( filtre );
        filtre = new Filtre();
        return "succesFiltre";
    }
}
