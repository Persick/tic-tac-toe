
/**
 * Created by Dasha on 25.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic();
        field.createFrame();
        gameLogic.step();
        gameLogic.restart();
    }
}
