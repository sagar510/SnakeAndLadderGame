package entity.items.impls;

import entity.items.BoardItems;

public class Ladder extends BoardItems {
    public Ladder(int start, int end) {
        if(start > end) throw new IllegalArgumentException("Ladder bottom must be at lower");
        super(start, end);
    }
}
