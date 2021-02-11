package sokobanCoree;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Baggage extends Actor {

    public Baggage(int x, int y) {
        super(x, y);
        
        initBaggage();
    }
    
    private void initBaggage() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/janbodnar/Java-Sokoban-Game/master/src/resources/baggage.png");
	        ImageIcon iicon = new ImageIcon(url);
	        Image image = iicon.getImage();
	        setImage(image);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void move(int x, int y) {
        
        int dx = x() + x;
        int dy = y() + y;
        
        setX(dx);
        setY(dy);
    }
}
