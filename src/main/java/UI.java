package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

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

        narrator = new JTextArea("Come on, by the order of the Peaky Blinders and the King, we need to move on!");
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

        var bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        bgLabel[bgNum].setIcon(bgIcon);
    }

    public void createObject(
            int bgNum, int objX, int objY, int objWidth, int objHeight,
            String objFileName, String[] menuChoices, String[] actions) {

        var popMenu = constructPopupMenu(menuChoices, actions);

        var objectLabel = new JLabel();
        objectLabel.setBounds(objX, objY, objWidth, objHeight);
        objectLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        var objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(objFileName)));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(final MouseEvent e) {

            }

            @Override
            public void mousePressed(final MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
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

    private JPopupMenu constructPopupMenu(String[] menuChoice, String[] commands) {
        var popMenu = new JPopupMenu();
        var menuItem = new JMenuItem[menuChoice.length];

        var i = 0;
        for (String item : menuChoice) {
            menuItem[i] = new JMenuItem(item);
            menuItem[i].addActionListener(gm.actionHandler);
            menuItem[i].setActionCommand(commands[i]);
            popMenu.add(menuItem[i]);
            i++;
        }
        return popMenu;
    }

    public void generateScreen() {
        createBackground(1, "paloucek.png");
        createObject(
                1, 200, 100, 90, 150,
                "guard.png",
                new String[]{"Talk", "Fight", "Rob"},
                new String[]{"talkKnight", "fightKnight", "robKnight"}
        );
        createObject(
                1, 455, 185, 120, 50,
                "",
                new String[]{"Explore"},
                new String[]{"exploreLog"}
        );
    }
}
