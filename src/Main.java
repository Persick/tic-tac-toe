
/**
 * Created by Dasha on 25.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.f.createFrame();
        gameLogic.step();
        gameLogic.restart();
    }
}
