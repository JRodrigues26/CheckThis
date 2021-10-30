import checkers.Checker;
import checkers.CheckerColor;
import checkers.NormalChecker;

import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private ExecutorService playersPool;
    private Board gameBoard;
    private boolean playerTurn;
    private boolean gameOver = false;
    private LinkedList<Checker> player1Checkers;
    private LinkedList<Checker> player2Checkers;


    public Game(Socket player1S, Socket player2S) {
        playerTurn = false;
        playersPool = Executors.newCachedThreadPool();
        player1 = new Player(player1S);
        player2 = new Player(player2S);
        gameBoard = new Board();
        player1Checkers = new LinkedList<>();
        player2Checkers = new LinkedList<>();
        addCheckers();
    }

    public void addCheckers() {
        int paint = 0;
        for (int y = 0; y < Board.BOARD_LENGHT; y++) {
            paint++;
            for (int x = 0; x < Board.BOARD_LENGHT; x++) {
                paint++;
                if (!(paint % 2 == 0)) {
                    if (y < 3) {
                        player1Checkers.add(new NormalChecker(CheckerColor.WHITE, x, y));
                    } else if (y >= 5) {
                        player1Checkers.add(new NormalChecker(CheckerColor.BLACK, x, y));
                    }
                }
            }
        }
    }

    public void init() {
        gameBoard.setPiece(player1Checkers);
        gameBoard.setPiece(player2Checkers);
        gameBoard.draw();
    }


    @Override
    public void run() {
        init();

        while (!gameOver) {

            playersPool.submit(player1);
            playersPool.submit(player2);

        }

    }
}
