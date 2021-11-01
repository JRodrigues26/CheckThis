package checkers;

public abstract class Checker implements CheckerState {


    private String checkerColor;
    private int col;
    private int row;

    public Checker(CheckerColor color, int col, int row) {
        this.checkerColor = color.getColor();
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getBoardRow(){
        return row + 1;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getCheckerColor() {
        return this.checkerColor;
    }




    //---// Interface Checker States //---//
    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean canKill() {
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
