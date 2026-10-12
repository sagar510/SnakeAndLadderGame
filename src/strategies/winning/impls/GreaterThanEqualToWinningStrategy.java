package strategies.winning.impls;

import entity.Board;
import entity.Player;
import strategies.winning.WinningStrategy;

public class GreaterThanEqualToWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWon(Board board, Player player, int diceRolled) {
        if(board.move(player.getPosition(), diceRolled) >= board.getSize()) return true;
        return false;
    }
}
