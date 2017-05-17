/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

/**aaaaaaaaaaaaaaaaab
 *
 * @author Asus2
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

            DataInputStream fin1 = new DataInputStream(clientSocket1.getInputStream());
            DataOutputStream fout1 = new DataOutputStream(clientSocket1.getOutputStream());

            DataInputStream fin2 = new DataInputStream(clientSocket2.getInputStream());
            DataOutputStream fout2 = new DataOutputStream(clientSocket2.getOutputStream());

            String mesage1, mesage2;

            while (true) {

                if ((mesage1 = fin1.readUTF()) != null) {
                    fout2.writeUTF(mesage1);
                    //System.out.println("Player1 " + mesage1);
                }
                if ((mesage2 = fin2.readUTF()) != null) {
                    fout1.writeUTF(mesage2);
                    //System.out.println("player2 " + mesage2);
                }
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());

        }

    }
}
