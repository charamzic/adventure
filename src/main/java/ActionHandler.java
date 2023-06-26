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
            // scene00
            case "talkKnight" -> game.event01.talkKnight();
            case "fightKnight" -> game.event01.fightKnight();
            case "robKnight" -> game.event01.robKnight();
            case "exploreLog" -> game.event01.exploreLog();
            case "exploreApple" -> game.event01.exploreApple();
            // scene02
            case "talkKneelingKnight" -> game.event02.talkKneelingKnight();
            case "askHelp" -> game.event02.askForHelp();
            case "exploreCave" -> game.event02.exploreCave();
            case "enterCave" -> game.event02.enterCave();
            // scenes
            case "goScene1" -> game.sceneSwitcher.showScene01();
            case "goScene2" -> game.sceneSwitcher.showScene02();
            case "goScene0" -> game.sceneSwitcher.showScene00();
            default -> {
                game.ui.narrator.setText("Nothing for you here, be on your way!");
                throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
