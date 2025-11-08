package model;

public class DoublingCube {
    private int value;
    private String owner;

    public DoublingCube() {
        this.value = 1;
        this.owner = "neutral";
    }

    public int getValue(){
        return value;
    }

    public String getOwner(){
        return owner;
    }

    public boolean canDouble(String currentPlayer){
        return owner.equals("neutral") || owner.equals(currentPlayer);
    }

    public void doubleCube(String currentPlayer, String player1, String player2){
        value *= 2;
        owner = currentPlayer.equals(player1) ? player2 : player1;
    }

    public void reset(){
        value = 1;
        owner = "neutral";
    }

    // Setter for the owner
    public void setOwner(String player) {
        this.owner = player;
    }
}
