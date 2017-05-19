/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

/**
 * @author Asus2
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;

        try {
            //server initialize
            ServerSocket serverSocket = new ServerSocket(8050);
            Socket clientSocket1 = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            // I/O streams
            DataInputStream fin1 = new DataInputStream(clientSocket1.getInputStream());
            DataOutputStream fout1 = new DataOutputStream(clientSocket1.getOutputStream());
            DataInputStream fin2 = new DataInputStream(clientSocket2.getInputStream());
            DataOutputStream fout2 = new DataOutputStream(clientSocket2.getOutputStream());

            //Game variables
            Game game = new Game();
            Integer player = 1;
            Integer x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            String p1, p2;

            fout1.writeUTF(game.toString());
            while (true) {

                game.showBoard();

                //System.out.println(game.toString());
                //Read Input    
                if (player % 2 == 0) {                                          //player2
                    fout2.writeUTF(game.toString());
                    p2 = fin1.readUTF();
                    System.out.println(p2);
                    x2 = p2.charAt(0) - '0';
                    y2 = p2.charAt(1) - '0';
                    game.setBoard(x2, y2, 2);
                    player++;
                    //fout2.writeUTF(game.toString());
                    fout1.writeUTF(game.toString());

                    System.out.println(x2 + " " + y2);
                } else {                                                        //player1                           
                    p1 = fin2.readUTF();
                    System.out.println(p1);
                    x1 = p1.charAt(0) - '0';
                    y1 = p1.charAt(1) - '0';
                    game.setBoard(x1, y1, 1);
                    player++;
//                    fout1.writeUTF(game.toString());
//                    fout2.writeUTF(game.toString());

                    System.out.println(x1 + " " + y1);
                }

                //Player move
//                if (player % 2 == 0) {
//
//                    player++;
//                } else {
//
//                    player++;
//                }
                if (game.endGame() != 0) {
                    game.showBoard();
                    int winner = game.endGame();
                    if (winner == 1 || winner == 2) {
                        System.out.println(winner + " won ");
                    } else {
                        System.out.println("Draw");
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
