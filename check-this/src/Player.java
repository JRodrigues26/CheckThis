import java.net.Socket;

public class Player implements Runnable{

    private Socket playerSocket;

    public Player(Socket socket){
        playerSocket = socket;
    }


    @Override
    public void run() {

    }
}
