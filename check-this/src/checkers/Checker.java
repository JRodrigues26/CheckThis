package checkers;

public abstract class Checker implements CheckerState {


    private String symbol;
    private int x;
    private int y;

    public Checker(String symbol){
        this.symbol = symbol;


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

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getCheckerColor() {
        return this.checkerColor;
    }

    public abstract void move();


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

    @Override
    public String getName() {
        return this.symbol;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }
}
