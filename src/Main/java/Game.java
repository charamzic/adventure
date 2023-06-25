package Main.java;

public class Game {

    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);

    public static void main(String[] args) {
        
        new Game();

    }

    public Game() {
        
    }
}