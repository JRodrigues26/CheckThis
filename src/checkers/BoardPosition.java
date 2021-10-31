package checkers;

public enum BoardPosition {

    A(0, "A"),
    B(1, "B"),
    C(2, "C"),
    D(3, "D"),
    E(4, "E"),
    F(5, "F"),
    G(6, "G"),
    H(7, "H");

    private int col;
    private String name;

    BoardPosition (int col, String name){
        this.col = col;
        this.name = name;
    }

    public static String colToString(int col){
        for(BoardPosition position: BoardPosition.values()){
            if(position.getCol() == col)
                return position.name;
        }
        return null;
    }

    public static int stringToCol(String string){
        for(BoardPosition position: BoardPosition.values()){
            if(position.getName().equals(string))
                return position.col;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getCol() {
        return col;
    }
}
