package checkers;

public interface CheckerProprieties {

    boolean isDead();
    boolean canKill();
    boolean canMove();

    String getName();

    int getX();
    void setX(int x);

    int getY();
    void setY(int y);
}
