package checkers;

public class CheckerFactory {

    private CheckerType checker;
    private CheckerColor color;
    private CheckerPosition position[][];

    public CheckerFactory(CheckerType checker, CheckerColor color, CheckerPosition position[][]){
        this.checker = checker;
        this.color = color;
        this.position = position;
    }

    //---// Return a new Checker whit name, color and starting position//---//

    public Checker createChecker() {

        switch (checker){

            case NORMAL:{
                return new NormalChecker(checker.getName(), color.getColor(), position);
            }

            case KING:{
                return new KingChecker(checker.getName(), color.getColor(), position);
            }
        }

        return null;
    }
}
