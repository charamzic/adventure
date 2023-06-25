package main.java;

import main.java.events.Event01;
import main.java.events.Event02;

public class Game {

    ActionHandler actionHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public SceneSwitcher sceneSwitcher = new SceneSwitcher(this);
    public Event01 event01 = new Event01(this);
    public Event02 event02 = new Event02(this);

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        
    }
}