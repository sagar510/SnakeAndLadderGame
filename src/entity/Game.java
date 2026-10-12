package entity;

import enums.GameStatus;
import enums.PlayerStatus;
import strategies.starting.StartingStrategy;
import strategies.starting.impls.StartingWithAnyStrategy;
import strategies.winning.WinningStrategy;
import strategies.winning.impls.ExactEqualWinningStrategy;

import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private GameStatus status;
    private WinningStrategy winningStrategy;
    private StartingStrategy startingStrategy;

    private Game(Builder builder) {
        this.board = builder.board;
        this.players = builder.players;
        this.dice = builder.dice;
        this.startingStrategy = builder.startingStrategy;
        this.winningStrategy = builder.winningStrategy;
        this.status = GameStatus.NOT_STARTED;
    }

    public void start() {
        if(players.size() < 2) {
            throw new IllegalStateException("Game must have at least 2 players");
        }

        this.status = GameStatus.RUNNING;

        while(status == GameStatus.RUNNING) {

            Player curr =  players.poll();

            takeTurn(curr);
        }
    }

    public void takeTurn(Player curr) {
        //  1. He will roll dice
        //  2.  finalPos = use move metthod (rolledDice)
        //  3. false = isWon(finalPos, player)
        //  4. curr.setPostiyon(finalPos)
        //  5. if(rolledDice  == 6) takeTurn(curr)

        int diceRoll = dice.roll();

        if(curr.getStatus() == PlayerStatus.CLOSED && startingStrategy.canStart(diceRoll)) {
            curr.setStatus(PlayerStatus.OPEN);
        }

        if(curr.getStatus() == PlayerStatus.OPEN) {
            int currPosition = curr.getPosition();

            boolean isPlayerWon = winningStrategy.isWon(board, curr, diceRoll);

            int finalPosition = board.move(currPosition,  diceRoll);

            if(board.isValidPosition(finalPosition)) {
                curr.setPosition(finalPosition);
            }

            if(isPlayerWon) curr.setStatus(PlayerStatus.WON);

            if(diceRoll == 6) takeTurn(curr);
        }
    }



    public static class Builder {
        private Board board;
        private Dice dice;
        private Queue<Player> players;
        private WinningStrategy winningStrategy = new ExactEqualWinningStrategy();
        private StartingStrategy startingStrategy = new StartingWithAnyStrategy();

        public Game build(){
            if(board == null || dice == null || players == null || startingStrategy == null || winningStrategy == null){
                throw new IllegalArgumentException("Invalid arguments provided");
            }
            return new Game(this);
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            for(Player player : players){
                this.players.add(player);
            }
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setStartingStrategy(StartingStrategy startingStrategy) {
            this.startingStrategy = startingStrategy;
            return this;
        }
    }
}
