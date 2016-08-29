import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dasha on 25.06.2016.
 */
public class GameLogic {
    static int numberOfStep = 0;

    public static boolean isWin() {
        if (Field.field[0] == Field.field[1] && Field.field[0] == Field.field[2] && Field.field[0] != 0) {
            return true;
        } else if (Field.field[3] == Field.field[4] && Field.field[3] == Field.field[5] && Field.field[3] != 0) {
            return true;
        } else if (Field.field[6] == Field.field[7] && Field.field[6] == Field.field[8] && Field.field[6] != 0) {
            return true;
        } else if (Field.field[0] == Field.field[3] && Field.field[0] == Field.field[6] && Field.field[0] != 0) {
            return true;
        } else if (Field.field[1] == Field.field[4] && Field.field[1] == Field.field[7] && Field.field[1] != 0) {
            return true;
        } else if (Field.field[2] == Field.field[5] && Field.field[2] == Field.field[8] && Field.field[2] != 0) {
            return true;
        } else if (Field.field[0] == Field.field[4] && Field.field[8] == Field.field[0] && Field.field[0] != 0) {
            return true;
        } else if (Field.field[2] == Field.field[4] && Field.field[2] == Field.field[6] && Field.field[2] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCross() {
        if ((numberOfStep % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }


    public void changeColor(int i) //обработчик события!
    {
        if (isCross() && Field.buttons[i].isEnabled()) {
            Field.buttons[i].setBackground(Color.RED);
            numberOfStep++;
            Field.buttons[i].setEnabled(false);
            Field.field[i] = 1;
        } else if (!isCross() && Field.buttons[i].isEnabled()) {
            Field.buttons[i].setBackground(Color.BLUE);
            numberOfStep++;
            Field.buttons[i].setEnabled(false);
            Field.field[i] = 2;
        }
        finishGame();
    }

    class MouseL implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == Field.buttons[0]) {
                changeColor(0);
            } else if (e.getSource() == Field.buttons[1]) {
                changeColor(1);
            } else if (e.getSource() == Field.buttons[2]) {
                changeColor(2);
            } else if (e.getSource() == Field.buttons[3]) {
                changeColor(3);
            } else if (e.getSource() == Field.buttons[4]) {
                changeColor(4);
            } else if (e.getSource() == Field.buttons[5]) {
                changeColor(5);
            } else if (e.getSource() == Field.buttons[6]) {
                changeColor(6);
            } else if (e.getSource() == Field.buttons[7]) {
                changeColor(7);
            } else if (e.getSource() == Field.buttons[8]) {
                changeColor(8);
            } else if (e.getSource() == Field.restartButton) {
                Field.redraw();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

    MouseListener mouseListener = new MouseL();

    public void step() {
        for (int i = 0; i < 9; i++) {
            Field.buttons[i].addMouseListener(mouseListener);
        }
    }

    public void restart() {
        Field.restartButton.addMouseListener(mouseListener);
    }

    public void finishGame() {
        if (GameLogic.isWin()) {
            JOptionPane.showMessageDialog(Field.frame, "Win!");
            Field.redraw();
        }
    }
}
