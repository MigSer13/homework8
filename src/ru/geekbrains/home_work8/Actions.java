package ru.geekbrains.home_work8;

import javax.swing.JOptionPane;

public class Actions {
    private enum Value {LINE, COLUMN, DIAGONAL_LR, DIAGONAL_RL}

    public void checkForWiinings() {
        int currentRowNumber_X, currentRowNumber_O;
        int currentColumnNumber_X, currentColumnNumber_O;
        int diagonal_LR_Number_X = 0, diagonal_LR_Number_O = 0;
        int diagonal_RL_Number_X = 0, diagonal_RL_Number_O = 0;
        int numberEMPTY = Main.SIZE * Main.SIZE;

        for (int i = 0; i < Main.map.length; i++) {
            currentRowNumber_X = 0;
            currentRowNumber_O = 0;
            currentColumnNumber_X = 0;
            currentColumnNumber_O = 0;

            //считаем диагонали
            if (Main.map[i][i] == Main.DOT_X) diagonal_LR_Number_X++;
            else if (Main.map[i][i] == Main.DOT_O) diagonal_LR_Number_O++;
            else if (Main.map[i][i] == Main.DOT_EMPTY) numberEMPTY++;

            if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_X) diagonal_RL_Number_X++;
            else if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_O) diagonal_RL_Number_O++;
            else if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_EMPTY) numberEMPTY++;

            for (int j = 0; j < Main.map[i].length; j++) {
                //считаем
                if (Main.map[i][j] == Main.DOT_X) currentRowNumber_X++;
                else if (Main.map[i][j] == Main.DOT_O) currentRowNumber_O++;
                else if (Main.map[i][j] == Main.DOT_EMPTY) numberEMPTY++;

                if (Main.map[j][i] == Main.DOT_X) currentColumnNumber_X++;
                else if (Main.map[j][i] == Main.DOT_O) currentColumnNumber_O++;
                else if (Main.map[j][i] == Main.DOT_EMPTY) numberEMPTY++;

                //проверяем
                if (currentRowNumber_X == Main.SIZE || currentColumnNumber_X == Main.SIZE
                        || diagonal_LR_Number_X == Main.SIZE || diagonal_RL_Number_X == Main.SIZE) {
                    JOptionPane.showMessageDialog(null, "Вы выиграли!!!  Игра закончена.");
                } else if (currentRowNumber_O == Main.SIZE || currentColumnNumber_O == Main.SIZE
                        || diagonal_LR_Number_O == Main.SIZE || diagonal_RL_Number_O == Main.SIZE) {
                    JOptionPane.showMessageDialog(null, "Вы проиграли!!!  Игра закончена.");
                }
            }
        }
        if (numberEMPTY == 0) JOptionPane.showMessageDialog(null, "Ничья.  Игра закончена.");
    }

    public int[] getCoordinatesActionsOfComputer() {
        Value value = Value.LINE;
        int currentRowNumber_X, currentRowNumber_O, currentRowNumber_EMPTY;
        int currentColumnNumber_X, currentColumnNumber_O, currentColumnNumber_EMPTY;
        int diagonal_LR_Number_X = 0, diagonal_LR_Number_O = 0, diagonal_LR_NumberEMPTY = 0;
        int diagonal_RL_Number_X = 0, diagonal_RL_Number_O = 0, diagonal_RL_NumberEMPTY = 0;

        int maxNumber_X_Row = 0;
        int maxNumber_X_Column = 0;
        int maxNumber_X_Diagonal_LR = 0;
        int maxNumber_X_Diagonal_RL = 0;

        int coordinate_i = 0;
        int coordinate_j = 0;
        boolean isMove;
        int currentMax;

        for (int i = 0; i < Main.map.length; i++) {
            currentRowNumber_X = 0;
            currentRowNumber_O = 0;
            currentRowNumber_EMPTY = 0;
            currentColumnNumber_X = 0;
            currentColumnNumber_O = 0;
            currentColumnNumber_EMPTY = 0;
            currentMax = 0;

            //считаем Х и О в диагонали LR
            if (Main.map[i][i] == Main.DOT_X) diagonal_LR_Number_X++;
            else if (Main.map[i][i] == Main.DOT_O) diagonal_LR_Number_O++;
            else if (Main.map[i][i] == Main.DOT_EMPTY) diagonal_LR_NumberEMPTY++;

            //считаем Х и О в диагонали RL
            if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_X) diagonal_RL_Number_X++;
            else if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_O) diagonal_RL_Number_O++;
            else if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_EMPTY) diagonal_RL_NumberEMPTY++;

            isMove = false;
            for (int j = 0; j < Main.map[i].length; j++) {
                //считаем Х и О в строке
                if (Main.map[i][j] == Main.DOT_X) currentRowNumber_X++;
                else if (Main.map[i][j] == Main.DOT_O) currentRowNumber_O++;
                else if (Main.map[i][j] == Main.DOT_EMPTY) currentRowNumber_EMPTY++;

                //считаем Х и О в колонке
                if (Main.map[j][i] == Main.DOT_X) currentColumnNumber_X++;
                else if (Main.map[j][i] == Main.DOT_O) currentColumnNumber_O++;
                else if (Main.map[j][i] == Main.DOT_EMPTY) currentColumnNumber_EMPTY++;


                //максимум Х в строках, колонках, диагоналях
                if (maxNumber_X_Row < currentRowNumber_X) {
                    maxNumber_X_Row = currentRowNumber_X;
                }
                if (maxNumber_X_Column < currentColumnNumber_X) {
                    maxNumber_X_Column = currentColumnNumber_X;
                }
                if (maxNumber_X_Diagonal_LR < diagonal_LR_Number_X) {
                    maxNumber_X_Diagonal_LR = diagonal_LR_Number_X;
                }
                if (maxNumber_X_Diagonal_RL < diagonal_RL_Number_X) {
                    maxNumber_X_Diagonal_RL = diagonal_RL_Number_X;
                }
                ///
                if (maxNumber_X_Row < maxNumber_X_Column) {
                    currentMax = maxNumber_X_Column;
                    value = Value.COLUMN;
                    coordinate_i = i;
                } else {
                    currentMax = maxNumber_X_Column;
                    value = Value.LINE;
                    coordinate_j = j;
                }
                if (currentMax < maxNumber_X_Diagonal_LR) {
                    value = Value.DIAGONAL_LR;
                } else if (currentMax < maxNumber_X_Diagonal_RL) {
                    value = Value.DIAGONAL_RL;
                }

//                //если остался один выигрышный ход игроку, то закрываем его
//                if ((currentRowNumber_X == Main.SIZE - 1) & currentRowNumber_EMPTY > 0) {
//                    value = Value.LINE;
//                    coordinate_j = j;
//                    isMove = true;
//                    //break;
//                } else if ((currentColumnNumber_X == Main.SIZE - 1) & currentColumnNumber_EMPTY > 0) {
//                    value = Value.COLUMN;
//                    coordinate_i = i;
//                    isMove = true;
//                    //break;
//                } else if ((diagonal_LR_Number_X == Main.SIZE - 1) & diagonal_LR_NumberEMPTY > 0) {
//                    value = Value.DIAGONAL_LR;
//                    isMove = true;
//                    //break;
//                } else if ((diagonal_RL_Number_X == Main.SIZE - 1 & diagonal_RL_NumberEMPTY > 0)) {
//                    value = Value.DIAGONAL_RL;
//                    isMove = true;
//                    //break;
//                }
//
//                //если остался один выигрышный ход, то делаем его
//                if ((currentRowNumber_O == Main.SIZE - 1) & currentRowNumber_EMPTY > 0) {
//                    value = Value.LINE;
//                    coordinate_j = j;
//                    isMove = true;
//                    //break;
//                } else if ((currentColumnNumber_O == Main.SIZE - 1) & currentColumnNumber_EMPTY > 0 ) {
//                    value = Value.COLUMN;
//                    coordinate_i = i;
//                    isMove = true;
//                    //break;
//                } else if (diagonal_LR_Number_O == Main.SIZE - 1) {
//                    value = Value.DIAGONAL_LR;
//                    isMove = true;
//                    // break;
//                } else if (diagonal_RL_Number_O == Main.SIZE - 1) {
//                    value = Value.DIAGONAL_RL;
//                    isMove = true;
//                    // break;
//                }
            }
            // if(isMove) break;
        }

        //устанавливаем координаты по найденным условиям
        if (value == Value.LINE) {
            for (int j = 0; j < Main.SIZE; j++) {
                if (Main.map[coordinate_i][j] == Main.DOT_EMPTY) {
                    coordinate_j = j;
                    break;
                }
            }
        } else if (value == Value.COLUMN) {
            for (int i = 0; i < Main.SIZE; i++) {
                if (Main.map[i][coordinate_j] == Main.DOT_EMPTY) {
                    coordinate_i = i;
                    break;
                }
            }
        } else if (value == Value.DIAGONAL_LR) {
            for (int i = 0; i < Main.SIZE; i++) {
                if (Main.map[i][i] == Main.DOT_EMPTY) {
                    coordinate_i = i;
                    coordinate_j = i;
                    break;
                }
            }
        } else if (value == Value.DIAGONAL_RL) {
            for (int i = 0; i < Main.SIZE; i++) {
                if (Main.map[Main.SIZE - 1 - i][Main.SIZE - 1 - i] == Main.DOT_EMPTY) {
                    coordinate_i = Main.SIZE - 1 - i;
                    coordinate_j = Main.SIZE - 1 - i;
                    break;
                }
            }
        }


        int[] arrCoordinates = new int[2];
        arrCoordinates[0] = coordinate_i;
        arrCoordinates[1] = coordinate_j;
        return arrCoordinates;
    }
}
