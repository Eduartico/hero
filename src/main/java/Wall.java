import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private int width;
    private int height;

    public Wall(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#eb3434"));
        graphics.putString(new TerminalPosition(width, height)," ");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
