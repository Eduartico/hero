import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.text.Position;

public abstract class Element {
    public Position position;
    public Element(int x, int y) {
        position = new Position(x,y);
    }
    public void draw(TextGraphics graphics){}
    public Position getPosition()
    {
        return position;
    }
}
