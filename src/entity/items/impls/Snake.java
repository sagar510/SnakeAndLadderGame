package entity.items.impls;

import entity.items.BoardItems;

public class Snake extends BoardItems {
    public Snake(int start, int end) {
        if(start < end) throw new IllegalArgumentException("Snake start position must be greater than end position");
        super(start, end);
    }
}
