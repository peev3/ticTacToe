/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeplayer2;

/**
 *
 * @author Asus1
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TicTacToePlayer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;
        try {
            Socket serverSocket = new Socket(InetAddress.getByName("localhost"), portNumber);
            Scanner stdIn = new Scanner(System.in);

            DataInputStream fin = new DataInputStream(serverSocket.getInputStream());
            DataOutputStream fout = new DataOutputStream(serverSocket.getOutputStream());

            while (true) {
                String input, output;

                if ((input = stdIn.next()) != null) {
                    fout.writeUTF(input);
                }

                if ((output = fin.readUTF()) != null) {
                    System.out.println("P1: " + output);
                }

            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + InetAddress.getByName("localhost"));
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + InetAddress.getByName("localhost"));
            System.exit(1);
        }
    }

}
