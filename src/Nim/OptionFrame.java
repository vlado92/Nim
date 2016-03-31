package Nim;

import java.awt.Dimension;
import javax.swing.JFrame;

public class OptionFrame extends JFrame{
    private static final int FRAME_WIDTH = 410;
    private static final int FRAME_HEIGHT = 350;

    public static int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    public static int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }
    
    public OptionFrame(){
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        OptionPanel panel = new OptionPanel(this);
        add(panel);
        
        pack();        
    }
}
