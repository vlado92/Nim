package Nim;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame{
    private final static int FRAME_HEIGHT = 450;
    private final static int FRAME_WIDTH = 600;
    
    public static int GetHeight()
    {
        return FRAME_HEIGHT;
    }
    
    public static int GetWidth()
    {
        return FRAME_WIDTH;
    }
    
    public MainFrame(Panel.GameType game, boolean player, int trees, int[] apples, boolean order){
        setPreferredSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, FRAME_WIDTH, 20);
        
        JMenu newGame = new JMenu("New Game");
        newGame.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent me) {
                int answer;
                    answer = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this game ?", "QUESTION ?",
                            javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                    if (answer == javax.swing.JOptionPane.YES_OPTION) {
                       OptionFrame frame = new OptionFrame();
                       dispose();
                    }
            }
            @Override public void mousePressed(MouseEvent me) {}
            @Override public void mouseReleased(MouseEvent me) {}
            @Override public void mouseEntered(MouseEvent me) {}
            @Override public void mouseExited(MouseEvent me) {}
        });
        menuBar.add(newGame);
        
        JMenu help = new JMenu("Help");
        help.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Instructions instructions = new Instructions(MainFrame.this);
            }
            @Override public void mousePressed(MouseEvent me) {}
            @Override public void mouseReleased(MouseEvent me) {}
            @Override public void mouseEntered(MouseEvent me) {}
            @Override public void mouseExited(MouseEvent me) {}
        });
        menuBar.add(help);
        
        JMenu exit = new JMenu("Exit");
        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {int answer;
                answer = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?", "QUESTION ?",
                        javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                    System.exit(0);
                }}

            @Override public void mousePressed(MouseEvent me) {}
            @Override public void mouseReleased(MouseEvent me) {}
            @Override public void mouseEntered(MouseEvent me) {}
            @Override public void mouseExited(MouseEvent me) {}
        });
        menuBar.add(exit);
        
        Panel panel = new Panel(game, player, trees, apples, order);
        setJMenuBar(menuBar);
        add(panel);
        pack();        
    }
}
