package checkers;

public class Checker implements CheckerProprieties {

    String name;
    String color;
    private CheckerPosition position[][];

    public Checker(String name, String color, CheckerPosition position[][]){
        this.name = name;
        this.color = color;
        this.position = position;
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
