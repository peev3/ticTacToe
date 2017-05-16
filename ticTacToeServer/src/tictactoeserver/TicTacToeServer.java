/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

/**
 *
 * @author Asus2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;

        try {
            ServerSocket serverSocket = new ServerSocket(8050);
            Socket clientSocket1 = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            BufferedReader inPlayer1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            BufferedReader inPlayer2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

            PrintWriter outPlayer1 = new PrintWriter(clientSocket1.getOutputStream());
            PrintWriter outPlayer2 = new PrintWriter(clientSocket2.getOutputStream());

            String mesage1, mesage2;

            mesage1 = inPlayer1.readLine();
            outPlayer2.println(mesage1);
            System.out.println(mesage1);

            mesage2 = inPlayer2.readLine();
            outPlayer1.println(mesage2);
            System.out.println(mesage2);

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());

        }

    }
}
