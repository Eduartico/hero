import com.googlecode.lanterna.graphics.TextGraphics;

abstract class Element {
    public int x, y;
    protected Position position;
    public Element(int x, int y) {
        position = new Position(x,y);
    }
    abstract void draw(TextGraphics graphics);

    public Position getPosition()
    {
        return position;
    }
}
