/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeplayer1;

/**aaaaaaaaaaab
 *
 * @author Asus1
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TicTacToePlayer1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;
        try {
            Socket serverSocket = new Socket(InetAddress.getByName("localhost"), portNumber);
            Scanner stdIn = new Scanner(System.in);

            DataInputStream fin = new DataInputStream(serverSocket.getInputStream());
            DataOutputStream fout = new DataOutputStream(serverSocket.getOutputStream());

            while (true) {
                String input;
                if ((input = stdIn.nextLine()) != null) {
                    fout.writeUTF(input);
                }
                System.out.println("P2: " + fin.readUTF());
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
