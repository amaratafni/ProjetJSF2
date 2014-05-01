package sera.rien;
//package bean;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//
//import org.primefaces.event.FileUploadEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//import com.model.Photo;
//
//@Controller( "voitureBean" )
//@Scope( "session" )
//public class VoitureBean implements Serializable {
//
//    @Autowired
//    ServiceGestionVoiture voitureService;
//    List<Voiture>         voituresList;
//
//    String                couleur;
//    String                type;
//    String                marque;
//
//    long                  idVoiture;
//    Voiture               voiture;
//    String                avecCh;
//    private String        chemin      = null;
//    private String        destination = "C:/Users/Ghani/Desktop/J2EE/Rental_Am/webapp/model/";
//    Photo                 photo;
//
//    public VoitureBean() {
//
//        voiture = new Voiture();
//        voituresList = new ArrayList<Voiture>();
//
//    }
//
//    public String modifVoiture()
//    {
//        voiture = voitureService.getVoitureById( idVoiture );
//        return "gestionVoitures";
//    }
//
//    public String modifierVoiture()
//    {
//
//        System.out.println( "bean.." );
//
//        voitureService.modifierVoiture( voiture );
//        return "gestionVoitures";
//    }
//
//    public String ajouterVoiture()
//    {
//
//        if ( chemin != null )
//        {
//            photo = new Photo();
//            photo.setChemin( "../model/" + chemin );
//            voiture.setP( photo );
//
//        }
//
//        if ( avecCh.equals( "non" ) )
//        {
//            voitureService.ajouterVoiture( voiture, false );
//
//        } else
//        {
//            voitureService.ajouterVoiture( voiture, true );
//        }
//
//        return "gestionVoitures";
//    }
//
//    public String suppVoiture()
//    {
//        voitureService.suppVoiture( voiture );
//
//        return "gestionVoitures";
//
//    }
//
//    public String getAvecCh() {
//        return avecCh;
//    }
//
//    public void setAvecCh( String avecCh ) {
//        this.avecCh = avecCh;
//    }
//
//    public Voiture getVoiture() {
//        return voiture;
//    }
//
//    public void setVoiture( Voiture voiture ) {
//        this.voiture = voiture;
//    }
//
//    public void rechercher()
//    {
//        System.out.println( "voiturebean rechercher" );
//        voituresList = voitureService.getAllVoiture();
//        System.out.println( "voiturebean result rechercher" );
//
//    }
//
//    public String getVoitureDetail()
//    {
//        voiture = voitureService.getVoitureById( idVoiture );
//        return "detail_voiture";
//    }
//
//    public List<Voiture> getVoituresList() {
//        voituresList = voitureService.getAllVoiture();
//
//        return voituresList;
//    }
//
//    public long getIdVoiture() {
//        return idVoiture;
//    }
//
//    public void setIdVoiture( long idVoiture ) {
//        this.idVoiture = idVoiture;
//    }
//
//    public void setVoituresList( List<Voiture> voituresList ) {
//        this.voituresList = voituresList;
//    }
//
//    public String getCouleur() {
//        return couleur;
//    }
//
//    public void setCouleur( String couleur ) {
//        this.couleur = couleur;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType( String type ) {
//        this.type = type;
//    }
//
//    public String getMarque() {
//        return marque;
//    }
//
//    public void setMarque( String marque ) {
//        this.marque = marque;
//    }
//
//    public void upload( FileUploadEvent event ) {
//        FacesMessage msg = new FacesMessage( "Success! ", event.getFile().getFileName() + " is uploaded." );
//        FacesContext.getCurrentInstance().addMessage( null, msg );
//        // Do what you want with the file
//        try {
//            copyFile( event.getFile().getFileName(), event.getFile().getInputstream() );
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void copyFile( String fileName, InputStream in ) {
//        try {
//
//            this.chemin = fileName;
//            System.out.println( chemin );
//            // write the inputStream to a FileOutputStream
//            OutputStream out = new FileOutputStream( new File( destination + fileName ) );
//
//            int read = 0;
//            byte[] bytes = new byte[1024];
//
//            while ( ( read = in.read( bytes ) ) != -1 ) {
//                out.write( bytes, 0, read );
//            }
//
//            in.close();
//            out.flush();
//            out.close();
//
//            System.out.println( "New file created!" );
//        } catch ( IOException e ) {
//            System.out.println( e.getMessage() );
//        }
//    }
//
// }