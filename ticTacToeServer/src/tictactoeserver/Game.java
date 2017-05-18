/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Game {

    private Integer board[][] = new Integer[3][3];

    public Game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, Integer player) {
        if (this.board[x - 1][y - 1] == 0) {
            this.board[x - 1][y - 1] = player;
        } else {
            System.out.println("Field already occupied");
        }
    }

    public void showBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    int endGame() {

        int ok;
        for (int i = 0; i < 3; i++) {
            ok = 1;
            int x = board[i][0];
            if (x == 1 || x == 2) {
                for (int j = 1; j < 3; j++) {
                    if (board[i][j] != x) {
                        ok = 0;
                    }
                }
                if (ok == 1) {
                    return x;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            ok = 1;
            int x = board[0][i];
            if (x == 1 || x == 2) {
                for (int j = 1; j < 3; j++) {
                    if (board[j][i] != x) {
                        ok = 0;
                    }
                }
                if (ok == 1) {
                    return x;
                }
            }

        }
        ok = 1;
        int x = board[0][0];
        for (int i = 1; i < 3; i++) {
            if (board[i][i] != x) {
                ok = 0;
            }
        }
        if (ok == 1) {
            return x;
        }

        ok = 1;
        x = board[0][2];
        for (int i = 1; i < 3; i++) {
            if (board[i][2 - i] != x) {
                ok = 0;
            }
        }
        if (ok == 1) {
            return x;
        }

        int contor = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0) {
                    contor++;
                }
            }
        }
        if (contor == 9) {
            return -1;
        }

        return 0;

    }

}