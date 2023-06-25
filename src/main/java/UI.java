package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UI {

    Game game;
    JFrame window;
    public JTextArea narrator;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    public UI(Game game) {
        this.game = game;

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
        // SCENE 00
        SceneBuilder.createBackground(window, bgPanel, bgLabel, 1, "paloucek.png");
        SceneBuilder.createObject(
                game, 1, bgPanel,
                200, 100, 90, 150, "guard.png",
                new String[]{"Talk", "Fight", "Rob"},
                new String[]{"talkKnight", "fightKnight", "robKnight"}
        );
        SceneBuilder.createObject(
                game, 1, bgPanel,
                455, 185, 120, 50, "",
                new String[]{"Explore"},
                new String[]{"exploreLog"}
        );
        createArrowButton(1, 650, 150, "vpravo.png", "goScene2", "K jeskyni");
        createArrowButton(1, 0, 150, "vlevo.png", "goScene1", "Utéct domů");

        // SCENE 02
        SceneBuilder.createBackground(window, bgPanel, bgLabel, 2, "jeskyne.png");
        SceneBuilder.createObject(
                game, 2, bgPanel,
                400, 200, 90, 150, "kneel.png",
                new String[]{"Talk"},
                new String[]{"talkKneelingKnight"}
        );
        SceneBuilder.createObject(
                game, 2, bgPanel,
                320, 220, 40, 40, "",
                new String[]{"Explore"},
                new String[]{"exploreCave"}
        );
        createArrowButton(2, 0, 150, "vlevo.png", "goScene0", "Zpět na začátek");

        bgPanel[1].add(bgLabel[1]);
        bgPanel[2].add(bgLabel[2]);
    }

    private void createArrowButton(
            int bgNum, int posX, int posY,
            String fileName, String command, String tooltip
    ) {
        ImageIcon arrowIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)));

        JButton arrowBtn = new JButton();

        arrowBtn.setBounds(posX, posY, 50, 50);
        arrowBtn.setOpaque(false);
        arrowBtn.setContentAreaFilled(false);
        arrowBtn.setBorderPainted(false);
        arrowBtn.setFocusPainted(false);

        arrowBtn.setIcon(arrowIcon);
        arrowBtn.addActionListener(game.actionHandler);
        arrowBtn.setActionCommand(command);

        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setReshowDelay(0);
        arrowBtn.setToolTipText(tooltip);

        bgPanel[bgNum].add(arrowBtn);
    }
}
