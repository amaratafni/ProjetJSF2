package sera.rien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Adresse;
import com.model.Annonce;
import com.services.IServiceGestionAnnonce;

@Controller( "rechercsheBean" )
@Scope( "session" )
public class RechercsheBean {

    Annonce                annonce;
    Adresse                adresse;

    @Autowired
    IServiceGestionAnnonce aIServiceGestionAnnonce;

    public RechercsheBean() {
        super();
        this.annonce = new Annonce();
        this.adresse = new Adresse();
    }

    /* Methode recherche : */
    public String recherche() {

        return "rechercheResultat";

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

}
