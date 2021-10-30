package checkers;

public class CheckerFactory{

    //---// Return a new Checker whit name, color and starting position//---//

    public Checker createChecker(CheckerType checker) {

        switch (checker){

            case NORMAL_WHITE, NORMAL_BLACK:{
                return new NormalChecker(checker.getName());
            }
            /*
            case KING:{
                return new KingChecker(checker.getName(), color.getColor(), x, y);
            }*/
        }

        return null;
    }
}
