package main.java;

public class Player {
    Game game;
    public int maxLife;
    public int currentLife;

    public boolean hasClub;
    public boolean hasSword;
    public boolean hasShield;
    public boolean hasLantern;
    public boolean hasMagic;

    public Player(Game game) {
        this.game = game;
    }

    public void setDefaultValues() {
        maxLife = 5;
        currentLife = 3;
        hasClub = false;
        hasSword = false;
        hasShield = false;
        hasLantern = false;
        hasMagic = false;

        updateStats();
    }

    public void updateStats() {
        for (int i = 1; i < 6; i++) {
            game.ui.lifes[i].setVisible(false);
        }

        int lifeCount = currentLife;
        while (lifeCount != 0) {
            game.ui.lifes[lifeCount].setVisible(true);
            lifeCount--;
        }

        game.ui.club.setVisible(hasClub);
        game.ui.sword.setVisible(hasSword);
        game.ui.shield.setVisible(hasShield);
        game.ui.lantern.setVisible(hasLantern);
        game.ui.magic.setVisible(hasMagic);
    }
}
