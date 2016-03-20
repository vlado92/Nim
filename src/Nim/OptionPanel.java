package Nim;

import java.awt.Dimension;
import java.awt.Font;
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
    private JLabel labelNumberOfTrees = null;
    private JComboBox numberOfTrees = null;
    private JTextField[] numberOfApplesOnTree = null;
    private JLabel labelNumberOfApples = null;
    private JLabel[] labelNumberOfApplesOnEachTree = null;
    private JLabel MistakeLabel = null;
    private JButton acceptButton = null;
    private boolean treeDone = false;
    private JRadioButton[] playOrder;
    
    private OptionFrame fra;
    
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
        addNumberOfTrees();
        addButton();
    }
    private void addTypeOfGame(){
        
        labelForTypeOfGame = new JLabel("Select type of game:");
        labelForTypeOfGame.setBounds(0, 0, 150, 30);
        
        typeOfGame = new JRadioButton[2];
        typeOfGame[0] = new JRadioButton("Misere");
        typeOfGame[0].setBounds(150, 0, 200, 15);
        typeOfGame[1] = new JRadioButton("Normal");
        typeOfGame[1].setBounds(150, 20, 200, 15);
        typeOfGame[0].addActionListener(this);
        typeOfGame[1].addActionListener(this);
        
        add(labelForTypeOfGame);
        add(typeOfGame[0]);
        add(typeOfGame[1]);
        
        typeOfGame[0].setSelected(true);
    }
    private void addTypeOfPlayers(){
        labelTypeOfPlayers = new JLabel("Select oponent:");
        labelTypeOfPlayers.setBounds(0, 40, 200, 30);
        
        humanPlayer = new JRadioButton("Human");
        humanPlayer.setVisible(true);
        humanPlayer.setBounds(150, 40, 75, 40);
        humanPlayer.addActionListener(this);
        
        computerPlayer = new JRadioButton("Computer");
        computerPlayer.setVisible(true);
        computerPlayer.setBounds(225, 40, 100, 40);
        computerPlayer.addActionListener(this);
        
        add(labelTypeOfPlayers);
        add(humanPlayer);
        add(computerPlayer);
        
        humanPlayer.setSelected(true);
    }
    private void addNumberOfTrees(){
        labelNumberOfTrees = new JLabel("Select number of trees:");
        labelNumberOfTrees.setBounds(0, 90, 150, 30);
    
        Integer[] inte = new Integer[3];
        for(int i=2; i<5; i++)
        {
            inte[i-2] = i;
        }
        numberOfTrees = new JComboBox(inte);
        numberOfTrees.setVisible(true);
        numberOfTrees.setBounds(150, 90, 75, 25);
        numberOfTrees.addActionListener(this);
        
        add(labelNumberOfTrees);
        add(numberOfTrees);
    }
    private void addNumberOfApplesOnTree(int noOfTres) {
        numberOfApplesOnTree = new JTextField[noOfTres];
        labelNumberOfApplesOnEachTree = new JLabel[noOfTres];
        JLabel hint = new JLabel("(Hint: 0 means random)");
        
        labelNumberOfApples = new JLabel("Select number of Apples");
        labelNumberOfApples.setBounds(0, 130, 150, 15);
        hint.setBounds(0, 145, 150, 20);
        hint.setFont(new Font("Arial", Font.PLAIN, 8));
        
        MistakeLabel = new JLabel();
        MistakeLabel.setBounds(160, 160, 200, 40);
        
        for(int i = 0; i< noOfTres; i++){
            labelNumberOfApplesOnEachTree[i] = new JLabel("Tree " + (1+i));
            labelNumberOfApplesOnEachTree[i].setBounds(i*50+160, 105, 60, 40);
            
            numberOfApplesOnTree[i] = new JTextField();
            numberOfApplesOnTree[i].setBounds(i*50+160, 135, 30, 30);
            numberOfApplesOnTree[i].addKeyListener(this);
            numberOfApplesOnTree[i].setText("0");
            add(labelNumberOfApplesOnEachTree[i]);
            add(numberOfApplesOnTree[i]);
            System.out.println("" + numberOfApplesOnTree[i].getText().length());
        }
        add(hint);
        add(labelNumberOfApples);
        add(MistakeLabel);
        
        repaint();
    }
    private void addButton(){
        acceptButton = new JButton();
        acceptButton.setText("Accept Option");
        acceptButton.setBounds(0, 250, OptionFrame.getFRAME_WIDTH(), 50);
        acceptButton.addActionListener(this);
        acceptButton.setEnabled(false);
        add(acceptButton);
    }
    private void addPlayOrder(){
        playOrder = new JRadioButton[2];
        playOrder[0] = new JRadioButton("Play first");
        playOrder[0].setBounds(0, 200, 100, 35);
        playOrder[1] = new JRadioButton("Play second");
        playOrder[1].setBounds(150, 200, 100, 35);
        playOrder[0].addActionListener(this);
        playOrder[1].addActionListener(this);
        
        add(playOrder[0]);
        add(playOrder[1]);
        
        playOrder[0].setSelected(true);
    }
    
    private void isDone(){
        if(treeDone && TypeOfGameDone() && TypeOfPlayerDone()&&ApplesDone())
            acceptButton.setEnabled(true);
    }
    private boolean ApplesDone(){
        boolean numberOfApplesSelected = false;
        for(int i = 0; i < Integer.parseInt(numberOfTrees.getSelectedItem().toString()); i++)
            if(numberOfApplesOnTree[i].getText().isEmpty())
            {
                numberOfApplesSelected = false;
                break;
            }
            else
                numberOfApplesSelected = true;
        return numberOfApplesSelected;
    }
    private boolean TypeOfGameDone(){
        if(typeOfGame[0].isSelected() || typeOfGame[1].isSelected())
            return true;
        else
            return false;
    }
    private boolean TypeOfPlayerDone(){
        if(humanPlayer.isSelected() || computerPlayer.isSelected())
            return true;
        else
            return false;
    }
    private void setPlayOrderVisible(boolean visible){
        playOrder[0].setVisible(visible);
        playOrder[1].setVisible(visible);
    }
    @Override public void actionPerformed(ActionEvent ae) {
        if(typeOfGame[0].isFocusOwner() && typeOfGame[1].isSelected())
                typeOfGame[1].setSelected(false);
        else if(typeOfGame[1].isFocusOwner() && typeOfGame[0].isSelected())
                typeOfGame[0].setSelected(false);
        else if(humanPlayer.isFocusOwner() && computerPlayer.isSelected()){
            computerPlayer.setSelected(false);
            if(treeDone)
                setPlayOrderVisible(false);
        }
        else if(computerPlayer.isFocusOwner() && humanPlayer.isSelected()){
            humanPlayer.setSelected(false);
            if(treeDone)
                setPlayOrderVisible(true);
        }
        else if(numberOfTrees.isFocusOwner())
        {
            treeDone = true;
            addNumberOfApplesOnTree(Integer.parseInt(numberOfTrees.getSelectedItem().toString()));
            addPlayOrder();
            if(!computerPlayer.isSelected())
                setPlayOrderVisible(false);
            else
                setPlayOrderVisible(true);
        }
        else if(playOrder[0].isFocusOwner() && playOrder[1].isSelected())
                playOrder[1].setSelected(false);
        else if(playOrder[1].isFocusOwner() && playOrder[0].isSelected())
                playOrder[0].setSelected(false);
        
        
        isDone();
        if(acceptButton.isFocusOwner()){
            int trees = numberOfTrees.getSelectedIndex()+2;
            int[] apples = new int[trees];
            boolean order = (playOrder[0].isSelected()) ? (true) : (false);
            for(int i = 0; i < trees; i++)
                apples[i] = Integer.parseInt(numberOfApplesOnTree[i].getText());
            boolean player = (computerPlayer.isSelected()) ? (true) : (false);
            Panel.GameType game = (typeOfGame[0].isSelected()) ? 
                    (Panel.GameType.NORMAL) : (Panel.GameType.MISERE);
            MainFrame frame = new MainFrame(game, player, trees, apples, order);
            fra.dispose();
        }
    }

    @Override public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            MistakeLabel.setVisible(false);
        }
        else if(ke.getKeyChar() == KeyEvent.VK_ENTER);
        else if(ke.getKeyChar()< '0' || ke.getKeyChar() > '9')
        {
            MistakeLabel.setText("Please use only numbers");
            MistakeLabel.setVisible(true);
            ke.consume();
        }
        else
            MistakeLabel.setVisible(false);
        for(int i = 0; i < Integer.parseInt(numberOfTrees.getSelectedItem().toString()); i++)
            if(numberOfApplesOnTree[i].isFocusOwner())
            {
                
                if(numberOfApplesOnTree[i].getText().length() > 0)
                {   
                    int inputedNumber = Integer.parseInt(
                        numberOfApplesOnTree[i].getText())*10+ (ke.getKeyChar()-'0');
                    if(inputedNumber > 50)
                    {
                        MistakeLabel.setText("Maximal number of apples is 50");
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

}
