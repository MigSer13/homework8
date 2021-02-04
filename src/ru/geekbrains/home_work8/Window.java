package ru.geekbrains.home_work8;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        setTitle("Крестики-нолики");

        JButton[][] arrJButton = new JButton[3][3];
        for(int i=0; i < arrJButton.length; i++){
            for(int j=0; j < arrJButton[i].length; j++){
                arrJButton[i][j].setText("-");
                arrJButton[i][j].setHorizontalAlignment(JTextField.CENTER);

            }
        }

        setLayout(new GridLayout(3,3));

        //setComponentOrientation(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
