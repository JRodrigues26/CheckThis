import Colors.Colors;
import checkers.Checker;
<<<<<<< HEAD
import checkers.CheckerFactory;
import checkers.CheckerType;
=======

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

>>>>>>> 0717ebc6c4d74b83c584e4b7c40ffb626afd39b5

public class Board {

    public static final int BOARD_LENGHT = 8;

    private String[][] board;
<<<<<<< HEAD
    private CheckerFactory checkerFactory = new CheckerFactory();
    private Checker[] blackCheckers = new Checker[12];
    private Checker[] whiteCheckers = new Checker[12];

    public Board() {

        int blackCount = 0;
        int whiteCount = 0;
        int paint = 0;
        board = new String[8][8];
        for (int x = 0; x < board.length; x++) {
            paint++;
            for (int y = 0; y < board.length; y++) {
                paint++;
                if(!(paint % 2 == 0)){

                    if(x<=3 && blackCount<blackCheckers.length){
                        blackCheckers[blackCount] = checkerFactory.createChecker(CheckerType.NORMAL_BLACK);
                        board[x][y] = Colors.RED_BACKGROUND + "[" + blackCheckers[blackCount].getName() + "]" + Colors.RESET;
                        blackCount++;
                    }

                    else if(x>=5 && whiteCount<whiteCheckers.length){
                        whiteCheckers[whiteCount] = checkerFactory.createChecker(CheckerType.NORMAL_WHITE);
                        board[x][y] = Colors.RED_BACKGROUND + "[" + whiteCheckers[whiteCount].getName() + "]" + Colors.RESET;
                        whiteCount++;
                    }

                    else{
                        board[x][y] = Colors.RED_BACKGROUND + "[ ]" + Colors.RESET;
                    }


                } else
                board[x][y] = "[ ]";
=======
    private Socket player1Socket;
    private Socket player2Socket;
    private PrintWriter p1printWriter;
    private PrintWriter p2printWriter;

    public Board(Socket player1, Socket player2) {
        try {

            player1Socket = player1;
            player2Socket = player2;

            p1printWriter = new PrintWriter(player1Socket.getOutputStream(), true);
            p2printWriter = new PrintWriter(player2Socket.getOutputStream(), true);

            int paint = 0;
            board = new String[BOARD_LENGHT][BOARD_LENGHT];
            for (int col = 0; col < BOARD_LENGHT; col++) {
                paint++;
                for (int row = 0; row < BOARD_LENGHT; row++) {
                    paint++;
                    if (!(paint % 2 == 0)) {
                        board[col][row] = Colors.RED_BACKGROUND + "   " + Colors.RESET;
                    } else
                        board[col][row] = Colors.WHITE_BACKGROUND_BRIGHT + "   " + Colors.RESET;
                }
>>>>>>> 0717ebc6c4d74b83c584e4b7c40ffb626afd39b5
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void println(String line) {
        p1printWriter.println(line);
        p2printWriter.println(line);
    }

    public void print(String line) {
        p1printWriter.print(line);
        p2printWriter.print(line);
    }

    public void draw() {



        System.out.println("   A  B  C  D  E  F  G  H");
        println("   A  B  C  D  E  F  G  H");


        for (int row = 0; row < BOARD_LENGHT; row++) {
            System.out.print((row + 1) + " ");
            print((row + 1) + " ");


            for (int col = 0; col < BOARD_LENGHT; col++) {
                System.out.print(board[col][row]);

                print(board[col][row]);

            }
            System.out.print(" " + (row + 1));
            print(" " + (row + 1));


            System.out.println();
            println("");

        }
        System.out.println("   A  B  C  D  E  F  G  H");
        println("   A  B  C  D  E  F  G  H");

    }
<<<<<<< HEAD
=======

    public void setPieces(LinkedList<Checker> list) {
        for (Checker checker : list) {
            board[checker.getCol()][checker.getRow()] = Colors.RED_BACKGROUND + checker.getCheckerColor() + Colors.RESET;
        }

    }

    public void movePiece(Checker checker) {
        //checker.setCol();
    }
>>>>>>> 0717ebc6c4d74b83c584e4b7c40ffb626afd39b5
}
