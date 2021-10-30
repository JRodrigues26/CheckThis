import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private ExecutorService playersPool;
    private Board gameBoard;

    public Game(Socket player1S, Socket player2S) {
        playersPool = Executors.newCachedThreadPool();
        player1 = new Player(player1S);
        player2 = new Player(player2S);
        gameBoard = new Board();
    }

    public void init() {
        gameBoard.draw();
    }


    @Override
    public void run() {
        init();
    }
}
