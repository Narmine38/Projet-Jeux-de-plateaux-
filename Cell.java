public class Cell {

    private String representation = "|   ";

    public String getRepresentation() {
        return representation;
    }

    public void setOwner(Player player) {
        this.representation = player.getRepresentation();
    }

}