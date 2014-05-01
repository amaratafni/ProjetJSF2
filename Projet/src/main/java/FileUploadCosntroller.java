import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@RequestScoped
public class FileUploadCosntroller {
    public void handleFileUpload( FileUploadEvent uploadEvent ) {
        System.out.println( "In Handle File Upload." );
    }
}