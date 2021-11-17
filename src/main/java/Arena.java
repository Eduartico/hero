import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero player;
    private List<Wall> walls;

    public Arena(int width, int height, Hero player) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.walls = createWalls();
    }

    public void processKey(KeyStroke key) {
        KeyType keyType = key.getKeyType();
        switch (keyType) {
            case ArrowUp: {
                moveHero(player.moveUp());
                break;
            }
            case ArrowDown: {
                moveHero(player.moveDown());
                break;
            }
            case ArrowLeft: {
                moveHero(player.moveLeft());
                break;
            }
            case ArrowRight: {
                moveHero(player.moveRight());
                break;
            }
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff6a00"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for(Wall wall : walls) {
            wall.draw(graphics);
        }

        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff6a00"));
        player.draw(graphics);
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            player.setPosition(position);
    }

    private boolean canHeroMove(Position position){
        int x = position.getX();
        int y = position.getY();

        for(Wall wall: walls) {
            if(wall.position.getX() == x && wall.position.getY() == y) {
                return false;
            }
        }

        return true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
