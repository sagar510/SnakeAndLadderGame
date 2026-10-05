package entity;

import entity.items.BoardItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    //List<BoardItems>  boardItems;
    private final Map<Integer, BoardItems> snakeAndLadders;

    public Board(int size, Map<Integer, BoardItems> snakeAndLadders) {
        this.size = size;
        this.snakeAndLadders = snakeAndLadders;
    }

    public int move(int currPosition, int diceRoll){
        currPosition += diceRoll;

        if(snakeAndLadders.containsKey(currPosition)){
            currPosition = snakeAndLadders.get(currPosition).getEnd();
        }

        return currPosition;
    }
}
