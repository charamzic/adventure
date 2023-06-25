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
        generateScene();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        narrator = new JTextArea();
        narrator.setBounds(50, 410, 700, 150);
        narrator.setBackground(Color.BLACK);
        narrator.setForeground(Color.WHITE);
        narrator.setEditable(false);
        narrator.setLineWrap(true);
        narrator.setWrapStyleWord(true);
        narrator.setFont(new Font("Didot", Font.PLAIN, 26));
        window.add(narrator);
    }

    public void generateScene() {
        // SCENE 1
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
        createArrowButton(1, 650, 150, 50, 50, "vpravo.png", "goScene2", "K jeskyni");
        createArrowButton(1, 0, 150, 50, 50, "vlevo.png", "goScene1", "Utéct domů");

        // SCENE 2
        createBackground(2, "jeskyne.png");
        createObject(
                2, 400, 200, 90, 150,
                "kneel.png",
                new String[]{"Talk"},
                new String[]{"talkKneelingKnight"}
        );
        createObject(
                2, 320, 220, 40, 40,
                "",
                new String[]{"Explore"},
                new String[]{"exploreCave"}
        );
        createArrowButton(2, 0, 150, 50, 50, "vlevo.png", "goScene0", "Zpět na začátek");

        bgPanel[1].add(bgLabel[1]);
        bgPanel[2].add(bgLabel[2]);
    }

    public void createBackground(int bgNum, String bgFileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.BLACK);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        var bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        bgLabel[bgNum].setIcon(bgIcon);
    }

    public void createArrowButton(
            int bgNum, int x, int y, int width, int height,
            String fileName, String command, String tooltip
    ) {
        ImageIcon arrowIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)));

        JButton arrowBtn = new JButton();

        arrowBtn.setBounds(x, y, width, height);
        arrowBtn.setOpaque(false);
        arrowBtn.setContentAreaFilled(false);
        arrowBtn.setBorderPainted(false);
        arrowBtn.setFocusPainted(false);

        arrowBtn.setIcon(arrowIcon);
        arrowBtn.addActionListener(gm.actionHandler);
        arrowBtn.setActionCommand(command);

        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setReshowDelay(0);
        arrowBtn.setToolTipText(tooltip);

        bgPanel[bgNum].add(arrowBtn);
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
}
