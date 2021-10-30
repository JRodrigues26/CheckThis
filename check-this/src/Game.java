import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private LinkedList<Socket> playersSockets;
    private ExecutorService playersPool;

    public Game(LinkedList list) {
        playersSockets = list;
        playersPool = Executors.newCachedThreadPool();
    }

    public void init() {
        player1 = new Player(playersSockets.get(0));
        player2 = new Player(playersSockets.get(1));
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                System.err.println("Runninngg");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
