package entity;

import entity.items.BoardItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private final Map<Integer, BoardItems> snakeAndLadderMap;

    public Board(int size, List<BoardItems> snakeAndLadders) {
        this.size = size;
        //this.snakeAndLadders = snakeAndLadders;
        snakeAndLadderMap = new HashMap<>(snakeAndLadders.size());
        for(BoardItems item : snakeAndLadders){
            snakeAndLadderMap.put(item.getStart(), item);
        }
    }

    public int move(int currPosition, int diceRoll){
        currPosition += diceRoll;

        if(snakeAndLadderMap.containsKey(currPosition)){
            currPosition = snakeAndLadderMap.get(currPosition).getEnd();
        }

        return currPosition;
    }

    public int getSize() {
        return size;
    }

    public boolean isValidPosition(int position){
        return position <= this.size  && position >= 0;
    }
}
