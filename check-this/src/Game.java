import checkers.*;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private Board gameBoard;
    private boolean gameOver = false;
    private LinkedList<Checker> allCheckers;

    public Game(Socket player1S, Socket player2S) {
        System.err.println("CREATING NEW GAME");
        player1 = new Player(player1S, CheckerColor.WHITE );
        player2 = new Player(player2S, CheckerColor.BLACK);
        gameBoard = new Board(player1S, player2S);
        allCheckers = new LinkedList<>();
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
                        allCheckers.add(new WhiteChecker(col, row));
                    } else if (row >= 5) {
                        allCheckers.add(new BlackChecker(col, row));
                    }
                }
            }
        }
    }

    public void init() {
        gameBoard.setPieces(allCheckers);
        gameBoard.draw();
    }

    public Checker StringToChecker(String coordinate) {
        for (Checker checker : allCheckers) {
            if ((checker.getCol() == BoardPosition.stringToCol(coordinate.split("")[0])) &&
                    (checker.getRow() == Integer.parseInt(coordinate.split("")[1]) - 1)) {
                    return checker;
            }
        }
        return null;
    }

    public void moveChecker(Checker checker) {
        for (Checker checkthis : allCheckers) {
            if (checker.getCol() == checkthis.getCol() && checker.getRow() == checkthis.getRow()) {
                if(checker.getCheckerColor().equals(CheckerColor.WHITE.getColor())) /*Move White checkers*/{
                    checkthis.setCol(checkthis.getCol() + 1);
                    checkthis.setRow(checkthis.getRow() + 1);
                }else{ /*Move Black checkers*/
                    checkthis.setCol(checkthis.getCol() - 1);
                    checkthis.setRow(checkthis.getRow() - 1);
                }
            }
        }
    }


    public void turn(Player player) {
        player.receiveCheckers();
        Checker checker = StringToChecker(player.chooseChecker());
        moveChecker(checker);

        //player.newPosition();

        gameBoard.setPieces(allCheckers);
        gameBoard.draw();
    }


    @Override
    public void run() {
        System.err.println("INITIATING GAME");
        player1.setName();
        player2.setName();
        init();

        while (!gameOver) {
            turn(player1);
            turn(player2);
        }


    }


    public class Player {

        private CheckerColor checkerColor;
        private Socket playerSocket;
        private PrintWriter out;
        private Prompt prompt;
        private String name;
        private PrintStream printStream;
        private Set<String> options;


        public Player(Socket socket, CheckerColor checkerColor) {
            try {
                this.checkerColor = checkerColor;
                this.playerSocket = socket;
                this.printStream = new PrintStream(this.playerSocket.getOutputStream()); // to print messages to the player terminal
                this.out = new PrintWriter(this.playerSocket.getOutputStream(), true);
                this.prompt = new Prompt(this.playerSocket.getInputStream(), printStream);
                this.options = new HashSet<>();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receiveCheckers() {
            int row = 0;
            String col = "";
            for (Checker checker : allCheckers) {
                if(checker.getCheckerColor().equals(this.checkerColor.getColor())) {
                    row = checker.getRow() + 1;
                    col = BoardPosition.colToString(checker.getCol());
                    options.add(col + row);
                }
            }
        }

        public synchronized void setName() {
            StringInputScanner question1 = new StringInputScanner();
            question1.setMessage("whats your name" + "\n");
            String name = prompt.getUserInput(question1);
            this.name = name;
            System.out.println(name);
        }

        public String chooseChecker() {

            StringSetInputScanner question = new StringSetInputScanner(options);
            question.setError("You don't have a checker in that position");
            out.print("Your turn " + name + "?" + "\n");
            question.setMessage("Which checker do you want to move?" + "\n");
            String checkerSelected = prompt.getUserInput(question);
            return checkerSelected;
        }

        public String newPosition() {

            StringSetInputScanner question = new StringSetInputScanner(options);
            question.setMessage("What is your new position?" + "\n");
            String newPosition = prompt.getUserInput(question);
            return newPosition;
        }


    }

}
