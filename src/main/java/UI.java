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
        createPlayerAttributes();
        generateScenes();

        window.setVisible(true);
    }

    // player ui
    JPanel lifePanel;
    JLabel[] lifes = new JLabel[6];
    JPanel inventory;
    public JLabel club, sword, shield, lantern, magic;

    private void createPlayerAttributes() {
        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.BLACK);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);

        ImageIcon lifeImage = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("heart.png")));
        Image image = lifeImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeImage = new ImageIcon(image);

        for (int i = 1; i < 6; i++) {
            lifes[i] = new JLabel();
            lifes[i].setIcon(lifeImage);
            lifePanel.add(lifes[i]);
        }

        inventory = new JPanel();
        inventory.setBounds(450, 0, 300, 50);
        inventory.setBackground(Color.BLACK);
        inventory.setLayout(new GridLayout(1, 5));
        window.add(inventory);

        // items
        club = new JLabel();
        ImageIcon clubIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("club.png")));
        club.setIcon(clubIcon);
        inventory.add(club);

        sword = new JLabel();
        ImageIcon swordIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("sword.png")));
        sword.setIcon(swordIcon);
        inventory.add(sword);

        shield = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("shield.png")));
        shield.setIcon(shieldIcon);
        inventory.add(shield);

        lantern = new JLabel();
        ImageIcon lanternIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("lantern.png")));
        lantern.setIcon(lanternIcon);
        inventory.add(lantern);

        magic = new JLabel();
        ImageIcon magicIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("magic.png")));
        magic.setIcon(magicIcon);
        inventory.add(magic);
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
        SceneBuilder.createObject(
                game, 1, bgPanel,
                600, 30, 50, 50, "apple.png",
                new String[]{"Explore"},
                new String[]{"exploreApple"}
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
                new String[]{"Talk", "Ask for help"},
                new String[]{"talkKneelingKnight", "askHelp"}
        );
        SceneBuilder.createObject(
                game, 2, bgPanel,
                320, 220, 40, 40, "",
                new String[]{"Explore", "Enter"},
                new String[]{"exploreCave", "enterCave"}
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
