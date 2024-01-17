public class Cell {

//    public String getRepresentation() {
//        return "|   ";
//    }

    private String representation = "|   ";

    public String getRepresentation() {
        return representation;
    }

    public void setOwner(Player owner) {
        this.representation = owner.getRepresentation();
    }

}