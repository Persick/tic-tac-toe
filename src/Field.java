
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Dasha on 25.06.2016.
 */
public class Field extends JFrame {
    static int field[] = new int[9]; // отвечает за логику игры

    static JButton buttons[] = new JButton[9];
    static JButton restartButton = new JButton("Restart");

    static JFrame frame = new JFrame("XO");

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

    public static void redraw() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setEnabled(true);
            GameLogic.numberOfStep = 0;
            field[i] = 0;
        }
    }
}
