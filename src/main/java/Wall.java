import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import javax.swing.text.Element;

public class Wall extends Element {
    private int width;
    private int height;
    private final Position position;

    public Wall(int width, int height, Position position) {
        super();
        this.position = position;
        this.width = position.getX();
        this.height = position.getY();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(new TerminalPosition(width, height)," ");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
