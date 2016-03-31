package Nim;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel extends JPanel implements ActionListener {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    private static final int PANEL_HEIGHT = MainFrame.GetHeight() - 70;
    private static final int PANEL_WIDTH = MainFrame.GetWidth();

    public enum GameType {
        MISERE, NORMAL
    }
    private GameType typeOfGame;
    private boolean numberOfPlayer;
    private boolean isComputerPlaying;
    private boolean playFirst;
    private boolean clicked = false;

    static Image backgroundImage;
    private Shelf[] shelf = null;
    private Fruit[][] fruits = null;
    private Basket[] basket = null;
    private JButton[] basketButton = null;
    private JButton finished = null;
    private String playerTurnText = "";
    
    private int numberOfStock = 4;
    private int[] numberOfFruitsOnShelfArray;
    private int numberOfFruitsOnShelf = 0;
    
    private final boolean picturesLoaded = loadImages();
    // </editor-fold>

    public Panel(GameType game, boolean player, int trees, int[] apples, boolean order) {
        this.numberOfFruitsOnShelfArray = null;
        initComponents(game, player, trees, apples, order);
        if(!playFirst)
            computerMove();
    }

    private void initComponents(GameType game, boolean player, int trees, int[] apples, boolean order) {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        setFocusable(true);
        java.util.Random rand = new java.util.Random();
        typeOfGame = game;
        this.numberOfPlayer = true;
        this.isComputerPlaying = player;
        numberOfStock = trees;
        playFirst = order;

        numberOfFruitsOnShelfArray = new int[numberOfStock];
        for (int i = 0; i < numberOfStock; i++) {
            if (apples[i] == 0) {
                numberOfFruitsOnShelfArray[i] = rand.nextInt(30) + 5;
            } else {
                numberOfFruitsOnShelfArray[i] = apples[i];
            }
            if (numberOfFruitsOnShelf < numberOfFruitsOnShelfArray[i]) {
                numberOfFruitsOnShelf = numberOfFruitsOnShelfArray[i];
            }
        }
        
        addStock();
        addBasket();
        addFruit();
        addBasketButton();
        addFinishButton();
        repaint();
        
        if(!picturesLoaded)
            Main.connect();
    }

    private void addStock() {
        shelf = new Shelf[numberOfStock];
        for (int i = 0; i < numberOfStock; i++) {
            shelf[i] = new Shelf(i * (PANEL_WIDTH / numberOfStock), 0, PANEL_WIDTH / numberOfStock, PANEL_HEIGHT-90);
        }
    }
    private void addFruit() {
        fruits = new Fruit[numberOfStock][numberOfFruitsOnShelf];

        for (int i = 0; i < numberOfStock; i++) {
            for (int j = 0; j < numberOfFruitsOnShelf; j++) {
                if (j >= basket[i].getMaxCount()) {
                    fruits[i][j] = new Fruit(0, 0, 0, 0);
                    fruits[i][j].setFruitExistance(false);
                } else {
                    fruits[i][j] = new Fruit(shelf[i].getX() + j * 25 - (j / getNum(numberOfStock)) * getNum(numberOfStock) * 25 + 15,
                            shelf[i].getY() + 36 * (j / getNum(numberOfStock)) + 77, 20, 20);
                    fruits[i][j].setFruitExistance(true);
                }
            }
        }
    }
    private int getNum(int stock){
        if(stock == 1)
        return 23;
        else if(stock == 2)
            return 11;
        else if(stock == 3)
            return 7;
        else if(stock ==4)
            return 5;
        else
            return 1;
    }
    private void addBasket() {
        basket = new Basket[numberOfStock];
        for (int i = 0; i < numberOfStock; i++) {
            basket[i] = new Basket(i * (PANEL_WIDTH / numberOfStock), PANEL_HEIGHT - 95,
                    PANEL_WIDTH / numberOfStock, 80);
            basket[i].setMaxCount(numberOfFruitsOnShelfArray[i]);
        }
    }
    private void addBasketButton() {
        basketButton = new JButton[numberOfStock];
        for (int i = 0; i < numberOfStock; i++) {
            basketButton[i] = new JButton();
            basketButton[i].setBounds(basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT());
            basketButton[i].setVisible(true);
            if(picturesLoaded)
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
    private void addFinishButton() {
        finished = new JButton(LanguagePack.setText(LanguagePack.getLanguage(), "Finish move"));
        finished.setVisible(true);
        finished.setBounds(0, PANEL_HEIGHT - 20, PANEL_WIDTH, 40);
        finished.setName("" + (numberOfStock));
        finished.setAlignmentX(CENTER_ALIGNMENT);
        finished.addActionListener(this);
        finished.setEnabled(false);
        add(finished);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Paint">
    private boolean loadImages() {
        return (Fruit.loadImages() && Shelf.loadImages() && Basket.loadImages());
    }
    
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int j = 0; j < numberOfStock; j++) {
            drawShelf(g2d, j);
            if(picturesLoaded)
                basketButton[j].repaint();
            finished.repaint();
            drawBasket(g2d, j);
            for (int i = 0; i < numberOfFruitsOnShelf; i++) {
                if (fruits[j][i].isFruitExist()) {
                    drawFruit(g2d, j, i);
                }
            }
            drawBasketText(g2d, j);
        }
        if(isComputerPlaying && (playFirst == numberOfPlayer) && !clicked)
            drawText(g2d);
        drawPlayer(g2d, numberOfPlayer);
    }
    private void drawShelf(Graphics2D g2d, int i) {
        if(picturesLoaded)
            g2d.drawImage(Shelf.getImage(), shelf[i].getX(), shelf[i].getY(), shelf[i].getWIDHT(), shelf[i].getHIGHT(), null);
    }
    private void drawBasket(Graphics2D g2d, int i) {
        if(picturesLoaded)
            g2d.drawImage(Basket.getImage(), basket[i].getX(), basket[i].getY(), basket[i].getWIDHT(), basket[i].getHIGHT(), null);
    }
    private void drawBasketText(Graphics2D g2d, int i) {
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("" + basket[i].getCount(), basket[i].getX() + basket[i].getWIDHT() / 2, basket[i].getY() + basket[i].getHIGHT() / 2);
    }
    private void drawFruit(Graphics2D g2d, int i, int j) {
        if(picturesLoaded)
            g2d.drawImage(Fruit.getImage(), fruits[i][j].getX(), fruits[i][j].getY(), fruits[i][j].getWIDHT(), fruits[i][j].getHIGHT(), null);
        else
            g2d.drawRect(fruits[i][j].getX(), fruits[i][j].getY(), fruits[i][j].getWIDHT(), fruits[i][j].getHIGHT());
    }
    private void drawPlayer(Graphics2D g2d, boolean player) {
        String text = LanguagePack.setText(LanguagePack.getLanguage(), "Player ") + ((player) ? ("1") : ("2"));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(text, PANEL_WIDTH / 2 - 50, 25);
    }
    private void drawText(Graphics2D g2d){
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        g2d.drawString(playerTurnText, PANEL_WIDTH/2 - 120, 50);
    }
    //</editor-fold>
    
    @Override public void actionPerformed(ActionEvent ae) {
        if (!isComputerPlaying) {
            doAction(ae);
        } else {
            if (playFirst == numberOfPlayer)
                doAction(ae);
            else
                computerMove();
        }
        repaint();
    }
    private void computerMove(){
        boolean moved = isComputerMove();
        if(!moved){
            JOptionPane.showMessageDialog(null, "UNABLE TO MOVE");
            OptionFrame frame = new OptionFrame();
            Main.fram.dispose();
        }
    }
    private void setPlayerTurnText(int numberOfApples, boolean player, int tree){
        playerTurnText = LanguagePack.setText(LanguagePack.getLanguage(), "Player ")
                + ((player) ? ("1") : ("2"))
                + " " + LanguagePack.setText(LanguagePack.getLanguage(), "take")
                + " " + numberOfApples + " " + LanguagePack.setText(LanguagePack.getLanguage(), "fruits")
                + " "  + LanguagePack.setText(LanguagePack.getLanguage(), "from")
                + " " + LanguagePack.setText(LanguagePack.getLanguage(), "Stock ") + tree;
    } 
    private boolean isComputerMove(){
        int nimSum = 0;
        int treesInPlay = 0;
        for(int i = 0; i < numberOfStock-1; i++){
            nimSum = basket[i].getMaxCount()^ basket[i+1].getMaxCount();
        }
        for(int i = 0; i < numberOfStock; i++)
            if(basket[i].getMaxCount() > 0)
                treesInPlay++;
        if(typeOfGame.equals(GameType.NORMAL))
            return NormalPlay(nimSum, treesInPlay);
        else if(typeOfGame.equals(GameType.MISERE))
            return MiserePlay(nimSum, treesInPlay);
        return false;
    }
    private boolean NormalPlay(int nimSum, int treesInPlay){
        if(nimSum == 0){
            for(int i = 0; i < numberOfStock; i++)
                if(basket[i].getMaxCount() > 0)
                {
                    basket[i].setCount(1);
                    removeApples(i, basket[i].getCount());
                    moveDone();
                    return true;
                }
        }
        else{
            for(int i = 0; i < numberOfStock; i++)
            {
                if((basket[i].getMaxCount() ^ nimSum) < basket[i].getMaxCount()){
                    basket[i].setCount(basket[i].getMaxCount() - (basket[i].getMaxCount() ^ nimSum));
                    removeApples(i, basket[i].getCount());
                    moveDone();
                    return true;
                }
            }
        }
        return false;
    }
    private boolean MiserePlay(int nimSum, int treesInPlay) {
        if(treesInPlay == 1)
                for(int i = 0; i < numberOfStock; i++)
                {
                    if(basket[i].getMaxCount() > 1)
                    {
                        basket[i].setCount(basket[i].getMaxCount() - 1);
                        removeApples(i, basket[i].getCount());
                        moveDone();
                        return true;
                    }
                }   
            else if(treesInPlay == 2)
            {
                int sizeOne = 0;
                int counter = 0;
                int[] index = new int[treesInPlay];
                for(int i = 0; i < numberOfStock; i++)
                {
                    if(basket[i].getMaxCount() > 0)
                        index[counter++] = i;
                    if(basket[i].getMaxCount() == 1)
                        sizeOne++;
                }
                if(sizeOne > 0)
                {
                    if(basket[index[0]].getMaxCount() == 1)
                    {
                        basket[index[1]].setCount(basket[index[1]].getMaxCount());
                        removeApples(index[1], basket[index[1]].getCount());
                        moveDone();
                        return true;
                    }
                    else
                    {
                        basket[index[0]].setCount(basket[index[0]].getMaxCount());
                        removeApples(index[0], basket[index[0]].getCount());
                        moveDone();
                        return true;
                    }
                }
            }
            if(nimSum == 0){
            for(int i = 0; i < numberOfStock; i++)
                if(basket[i].getMaxCount() > 0)
                {
                    basket[i].setCount(1);
                    removeApples(i, basket[i].getCount());
                    moveDone();
                    return true;
                }
        }
        else{
            for(int i = 0; i < numberOfStock; i++)
            {
                if((basket[i].getMaxCount() ^ nimSum) < basket[i].getMaxCount()){
                    basket[i].setCount(basket[i].getMaxCount() - (basket[i].getMaxCount() ^ nimSum));
                    removeApples(i, basket[i].getCount());
                    moveDone();
                    return true;
                }
            }
        }
        return false;
    }
    int tempMaxCount;
    private void doAction(ActionEvent ae) {
        int substringIndex = ae.toString().indexOf(" on ");
        int indexOfClickedButton = Integer.parseInt(ae.toString().substring(substringIndex + 4));
        if (indexOfClickedButton != numberOfStock) {
            
            if(!clicked){
                finished.setEnabled(true);
                tempMaxCount = basket[indexOfClickedButton].getMaxCount();
                for (int j = 0; j < numberOfStock; j++) {
                    if (j != indexOfClickedButton) {
                        basketButton[j].setVisible(false);
                    }
                }
            }
            basket[indexOfClickedButton].setCount(basket[indexOfClickedButton].getCount() + 1);
            basketButton[indexOfClickedButton].setText("" + basket[indexOfClickedButton].getCount());
            removeApples(indexOfClickedButton, 1);
            clicked = true;
            
            if (basket[indexOfClickedButton].getCount() == tempMaxCount){
                basketButton[indexOfClickedButton].setVisible(false);    
                isFinished();
            }
        } else {
            if (clicked) {
                moveDone();
                if (isComputerPlaying) {
                    computerMove();
                }
                clicked = false;
            }
        }
    }
    private void moveDone(){
        for (int j = 0; j < numberOfStock; j++) {
            basket[j].setCount(0);
            if (basket[j].getMaxCount() != 0) {
                basketButton[j].setVisible(true);
                basketButton[j].setText("" + basket[j].getCount());
            } else {
                basketButton[j].setEnabled(false);
            }
        }
        isFinished();
        numberOfPlayer = !numberOfPlayer;
        finished.setEnabled(false);
    }
    private boolean removeApples(int i, int numberOfApples){
        if (basket[i].getCount() > 0) {
            if(isComputerPlaying && (playFirst != numberOfPlayer))
            {
                setPlayerTurnText(numberOfApples, numberOfPlayer, (i+1));
            }
            int j = basket[i].getMaxCount() - 1;
            int removeApples = numberOfApples;
            basket[i].setMaxCount(basket[i].getMaxCount() - removeApples);
            while (removeApples > 0) {
                fruits[i][j--].setFruitExistance(false);
                removeApples--;
            }
            return true;
        }
        return false;
    }
    private void isFinished() {
        boolean finish = false;
        for (int i = 0; i < numberOfStock; i++) {
            if (basket[i].getMaxCount() > 0) {
                finish = false;
                break;
            } else {
                finish = true;
            }
        }
        if (finish) {
            int player = (numberOfPlayer) ? (1) : (2);
            if (typeOfGame.equals(GameType.MISERE)) {
                JOptionPane.showMessageDialog(null, 
                    LanguagePack.setText(LanguagePack.getLanguage(), "Player ") 
                    + (1 + (player%2)) + 
                    LanguagePack.setText(LanguagePack.getLanguage(), " won"));
            } else {
                JOptionPane.showMessageDialog(null, 
                    LanguagePack.setText(LanguagePack.getLanguage(), "Player ") 
                    + player + 
                    LanguagePack.setText(LanguagePack.getLanguage(), " won"));
            }
            int answer;
            answer = javax.swing.JOptionPane.showConfirmDialog(null, 
                    LanguagePack.setText(LanguagePack.getLanguage(), "Want to play again?"), 
                    LanguagePack.setText(LanguagePack.getLanguage(), "QUESTION ?"),
                    javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
            if (answer == javax.swing.JOptionPane.YES_OPTION) {
               OptionFrame frame = new OptionFrame();
            }
            Main.fram.dispose();
            
            this.setVisible(false);
        }
    }
}
