package checkers;

public class Checker implements CheckerState {


    private String checkerColor;
    private int x;
    private int y;

    public Checker(CheckerColor color, int x, int y){
        this.checkerColor = color.getColor();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCheckerColor(){
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
