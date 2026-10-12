package strategies.starting.impls;

import strategies.starting.StartingStrategy;

public class StartingWithSixStrategy implements StartingStrategy {
    @Override
    public boolean canStart(int diceRolled) {
        if (diceRolled == 6) return true;
        return false;
    }
}
