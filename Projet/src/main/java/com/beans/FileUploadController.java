package com.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

public class FileUploadController {
    private String cheminPhoto;
    private String destination = "G:\\Tout les tp J2EE/workspace jEE/Projet/webapp/images/annonce/";

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

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public void setCheminPhoto( String cheminPhoto ) {
        this.cheminPhoto = cheminPhoto;
    }

}