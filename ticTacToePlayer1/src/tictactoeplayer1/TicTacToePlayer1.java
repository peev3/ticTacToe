/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeplayer1;

/**
 *
 * @author Asus1
 */ 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TicTacToePlayer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;

        try (
                Socket serverSocket = new Socket(InetAddress.getByName("localhost"), portNumber);
                PrintWriter out
                = new PrintWriter(serverSocket.getOutputStream());
                BufferedReader in
                = new BufferedReader(
                        new InputStreamReader(serverSocket.getInputStream()));
                BufferedReader stdIn
                = new BufferedReader(
                        new InputStreamReader(System.in))) {

            String userInput = stdIn.readLine();
            out.println(userInput);
            System.out.println("echo: " + in.readLine());

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
