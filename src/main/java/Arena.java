import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Arena {
    private int width, height;
    private Hero player;
    public Arena(int width, int height, Hero player) {
        this.width = width;
        this.height = height;
        this.player = player;
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
    public void moveHero(Position position) {
        if (canHeroMove(position))
            player.setPosition(position);
    }
    private boolean canHeroMove(Position position){
        return false;
    }
}
