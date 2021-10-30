import checkers.Checker;
import checkers.CheckerFactory;
import checkers.CheckerType;

public class Board {

    private String[][] board;
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
}
