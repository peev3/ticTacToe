/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class GameThread implements Runnable {

    int portNumber;
    ServerSocket serverSocket;

    public GameThread(int portNumber) throws IOException {
        this.serverSocket = new ServerSocket(portNumber);
        this.portNumber = portNumber;

    }

    @Override
    public void run() {

        try {
            //server initialize

            Socket clientSocket1 = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            // I/O streams
            DataInputStream fin1 = new DataInputStream(clientSocket1.getInputStream());
            DataOutputStream fout1 = new DataOutputStream(clientSocket1.getOutputStream());

            DataInputStream fin2 = new DataInputStream(clientSocket2.getInputStream());
            DataOutputStream fout2 = new DataOutputStream(clientSocket2.getOutputStream());
            Scanner sc = new Scanner(System.in);
            //Game variables
            Game game = new Game();
            Integer player = 1;
            Integer x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            String p1, p2;

            while (true) {

                game.showBoard();

                //Read Input   
                if (player % 2 == 0) {                                          //player2
                    fout1.writeUTF(game.toString());
                    p2 = fin1.readUTF();
                    System.out.println(p2);
                    x2 = p2.charAt(0) - '0';
                    y2 = p2.charAt(1) - '0';
                    game.setBoard(x2, y2, 2);
                    player++;
                    fout1.writeUTF(game.toString());

                    System.out.println(x2 + " " + y2);
                } else {                                                        //player1        
                    fout2.writeUTF(game.toString());
                    p1 = fin2.readUTF();
                    System.out.println(p1);
                    x1 = p1.charAt(0) - '0';
                    y1 = p1.charAt(1) - '0';
                    game.setBoard(x1, y1, 1);
                    player++;
                    fout2.writeUTF(game.toString());

                    System.out.println(x1 + " " + y1);
                }

                if (game.endGame() != 0) {
                    game.showBoard();
                    int winner = game.endGame();
                    if (winner == 1) {
                        fout1.writeUTF("Player 1 won!");
                        System.out.println("Player 1 won");
                    } else {
                        if (winner == 2) {
                            fout2.writeUTF("Player 2 won!");
                            System.out.println("Player 1 won");
                        } else {
                            System.out.println("Draw");
                        }
                    }
                    break;

                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

}
