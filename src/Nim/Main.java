package Nim;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Vladimir Kunarac
 */
public class Main {
    static MainFrame fram;
    public static void main(String[] args) {
         fram = new MainFrame();
    }
    static void connect() {
    
                JFrame frame = new JFrame("Please connect to Internet");
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
                JLabel labela = new JLabel("Please connect to internet");
                labela.setVerticalAlignment(JLabel.BOTTOM);
                labela.setHorizontalAlignment(JLabel.RIGHT);
                frame.setSize(262, 300);
        
                frame.add(labela);
                frame.pack();
                frame.setLocationRelativeTo(fram);
    }
}
