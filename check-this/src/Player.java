import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Player implements Runnable{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    private Socket playerSocket;

    public Player(Socket socket) {
        playerSocket = socket;
        try {
            PrintWriter out = new PrintWriter(this.playerSocket.getOutputStream(), true);
            out.println(ANSI_CYAN_BACKGROUND+"This text has a green background and red text!"+ANSI_RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
