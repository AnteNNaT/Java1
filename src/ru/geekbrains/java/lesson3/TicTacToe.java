package ru.geekbrains.java.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int WinningLength;


    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        WinningLength=4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите, пожалуйста, координаты X от 1 до "+ fieldSizeX + " и Y от 1 до "
                    +fieldSizeY+" через пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        for(int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++) {
                if(isEmptyCell(x, y)){
                    field[y][x]=DOT_AI;
                    if(checkWin(DOT_AI)){
                        return;
                    }
                    field[y][x]=DOT_HUMAN;
                    if(checkWin(DOT_HUMAN)){
                        field[y][x]=DOT_AI;
                        return;
                    }
                    field[y][x]=DOT_EMPTY;
                }
            }
        }
        int x; int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkWin(char Symbol) {
        for (int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++){
                if (field[y][x]==Symbol){
                    int a=1; int b=1; int c=1; int d=1;
                    while (((x+b)<fieldSizeX)&&(field[y][x]==field[y][x+b])){  //проверка строки
                        if ((b+1)==WinningLength) return true;
                            b++;
                    }
                    while (((y+a)<fieldSizeY)&&(field[y][x]==field[y+a][x])){  //проверка столбца
                        if ((a+1)==WinningLength) return true;
                        a++;
                    }
                    while (((y+c)<fieldSizeY)&&((x+c)<fieldSizeX)&&(field[y][x]==field[y+c][x+c])){ //проверка главной диагонали
                        if ((c+1)==WinningLength) return true;
                        c++;
                    }
                    while (((y+d)<fieldSizeY)&&((x-d)>=0)&&(field[y][x]==field[y+d][x-d])){ //проверка побочной диагонали
                        if ((d+1)==WinningLength) return true;
                        d++;
                    }

                }
            }
        }
        return false;
    }

    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }


       /*
        int[][] arr5 = {
                {1,0,0,0,0},
                {0,0,0,1,0},
                {1,0,1,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0},
        };

        System.out.println(checkWin(arr5,1,3));
        */


}

    /*1. Полностью разобраться с кодом;
    2. Переделать проверку победы, чтобы она не была реализована
        просто набором условий.
    3. * Попробовать переписать логику проверки победы,
        чтобы она работала для поля 5х5 и количества фишек 4.
    4. *** Доработать искусственный интеллект, чтобы он мог
        блокировать ходы игрока, и пытаться выиграть сам.
    * */
}