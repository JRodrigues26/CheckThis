package checkers;

public class Checker implements CheckerProprieties {

    private String symbol;
    private int x;
    private int y;

    public Checker(String symbol){
        this.symbol = symbol;
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
