import Colors.Colors;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Player implements Runnable{

    private Socket playerSocket;
    private Board gameboard;

    public Player(Socket socket, Board gameboard) {
        playerSocket = socket;
        this.gameboard = gameboard;

        try {

            PrintWriter out = new PrintWriter(this.playerSocket.getOutputStream(), true);
            out.println(Colors.CYAN_BACKGROUND_BRIGHT+"This text has a green background and red text!"+ Colors.RESET);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {



    }
}
