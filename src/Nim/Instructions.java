package Nim;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Instructions extends JFrame {

    private final JLabel madeBy = new JLabel("made by: Vladimir Kunarac");
    private final JTextArea email = new JTextArea("vladimir.kunarac@gmail.com");
    private final JLabel date = new JLabel("Date made: 31.3.2016.");
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 240;
    
    public Instructions(JFrame frame) {
        setVisible(true);
        setLocation(frame.getX()+50, frame.getY()+50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setResizable(false);
        
        addInstructionText();
        pack();
    }
    private void addInstructionText(){
        JTextArea rulesOfGame = new JTextArea();
        
        String text = "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button";
        rulesOfGame.setText(LanguagePack.setText(LanguagePack.getLanguage(), text));
        rulesOfGame.setBounds(0, 0, FRAME_WIDTH, 140);
        rulesOfGame.setEditable(false);
        rulesOfGame.setBackground(this.getBackground());
        add(rulesOfGame);
        madeBy.setBounds(0, 140, 200, 30);
        add(madeBy);
        
        date.setBounds(FRAME_WIDTH-150, 140, 200, 30);
        add(date);
                
        email.setBounds(0, 170, FRAME_WIDTH, 30);
        email.setEditable(false);
        email.setBackground(this.getBackground());
        add(email);
        
        JLabel pointless = new JLabel();
        add(pointless);
    }
}
