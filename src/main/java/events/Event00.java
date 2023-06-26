package main.java.events;

import main.java.Game;

public class Event00 {

    private final Game game;

    public Event00(Game game) {
        this.game = game;
    }

    public void talkKnight() {
        game.ui.narrator.setText("Are you mad? You cannot join the mission without a weapon. Arm yourself!");
    }

    public void fightKnight() {
        if (game.player.currentLife == 1) {
            game.ui.narrator.setText("Guard: \"What a waste of a warrior.\"");
            game.player.currentLife--;
        }
        if (game.player.hasClub) {
            game.ui.narrator.setText("Guard: \"Nice stick, boy. Now be gone or I stick it up your arse!\"");
        } else {
            game.ui.narrator.setText("Guard: \"Let this be your first lesson, boy!\"\n You lost one life in an indiscreet skirmish. Bring yourself some weapon, next time.");
            game.player.currentLife--;
        }
        if (game.player.hasSword) {
            game.ui.narrator.setText("I surrender, you gained strength since I have seen you last time. Good job, my lord!");
        }
        game.player.updateStats();
    }

    public void robKnight() {
        game.ui.narrator.setText("This is not chivalrous behavior! You want to get whipped?");
    }

    public void exploreLog() {
        if (!game.player.hasClub) {
            game.ui.narrator.setText("You got yourself a club. Better than nothing. Now, hurry up, be on your way!");
            game.player.hasClub = true;
            game.player.updateStats();
        } else {
            game.ui.narrator.setText("There is nothing more here!");
        }
    }

    public void exploreApple() {
        if (game.player.currentLife != game.player.maxLife) {
            game.ui.narrator.setText("An apple a day keeps doctor away. You just gained an extra life!");
            game.player.currentLife++;
            game.player.updateStats();

            game.ui.bgPanel[1].getComponent(2).setVisible(false);
        } else {
            game.ui.narrator.setText("Your strength is at max level, lord.");
        }
    }
}
