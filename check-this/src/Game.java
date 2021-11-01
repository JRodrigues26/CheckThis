import Colors.Colors;
import checkers.*;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Game implements Runnable {

    private Player player1;
    private Player player2;
    private Board gameBoard;
    private boolean gameOver = false;
    private LinkedList<Checker> allCheckers;
    private Set<String> availableMoves;


    public Game(Socket player1S, Socket player2S) {
        System.err.println("CREATING NEW GAME");
        player1 = new Player(player1S, CheckerColor.WHITE);
        player2 = new Player(player2S, CheckerColor.BLACK);
        gameBoard = new Board(player1S, player2S);
        allCheckers = new LinkedList<>();
        availableMoves = new HashSet<>();
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

    public void moveChecker(String newPosition, Checker checker) {

       int col = BoardPosition.stringToCol(newPosition.split("")[0]);
       int row = Integer.parseInt(newPosition.split("")[1]) - 1;

        for (Checker checkthis : allCheckers) {
            if (checkthis.getCol() == checker.getCol() && checkthis.getRow() == checker.getRow()) {
             checkthis.setCol(col);
             checkthis.setRow(row);
            }
        }

    }


    public void availableMoves(Checker checker) {
        String[][] boardPositions = gameBoard.getBoardPositions();
        int row;

        //Verify if it if white
        if (checker.getCheckerColor().equals(CheckerColor.WHITE.getColor())) {

            //check if the next position x+1 y+1 is inside the board
            if (checker.getCol() + 1 < Board.BOARD_LENGHT && checker.getRow() + 1 < Board.BOARD_LENGHT) {

                if (boardPositions[checker.getCol() + 1][checker.getRow() + 1].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                    row = checker.getBoardRow() + 1;
                    availableMoves.add(BoardPosition.colToString(checker.getCol() + 1) + row);

                    //check if the next position x+2 y+2 is available
                } else if (boardPositions[checker.getCol() + 1][checker.getRow() + 1].equals(Colors.RED_BACKGROUND + " B " + Colors.RESET)) {

                    if (checker.getCol() + 2 < Board.BOARD_LENGHT && checker.getRow() + 2 < Board.BOARD_LENGHT) {

                        if (boardPositions[(checker.getCol() + 2)][(checker.getRow() + 2)].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                            for (Checker deadChecker : allCheckers) {
                                if (deadChecker.getCol() == checker.getCol() + 1 && deadChecker.getRow() == checker.getRow() + 1) {

                                    allCheckers.remove(deadChecker);
                                    break;
                                }
                            }

                            row = checker.getBoardRow() + 2;
                            availableMoves.clear();
                            availableMoves.add(BoardPosition.colToString(checker.getCol() + 2) + row);
                        }
                    }
                }
            }
            //check if the next position x-1 y+1 is inside the board
            if (checker.getCol() - 1 >= 0 && checker.getRow() + 1 < Board.BOARD_LENGHT) {
                if (boardPositions[checker.getCol() - 1][checker.getRow() + 1].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {
                    row = checker.getBoardRow() + 1;
                    availableMoves.add(BoardPosition.colToString(checker.getCol() - 1) + row);
                    //check if the next position x-2 y+2 is available
                } else if (boardPositions[checker.getCol() - 1][checker.getRow() + 1].equals(Colors.RED_BACKGROUND + " B " + Colors.RESET)) {

                    if (checker.getCol() - 2 >= 0 && checker.getRow() + 1 < Board.BOARD_LENGHT) {
                        if (boardPositions[checker.getCol() - 2][checker.getRow() + 2].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {


                            for (Checker deadChecker : allCheckers) {
                                if (deadChecker.getCol() == checker.getCol() - 1 && deadChecker.getRow() == checker.getRow() + 1) {

                                    allCheckers.remove(deadChecker);
                                    break;
                                }
                            }

                            row = checker.getBoardRow() + 2;
                            availableMoves.clear();
                            availableMoves.add(BoardPosition.colToString(checker.getCol() - 2) + row);
                        }
                    }
                }
            }
        } else {


            //check if the next position x+1 y-1 is available
            if (checker.getCol() + 1 < Board.BOARD_LENGHT && checker.getRow() - 1 >= 0) {

                if (boardPositions[checker.getCol() + 1][checker.getRow() - 1].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                    row = checker.getBoardRow() - 1;
                    availableMoves.add(BoardPosition.colToString(checker.getCol() + 1) + row);

                    //check if the next position x+2 y-2 is available
                } else if (boardPositions[checker.getCol() + 1][checker.getRow() - 1].equals(Colors.RED_BACKGROUND + " W " + Colors.RESET)) {

                    if (checker.getCol() + 2 < Board.BOARD_LENGHT && checker.getRow() - 2 >= 0) {

                        if (boardPositions[(checker.getCol() + 2)][(checker.getRow() - 2)].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                            for (Checker deadChecker : allCheckers) {
                                if (deadChecker.getCol() == checker.getCol() + 1 && deadChecker.getRow() == checker.getRow() - 1) {

                                    allCheckers.remove(deadChecker);
                                    break;
                                }
                            }

                            row = checker.getBoardRow() - 2;
                            availableMoves.clear();
                            availableMoves.add(BoardPosition.colToString(checker.getCol() + 2) + row);
                        }
                    }
                }
            }
            //check if the next position x-1 y+1 is inside the board

            if (checker.getCol() - 1 >= 0 && checker.getRow() - 1 >= 0) {


                if (boardPositions[checker.getCol() - 1][checker.getRow() - 1].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                    row = checker.getBoardRow() - 1;
                    availableMoves.add(BoardPosition.colToString(checker.getCol() - 1) + row);
                    //check if the next position x-2 y+2 is available
                } else if (boardPositions[checker.getCol() - 1][checker.getRow() - 1].equals(Colors.RED_BACKGROUND + " W " + Colors.RESET)) {

                    if (checker.getCol() - 2 >= 0 && checker.getRow() - 2 >= 0) {
                        if (boardPositions[checker.getCol() - 2][checker.getRow() - 2].equals(Colors.RED_BACKGROUND + "   " + Colors.RESET)) {

                            for (Checker deadChecker : allCheckers) {
                                if (deadChecker.getCol() == checker.getCol() - 1 && deadChecker.getRow() == checker.getRow() - 1) {

                                    allCheckers.remove(deadChecker);
                                    break;
                                }
                            }


                            row = checker.getBoardRow() - 2;
                            availableMoves.clear();
                            availableMoves.add(BoardPosition.colToString(checker.getCol() - 2) + row);
                        }
                    }
                }
            }


        }
    }

    public void turn(Player player) {
        Checker checker = null;
        String oldPosition ="";
        while (availableMoves.size() == 0) {
            player.receiveCheckers();
            checker = StringToChecker(player.chooseChecker());
            oldPosition = BoardPosition.colToString(checker.getCol()) + checker.getBoardRow();
            availableMoves(checker);
        }

        String newPosition = player.chooseNewPosition(availableMoves);
        moveChecker(newPosition, checker);
        gameBoard.setPieces(allCheckers);
        player1.sendMessage("");
        player2.sendMessage("");
        gameBoard.draw();
        availableMoves.clear();
        player1.sendMessage(player.getName().toUpperCase() + " MOVED PIECE FROM " + oldPosition + " TO " + newPosition + "\n");
        player2.sendMessage(player.getName().toUpperCase() + " MOVED PIECE FROM " + oldPosition + " TO " + newPosition + "\n");
    }

    public void verifyGameOver(){
        for(Checker checker : allCheckers){
            if(checker.getCheckerColor().equals(CheckerColor.WHITE.getColor()) && checker.getRow() == Board.BOARD_LENGHT){
                player1.sendMessage("YOU WON");
                player2.sendMessage("YOU LOSE");
                gameOver = true;
            } else if (checker.getCheckerColor().equals(CheckerColor.BLACK.getColor()) && checker.getRow() == 0){
                player1.sendMessage("YOU LOSE");
                player2.sendMessage("YOU WON");
                gameOver = true;
            }


        }
    }

    @Override
    public void run() {
        System.err.println("INITIATING GAME");
        player1.setName();
        player2.setName();
        init();

        while (!gameOver) {
            turn(player1);
            verifyGameOver();
            turn(player2);
            verifyGameOver();
        }


    }


    public class Player {

        private CheckerColor checkerColor;
        private Socket playerSocket;
        private PrintWriter out;
        private Prompt prompt;
        private String name;
        private PrintStream printStream;
        private Set<String> playerCheckersOptions;


        public Player(Socket socket, CheckerColor checkerColor) {
            try {
                this.checkerColor = checkerColor;
                this.playerSocket = socket;
                this.printStream = new PrintStream(this.playerSocket.getOutputStream()); // to print messages to the player terminal
                this.out = new PrintWriter(this.playerSocket.getOutputStream(), true);
                this.prompt = new Prompt(this.playerSocket.getInputStream(), printStream);
                this.playerCheckersOptions = new HashSet<>();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        public void sendMessage(String string){
            this.out.println(string);
        }

        public void receiveCheckers() {
            int row = 0;
            String col = "";
            for (Checker checker : allCheckers) {
                if (checker.getCheckerColor().equals(this.checkerColor.getColor())) {
                    row = checker.getRow() + 1;
                    col = BoardPosition.colToString(checker.getCol());
                    this.playerCheckersOptions.add(col + row);
                }
            }
        }

        public synchronized void setName() {
            StringInputScanner question1 = new StringInputScanner();
            question1.setMessage("whats your name" + "\n");
            String name = prompt.getUserInput(question1);
            this.name = name;
            this.out.println();
            this.out.println("Your team is:" + checkerColor.getColor() + "\n");
            System.out.println(name);
        }

        public String chooseChecker() {
            for (String string : playerCheckersOptions) {
                System.out.println(string);
            }
            StringSetInputScanner question = new StringSetInputScanner(playerCheckersOptions);
            question.setError("You don't have a checker in that position");
            question.setMessage(this.name + ": Choose a valid checker you want to move?" + "\n");
            String checkerSelected = prompt.getUserInput(question);
            return checkerSelected;
        }

        public String chooseNewPosition(Set<String> movesAvailable) {
            System.out.println();
            for (String string : movesAvailable) {
                System.out.print(string + " ");
            }
            StringSetInputScanner question = new StringSetInputScanner(movesAvailable);
            question.setError("You can't make that move");
            question.setMessage("Where do you want to move?" + "\n");
            String newPosition = prompt.getUserInput(question);
            return newPosition;
        }

    }

}
