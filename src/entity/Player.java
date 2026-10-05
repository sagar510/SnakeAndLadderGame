package entity;

public class Player {
    private final String name;
    private Cell position;

    public Player(String name, Cell position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Cell getPosition() {
        return position;
    }
}
