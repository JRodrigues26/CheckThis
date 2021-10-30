import Colors.Colors;
import checkers.Checker;

import java.util.LinkedList;


public class Board {

    public static final int BOARD_LENGHT = 8;

    private String[][] board;

    public Board() {
        int paint = 0;
        board = new String[BOARD_LENGHT][BOARD_LENGHT];
        for (int col = 0; col < BOARD_LENGHT; col++) {
            paint++;
            for (int row = 0; row < BOARD_LENGHT; row++) {
                paint++;
                if(!(paint % 2 == 0)){
                        board[col][row] = Colors.RED_BACKGROUND + "   " + Colors.RESET;
                } else
                board[col][row] = Colors.WHITE_BACKGROUND_BRIGHT + "   " + Colors.RESET;
            }
        }
    }

    public void draw() {
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int row = 0; row < BOARD_LENGHT; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < BOARD_LENGHT; col++) {
                System.out.print(board[col][row]);
            }
            System.out.println();
        }
    }

    public void setPieces(LinkedList<Checker> list){
        for (Checker checker : list){
            board[checker.getCol()][checker.getRow()] = Colors.RED_BACKGROUND + checker.getCheckerColor() + Colors.RESET;
        }

    }

    public void movePiece(Checker checker){
    }
}
