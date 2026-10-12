package strategies.starting.impls;

import strategies.starting.StartingStrategy;

public class StartingWithOneOrSixStrategy implements StartingStrategy {
    @Override
    public boolean canStart(int diceRolled) {
        if (diceRolled == 6 || diceRolled == 1) return true;
        return false;
    }
}
