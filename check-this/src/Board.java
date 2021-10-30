import checkers.Checker;

import java.util.LinkedList;


public class Board {

    public static final int BOARD_LENGHT = 8;

    private String[][] board;

    public Board() {
        int paint = 0;
        board = new String[BOARD_LENGHT][BOARD_LENGHT];
        for (int y = 0; y < BOARD_LENGHT; y++) {
            paint++;
            for (int x = 0; x < BOARD_LENGHT; x++) {
                paint++;
                if(!(paint % 2 == 0)){
                        board[x][y] = Colors.RED_BACKGROUND + "   " + Colors.RESET;
                } else
                board[x][y] = Colors.WHITE_BACKGROUND_BRIGHT + "   " + Colors.RESET;
            }
        }
    }

    public void draw() {
        for (int y = 0; y < board.length; y++) {
            System.out.println();
            for (int x = 0; x < board.length; x++) {
                System.out.print(board[x][y]);
            }
        }
    }

    public void setPiece(LinkedList<Checker> list){
        for (Checker checker : list){
            board[checker.getX()][checker.getY()] = Colors.RED_BACKGROUND + checker.getCheckerColor() + Colors.RESET;
        }

    }
}
