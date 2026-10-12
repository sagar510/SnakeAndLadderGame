package entity;

import enums.PlayerStatus;

public class Player {
    private final String name;
    private int position;
    private PlayerStatus status;

    public Player(String name) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
