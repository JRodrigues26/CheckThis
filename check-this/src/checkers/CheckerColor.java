package checkers;

public enum CheckerColor {

    WHITE(" W "),
    BLACK(" B ");

    String color;

    CheckerColor(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
