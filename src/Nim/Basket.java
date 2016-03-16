package Nim;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Basket {
private Rectangle2D.Double rectangle;
    static BufferedImage basketImage = null;
    private int x;
    private int y;
    private int WIDHT;
    private int HIGHT;

    public Basket(int x, int y, int WIDHT, int HIGHT) {
        this.x = x;
        this.y = y;
        this.WIDHT = WIDHT;
        this.HIGHT = HIGHT;

        rectangle = new Rectangle2D.Double(x, y, WIDHT, HIGHT);
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
            basketImage = ImageIO.read(new File("C:\\picturesForNim\\basket.jpg"));
            System.out.println("uzelo sliku sa kompa");
        } catch (IOException ex) {
            try {
                System.out.println("uzelo sliku sa neta");
                URL url = new URL("http://www.wtv-zone.com/LaDeBoheme/studio/basket/basket.jpg");
                basketImage = ImageIO.read(url);
            } catch (IOException e) { 
                Main.connect();
            }
        }
    }

    public static BufferedImage getImage() {
        return basketImage;
    }    
}