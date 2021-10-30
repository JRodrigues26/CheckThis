package checkers;

public enum CheckerColor {

    WHITE("White"),
    BLACK("Black");

    String color;

    CheckerColor(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
