import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x,y;
    Hero hero = new Hero(x,y);
    public Hero(int a, int b){
    }
    public void moveUp(){
        y--;
    }
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }
    public void draw(Screen screen){
        screen.setCharacter(x, y,
        TextCharacter.fromCharacter('O')[0]);
    }
}
