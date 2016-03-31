package Nim;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OptionPanel extends JPanel implements ActionListener, KeyListener{
    private final int PANEL_WIDTH = OptionFrame.getFRAME_WIDTH();
    private final int PANEL_HEIGHT = OptionFrame.getFRAME_HEIGHT();
    
    private JLabel labelForTypeOfGame = null;
    private JRadioButton[] typeOfGame = null;
    private JLabel labelTypeOfPlayers = null;
    private JRadioButton computerPlayer = null;
    private JRadioButton humanPlayer = null;
    private JLabel labelNumberOfShelves = null;
    private JComboBox numberOfShelves = null;
    private JTextField[] numberOfFruitsOnShelves = null;
    private JLabel labelNumberOfFruits = null;
    private JLabel[] labelNumberOfFruitOnEachShelf = null;
    private JLabel MistakeLabel = null;
    private JButton acceptButton = null;
    private JRadioButton[] playOrder;
    private final OptionFrame fra;
    private JRadioButton[] typeOfFruit = null;
    private JButton Instructions;
    boolean picturesLoaded = (Fruit.loadAppleImage() && Fruit.loadBananaImage() && Fruit.loadWatermelonImage());
        
    public OptionPanel(OptionFrame frame) {
        fra = frame;
        initComponents();
    }
    void initComponents(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        setFocusable(true);
        setVisible(true);
        
        addTypeOfGame();
        addTypeOfPlayers();
        addNumberOfShelves();
        addNumberOfFruitsOnShelf(Integer.parseInt(numberOfShelves.getSelectedItem().toString()));
        addPlayOrder();
        addTypeOfFruit();
        addInstructions();
        addButton();
        if(!picturesLoaded)
            Main.connect();
    }
    private void addTypeOfGame(){  
        labelForTypeOfGame = new JLabel(LanguagePack.setText(LanguagePack.getLanguage(), "Select type of game:"));
        labelForTypeOfGame.setBounds(0, 0, 225, 30);
        
        typeOfGame = new JRadioButton[2];
        typeOfGame[0] = new JRadioButton("Misere");
        typeOfGame[0].setBounds(230, 0, 100, 15);
        typeOfGame[1] = new JRadioButton("Normal");
        typeOfGame[1].setBounds(230, 20, 100, 15);
        typeOfGame[0].addActionListener(this);
        typeOfGame[1].addActionListener(this);
        
        add(labelForTypeOfGame);
        add(typeOfGame[0]);
        add(typeOfGame[1]);
        
        typeOfGame[0].setSelected(true);
    }
    private void addTypeOfPlayers(){
        labelTypeOfPlayers = new JLabel(LanguagePack.setText(LanguagePack.getLanguage(), "Select opponent:"));
        labelTypeOfPlayers.setBounds(0, 40, 200, 30);
        
        humanPlayer = new JRadioButton(LanguagePack.setText(LanguagePack.getLanguage(), 
                "Human"));
        humanPlayer.setVisible(true);
        humanPlayer.setBounds(150, 40, 75, 40);
        humanPlayer.addActionListener(this);
        
        computerPlayer = new JRadioButton(LanguagePack.setText(LanguagePack.getLanguage(), 
                "Computer"));
        computerPlayer.setVisible(true);
        computerPlayer.setBounds(225, 40, 100, 40);
        computerPlayer.addActionListener(this);
        
        add(labelTypeOfPlayers);
        add(humanPlayer);
        add(computerPlayer);
        
        humanPlayer.setSelected(true);
    }
    private void addNumberOfShelves(){
        labelNumberOfShelves = new JLabel(LanguagePack.setText(LanguagePack.getLanguage(), "Select number of stocks:"));
        labelNumberOfShelves.setBounds(0, 90, 225, 30);
    
        Integer[] inte = new Integer[4];
        for(int i=1; i<5; i++)
        {
            inte[i-1] = i;
        }
        numberOfShelves = new JComboBox(inte);
        numberOfShelves.setVisible(true);
        numberOfShelves.setBounds(230, 90, 75, 25);
        numberOfShelves.addActionListener(this);
        
        add(labelNumberOfShelves);
        add(numberOfShelves);
    }
    private boolean firstIteration = true;
    private void addNumberOfFruitsOnShelf(int noOfTres) {
        if(!firstIteration)
        {
            for(int i = 0; i < numberOfFruitsOnShelves.length; i++){
                remove(numberOfFruitsOnShelves[i]);
                remove(labelNumberOfFruitOnEachShelf[i]);
            }
            repaint();
        }
        else{
            firstIteration = false;
            labelNumberOfFruits = new JLabel(LanguagePack.setText(LanguagePack.getLanguage(), "Select number of fruits:"));
            labelNumberOfFruits.setBounds(0, 130, 225, 15);
            
            MistakeLabel = new JLabel();
            MistakeLabel.setBounds(160, 160, 200, 40);
            
            JLabel hint = new JLabel(LanguagePack.setText(LanguagePack.getLanguage(), "(Hint: 0 is random)"));
            hint.setBounds(0, 145, 220, 20);
            hint.setFont(new Font("Arial", Font.PLAIN, 8));

            add(hint);
            add(labelNumberOfFruits);
            add(MistakeLabel);
        }
        numberOfFruitsOnShelves = new JTextField[noOfTres];
        
        labelNumberOfFruitOnEachShelf = new JLabel[noOfTres];
        
        for(int i = 0; i< noOfTres; i++){
            labelNumberOfFruitOnEachShelf[i] = new JLabel(
                    LanguagePack.setText(LanguagePack.getLanguage(), "Stock ") + (1+i));
            labelNumberOfFruitOnEachShelf[i].setBounds(i*50+200, 105, 60, 40);
            
            numberOfFruitsOnShelves[i] = new JTextField();
            numberOfFruitsOnShelves[i].setBounds(i*50+200, 135, 30, 30);
            numberOfFruitsOnShelves[i].addKeyListener(this);
            numberOfFruitsOnShelves[i].setText("0");
            add(labelNumberOfFruitOnEachShelf[i]);
            add(numberOfFruitsOnShelves[i]);
        }
        repaint();
    }
    private void addButton(){
        acceptButton = new JButton();
        acceptButton.setText(LanguagePack.setText(LanguagePack.getLanguage(), "Accept settings"));
        acceptButton.setBounds(0, OptionFrame.getFRAME_HEIGHT()-80, OptionFrame.getFRAME_WIDTH(), 50);
        acceptButton.addActionListener(this);
        isDone();
        add(acceptButton);
    }
    private void addPlayOrder(){
        playOrder = new JRadioButton[2];
        playOrder[0] = new JRadioButton(LanguagePack.setText(LanguagePack.getLanguage(), "Play first"));
        playOrder[0].setBounds(0, 200, 140, 35);
        playOrder[1] = new JRadioButton(LanguagePack.setText(LanguagePack.getLanguage(), "Play second"));
        playOrder[1].setBounds(150, 200, 140, 35);
        playOrder[0].addActionListener(this);
        playOrder[1].addActionListener(this);
        
        add(playOrder[0]);
        add(playOrder[1]);
        
        playOrder[0].setSelected(true);
        if(!computerPlayer.isSelected()){
            setPlayOrderVisible(false);
        }
        else
            setPlayOrderVisible(true);
    }
    private void addTypeOfFruit(){
        typeOfFruit = new JRadioButton[3];
        typeOfFruit[0] = new JRadioButton();
        typeOfFruit[0].setBounds(330, 10, 20, 15);
        typeOfFruit[0].addActionListener(this);
        
        typeOfFruit[1] = new JRadioButton();
        typeOfFruit[1].setBounds(330, 30, 20, 15);
        typeOfFruit[1].addActionListener(this);
        
        typeOfFruit[2] = new JRadioButton();
        typeOfFruit[2].setBounds(330, 50, 20, 15);
        typeOfFruit[2].addActionListener(this);
        
        add(typeOfFruit[0]);
        add(typeOfFruit[1]);
        add(typeOfFruit[2]);
        
        typeOfFruit[0].setSelected(true);
    }
    private void addInstructions(){
        Instructions = new JButton();
        Instructions.setText(LanguagePack.setText(LanguagePack.getLanguage(), "Instructions"));
        Instructions.setBounds(0, OptionFrame.getFRAME_HEIGHT()-100, OptionFrame.getFRAME_WIDTH(), 20);
        Instructions.addActionListener(this);
        add(Instructions);
    }
    
    private void isDone(){
        if(TypeOfGameDone() && TypeOfPlayerDone()&&FruitsDone() && PlayOrderDone() && TypeOfFruitDone())
            acceptButton.setEnabled(true);
        else
            acceptButton.setEnabled(false);
    }
    private boolean FruitsDone(){
        for(int i = 0; i < Integer.parseInt(numberOfShelves.getSelectedItem().toString()); i++)
            if(numberOfFruitsOnShelves[i].getText().isEmpty())
                return false;
        return true;
    }
    private boolean TypeOfGameDone(){
        return typeOfGame[0].isSelected() || typeOfGame[1].isSelected();
    }
    private boolean TypeOfPlayerDone(){
        return humanPlayer.isSelected() || computerPlayer.isSelected();
    }
    private boolean PlayOrderDone(){
        return playOrder[0].isSelected() || playOrder[1].isSelected();
    }
    private boolean TypeOfFruitDone(){
        return typeOfFruit[0].isSelected() || typeOfFruit[1].isSelected() || typeOfFruit[2].isSelected();
    }
    
    private void setPlayOrderVisible(boolean visible){
        if(!(playOrder[0].isSelected() && playOrder[1].isSelected()))
            playOrder[0].setSelected(true);
        
        playOrder[0].setVisible(visible);
        playOrder[1].setVisible(visible);
    }
    private Fruit.fruit SelectedFruit(){
        if(typeOfFruit[0].isSelected())
            return Fruit.fruit.APPLE;
        else if(typeOfFruit[1].isSelected())
            return Fruit.fruit.BANANA;
        else if(typeOfFruit[2].isSelected())
            return Fruit.fruit.WATERMELON;
        else 
            return null;
    }
    @Override public void actionPerformed(ActionEvent ae) {
        if(typeOfGame[0].isFocusOwner())
        {
            if(typeOfGame[1].isSelected())
                typeOfGame[1].setSelected(false);
        }
        else if(typeOfGame[1].isFocusOwner())
        {    
            if(typeOfGame[0].isSelected())
                typeOfGame[0].setSelected(false);
        }
        else if(humanPlayer.isFocusOwner()){
            if(computerPlayer.isSelected())
                computerPlayer.setSelected(false);
            setPlayOrderVisible(false);
        }
        else if(computerPlayer.isFocusOwner()){
            if(humanPlayer.isSelected()){
                humanPlayer.setSelected(false);
                setPlayOrderVisible(true);
            }   
        }
        else if(numberOfShelves.isFocusOwner())
        {
            addNumberOfFruitsOnShelf(Integer.parseInt(numberOfShelves.getSelectedItem().toString()));
            if(!computerPlayer.isSelected())
                setPlayOrderVisible(false);
            else
                setPlayOrderVisible(true);
        }
        else if(playOrder[0].isFocusOwner()){
            if(playOrder[1].isSelected())
                playOrder[1].setSelected(false);   
        }
        else if(playOrder[1].isFocusOwner()){
            if(playOrder[0].isSelected())
                playOrder[0].setSelected(false);
        }
        else if(typeOfFruit[0].isFocusOwner()){
            if(typeOfFruit[1].isSelected())
                typeOfFruit[1].setSelected(false);
            if(typeOfFruit[2].isSelected())
                typeOfFruit[2].setSelected(false);
        }
        else if(typeOfFruit[1].isFocusOwner()){
            if(typeOfFruit[0].isSelected())
                typeOfFruit[0].setSelected(false);
            if(typeOfFruit[2].isSelected())
                typeOfFruit[2].setSelected(false);
        }
        else if(typeOfFruit[2].isFocusOwner()){
            if(typeOfFruit[1].isSelected())
                typeOfFruit[1].setSelected(false);
            if(typeOfFruit[0].isSelected())
                typeOfFruit[0].setSelected(false);
        }
        else if(acceptButton.isFocusOwner()){
            int trees = numberOfShelves.getSelectedIndex()+1;
            int[] apples = new int[trees];
            boolean order = (playOrder[0].isSelected()) ? (true) : (false);
            for(int i = 0; i < trees; i++)
                apples[i] = Integer.parseInt(numberOfFruitsOnShelves[i].getText());
            boolean player = (computerPlayer.isSelected()) ? (true) : (false);
            Panel.GameType game = (typeOfGame[1].isSelected()) ? 
                    (Panel.GameType.NORMAL) : (Panel.GameType.MISERE);
            Fruit.selectedFruit = SelectedFruit();
            MainFrame frame = new MainFrame(game, player, trees, apples, order, fra);
            Main.fram = frame;
            fra.dispose();
        }
        else if(Instructions.isFocusOwner()){
            Instructions inst = new Instructions(fra);
        }
        isDone();
    }

    @Override public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            MistakeLabel.setVisible(false);
            for(int i = 0; i < Integer.parseInt(numberOfShelves.getSelectedItem().toString()); i++)
                if(numberOfFruitsOnShelves[i].isFocusOwner())
                {
                    if(numberOfFruitsOnShelves[i].getText().isEmpty())
                        acceptButton.setEnabled(false);
                    break;
                }
        }
        else if(ke.getKeyChar() == KeyEvent.VK_ENTER);
        else if(ke.getKeyChar()< '0' || ke.getKeyChar() > '9')
        {
            MistakeLabel.setText(LanguagePack.setText(LanguagePack.getLanguage(), 
                    "Please use only numbers"));
            MistakeLabel.setVisible(true);
            ke.consume();
        }
        else
            MistakeLabel.setVisible(false);
        for(int i = 0; i < Integer.parseInt(numberOfShelves.getSelectedItem().toString()); i++)
            if(numberOfFruitsOnShelves[i].isFocusOwner())
            {
                if(numberOfFruitsOnShelves[i].getText().length() > 0)
                {
                    int inputedNumber = Integer.parseInt(numberOfFruitsOnShelves[i].getText())*10+ (ke.getKeyChar()-'0');
                    if(numberOfFruitsOnShelves[i].getText().startsWith("0"))
                    {
                        if(numberOfFruitsOnShelves[i].getText().length() > 1)
                            numberOfFruitsOnShelves[i].setText(numberOfFruitsOnShelves[i].getText().substring(1));
                        else
                            numberOfFruitsOnShelves[i].setText("");
                    }
                    if(inputedNumber > 50)
                    {
                        MistakeLabel.setText(LanguagePack.setText(LanguagePack.getLanguage(), 
                                "Maximal number of fruits is 50"));
                        MistakeLabel.setVisible(true);
                        ke.consume();
                    }
                }
                break;
            }
    }
    @Override public void keyPressed(KeyEvent ke) { }
    @Override public void keyReleased(KeyEvent ke) {
        isDone();
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        drawApple((Graphics2D) grphcs);
        drawBanana((Graphics2D) grphcs);
        drawWatermelon((Graphics2D) grphcs);
    }
    private void drawApple(Graphics2D g2d){
        if(Fruit.loadAppleImage())
            g2d.drawImage(Fruit.fruitImage, typeOfFruit[0].getX() +20, typeOfFruit[0].getY()-5, 20, 20, this);
        else
            g2d.drawString("Apple", typeOfFruit[0].getX() + 20, typeOfFruit[0].getY()+10);
    }
    private void drawBanana(Graphics2D g2d){
        if(Fruit.loadBananaImage())
            g2d.drawImage(Fruit.fruitImage, typeOfFruit[1].getX() +20, typeOfFruit[1].getY()-5, 20, 20, this);
        else
            g2d.drawString("Banana", typeOfFruit[1].getX() +20, typeOfFruit[1].getY()+10);
    }
    private void drawWatermelon(Graphics2D g2d){
        if(Fruit.loadWatermelonImage())
            g2d.drawImage(Fruit.fruitImage, typeOfFruit[2].getX() +20, typeOfFruit[2].getY()-5, 20, 20, this);
        else
            g2d.drawString("Watermelon", typeOfFruit[2].getX() +20, typeOfFruit[2].getY()+10);
    }
}
