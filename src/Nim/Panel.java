package Nim;

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
    private static int PANEL_HEIGHT = MainFrame.GetHeight()-50;
    private static int PANEL_WIDTH = MainFrame.GetWidth()-50;
    
    static Image backgroundImage;
    private Tree[] tree = null;
    private Apple[][] apple = null;
    private Basket[] basket = null;
    private int numberOfTree = 2;
    private int numberOfApplesOnTree = 45;
    
    
    public Panel(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
    
        loadImages();
        setFocusable(true);
        
        basket = new Basket[numberOfTree];
        tree = new Tree[numberOfTree];
        apple = new Apple[numberOfTree][numberOfApplesOnTree];
        
        for(int i = 0; i < numberOfTree; i++){
            tree[i] = new Tree(i*(PANEL_WIDTH/numberOfTree), 0, PANEL_WIDTH/numberOfTree, PANEL_HEIGHT);
            basket[i] = new Basket(i*(PANEL_WIDTH/numberOfTree), PANEL_HEIGHT-100, PANEL_WIDTH/numberOfTree, 80);
            for(int j = 0; j < numberOfApplesOnTree; j++)
                apple[i][j] = new Apple(tree[i].getX()+j*25-(j/(9-numberOfTree))*(9-numberOfTree)*25+10, 
                                tree[i].getY() + 25*(j/(9-numberOfTree)) + 75, 20, 20);
        }
    }

    private void loadImages() {
        Apple.loadImages();
        Tree.loadImages();
        Basket.loadImages();
        try {
            backgroundImage = ImageIO.read(new File("C:\\picturesForNim\\background.jpg"));
        } catch (IOException ex) {
            try {
                URL url = new URL("http://cdn.onextrapixel.com/wp-content/uploads/2011/01/27_summer-field.jpg");

                backgroundImage = ImageIO.read(url);
            } catch (IOException e) { 
                Main.connect();
            }
        }
    }
    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        drawBackground(g2d);
        for(int j = 0; j<numberOfTree; j++){
            drawTree(g2d, j);
            drawBasket(g2d, j);
            for(int i=0; i<numberOfApplesOnTree; i++)
            {
                drawApple(g2d, j, i);
            }
        }
    }
    private void drawTree(Graphics2D g2d, int i) {
        g2d.drawImage(Tree.getImage(), tree[i].getX(), tree[i].getY(), tree[i].getWIDHT(), tree[i].getHIGHT(), null);
    }
    private void drawBasket(Graphics2D g2d, int i) {
        g2d.drawImage(Basket.getImage(), basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT(), null);
    }
    private void drawApple(Graphics2D g2d, int i, int j) {
            g2d.drawImage(Apple.getImage(), apple[i][j].getX(), apple[i][j].getY(), apple[i][j].getWIDHT(), apple[i][j].getHIGHT(), null);
    }
     private void drawBackground(Graphics2D g2d) {
        g2d.drawImage(backgroundImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
    }
}
