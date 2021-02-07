package ru.geekbrains.home_work8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private static JButton[][] arrJButton = new JButton[Main.SIZE][Main.SIZE];
    private Actions actions;

    public Window(int SIZE) {
        setTitle("Крестики-нолики");
        setResizable(false);
        setLayout(new GridLayout(3, 3));
        setSize(SIZE * 50, SIZE * 50);

        Listener listener = new Listener();
        this.actions = new Actions();
        for (int i = 0; i < arrJButton.length; i++) {
            for (int j = 0; j < arrJButton[i].length; j++) {
                arrJButton[i][j] = new JButton();
                //arrJButton[i][j].setText("");
                arrJButton[i][j].setHorizontalAlignment(JTextField.CENTER);
                arrJButton[i][j].addActionListener(listener);
                add(arrJButton[i][j]);
            }
        }

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < arrJButton.length; i++) {
                for (int j = 0; j < arrJButton[i].length; j++) {
                    if (e.getSource().equals(arrJButton[i][j])) {
                        arrJButton[i][j].setText("X");
                        arrJButton[i][j].setEnabled(false);
                        Main.map[i][j] = Main.DOT_X;
                        actions.checkForWiinings();

                        //получаем координаты для хода компьютера
                        int[] arrCoordinates = actions.getCoordinatesActionsOfComputer();
                        int x = arrCoordinates[0];
                        int y = arrCoordinates[1];
                        Main.map[x][y] = Main.DOT_O;
                        arrJButton[x][y].setText("O");
                        arrJButton[x][y].setEnabled(false);
                        actions.checkForWiinings();
                        break;
                    }
                }
            }
        }
    }


}

