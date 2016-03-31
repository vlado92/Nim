package Nim;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Shelf {
    static BufferedImage shelfImage = null;
    private int x;
    private int y;
    private int WIDHT;
    private int HIGHT;

    public Shelf(int x, int y, int WIDHT, int HIGHT) {
        this.x = x;
        this.y = y;
        this.WIDHT = WIDHT;
        this.HIGHT = HIGHT;
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
    
    public static boolean loadImages() {
        try {
            shelfImage = ImageIO.read(new File(".\\picturesForNim\\stock.jpg"));
        } catch (IOException ex) {
            try {
                URL url = new URL("https://scontent-vie1-1.xx.fbcdn.net/hphotos-xla1/v/t1.0-9/12932580_1276225395728721_7602401572812515509_n.jpg?oh=cee77ccc4d8ee8360110e0650454442f&oe=57758F88");
                shelfImage = ImageIO.read(url);
            } catch (IOException e) { 
                return false;
            }
        }
        return true;
    }

    public static BufferedImage getImage() {
        return shelfImage;
    }
}