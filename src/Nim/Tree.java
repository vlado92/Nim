package Nim;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Tree {
    private Rectangle2D.Double rectangle;
    static BufferedImage treeImage = null;
    private int x;
    private int y;
    private int WIDHT;
    private int HIGHT;

    public Tree(int x, int y, int WIDHT, int HIGHT) {
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
            treeImage = ImageIO.read(new File("C:\\picturesForNim\\tree.jpg"));
        } catch (IOException ex) {
            try {
                URL url = new URL("http://images.all-free-download.com/images/graphiclarge/tree_vector_147863.jpg");

                treeImage = ImageIO.read(url);
            } catch (IOException e) { }
        }
    }

    public static BufferedImage getImage() {
        return treeImage;
    }
}
