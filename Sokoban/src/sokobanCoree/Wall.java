package sokobanCoree;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Wall extends Actor {

    private Image image;

    public Wall(int x, int y) {
        super(x, y);
        
        initWall();
    }
    
    private void initWall() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/janbodnar/Java-Sokoban-Game/master/src/resources/wall.png");
	        ImageIcon iicon = new ImageIcon(url);
	        image = iicon.getImage();
	        setImage(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
}
