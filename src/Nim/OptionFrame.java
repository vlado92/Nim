package Nim;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class OptionFrame extends JFrame{
    private static final int FRAME_WIDTH = 360;
    private static final int FRAME_HEIGHT = 320;

    public static int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    public static int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }
    
    
    
    public OptionFrame() throws HeadlessException {
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
