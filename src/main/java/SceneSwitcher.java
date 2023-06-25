package main.java;

public class SceneSwitcher {

    Game game;

    public SceneSwitcher(Game game) {
        this.game = game;
    }

    public void showScene00() {
        game.ui.bgPanel[1].setVisible(true);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.narrator.setText("Come on, by the order of the Peaky Blinders and the King, we need to move on!");
    }

    public void showScene01() {
//        game.ui.bgPanel[1].setVisible(true);
//        game.ui.bgPanel[2].setVisible(false);
    }

    public void showScene02() {
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(true);
        game.ui.narrator.setText("You found yourself in front of a dark and cold cave. Your path leads through. " +
                "The adventure begins. There is a knight sobbing out loud...");
    }
}
