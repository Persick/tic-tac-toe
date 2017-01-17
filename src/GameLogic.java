import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

/**
 * Created by Dasha on 25.06.2016.
 */
public class GameLogic {
    private int numberOfStep = 0;

    public int getNumberOfStep() {
        return numberOfStep;
    }

    public void setNumberOfStep(int numberOfStep) {
        this.numberOfStep = numberOfStep;
    }

    Field f = new Field();

    public boolean isWin() {
        if (f.getField()[0] == f.getField()[1] && f.getField()[0] == f.getField()[2] && f.getField()[0] != 0) {
            return true;
        } else if (f.getField()[3] == f.getField()[4] && f.getField()[3] == f.getField()[5] && f.getField()[3] != 0) {
            return true;
        } else if (f.getField()[6] == f.getField()[7] && f.getField()[6] == f.getField()[8] && f.getField()[6] != 0) {
            return true;
        } else if (f.getField()[0] == f.getField()[3] && f.getField()[0] == f.getField()[6] && f.getField()[0] != 0) {
            return true;
        } else if (f.getField()[1] == f.getField()[4] && f.getField()[1] == f.getField()[7] && f.getField()[1] != 0) {
            return true;
        } else if (f.getField()[2] == f.getField()[5] && f.getField()[2] == f.getField()[8] && f.getField()[2] != 0) {
            return true;
        } else if (f.getField()[0] == f.getField()[4] && f.getField()[8] == f.getField()[0] && f.getField()[0] != 0) {
            return true;
        } else if (f.getField()[2] == f.getField()[4] && f.getField()[2] == f.getField()[6] && f.getField()[2] != 0) {
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
        if (isCross() && f.getButtons()[i].isEnabled()) {
            f.getButtons()[i].setBackground(Color.RED);
            numberOfStep++;
            f.getButtons()[i].setEnabled(false);
            f.getField()[i] = 1;
        } else if (!isCross() && f.getButtons()[i].isEnabled()) {
            f.getButtons()[i].setBackground(Color.BLUE);
            numberOfStep++;
            f.getButtons()[i].setEnabled(false);
            f.getField()[i] = 2;
        }
        finishGame();
    }

    class MouseL implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == f.getButtons()[0]) {
                changeColor(0);
            } else if (e.getSource() == f.getButtons()[1]) {
                changeColor(1);
            } else if (e.getSource() == f.getButtons()[2]) {
                changeColor(2);
            } else if (e.getSource() == f.getButtons()[3]) {
                changeColor(3);
            } else if (e.getSource() == f.getButtons()[4]) {
                changeColor(4);
            } else if (e.getSource() == f.getButtons()[5]) {
                changeColor(5);
            } else if (e.getSource() == f.getButtons()[6]) {
                changeColor(6);
            } else if (e.getSource() == f.getButtons()[7]) {
                changeColor(7);
            } else if (e.getSource() == f.getButtons()[8]) {
                changeColor(8);
            } else if (e.getSource() == f.getRestartButton()) {
                redraw();
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
            f.getButtons()[i].addMouseListener(mouseListener);
        }
    }

    public void restart() {
        f.getRestartButton().addMouseListener(mouseListener);
    }

    public void redraw() {
        for (int i = 0; i < f.getButtons().length; i++) {
            f.getButtons()[i].setBackground(Color.WHITE);
            f.getButtons()[i].setEnabled(true);
            numberOfStep = 0;
            //field[i] = 0;
            f.getField()[i] = 0;
        }
    }

    public void finishGame() {
        if (isWin()) {
            JOptionPane.showMessageDialog(f.getFrame(), "Win!");
            redraw();
        }
    }
}
