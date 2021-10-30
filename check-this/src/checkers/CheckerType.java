package checkers;

public enum CheckerType {

    NORMAL("Checker"),
    KING("King Checker");

    String name;

    CheckerType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
