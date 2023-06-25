package main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    Game game;

    public ActionHandler(Game game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var choice = e.getActionCommand();

        switch (choice) {
            case "talkKnight" -> game.knight01.talkKnight();
            case "fightKnight" -> game.knight01.fightKnight();
            case "robKnight" -> game.knight01.robKnight();
            case "exploreLog" -> game.ui.narrator.setText("You got yourself a stick. Better than nothing. Now, hurry up, be on your way!");
            default -> {
                game.ui.narrator.setText("Nothing for you here, be on your way!");
                throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
