package Nim;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Instructions extends JFrame {

    public Instructions(MainFrame frame) {
        setVisible(true);
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        pack();
    }
}
