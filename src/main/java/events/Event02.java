package main.java.events;

import main.java.Game;

public class Event02 {

    private final Game game;

    public Event02(Game game) {
        this.game = game;
    }

    public void talkKneelingKnight() {
        game.ui.narrator.setText("I warn you, go back to where you came from. I just lost a friend in a fierce battle with a cave demon.");
    }

    public void exploreCave() {
        game.ui.narrator.setText("Mhm...there is no chance for me to get through without a torch or a lantern. 🔥");
        if (!game.player.hasClub && !game.player.hasSword) {
            game.ui.narrator.append(" And I should probably arm myself with something!");
        }
    }

    public void enterCave() {
        if (game.player.hasSword && game.player.hasLantern || game.player.hasClub && game.player.hasLantern) {
            game.ui.narrator.setText("You have entered the cave!");
            game.sceneSwitcher.showScene03();
        } else {
            game.ui.narrator.setText("You need a light and a weapon to enter the cave.");
        }
    }

    public void askForHelp() {
        if (!game.player.hasLantern) {
            game.ui.narrator.setText("Sobbing knight: \"I can give you the lantern, there is no way I would enter that place again. Here, take it. And good luck to you.\"");
            game.player.hasLantern = true;
        } else {
            game.ui.narrator.setText("Sobbing knight: \"There is nothing more I can do for you.\"");
        }
        game.player.updateStats();
    }
}
