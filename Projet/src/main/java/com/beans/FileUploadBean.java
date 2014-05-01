package com.beans;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.primefaces.event.FileUploadEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.File;

@Controller( "fileUploadBean" )
@Scope( "session" )
public class FileUploadBean {

    private ArrayList<File>   files            = new ArrayList<File>();
    private int               uploadsAvailable = 5;
    private boolean           autoUpload       = false;
    private boolean           useFlash         = false;
    private byte[]            datas;
    private ArrayList<byte[]> allPhoto         = new ArrayList<byte[]>();

    public ArrayList<byte[]> getAllPhoto() {
        return allPhoto;
    }

    public void setAllPhoto( ArrayList<byte[]> allPhoto ) {
        this.allPhoto = allPhoto;
    }

    public FileUploadBean() {
    }

    public void listener( FileUploadEvent uploadEvent ) throws Exception {

        byte[] bFile = new byte[(int) uploadEvent.getFile().getSize()];

        allPhoto.add( bFile );
        datas = bFile;
        // annonce.setBytes( datas );
        // creerAnnonce();
    }

    public byte[] getDatas() {
        return datas;
    }

    public void setDatas( byte[] datas ) {
        this.datas = datas;
    }

    public void paint( OutputStream stream, Object object ) throws IOException {
        stream.write( getFiles().get( (Integer) object ).getData() );
    }

    public String clearUploadData() {
        files.clear();
        setUploadsAvailable( 5 );
        return null;
    }

    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles( ArrayList<File> files ) {
        this.files = files;
    }

    public int getUploadsAvailable() {
        return uploadsAvailable;
    }

    public void setUploadsAvailable( int uploadsAvailable ) {
        this.uploadsAvailable = uploadsAvailable;
    }

    public boolean isAutoUpload() {
        return autoUpload;
    }

    public void setAutoUpload( boolean autoUpload ) {
        this.autoUpload = autoUpload;
    }

    public boolean isUseFlash() {
        return useFlash;
    }

    public void setUseFlash( boolean useFlash ) {
        this.useFlash = useFlash;
    }

}