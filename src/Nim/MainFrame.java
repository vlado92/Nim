package Nim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame{
    private final static int FRAME_HEIGHT = 450;
    private final static int FRAME_WIDTH = 600;
    public Panel.GameType type;
    public boolean players;
    public int tree;
    public int[] apple;
    public boolean orders;
    
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
        
        JMenu newGame = new JMenu(LanguagePack.setText(LanguagePack.getLanguage(), "New Game"));
        newGame.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent me) {
                int answer;
                    answer = javax.swing.JOptionPane.showConfirmDialog(null,
                            LanguagePack.setText(LanguagePack.getLanguage(), 
                                    "Are you sure you want to cancel this game") + " ?", 
                            LanguagePack.setText(LanguagePack.getLanguage(), "QUESTION ?"),
                            javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                    if (answer == javax.swing.JOptionPane.YES_OPTION) {
                       OptionFrame frame = new OptionFrame();
                       dispose();
                    }
            }
        });
        menuBar.add(newGame);
        
        JMenu help = new JMenu(LanguagePack.setText(LanguagePack.getLanguage(), "Instructions"));
        help.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent me) {
                Instructions instructions = new Instructions(MainFrame.this);
            }
        });
        menuBar.add(help);
        
        JMenu language = new JMenu(LanguagePack.setText(LanguagePack.getLanguage(), 
                "Select language"));
        JMenuItem english = new JMenuItem("English");
        JMenuItem slovenian = new JMenuItem("Slovencina");
        JMenuItem german = new JMenuItem("Deutsch");
        JMenuItem italian = new JMenuItem("Italiano");
        JMenuItem serbian = new JMenuItem("Српски");
        JMenuItem croatian = new JMenuItem("Hrvatski");
        english.addActionListener(new ActionListener()   {
            @Override public void actionPerformed(ActionEvent ae) {
                int answer;
                answer = dialogBox(LanguagePack.Language.ENGLISH);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                    LanguagePack.changeLanguage(LanguagePack.Language.ENGLISH);
                    OptionFrame frame = new OptionFrame();
                    dispose();
                }
        }
        });
        german.addActionListener(new ActionListener()    {
            @Override public void actionPerformed(ActionEvent ae) {
                int answer;
                answer = dialogBox(LanguagePack.Language.DEUTSCH);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                    LanguagePack.changeLanguage(LanguagePack.Language.DEUTSCH);
                    OptionFrame frame = new OptionFrame();
                    dispose();
                }
}
        });
        italian.addActionListener(new ActionListener()   {
            @Override public void actionPerformed(ActionEvent ae) {
                int answer;
                answer = dialogBox(LanguagePack.Language.ITALIANO);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                   LanguagePack.changeLanguage(LanguagePack.Language.ITALIANO);
                   OptionFrame frame = new OptionFrame();
                   dispose();
                }
}
        });
        serbian.addActionListener(new ActionListener()   {
            @Override public void actionPerformed(ActionEvent ae) {
                int answer;
                answer = dialogBox(LanguagePack.Language.СРПСКИ);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                   LanguagePack.changeLanguage(LanguagePack.Language.СРПСКИ);
                   OptionFrame frame = new OptionFrame();
                   dispose();
                }
}
        });
        croatian.addActionListener(new ActionListener()  {
            @Override public void actionPerformed(ActionEvent ae) {
                int answer;
                answer = dialogBox(LanguagePack.Language.HRVATSKI);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                   LanguagePack.changeLanguage(LanguagePack.Language.HRVATSKI);
                   OptionFrame frame = new OptionFrame();
                   dispose();
                }
            }
        });
        slovenian.addActionListener(new ActionListener() {
                    @Override public void actionPerformed(ActionEvent ae) {
                    int answer = dialogBox(LanguagePack.Language.SLOVENČINA);
                            if (answer == javax.swing.JOptionPane.YES_OPTION) {
                        LanguagePack.changeLanguage(LanguagePack.Language.SLOVENČINA);
                        OptionFrame frame = new OptionFrame();
                        dispose();
                    }
    
                    }
                });

        language.add(english);
        language.add(slovenian);
        language.add(german);
        language.add(italian);
        language.add(croatian);
        language.add(serbian);
        
        menuBar.add(language);

        JMenu exit = new JMenu(LanguagePack.setText(LanguagePack.getLanguage(),  "Exit"));
        exit.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent me) {int answer;
                answer = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?", "QUESTION ?",
                        javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        menuBar.add(exit);
        
        Panel panel = new Panel(game, player, trees, apples, order);
        setJMenuBar(menuBar);
        add(panel);
        pack();        
    }
    private int dialogBox(LanguagePack.Language lang){
        return javax.swing.JOptionPane.showConfirmDialog(null, 
        LanguagePack.setText(LanguagePack.getLanguage(), 
            "Are you sure you want to cancel this game")
        + LanguagePack.setText(LanguagePack.getLanguage(), " and change language?")
        + "\n" + LanguagePack.setText(lang, 
            "Are you sure you want to cancel this game")
        + LanguagePack.setText(lang, " and change language?"), 
        LanguagePack.setText(LanguagePack.getLanguage(), "QUESTION ?"),
        javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        
    }
}
