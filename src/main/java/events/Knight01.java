package main.java.events;

import main.java.Game;

public class Knight01 {

    Game game;

    public Knight01(Game game) {
        this.game = game;
    }

    public void talkKnight() {
        game.ui.narrator.setText("Are you mad? You cannot join the mission without a weapon. Arm yourself!");
    }

    public void fightKnight() {
        game.ui.narrator.setText("This is not the right time for a training, young man. By the order of the king, we need to continue on our mission.");
    }

    public void robKnight() {
        game.ui.narrator.setText("This is not chivalrous behavior! You want to get whipped?");
    }
}
