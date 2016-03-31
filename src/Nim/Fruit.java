package Nim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Fruit {
    public static enum fruit { APPLE, BANANA, WATERMELON}
    
    static BufferedImage fruitImage = null;
    private final int x;
    private final int y;
    private final int WIDHT;
    private final int HIGHT;
    private boolean fruitExist;
    public static fruit selectedFruit = fruit.WATERMELON;
    
    public Fruit(int x, int y, int WIDHT, int HIGHT) {
        this.x = x;
        this.y = y;
        this.WIDHT = WIDHT;
        this.HIGHT = HIGHT;
    }
    
    public void setFruitExistance(boolean state){
        fruitExist = state;
    }
    
    public boolean isFruitExist()
    {
        return fruitExist;
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
            if(selectedFruit.equals(fruit.APPLE))
                return loadAppleImage();
            else if(selectedFruit.equals(fruit.BANANA))
                return loadBananaImage();
            else if(selectedFruit.equals(fruit.WATERMELON))
                return loadWatermelonImage();
            else
                return false;
    }
    public static boolean loadAppleImage(){
        try{
            fruitImage = ImageIO.read(new File(".\\picturesForNim\\apple.jpg"));
        }catch (IOException ex) {
            try {
                URL url = new URL("https://scontent-vie1-1.xx.fbcdn.net/hphotos-xat1/v/t1.0-9/944330_1276225272395400_7026037628424613934_n.jpg?oh=f42de4312a5c44e66214d42ff7a9c02c&oe=57788667");
                fruitImage = ImageIO.read(url);
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
    public static boolean loadBananaImage(){
        try{
            fruitImage = ImageIO.read(new File(".\\picturesForNim\\banana.jpg"));
        }catch (IOException ex) {
            try {
                URL url = new URL("https://scontent-vie1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/12931235_1276225255728735_49009602651512894_n.jpg?oh=dd9fbb3775deeb05f50a5f6abd2c8be4&oe=578DBD24");
           fruitImage = ImageIO.read(url);
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
    public static boolean loadWatermelonImage(){
        try{
            fruitImage = ImageIO.read(new File(".\\picturesForNim\\watermelon.jpg"));
        }catch (IOException ex) {
            try {
                URL url = new URL("https://scontent-vie1-1.xx.fbcdn.net/hphotos-xal1/v/t1.0-9/12670723_1276225399062054_3066211332664729608_n.jpg?oh=00b97a93919a27f4d35fe15ce184fc17&oe=577C7F04");
           fruitImage = ImageIO.read(url);
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static BufferedImage getImage() {
        return fruitImage;
    }
}
