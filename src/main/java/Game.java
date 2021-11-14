import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Position position = new Position(10,10);
    private TerminalScreen screen;
    Hero player = new Hero(position);
    Arena arena = new Arena(100,100, player);
    //private int x = 10;
    //private int y = 10;
    public Game(int alt, int larg) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(alt, larg)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
    }

    private void draw() throws IOException {
        screen.clear();
        player.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException {
        while(true){
        draw();
        KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q' || key.getCharacter() == 'Q' ){
                screen.close();
            }
        }
    }
    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(player.moveUp());
        };
        if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(player.moveDown());
        };
        if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(player.moveLeft());
        };
        if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(player.moveRight());
        };
    }

    private void moveHero(Position position) {
        player.setPosition(position);
    }
}