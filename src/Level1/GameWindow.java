package Level1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    private Map map;
    private StartNewGameWindow startNewGameWindow;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("TicTacToe");
        setResizable(false);

        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        map = new Map();
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        startNewGameWindow = new StartNewGameWindow(this);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
