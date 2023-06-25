package Main.java;

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
            case "talkKnight" -> {
                game.ui.narrator.setText("Talk to knight on your own danger!");
            }
            case "fightKnight" -> {

            }
            case "robKnight" -> {

            }
        }
    }
}
