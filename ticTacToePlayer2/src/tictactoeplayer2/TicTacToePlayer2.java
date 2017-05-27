/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeplayer2;

/**
 * @author Asus1
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TicTacToePlayer2 {

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
                String output;

                input = fin.readUTF();
                int count = 0;
                for (int i = 4; i < input.length(); i++) {
                    System.out.print(input.charAt(i) + " ");
                    count++;
                    if (count == 3) {
                        System.out.println("");
                        count = 0;
                    }
                }
                
                System.out.println("");
                System.out.println("");

                if (stdIn.hasNext() != false) {
                    output = stdIn.next();
                    fout.writeUTF(output);
                }

                input = fin.readUTF();
                //int count = 0;
                count = 0;
                for (int i = 4; i < input.length(); i++) {
                    System.out.print(input.charAt(i) + " ");
                    count++;
                    if (count == 3) {
                        System.out.println("");
                        count = 0;
                    }
                }

                //System.out.println("P2: " + fin.readUTF());
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
