package Nim;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Apple {
    private Rectangle2D.Double rectangle;
    static BufferedImage appleImage = null;
    private int x;
    private int y;
    private int WIDHT;
    private int HIGHT;
    private boolean appleExist;

    public Apple(int x, int y, int WIDHT, int HIGHT) {
        this.x = x;
        this.y = y;
        this.WIDHT = WIDHT;
        this.HIGHT = HIGHT;
        rectangle = new Rectangle2D.Double(x, y, WIDHT, HIGHT);
    }
    
    public void setAppleExistance(boolean state){
        appleExist = state;
    }
    
    public boolean appleExist()
    {
        return appleExist;
    }
    
    public Rectangle2D.Double getRectangle() {
        rectangle.x = x;
        return rectangle;
    }

    public int getWIDHT() {
        return WIDHT;
    }

    public int getHIGHT() {
        return HIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public static void loadImages() { 
    try {
            appleImage = ImageIO.read(new File("C:\\picturesForNim\\apple.gif"));
        } catch (IOException ex) {
            try {
                URL url = new URL("http://www.clipartbest.com/cliparts/yTk/eyR/yTkeyRaqc.gif");

                appleImage = ImageIO.read(url);
            } catch (IOException e) {
                Main.connect();
            }
        }
    }

    public static BufferedImage getImage() {
        return appleImage;
    }
}
