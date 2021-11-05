import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        TerminalSize terminalSize = new TerminalSize(200, 100);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.clear();
        screen.setCharacter(10, 10,
                TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
}