package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class SceneBuilder {

    public static void createBackground(JFrame window, JPanel[] bgPanel, JLabel[] bgLabel, int sceneNumber, String background) {
        bgPanel[sceneNumber] = new JPanel();
        bgPanel[sceneNumber].setBounds(50, 50, 700, 350);
        bgPanel[sceneNumber].setBackground(Color.BLACK);
        bgPanel[sceneNumber].setLayout(null);
        window.add(bgPanel[sceneNumber]);

        bgLabel[sceneNumber] = new JLabel();
        bgLabel[sceneNumber].setBounds(0, 0, 700, 350);

        var bgIcon = new ImageIcon(Objects.requireNonNull(SceneBuilder.class.getClassLoader().getResource(background)));
        bgLabel[sceneNumber].setIcon(bgIcon);
    }

    public static void createObject(
            Game game, int sceneNumber, JPanel[] bgPanel,
            int objX, int objY, int objWidth, int objHeight,
            String objFileName, String[] menuChoices, String[] actions
    ) {

        var popMenu = constructPopupMenu(game, menuChoices, actions);

        var objectLabel = new JLabel();
        objectLabel.setBounds(objX, objY, objWidth, objHeight);
        objectLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        var objectIcon = new ImageIcon(Objects.requireNonNull(SceneBuilder.class.getClassLoader().getResource(objFileName)));
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

        bgPanel[sceneNumber].add(objectLabel);
    }

    private static JPopupMenu constructPopupMenu(Game game, String[] menuChoice, String[] commands) {
        var popMenu = new JPopupMenu();
        var menuItem = new JMenuItem[menuChoice.length];

        var i = 0;
        for (String item : menuChoice) {
            menuItem[i] = new JMenuItem(item);
            menuItem[i].addActionListener(game.actionHandler);
            menuItem[i].setActionCommand(commands[i]);
            popMenu.add(menuItem[i]);
            i++;
        }
        return popMenu;
    }

}
