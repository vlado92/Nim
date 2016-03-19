package Nim;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener{
    private static int PANEL_HEIGHT = MainFrame.GetHeight()-50;
    private static int PANEL_WIDTH = MainFrame.GetWidth()-50;
    
    static Image backgroundImage;
    private Tree[] tree = null;
    private Apple[][] apple = null;
    private Basket[] basket = null;
    private JButton[] dugme = null;
    private JButton finished = null;
    private int numberOfTree = 4;
    private int numberOfApplesOnTreeArray[] = null;
    private int numberOfApplesOnTree = 0;
    
    
    public Panel(){
        InitializeElements();        
    }
    void InitializeElements(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        finished = new JButton("Finish move");
        finished.setVisible(true);
        finished.setBounds(PANEL_WIDTH/2 - 60, PANEL_HEIGHT-20, 120, 40);
        
        setLayout(null);
        loadImages();
        setFocusable(true);
        java.util.Random rand = new java.util.Random();
        basket = new Basket[numberOfTree];
        dugme = new JButton[numberOfTree];
        tree = new Tree[numberOfTree];
        numberOfApplesOnTreeArray = new int[numberOfTree];
        for(int i = 0; i < numberOfTree; i++){
            numberOfApplesOnTreeArray[i] = rand.nextInt(40) + 10;
            if(numberOfApplesOnTree < numberOfApplesOnTreeArray[i])
                numberOfApplesOnTree = numberOfApplesOnTreeArray[i];
        }
        apple = new Apple[numberOfTree][numberOfApplesOnTree];
        
        for(int i = 0; i < numberOfTree; i++){
            tree[i] = new Tree(i*(PANEL_WIDTH/numberOfTree), 0, PANEL_WIDTH/numberOfTree, PANEL_HEIGHT);
            basket[i] = new Basket(i*(PANEL_WIDTH/numberOfTree), PANEL_HEIGHT-100, PANEL_WIDTH/numberOfTree, 80);
            dugme[i] = new JButton();
            dugme[i].setBounds(basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT());
            dugme[i].setVisible(true);
            dugme[i].setIcon(new ImageIcon(Basket.getImage().getScaledInstance(basket[i].getWIDHT(), basket[i].getHIGHT(), Image.SCALE_DEFAULT)));
            dugme[i].setText("" + basket[i].getCount());
            dugme[i].addActionListener(this);
            
            add(dugme[i]);
            
            for(int j = 0; j < numberOfApplesOnTree; j++){
                if(j > numberOfApplesOnTreeArray[i]){
                    apple[i][j] = new Apple(0, 0, 0, 0);
                    apple[i][j].setAppleExistance(false);
                }
                else{
                    apple[i][j] = new Apple(tree[i].getX()+j*25-(j/(9-numberOfTree))*(9-numberOfTree)*25+10, 
                                tree[i].getY() + 25*(j/(9-numberOfTree)) + 75, 20, 20);
                    apple[i][j].setAppleExistance(true);
                }
            }
        }
        add(finished);

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
    
     @Override public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        drawBackground(g2d);
        for(int j = 0; j<numberOfTree; j++){
            drawTree(g2d, j);
            drawBasket(g2d, j);
            for(int i=0; i<numberOfApplesOnTree; i++)
            {
                if(apple[j][i].appleExist())
                    drawApple(g2d, j, i);
            }
        }
    }
    private void drawTree(Graphics2D g2d, int i) {
        g2d.drawImage(Tree.getImage(), tree[i].getX(), tree[i].getY(), tree[i].getWIDHT(), tree[i].getHIGHT(), null);
    }
    private void drawBasket(Graphics2D g2d, int i) {
        g2d.drawImage(Basket.getImage(), basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT(), null);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));

        g2d.drawString("" + basket[i].getCount(), basket[i].getX() + basket[i].getWIDHT()/2, basket[i].getY() + basket[i].getHIGHT()/2 + 30);
    }
    private void drawApple(Graphics2D g2d, int i, int j) {
        
            g2d.drawImage(Apple.getImage(), apple[i][j].getX(), apple[i][j].getY(), apple[i][j].getWIDHT(), apple[i][j].getHIGHT(), null);
    }
     private void drawBackground(Graphics2D g2d) {
        g2d.drawImage(backgroundImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("desilo se nesto");
        basket[0].setCount(basket[0].getCount()+1);
        dugme[0].setText("" + basket[0].getCount());
        dugme[0].setVisible(false);
        repaint();
    }
}
