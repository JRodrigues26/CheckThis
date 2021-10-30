public class Board {

    private String [][] board;


    public Board(){
        board = new String[8][8];
        for (int i = 0; i < board.length; i++){
            System.out.println();
            for (int y = 0; y < board.length; y++){
                board[i][y] = "[  ]";
                System.out.print(board[i][y]);
            }
        }
    }

    public void drawBoard(){
        for (int i = 0; i < board.length; i++){
            System.out.println();
            for (int y = 0; y < board.length; y++){
                System.out.print(board[i][y]);
            }
        }
    }

    public void displayChecker(){

    }

}
