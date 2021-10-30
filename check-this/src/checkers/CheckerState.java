package checkers;

public interface CheckerState {

    public boolean isDead();
    public boolean canKill();
    public boolean canMove();
}
