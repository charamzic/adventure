package main.java.events;

import main.java.Game;

public class Event02 {

    Game game;

    public Event02(Game game) {
        this.game = game;
    }

    public void talkKneelingKnight() {
        game.ui.narrator.setText("I warn you, go back to where you came from. I just lost a friend in a fierce battle with a cave demon.");
    }

    public void exploreCave() {
        game.ui.narrator.setText("There is no chance to get through without a torch or a lantern. 🔥");

    }
}
