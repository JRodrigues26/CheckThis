import checkers.Checker;
import checkers.CheckerColor;

import java.awt.*;

public class Board {

    private String[][] board;

    public Board() {
        int paint = 0;
        board = new String[8][8];
        for (int x = 0; x < board.length; x++) {
            paint++;
            for (int y = 0; y < board.length; y++) {
                paint++;
                if(!(paint % 2 == 0)){
                        board[x][y] = Colors.RED_BACKGROUND + "[ ]" + Colors.RESET;
                } else
                board[x][y] = "[ ]";
            }
        }
    }

    public void draw() {
        for (int x = 0; x < board.length; x++) {
            System.out.println();
            for (int y = 0; y < board.length; y++) {
                System.out.print(board[x][y]);
            }
        }

    }

    public void drawPiece(){

        if(color == CheckerColor.WHITE) {
            board[x][y] = Colors.RED_BACKGROUND + "[W]" + Colors.RESET;
        } else {
            board[x][y] = Colors.RED_BACKGROUND + "[B]" + Colors.RESET;
        }

    }
}
