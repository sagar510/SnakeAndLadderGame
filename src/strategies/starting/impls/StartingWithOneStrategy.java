package strategies.starting.impls;

import strategies.starting.StartingStrategy;

public class StartingWithOneStrategy implements StartingStrategy {
    @Override
    public boolean canStart(int diceRolled) {
        if (diceRolled == 1) return true;
        return false;
    }
}
