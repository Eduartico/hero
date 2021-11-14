import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private final TerminalScreen screen;
    Position position;
    Hero player;
    Arena arena;

    public Game(int alt, int larg) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(alt, larg)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

        this.position = new Position(50,25);
        this.player = new Hero(this.position);
        this.arena  = new Arena(100,50, this.player);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException {
        boolean keep = true;
        while(keep) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'q' || key.getCharacter() == 'Q') ){
                screen.close();
                keep = false;
            }
        }
    }
    private void processKey(KeyStroke key) {
        this.arena.processKey(key);
    }
}