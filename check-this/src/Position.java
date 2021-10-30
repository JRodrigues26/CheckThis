public class Position {

    private int col;
    private int row;

    public Position(int x, int y) {
        col = x;
        row = y;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
