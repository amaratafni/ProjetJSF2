package com.model;

// Generated 25 f�vr. 2014 18:04:58 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Annonce generated by hbm2java
 */
@Entity
@Table( name = "annonce"
        , schema = "public" )
public class Annonce implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int               idAnnonce;
    private Utilisateur       utilisateur;
    private Adresse           adresse;
    private String            typeBien;
    private String            typeAnnonce;
    private String            titre;
    private Integer           surface;
    private Integer           surfaceCarry;
    private String            description;
    private String            classeEnergitique;
    private String            email;
    private Integer           numTel;
    private Integer           prix;
    private Long              photo;
    private Set<Photo>        photos           = new HashSet<Photo>( 0 );
    private byte[]            bytes;
    private String            cheminphoto;

    public Annonce() {
    }

    public Annonce( int idAnnonce ) {
        this.idAnnonce = idAnnonce;
    }

    public Annonce( int idAnnonce, Utilisateur utilisateur, Adresse adresse, String typeBien, String typeAnnonce ) {
        this.idAnnonce = idAnnonce;
        this.utilisateur = utilisateur;
        this.adresse = adresse;
        this.typeBien = typeBien;
        this.typeAnnonce = typeAnnonce;
    }

    public Annonce( int idAnnonce, Utilisateur utilisateur, Adresse adresse, String typeBien, String typeAnnonce,
            String titre, Integer surface, Integer surfaceCarry, String description, String classeEnergitique,
            String email, Integer numTel, Integer prix, Long photo, Set<Photo> photos, String cheminphoto ) {

        this.idAnnonce = idAnnonce;
        this.utilisateur = utilisateur;
        this.adresse = adresse;
        this.typeBien = typeBien;
        this.typeAnnonce = typeAnnonce;
        this.titre = titre;
        this.surface = surface;
        this.surfaceCarry = surfaceCarry;
        this.description = description;
        this.classeEnergitique = classeEnergitique;
        this.email = email;
        this.numTel = numTel;
        this.prix = prix;
        this.photo = photo;
        this.photos = photos;
        this.cheminphoto = cheminphoto;
    }

    public Annonce( String randomModel, int randomYear, String randomManufacturer, String randomColor ) {

    }

    public Annonce( Adresse adresse2 ) {
        this.adresse = adresse2;
    }

    @Id
    @Column( name = "id_annonce", unique = true, nullable = false )
    @GenericGenerator( name = "kaugen", strategy = "increment" )
    @GeneratedValue( generator = "kaugen" )
    public int getIdAnnonce() {
        return this.idAnnonce;
    }

    public void setIdAnnonce( int idAnnonce ) {
        this.idAnnonce = idAnnonce;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_user", nullable = false )
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur( Utilisateur utilisateur ) {
        this.utilisateur = utilisateur;
    }

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "id_adresse", nullable = false )
    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse( Adresse adresse ) {
        this.adresse = adresse;
    }

    @Column( name = "type_bien", nullable = false )
    public String getTypeBien() {
        return this.typeBien;
    }

    public void setTypeBien( String typeBien ) {
        this.typeBien = typeBien;
    }

    @Column( name = "type_annonce", nullable = false )
    public String getTypeAnnonce() {
        return this.typeAnnonce;
    }

    public void setTypeAnnonce( String typeAnnonce ) {
        this.typeAnnonce = typeAnnonce;
    }

    @Column( name = "titre" )
    public String getTitre() {
        return this.titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    @Column( name = "surface" )
    public Integer getSurface() {
        return this.surface;
    }

    public void setSurface( Integer surface ) {
        this.surface = surface;
    }

    @Column( name = "surface_carry" )
    public Integer getSurfaceCarry() {
        return this.surfaceCarry;
    }

    public void setSurfaceCarry( Integer surfaceCarry ) {
        this.surfaceCarry = surfaceCarry;
    }

    @Column( name = "description" )
    public String getDescription() {
        return this.description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Column( name = "classe_energitique" )
    public String getClasseEnergitique() {
        return this.classeEnergitique;
    }

    public void setClasseEnergitique( String classeEnergitique ) {
        this.classeEnergitique = classeEnergitique;
    }

    @Column( name = "email" )
    public String getEmail() {
        return this.email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Column( name = "num_tel" )
    public Integer getNumTel() {
        return this.numTel;
    }

    public void setNumTel( Integer numTel ) {
        this.numTel = numTel;
    }

    @Column( name = "prix" )
    public Integer getPrix() {
        return this.prix;
    }

    public void setPrix( Integer prix ) {
        this.prix = prix;
    }

    /*
     * @Column( name = "photo" ) public Long getPhoto() { return this.photo; }
     * 
     * public void setPhoto( Long photo ) { this.photo = photo; }
     */

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "annonce" )
    public Set<Photo> getPhotos() {
        return this.photos;
    }

    public void setPhotos( Set<Photo> photos ) {
        this.photos = photos;
    }

    @Lob
    @Column( name = "photo" )
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes( byte[] bytes ) {
        this.bytes = bytes;
    }

    @Column( name = "cheminphoto" )
    public String getCheminphoto() {
        return cheminphoto;
    }

    public void setCheminphoto( String cheminphoto ) {
        this.cheminphoto = cheminphoto;
    }

}
