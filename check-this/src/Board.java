import Colors.Colors;
import checkers.Checker;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;


public class Board {

    public static final int BOARD_LENGHT = 8;

    private String[][] board;
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
                    } else {
                        board[col][row] = Colors.WHITE_BACKGROUND_BRIGHT + "   " + Colors.RESET;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearBoard(){
        int paint = 0;
        board = new String[BOARD_LENGHT][BOARD_LENGHT];
        for (int col = 0; col < BOARD_LENGHT; col++) {
            paint++;
            for (int row = 0; row < BOARD_LENGHT; row++) {
                paint++;
                if (!(paint % 2 == 0)) {
                    board[col][row] = Colors.RED_BACKGROUND + "   " + Colors.RESET;
                } else {
                    board[col][row] = Colors.WHITE_BACKGROUND_BRIGHT + "   " + Colors.RESET;
                }
            }
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

    public void setPieces(LinkedList<Checker> list) {
        clearBoard();
        for (Checker checker : list) {
            board[checker.getCol()][checker.getRow()] = Colors.RED_BACKGROUND + checker.getCheckerColor() + Colors.RESET;
        }

    }

<<<<<<< HEAD
    public void movePiece(Checker checker){
    }
=======
>>>>>>> 45376e017e4c276a4533b70e6218ffb240cae13b
}
