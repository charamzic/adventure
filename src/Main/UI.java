package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class UI {

    Game gm;
    JFrame window;
    public JTextArea narrator;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    public UI(Game gm) {
        this.gm = gm;

        createMainField();
        generateScreen();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        narrator = new JTextArea("Tak tohle bude nejprisnejsi klikacka efffer");
        narrator.setBounds(50, 410, 700, 150);
        narrator.setBackground(Color.BLACK);
        narrator.setForeground(Color.WHITE);
        narrator.setEditable(false);
        narrator.setLineWrap(true);
        narrator.setWrapStyleWord(true);
        narrator.setFont(new Font("Didot", Font.PLAIN, 26));
        window.add(narrator);
    }

    public void createBackground(int bgNum, String bgFileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        bgLabel[bgNum].setIcon(bgIcon);
    }

    public void createObject(
            int bgNum, int objX, int objY, int objWidth, int objHeight,
            String objFileName, String menuChoice0, String menuChoice1, String menuChoice2) {

        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem[] menuItem = new JMenuItem[3];

        menuItem[0] = new JMenuItem(menuChoice0);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(menuChoice1);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(menuChoice2);
        popMenu.add(menuItem[2]);

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objX, objY, objWidth, objHeight);

        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(objFileName)));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(final MouseEvent e) {

            }

            @Override
            public void mousePressed(final MouseEvent e) {

            }

            @Override
            public void mouseReleased(final MouseEvent e) {

            }

            @Override
            public void mouseEntered(final MouseEvent e) {

            }

            @Override
            public void mouseExited(final MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    public void generateScreen() {
        createBackground(1, "paloucek.png");
        createObject(1, 340, 140, 200, 200, "guard.png", "Talk", "Fight", "Yield");
    }
}
