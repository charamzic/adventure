package main.java;

import main.java.events.Knight01;

public class Game {

    ActionHandler actionHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Knight01 knight01 = new Knight01(this);

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        
    }
}