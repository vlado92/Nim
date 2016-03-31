package Nim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Basket{
    static BufferedImage basketImage = null;
    private final int x;
    private final int y;
    private final int WIDHT;
    private final int HIGHT;
    private int count;
    private int maxCount;

    public Basket(int x, int y, int WIDHT, int HIGHT) {
        this.x = x;
        this.y = y;
        this.WIDHT = WIDHT;
        this.HIGHT = HIGHT;
        setCount(0);
    }

    public void setCount(int number){
        count = number;
    }
    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public int getCount() {
        return count;
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
            basketImage = ImageIO.read(new File(".\\picturesForNim\\basket.jpg"));
            System.out.println("uzelo sliku sa kompa");
        } catch (IOException ex) {
            try {
                System.out.println("uzelo sliku sa neta");
                URL url = new URL("https://scontent-vie1-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/12932827_1276225262395401_3591476988033199140_n.jpg?oh=5166ddc40c69f2ae9d6021331d8271a1&oe=577ED9E4");
                basketImage = ImageIO.read(url);
            } catch (IOException e) { 
                return false;
            }
        }
        return true;
    }
    public static BufferedImage getImage() {
        return basketImage;
    }
}
