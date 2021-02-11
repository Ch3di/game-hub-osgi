package sokobanCoree;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);
        
        initArea();
    }
    
    private void initArea() {
    	try {
			URL url = new URL("https://raw.githubusercontent.com/janbodnar/Java-Sokoban-Game/master/src/resources/area.png");
	        ImageIcon iicon = new ImageIcon(url);
	        Image image = iicon.getImage();
	        setImage(image);
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
    
}
