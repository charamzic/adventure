package main.java;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class UI {

    Game game;
    JFrame window;
    public JTextArea narrator;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    public UI(Game game) {
        this.game = game;

        createMainField();
        generateScenes();

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

    public void generateScenes() {
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
        SceneBuilder.createArrowButton(
                game, bgPanel,
                1, 650, 150,
                "vpravo.png", "goScene2", "K jeskyni"
        );
        SceneBuilder.createArrowButton(
                game, bgPanel,
                1, 0, 150,
                "vlevo.png", "goScene1", "Utéct domů"
        );

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
        SceneBuilder.createArrowButton(
                game, bgPanel,
                2, 0, 150,
                "vlevo.png", "goScene0", "Zpět na začátek"
        );

        bgPanel[1].add(bgLabel[1]);
        bgPanel[2].add(bgLabel[2]);
    }
}
