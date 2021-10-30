package checkers;

public enum CheckerType {

    NORMAL_WHITE("W"),
    NORMAL_BLACK("B");

    //KING("King Checker");

    String symbol;

    CheckerType(String symbol){
        this.symbol = symbol;
    }

    public String getName() {
        return this.symbol;
    }
}
