package checkers;

public class Checker implements CheckerProprieties {

    private String name;
    private String color;
    private int x;
    private int y;

    public Checker(String name, String color, int x, int y){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
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
