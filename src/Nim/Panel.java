package Nim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private static int PANEL_HEIGHT = MainFrame.GetHeight();
    private static int PANEL_WIDTH = MainFrame.GetWidth();
    
    static Image backgroundImage;
    private Tree tree = null;
    private Apple apple = null;
    
    public Panel(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.yellow);
        setLayout(null);
    
        loadImages();
        setFocusable(true);
        tree = new Tree(0, 0, 200, 200);
        apple = new Apple(0, 0, 50, 50);
    }

    private void loadImages() {
        Apple.loadImages();
        Tree.loadImages();
        try {
            backgroundImage = ImageIO.read(new File("C:\\picturesForNim\\background.jpg"));
        } catch (IOException ex) {
            try {
                URL url = new URL("http://cdn.onextrapixel.com/wp-content/uploads/2011/01/27_summer-field.jpg");

                backgroundImage = ImageIO.read(url);
            } catch (IOException e) { }
        }
    }
    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
         drawBackground(g2d);
        g2d.draw(tree.getRectangle());
         drawTree(g2d);
         drawApple(g2d);
    }
    private void drawTree(Graphics2D g2d) {
        g2d.drawImage(Tree.getImage(), tree.getX(), tree.getY(), tree.getWIDHT(), tree.getHIGHT(), null);
    }
    private void drawApple(Graphics2D g2d) {
        g2d.drawImage(Apple.getImage(), apple.getX(), apple.getY(), apple.getWIDHT(), apple.getHIGHT(), null);
    }
     private void drawBackground(Graphics2D g2d) {
        g2d.drawImage(backgroundImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
    }
}
