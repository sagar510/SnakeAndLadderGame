package strategies.winning;

import entity.Board;
import entity.Player;

public interface WinningStrategy {
    boolean isWon(Board board, Player player, int diceRolled);
}
