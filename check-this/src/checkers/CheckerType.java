package checkers;

public enum CheckerType {

    NORMAL("Checker"),
    KING("King Checker");

    String symbol;

    CheckerType(String name){
        this.symbol = symbol;
    }

    public String getName() {
        return this.symbol;
    }
}
