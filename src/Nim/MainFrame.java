package Nim;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
    private final static int FRAME_HEIGHT = 500;
    private final static int FRAME_WIDTH = 500;

    
    
    Panel panel = new Panel();
    
    public static int GetHeight()
    {
        return FRAME_HEIGHT;
    }
    
    public static int GetWidth()
    {
        return FRAME_WIDTH;
    }
    
    public MainFrame()
    {
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel);
        pack();
        
    }
    
}
