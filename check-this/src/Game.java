import checkers.BlackChecker;
import checkers.Checker;
import checkers.WhiteChecker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        System.err.println("CREATING NEW GAME");
        playerTurn = false;
        playersPool = Executors.newCachedThreadPool();
        player1 = new Player(player1S, this.gameBoard);
        player2 = new Player(player2S, this.gameBoard);
        gameBoard = new Board(player1S, player2S);
        player1Checkers = new LinkedList<>();
        player2Checkers = new LinkedList<>();


        addCheckers();
    }

    public void addCheckers() {
        int paint = 0;
        for (int row = 0; row < Board.BOARD_LENGHT; row++) {
            paint++;
            for (int col = 0; col < Board.BOARD_LENGHT; col++) {
                paint++;
                if (!(paint % 2 == 0)) {
                    if (row < 3) {
                        player1Checkers.add(new WhiteChecker(col, row));
                    } else if (row >= 5) {
                        player2Checkers.add(new BlackChecker(col, row));
                    }
                }
            }
        }
    }

    public void init() {
        gameBoard.setPieces(player1Checkers);
        gameBoard.setPieces(player2Checkers);
        gameBoard.draw();
    }

    public void movePiece(Checker checker) {

    }


    @Override
    public void run() {
        try {
            System.err.println("INITIATING GAME");
            player1.setName();
            player2.setName();
            init();
            while (!gameOver) {

                player1.play();
                player2.play();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
