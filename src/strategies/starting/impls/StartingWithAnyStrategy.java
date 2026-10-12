package strategies.starting.impls;

import strategies.starting.StartingStrategy;

public class StartingWithAnyStrategy implements StartingStrategy {
    @Override
    public boolean canStart(int diceRolled) {
        return true;
    }
}
