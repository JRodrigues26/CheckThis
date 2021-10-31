import checkers.BlackChecker;
import checkers.Checker;
import checkers.WhiteChecker;


import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private Board gameBoard;
    private boolean gameOver = false;
    private LinkedList<Checker> player1Checkers;
    private LinkedList<Checker> player2Checkers;




    public Game(Socket player1S, Socket player2S) {
        System.err.println("CREATING NEW GAME");
        player1 = new Player(player1S);
        player2 = new Player(player2S);
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

    public void sendMessage(){

    }

    public void movePiece(Player player) {
        String checkerChosen;
        String checkerMove;
        checkerChosen = player.choseChecker();
        //pass a set with the possibility
        checkerChosen = player.moveChecker();

    }


    @Override
    public void run() {
            System.err.println("INITIATING GAME");
            player1.setName();
            player2.setName();

            init();

            while (!gameOver) {
                movePiece(player1);
                movePiece(player2);
            }
    }
}
