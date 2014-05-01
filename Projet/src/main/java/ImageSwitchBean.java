import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ImageSwitchBean implements Serializable {

    private List<String> images;

    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add( "a8.jpg" );
        images.add( "a14.jpg" );
        images.add( "a10.jpg" );
        images.add( "a4.jpg" );

        images.add( "a1.jpg" );
        images.add( "a2.jpg" );
        images.add( "a3.jpg" );
        images.add( "a5.jpg" );
        images.add( "a7.jpg" );
        images.add( "a13.jpg" );
    }

    public List<String> getImages() {
        return images;
    }
}
