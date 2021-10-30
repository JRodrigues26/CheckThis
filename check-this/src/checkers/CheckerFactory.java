package checkers;

public class CheckerFactory {

    private CheckerType checker;
    private CheckerColor color;
    private int x;
    private int y;

    public CheckerFactory(CheckerType checker, CheckerColor color, int x, int y){
        this.checker = checker;
        this.color = color;
        this.x = x;
        this.y =y;
    }

    //---// Return a new Checker whit name, color and starting position//---//

    public Checker createChecker() {

        switch (checker){

            case NORMAL:{
                return new NormalChecker(checker.getName(), color.getColor(), x, y);
            }

            case KING:{
                return new KingChecker(checker.getName(), color.getColor(), x, y);
            }
        }

        return null;
    }
}
