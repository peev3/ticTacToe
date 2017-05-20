/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

/**
 * @author Asus2
 */
import java.io.IOException;

public class TicTacToeServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int portNumber = 8050;


            GameThread r = new GameThread(portNumber);
            new Thread(r).start();

    }
}
