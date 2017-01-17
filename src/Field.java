
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Dasha on 25.06.2016.
 */
public class Field extends JFrame {
    private int field[] = new int[9]; // отвечает за логику игры

    public int[] getField() {
        return field;
    }

    public void setField(int[] field) {
        this.field = field;
    }

    private JButton buttons[] = new JButton[9];
    private JButton restartButton = new JButton("Restart");

    private JFrame frame = new JFrame("XO");

    public JButton[] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public void setRestartButton(JButton restartButton) {
        this.restartButton = restartButton;
    }

    public void createFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 500); //размер окна
        //frame.pack(); // автоматически настраиваем размер окна под содержимое
        frame.setResizable(false); //размер окна изменять нельзя

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        frame.add(c);

        JPanel panelTwo = new JPanel();
        panelTwo.add(restartButton);
        panelTwo.setBorder(new LineBorder(Color.RED, 4));
        c.add(panelTwo, BorderLayout.NORTH);

        c.add(createPlayArea(), BorderLayout.CENTER);
    }

    public JPanel createPlayArea() {
        JPanel playArea = new JPanel();
        playArea.setLayout(new GridLayout(3, 3, 3, 3));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            playArea.add(buttons[i]);
            field[i] = 0;
        }

        playArea.setBorder(new LineBorder(Color.BLACK, 4));
        return playArea;
    }
}
