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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel extends JPanel implements ActionListener{
    // <editor-fold defaultstate="collapsed" desc="Variables">
    private static int PANEL_HEIGHT = MainFrame.GetHeight()-50;
    private static int PANEL_WIDTH = MainFrame.GetWidth();
    
    private int player = 1;
    private int numberOfPlayers = 2;
    
    static Image backgroundImage;
    private Tree[] tree = null;
    private Apple[][] apple = null;
    private Basket[] basket = null;
    private JButton[] basketButton = null;
    private JButton finished = null;
    private int numberOfTree = 4;
    private int numberOfApplesOnTreeArray[] = null;
    private int numberOfApplesOnTree = 0;
// </editor-fold>
    
    public Panel(){
        InitializeElements();        
    }
    void InitializeElements(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        loadImages();
        setFocusable(true);
        java.util.Random rand = new java.util.Random();
        
        numberOfApplesOnTreeArray = new int[numberOfTree];
        for(int i = 0; i < numberOfTree; i++){
            numberOfApplesOnTreeArray[i] = rand.nextInt(10) + 10;
            if(numberOfApplesOnTree < numberOfApplesOnTreeArray[i])
                numberOfApplesOnTree = numberOfApplesOnTreeArray[i];
        }
        
        addElements();
        addBasketButton();
        addFinishButton();
        repaint();
    }   
    void addElements(){
        basket = new Basket[numberOfTree];
        tree = new Tree[numberOfTree];
        apple = new Apple[numberOfTree][numberOfApplesOnTree];
        
        for(int i = 0; i < numberOfTree; i++)
            tree[i] = new Tree(i*(PANEL_WIDTH/numberOfTree), 0, PANEL_WIDTH/numberOfTree, PANEL_HEIGHT);
        for(int i = 0; i < numberOfTree; i++){
            basket[i] = new Basket(i*(PANEL_WIDTH/numberOfTree), PANEL_HEIGHT-100, PANEL_WIDTH/numberOfTree, 80);
            basket[i].setMaxCount(numberOfApplesOnTreeArray[i]);
        }
        for(int i = 0; i < numberOfTree; i++){
            for(int j = 0; j < numberOfApplesOnTree; j++){
                if(j >=  basket[i].getMaxCount()){
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
    }
    void addBasketButton(){
        basketButton = new JButton[numberOfTree];
        for(int i = 0; i < numberOfTree; i++){
            basketButton[i] = new JButton();
            basketButton[i].setBounds(basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT());
            basketButton[i].setVisible(true);
            basketButton[i].setIcon(new ImageIcon(Basket.getImage().getScaledInstance(basket[i].getWIDHT(), basket[i].getHIGHT(), Image.SCALE_DEFAULT)));
            basketButton[i].setText("" + basket[i].getCount());
            basketButton[i].setName("" + i);
            basketButton[i].addActionListener(this);
            basketButton[i].setFont(new Font("Arial", Font.BOLD, 20));
            basketButton[i].setVerticalTextPosition(SwingConstants.CENTER);
            basketButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            add(basketButton[i]);
        }
    }
    void addFinishButton(){
        finished = new JButton("Finish move");
        finished.setVisible(true);
        finished.setBounds(PANEL_WIDTH/2 - 60, PANEL_HEIGHT-20, 120, 40);
        finished.setName("" + (numberOfTree));
        finished.addActionListener(this);
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
        
        for(int j = 0; j<numberOfTree; j++){
            drawTree(g2d, j);
            basketButton[j].repaint();
            finished.repaint();
            drawBasket(g2d, j);
            for(int i=0; i<numberOfApplesOnTree; i++)
            {
                if(apple[j][i].appleExist())
                    drawApple(g2d, j, i);
            }
            
        drawBasketText(g2d, j);
        }
        
        drawPlayer(g2d, player);
    }
    private void drawTree(Graphics2D g2d, int i) {
        g2d.drawImage(Tree.getImage(), tree[i].getX(), tree[i].getY(), tree[i].getWIDHT(), tree[i].getHIGHT(), null);
    }
    private void drawBasket(Graphics2D g2d, int i) {
        g2d.drawImage(Basket.getImage(), basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT(), null);
    }
    private void drawBasketText(Graphics2D g2d, int i){
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("" + basket[i].getCount(), basket[i].getX() + basket[i].getWIDHT()/2, basket[i].getY() + basket[i].getHIGHT()/2);
    }
    private void drawApple(Graphics2D g2d, int i, int j) {
        
            g2d.drawImage(Apple.getImage(), apple[i][j].getX(), apple[i][j].getY(), apple[i][j].getWIDHT(), apple[i][j].getHIGHT(), null);
    }
    private void drawPlayer(Graphics2D g2d, int player) {
        String text = "Player " + player;
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(text, PANEL_WIDTH/2-25, 50);
    }
    
    @Override public void actionPerformed(ActionEvent ae) {
        int indexOfClickedButton;
        int substringIndex = ae.toString().indexOf(" on ");
        indexOfClickedButton = Integer.parseInt(ae.toString().substring(substringIndex + 4));
        if(indexOfClickedButton != numberOfTree)
        {
            basket[indexOfClickedButton].setCount(basket[indexOfClickedButton].getCount()+1);
            basketButton[indexOfClickedButton].setText("" + basket[indexOfClickedButton].getCount());
            for(int j = 0; j < numberOfTree; j++)
                if(j!=indexOfClickedButton)
                    basketButton[j].setVisible(false);
            if(basket[indexOfClickedButton].getCount() == basket[indexOfClickedButton].getMaxCount())
                basketButton[indexOfClickedButton].setVisible(false);
        }
        else
        {
            player++;
            if(player > numberOfPlayers)
                player-=numberOfPlayers;
            for(int i = 0; i < numberOfTree; i++)
            {
                System.out.println("dodje ovde" + i);
                if(basket[i].getCount() > 0){
                    System.out.println("doslo i ovde" + i);
                    int j = basket[i].getMaxCount()-1;
                    int removeApples = basket[i].getCount();
                    System.out.println("prije konverzije" + basket[i].getMaxCount());
                    basket[i].setMaxCount(basket[i].getMaxCount() - removeApples);
                    System.out.println("posle konverzije" + basket[i].getMaxCount());
                    while (removeApples > 0) { 
                        apple[i][j--].setAppleExistance(false);
                        removeApples--;
                    }
                }
            }
            for(int j = 0; j < numberOfTree; j++){
                basket[j].setCount(0);
                if(basket[j].getMaxCount() != 0){
                    basketButton[j].setVisible(true);
                    basketButton[j].setText("" + basket[j].getCount());
                }
                else
                {
                    basketButton[j].setEnabled(false);
                }
            }
        }
        repaint();
    }

}
