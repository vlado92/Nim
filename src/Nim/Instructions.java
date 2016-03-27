package Nim;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Instructions extends JFrame {

    private JLabel madeBy = new JLabel("made by: Vladimir Kunarac");
    private JLabel date = new JLabel("Date: 24.3.2016.");
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 200;
    
    public Instructions(MainFrame frame) {
        setVisible(true);
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setResizable(false);
        
        addInstructionText();
        pack();
    }
    private void addInstructionText(){
        JTextArea rulesOfGame = new JTextArea();
        
        String text = "Nim is played starting with piles or rows of objects.\n"
                + "In every move you can take any number of apples from one trees.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below tree, you take apples from that tree\n"
                + "When you finish your move, press \"Finish move\" button";
        rulesOfGame.setText(LanguagePack.setText(LanguagePack.getLanguage(), text));
        rulesOfGame.setBounds(0, 0, FRAME_WIDTH, 140);
        rulesOfGame.setEditable(false);
        rulesOfGame.setBackground(this.getBackground());
        add(rulesOfGame);
        madeBy.setBounds(200, 140, FRAME_WIDTH-200, 30);
        date.setBounds(0, 140, 150, 30);
        JLabel pointless = new JLabel();
        add(madeBy);
        add(date);
        add(pointless);
    }
}
