package ru.geekbrains.home_work8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 3;
    public static final int NUMBER_OF_MATCHES = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';
    public static char[][] map;
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        map = new char[SIZE][SIZE];
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }

        Window window = new Window(SIZE);

    }
}
